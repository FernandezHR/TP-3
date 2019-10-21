package controlador;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import modelo.Empleado;
import modelo.Modelo;
import vista.VentanaPrincipal;

public class CtrlVentanaPrincipal implements ActionListener
{
	private Modelo modelo;
	private VentanaPrincipal vPrincipal;
	
	private ListaDeNombres listaDeNombres;
	
	private ArrayList<Empleado> empleados;
	
	public CtrlVentanaPrincipal(Modelo modelo, VentanaPrincipal vPrincipal) 
	{
		this.modelo = modelo;
		this.vPrincipal = vPrincipal;
		
		listaDeNombres = new ListaDeNombres();
		
		empleados = new ArrayList<Empleado>();
		
		this.vPrincipal.btnCargar.addActionListener(this);
		this.vPrincipal.btnGenerar.addActionListener(this);
		this.vPrincipal.btnEliminar.addActionListener(this);
		this.vPrincipal.btnSiguinte.addActionListener(this);
		this.vPrincipal.btnAgregar.addActionListener(this);

	}
	
	public void iniciar() 
	{
		vPrincipal.lblCantNombres.setToolTipText("Es posible generar " + listaDeNombres.cantidad() + " empleados.");
		vPrincipal.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		if(arg0.getSource() == vPrincipal.btnCargar)
			cargarEmpleado();
		
		if(arg0.getSource() == vPrincipal.btnGenerar)
			generarEmpleados();
		
		if(arg0.getSource() == vPrincipal.btnEliminar)
			eliminarEmpleado();
		
		if(arg0.getSource() == vPrincipal.btnSiguinte) 
			configurarSegundoPanel();
		
		if(arg0.getSource() == vPrincipal.btnAgregar)
			agregarIncompatibles();
	}

	

