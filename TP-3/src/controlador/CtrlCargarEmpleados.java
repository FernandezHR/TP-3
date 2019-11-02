package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.stream.IntStream;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import modelo.Empleado;
import modelo.Modelo;
import vista.CargarEmpleados;

public class CtrlCargarEmpleados implements ActionListener
{
	private Modelo modelo;
	private CargarEmpleados panelCargarEmpleados;
	private ListaDeNombres listaDeNombres;
	
	public CtrlCargarEmpleados(Modelo modelo, CargarEmpleados panelCargarEmpleados) 
	{
		this.modelo = modelo;
		this.panelCargarEmpleados = panelCargarEmpleados;
		
		listaDeNombres = new ListaDeNombres();
	}
	
	public void iniciar() 
	{
		panelCargarEmpleados.lblCantNombres.setToolTipText("Es posible generar " + listaDeNombres.cantidad() + " empleados.");
		
		this.panelCargarEmpleados.btnElegirFoto.addActionListener(this);
		this.panelCargarEmpleados.btnCargar.addActionListener(this);
		this.panelCargarEmpleados.btnGenerar.addActionListener(this);
		this.panelCargarEmpleados.btnEliminar.addActionListener(this);
	}
		
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		if(arg0.getSource() == panelCargarEmpleados.btnElegirFoto)
			elegirFoto();
		
		if(arg0.getSource() == panelCargarEmpleados.btnCargar) 
			if(esPosibleCargarEmpleado())
				cargarEmpleado();
		
		if(arg0.getSource() == panelCargarEmpleados.btnGenerar)
			if(sePuedeGenerar())
				generarEmpleados();
		
