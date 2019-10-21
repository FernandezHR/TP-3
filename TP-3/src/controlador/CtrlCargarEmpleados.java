package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
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
			String nombre = panelCargarEmpleados.txtNombre.getText() + " " + panelCargarEmpleados.txtApellido.getText();
			String puesto = panelCargarEmpleados.cmboxPuestos.getSelectedItem().toString();
			
			try
			{
				modelo.agregarEmpleado(nombre, puesto);
				listaDeNombres.eliminarSiExiste(nombre);
				
				actualizarVista();
	
			} catch(RuntimeException e) 
			{
				JOptionPane.showMessageDialog(null, e.getMessage(), "Advertencia", JOptionPane.WARNING_MESSAGE);
			}			

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
		for(Empleado empleado : empleadosSeleccionados())
			modelo.getEmpleados().remove(empleado);
			
		actualizarTablaDeEmpleados();
	}
	
	private void crearEmpleados(int cantidad, String puesto) 
	{
		for(int i=0; i < cantidad; i++)
			modelo.agregarEmpleado(listaDeNombres.dameUno(), puesto);
	}
	
	private void actualizarVista() 
	{
		actualizarTablaDeEmpleados();
		resetearCampos();
		panelCargarEmpleados.lblCantNombres.setToolTipText("Es posible generar " + listaDeNombres.cantidad() + " empleados.");
	}

	private void actualizarTablaDeEmpleados() 
	{
		String matriz[][] = new String[modelo.getEmpleados().size()][2];
		
		for(int i=0; i < modelo.getEmpleados().size(); i++) 
		{
			matriz[i][0] = modelo.getEmpleados().get(i).getNombre();
			matriz[i][1] = modelo.getEmpleados().get(i).getPuesto();
		}
		
		DefaultTableModel dtm = new DefaultTableModel(matriz, new String[] {"Nombre", "Puesto"}) 
		{
			@Override //Sobreescribmos este metodo para desactivar la edicion de celdas
			public boolean isCellEditable(int i, int j) 
			{
				return false;
			}
		};
		
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
	
	private Set<Empleado> empleadosSeleccionados() 
	{
		int indices[] = panelCargarEmpleados.tablaEmpleados.getSelectedRows();
		
		Set<Empleado> empleadosSelec = new HashSet<Empleado>();
		for(Integer i : indices)
			empleadosSelec.add(modelo.getEmpleados().get(i));
		
		return empleadosSelec;
	}

}