	private void agregarIncompatibles() 
	{
		int empleado1 = vPrincipal.cmboxIncompat.getSelectedIndex();
		int empleado2 = vPrincipal.cmboxIncompat2.getSelectedIndex();
		
		if(empleado1 != empleado2)
			modelo.agregarBuenaRelacion(empleado1,empleado2);		
		
		else
			JOptionPane.showMessageDialog(null, "Seleccione empleados distintos", "Advertencia", JOptionPane.ERROR_MESSAGE);
	}

	
	private void cargarEmpleado() 
	{
		if(camposEstanLlenos()) 
		{
			String nombre = vPrincipal.txtNombre.getText() + " " + vPrincipal.txtApellido.getText();
			String puesto = vPrincipal.cmboxPuestos.getSelectedItem().toString();
			
			if(!existeEmpleado(nombre)) 
			{
				crearEmpleado(nombre, puesto);
				listaDeNombres.eliminarSiExiste(nombre);
				
				actualizarVista();
			}
			else
				JOptionPane.showMessageDialog(null, "El empleado ya existe.", "Advertencia", JOptionPane.WARNING_MESSAGE);

		}
		else
			JOptionPane.showMessageDialog(null, "Rellene todos los campos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
	}
	
	private void generarEmpleados() 
	{
		if(cantidadEsValida()) 
		{
			crearEmpleados((int) vPrincipal.cantLiderDeProyecto.getValue(), "Lider de Proyecto");
			crearEmpleados((int) vPrincipal.cantArquitecto.getValue(), "Arquitecto");
			crearEmpleados((int) vPrincipal.cantProgramador.getValue(), "Programador");
			crearEmpleados((int) vPrincipal.cantTester.getValue(), "Tester");
		
			actualizarVista();
		}
		else
			JOptionPane.showMessageDialog(null, "No es posible generar esa cantidad de empleados.", "Advertencia", JOptionPane.WARNING_MESSAGE);
		
	}

	private void eliminarEmpleado() 
	{
		if(seleccionoAlguno()) 
		{		
			for(Empleado empleado : empleadosSeleccionados())
				empleados.remove(empleado);
			
			actualizarTablaDeEmpleados();
		
			if(empleados.size() == 0)
				vPrincipal.btnEliminar.setEnabled(false);
		}
		else
			JOptionPane.showMessageDialog(null, "No has seleccionado ninguno.", "Advertencia", JOptionPane.WARNING_MESSAGE);	
	}


	private void crearEmpleado(String nombre, String puesto) 
	{
		Empleado empleado = new Empleado(nombre, puesto);
		empleados.add(empleado);
	}
	
	private void crearEmpleados(int cantidad, String puesto) 
	{
		for(int i=0; i < cantidad; i++)
			crearEmpleado(listaDeNombres.dameUno(), puesto);
	}
	
	private void actualizarVista() 
	{
		actualizarTablaDeEmpleados();
		resetearCampos();
		vPrincipal.lblCantNombres.setToolTipText("Es posible generar " + listaDeNombres.cantidad() + " empleados.");
		
		if(empleados.size() > 0)
			vPrincipal.btnEliminar.setEnabled(true);
	}

	private void actualizarTablaDeEmpleados() 
	{
		String matriz[][] = new String[empleados.size()][2];
		
		for(int i=0; i < empleados.size(); i++) 
		{
			matriz[i][0] = empleados.get(i).getNombre();
			matriz[i][1] = empleados.get(i).getPuesto();
		}
		
		DefaultTableModel dtm = new DefaultTableModel(matriz, new String[] {"Nombre", "Puesto"}) 
		{
			@Override //Sobreescribmos este metodo para desactivar la edicion de celdas
			public boolean isCellEditable(int i, int j) 
			{
				return false;
			}
		};
		
		vPrincipal.tablaEmpleados.setModel(dtm);
	}

	private void resetearCampos() 
	{
		vPrincipal.txtNombre.setText(null);
		vPrincipal.txtApellido.setText(null);
		vPrincipal.cmboxPuestos.setSelectedItem(null);
		vPrincipal.cantLiderDeProyecto.setValue(0);
		vPrincipal.cantArquitecto.setValue(0);
		vPrincipal.cantProgramador.setValue(0);
		vPrincipal.cantTester.setValue(0);
	}
	
	
	private void configurarSegundoPanel() 
	{
		if(empleados.size() <= 1)
			JOptionPane.showMessageDialog(null, "Debe cargar mas empleados", "Advertencia", JOptionPane.WARNING_MESSAGE);
		else
		{
			vPrincipal.getContentPane().add(vPrincipal.segundoPanel, BorderLayout.CENTER);
			vPrincipal.primerPanel.setVisible(false);
			modelo.inicializar(empleados.size());
		
			for(Empleado empleado: empleados)
			{
				vPrincipal.cmboxIncompat.addItem(empleado.getNombre());
				vPrincipal.cmboxIncompat2.addItem(empleado.getNombre());
			}
		}
	}
	
	//METODOS AUXILIARES
	private boolean camposEstanLlenos() 
	{
		if(vPrincipal.txtNombre.getText().equals(""))
			return false;
		
		if(vPrincipal.txtApellido.getText().equals(""))
			return false;
		
		if(vPrincipal.cmboxPuestos.getSelectedItem() == null)
			return false;
		
		return true;
	}
	
	private boolean existeEmpleado(String nombre) 
	{
		for(Empleado empleado : empleados)
			if(empleado.getNombre().equals(nombre))
				return true;
		
		return false;
	}
	
	private boolean seleccionoAlguno() 
	{
		int filaSelec = vPrincipal.tablaEmpleados.getSelectedRow();
		
		if(filaSelec == -1)
			return false;
		return true;
	}
	
	private boolean cantidadEsValida() 
	{
		int cantidadAGenerar = (int)vPrincipal.cantLiderDeProyecto.getValue() + (int)vPrincipal.cantArquitecto.getValue() 
			+ (int)vPrincipal.cantProgramador.getValue() + (int)vPrincipal.cantTester.getValue();
		
		if(listaDeNombres.cantidad() >= cantidadAGenerar)
			return true;
		return false;
	}
	
	private Set<Empleado> empleadosSeleccionados() 
	{
		int indices[] = vPrincipal.tablaEmpleados.getSelectedRows();
		
		Set<Empleado> empleadosSelec = new HashSet<Empleado>();
		for(Integer i : indices)
			empleadosSelec.add(empleados.get(i));
		
		return empleadosSelec;
	}
	
	public ArrayList<Empleado> getEmpleados()
	{
		return empleados;
	}
}