		if(arg0.getSource() == panelCargarEmpleados.btnEliminar)
			eliminarEmpleados();
	}

	private void elegirFoto() 
	{
		JFileChooser jfc = new JFileChooser();
		jfc.setFileFilter(new FileNameExtensionFilter("JPG y PNG", "jpg","png"));
		
		if(jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) 
		{
			String path = jfc.getSelectedFile().toString();
			panelCargarEmpleados.txtPathFoto.setText(path);
		}
	}

	private void cargarEmpleado() 
	{
		String nombre = obtenerNombre();
		String puesto = obtenerPuesto();
		String path = obtenerPath();
		
		modelo.agregarEmpleado(nombre, puesto);
		listaDeNombres.eliminar(nombre); //Por si el nombre existe en la lista	
	
		FotosDeEmpleados.agregarFoto(nombre, new ImageIcon(path));
			
		actualizarVista();
	}

	private void generarEmpleados() 
	{
		crearEmpleados((int) panelCargarEmpleados.cantLiderDeProyecto.getValue(), "Lider de Proyecto");
		crearEmpleados((int) panelCargarEmpleados.cantArquitecto.getValue(), "Arquitecto");
		crearEmpleados((int) panelCargarEmpleados.cantProgramador.getValue(), "Programador");
		crearEmpleados((int) panelCargarEmpleados.cantTester.getValue(), "Tester");
	
		actualizarVista();
	}

	private void eliminarEmpleados() 
	{
		nombresEmpleadosSelec()
		.stream()
		.forEach(n -> modelo.eliminarEmpleado(n));
			
		actualizarTablaDeEmpleados();
	}
	
	private void crearEmpleados(int cantidad, String puesto) 
	{
		String nombre;
		for(int i=1; i <= cantidad; i++) 
		{
			nombre = listaDeNombres.dameUno();
			modelo.agregarEmpleado(nombre, puesto);
			FotosDeEmpleados.agregarFoto(nombre, new ImageIcon("src/iconos/fotoDefault.png"));
		}
	}
	
	private void actualizarVista() 
	{
		actualizarTablaDeEmpleados();
		resetearCampos();
		panelCargarEmpleados.lblCantNombres.setToolTipText("Es posible generar " + listaDeNombres.cantidad() + " empleados.");
	}

	private void actualizarTablaDeEmpleados() 
	{
		ArrayList<Empleado> empleados = modelo.getEmpleados();
		String matriz[][] = new String[modelo.getEmpleados().size()][2];
		
		IntStream.range(0, empleados.size())
		.forEach(i -> {
			matriz[i][0] = empleados.get(i).getNombre();
			matriz[i][1] = empleados.get(i).getPuesto();
		});
		
		DefaultTableModel dtm = new DefaultTableModel(matriz, new String[] {"Nombre", "Puesto"});
		panelCargarEmpleados.tablaEmpleados.setModel(dtm);
	}

	private void resetearCampos() 
	{
		panelCargarEmpleados.txtNombre.setText(null);
		panelCargarEmpleados.txtApellido.setText(null);
		panelCargarEmpleados.cmboxPuestos.setSelectedItem(null);
		panelCargarEmpleados.txtPathFoto.setText("Default");
		panelCargarEmpleados.cantLiderDeProyecto.setValue(0);
		panelCargarEmpleados.cantArquitecto.setValue(0);
		panelCargarEmpleados.cantProgramador.setValue(0);
		panelCargarEmpleados.cantTester.setValue(0);
	}
	
	
	//////////////////////
	//METODOS AUXILIARES//
	//////////////////////
	
	private boolean esPosibleCargarEmpleado() 
	{
		if(!camposEstanLlenos())
		{
			JOptionPane.showMessageDialog(null, "Rellene todos los campos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		
		if(modelo.existeEmpleado(obtenerNombre())) 
		{
			JOptionPane.showMessageDialog(null, "El empleado '" + obtenerNombre() + "' ya fue agregado.", "Advertencia", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		
		if(!existeDirectorio())
		{
			JOptionPane.showMessageDialog(null, "El direcctorio " + obtenerPath() + " no existe.", "Error", JOptionPane.ERROR_MESSAGE);
			panelCargarEmpleados.txtPathFoto.setText("Default");
			return false;
		}
		
		return true;
	}
	
	private boolean existeDirectorio() 
	{
		if(new File(obtenerPath()).exists())
			return true;
		return false;
	}
	
	private boolean camposEstanLlenos() 
	{
		if(panelCargarEmpleados.txtNombre.getText().equals(""))
			return false;
		
		if(panelCargarEmpleados.txtApellido.getText().equals(""))
			return false;
		
		if(panelCargarEmpleados.cmboxPuestos.getSelectedItem() == null)
			return false;
		
		return true;
	}
	
	//Devuelve verdadero si la lista tiene nombres suficientes para la cantidad de empleados a generar
	private boolean sePuedeGenerar() 
	{
		int cantidadAGenerar = (int)panelCargarEmpleados.cantLiderDeProyecto.getValue() + (int)panelCargarEmpleados.cantArquitecto.getValue() 
			+ (int)panelCargarEmpleados.cantProgramador.getValue() + (int)panelCargarEmpleados.cantTester.getValue();
		
		if(listaDeNombres.cantidad() < cantidadAGenerar)
		{
			JOptionPane.showMessageDialog(null, "No es posible generar esa cantidad de empleados.", "Advertencia", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}

	//Metodo que devuelve verdadero si se han cargado al menos un empleado de cada puesto
	public boolean tieneDatosSuficientes()
	{
		ArrayList<Empleado> empleados = modelo.getEmpleados();
		
		int cantLider = (int) empleados.stream().filter(e -> e.getPuesto().equals("Lider de Proyecto")).count();
		int cantArquitecto = (int) empleados.stream().filter(e -> e.getPuesto().equals("Arquitecto")).count();
		int cantProgramador = (int) empleados.stream().filter(e -> e.getPuesto().equals("Programador")).count();
		int cantTester = (int) empleados.stream().filter(e -> e.getPuesto().equals("Tester")).count();
		
		return cantLider >= 1 && cantArquitecto >= 1 && cantProgramador >= 1 && cantTester >= 1;
	}
	
	private String obtenerNombre() 
	{
		return panelCargarEmpleados.txtNombre.getText() + " " + panelCargarEmpleados.txtApellido.getText();
	}
	
	private String obtenerPuesto() 
	{
		return panelCargarEmpleados.cmboxPuestos.getSelectedItem().toString();
	}
	
	private String obtenerPath() 
	{
		if(panelCargarEmpleados.txtPathFoto.getText().equals("Default"))
			return "src/iconos/fotoDefault.png";
		
		return panelCargarEmpleados.txtPathFoto.getText();
	}
	
	//Devuelve una lista con los nombres de los empleados seleccionados de la tabla
	private ArrayList<String> nombresEmpleadosSelec() 
	{	
		int indices[] = panelCargarEmpleados.tablaEmpleados.getSelectedRows();
		
		DefaultTableModel dtm = (DefaultTableModel) panelCargarEmpleados.tablaEmpleados.getModel();
		
		ArrayList<String> nombresEmpleadosSelec = new ArrayList<String>();
		for(Integer i : indices) 
			nombresEmpleadosSelec.add((String) dtm.getValueAt(i, 0));
		
		return nombresEmpleadosSelec;
	}
}
