package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.stream.IntStream;

import javax.swing.JOptionPane;
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
		
		this.panelCargarEmpleados.btnCargar.addActionListener(this);
		this.panelCargarEmpleados.btnGenerar.addActionListener(this);
		this.panelCargarEmpleados.btnEliminar.addActionListener(this);
	}
		
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		if(arg0.getSource() == panelCargarEmpleados.btnCargar)
			cargarEmpleado();
		
		if(arg0.getSource() == panelCargarEmpleados.btnGenerar)
			generarEmpleados();
		
		if(arg0.getSource() == panelCargarEmpleados.btnEliminar)
			eliminarEmpleados();
	}

	private void cargarEmpleado() 
	{
		if(camposEstanLlenos()) 
		{
			String nombre = obtenerNombre();
			String puesto = obtenerPuesto();
			
			if(!modelo.existeEmpleado(nombre))
			{
				modelo.agregarEmpleado(nombre, puesto);
				listaDeNombres.eliminar(nombre);
				
				actualizarVista();
			}
			else
				JOptionPane.showMessageDialog(null, "El empleado '" + nombre + "' ya fue agregado.", "Advertencia", JOptionPane.WARNING_MESSAGE);
		}
		else
			JOptionPane.showMessageDialog(null, "Rellene todos los campos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
	}
	
	private void generarEmpleados() 
	{
		if(cantidadEsValida()) 
		{
			crearEmpleados((int) panelCargarEmpleados.cantLiderDeProyecto.getValue(), "Lider de Proyecto");
			crearEmpleados((int) panelCargarEmpleados.cantArquitecto.getValue(), "Arquitecto");
			crearEmpleados((int) panelCargarEmpleados.cantProgramador.getValue(), "Programador");
			crearEmpleados((int) panelCargarEmpleados.cantTester.getValue(), "Tester");
		
			actualizarVista();
		}
		else
			JOptionPane.showMessageDialog(null, "No es posible generar esa cantidad de empleados.", "Advertencia", JOptionPane.WARNING_MESSAGE);
		
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
		IntStream.rangeClosed(1, cantidad)
		.forEach(i -> modelo.agregarEmpleado(listaDeNombres.dameUno(), puesto));
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
		panelCargarEmpleados.cantLiderDeProyecto.setValue(0);
		panelCargarEmpleados.cantArquitecto.setValue(0);
		panelCargarEmpleados.cantProgramador.setValue(0);
		panelCargarEmpleados.cantTester.setValue(0);
	}
	
	//METODOS AUXILIARES
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
	
	private boolean cantidadEsValida() 
	{
		int cantidadAGenerar = (int)panelCargarEmpleados.cantLiderDeProyecto.getValue() + (int)panelCargarEmpleados.cantArquitecto.getValue() 
			+ (int)panelCargarEmpleados.cantProgramador.getValue() + (int)panelCargarEmpleados.cantTester.getValue();
		
		if(listaDeNombres.cantidad() >= cantidadAGenerar)
			return true;
		return false;
	}
	
	private ArrayList<String> nombresEmpleadosSelec() 
	{	
		int indices[] = panelCargarEmpleados.tablaEmpleados.getSelectedRows();
		
		DefaultTableModel dtm = (DefaultTableModel) panelCargarEmpleados.tablaEmpleados.getModel();
		
		ArrayList<String> nombresEmpleadosSelec = new ArrayList<String>();
		for(Integer i : indices) 
			nombresEmpleadosSelec.add((String) dtm.getValueAt(i, 0));
		
		return nombresEmpleadosSelec;
	}
	
	private String obtenerNombre() 
	{
		return panelCargarEmpleados.txtNombre.getText() + " " + panelCargarEmpleados.txtApellido.getText();
	}
	
	private String obtenerPuesto() 
	{
		return panelCargarEmpleados.cmboxPuestos.getSelectedItem().toString();
	}

	public boolean tieneDatosSuficientes()
	{
		ArrayList<Empleado> empleados = modelo.getEmpleados();
		
		int cantLider = (int) empleados.stream().filter(e -> e.getPuesto().equals("Lider de Proyecto")).count();
		int cantArquitecto = (int) empleados.stream().filter(e -> e.getPuesto().equals("Arquitecto")).count();
		int cantProgramador = (int) empleados.stream().filter(e -> e.getPuesto().equals("Programador")).count();
		int cantTester = (int) empleados.stream().filter(e -> e.getPuesto().equals("Tester")).count();
		
		return cantLider >= 1 && cantArquitecto >= 1 && cantProgramador >= 1 && cantTester >= 1;
	}
}
