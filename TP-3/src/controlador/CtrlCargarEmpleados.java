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
		panelCargarEmpleados.setCantNombres(listaDeNombres.cantidad());;
		
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
			panelCargarEmpleados.setPathFoto(path);
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
		crearEmpleados(panelCargarEmpleados.getCantLider(), "Lider de Proyecto");
		crearEmpleados(panelCargarEmpleados.getCantArquitecto(), "Arquitecto");
		crearEmpleados(panelCargarEmpleados.getCantProgramador(), "Programador");
		crearEmpleados(panelCargarEmpleados.getCantTester(), "Tester");
	
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
		panelCargarEmpleados.resetearCampos();
		panelCargarEmpleados.setCantNombres(listaDeNombres.cantidad());
	}

	private void actualizarTablaDeEmpleados() 
	{
		ArrayList<Empleado> empleados = modelo.getEmpleados();
		
		String matriz[][] = new String[modelo.cantEmpleados()][2];
		
		IntStream.range(0, empleados.size())
		.forEach(i -> {
			matriz[i][0] = empleados.get(i).getNombre();
			matriz[i][1] = empleados.get(i).getPuesto();
		});
		
		panelCargarEmpleados.setTabla(matriz);
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
			panelCargarEmpleados.resetPath();
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
		if(panelCargarEmpleados.getNombre().isEmpty())
			return false;
		
		if(panelCargarEmpleados.getApellido().isEmpty())
			return false;
		
		if(panelCargarEmpleados.getPuesto().isEmpty())
			return false;
		
		return true;
	}
	
	//Devuelve verdadero si la lista tiene nombres suficientes para la cantidad de empleados a generar
	private boolean sePuedeGenerar() 
	{
		int cantidadAGenerar = panelCargarEmpleados.getCantLider() + panelCargarEmpleados.getCantArquitecto() 
			+ panelCargarEmpleados.getCantProgramador() + panelCargarEmpleados.getCantTester();
		
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
		return panelCargarEmpleados.getNombre() + " " + panelCargarEmpleados.getApellido();
	}
	
	private String obtenerPuesto() 
	{
		return panelCargarEmpleados.getPuesto();
	}
	
	private String obtenerPath() 
	{
		if(panelCargarEmpleados.getPathFoto().equals("Default"))
			return "src/iconos/fotoDefault.png";
		
		return panelCargarEmpleados.getPathFoto();
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
