package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Empleado;
import modelo.Modelo;
import vista.CargarIncompatibles;

public class CtrlCargarIncompatibles implements ActionListener
{
	private Modelo modelo;
	private CargarIncompatibles panelCargarIncompatibles;
	
	public CtrlCargarIncompatibles(Modelo modelo, CargarIncompatibles panelCargarIncompatibles) 
	{
		this.modelo = modelo;
		this.panelCargarIncompatibles = panelCargarIncompatibles;	
	}
	
	public void iniciar() 
	{
		for(Empleado empleado: modelo.getEmpleados())
		{
			panelCargarIncompatibles.cmboxEmpleado1.addItem(empleado.getNombre() + ", " + empleado.getPuesto());
			panelCargarIncompatibles.cmboxEmpleado2.addItem(empleado.getNombre() + ", " + empleado.getPuesto());
		}
		
		panelCargarIncompatibles.btnAgregar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == panelCargarIncompatibles.btnAgregar)
			agregarIncompatibles();
		
	}
	
	private void agregarIncompatibles() 
	{
		if(losEmpleadosSonValidos())
		{
			String empleado1 = nombreE1();
			String empleado2 = nombreE2();
			
			modelo.agregarMalaRelacion(empleado1, empleado2);
			
			actualizarTablaDeIncompatibles();
		}	
		else
			JOptionPane.showMessageDialog(null, "Seleccione empleados distintos y/o no agregados", "Advertencia", JOptionPane.WARNING_MESSAGE);
	}
	
	private void actualizarTablaDeIncompatibles() 
	{
		DefaultTableModel tablaModelo = (DefaultTableModel) panelCargarIncompatibles.tablaIncompatibles.getModel();
		
		tablaModelo.addRow(new String[] { nombreE1(), puestoE1(), nombreE2(), puestoE2() });
	}
	
	
	//METODOS AUXILIARES
	private boolean losEmpleadosSonValidos() 
	{
		return !nombreE1().equals(nombreE2()) && !relacionFueAgregada();
	}

	private boolean relacionFueAgregada()
	{	
		return modelo.existeMalaRelacionEntre(nombreE1(), nombreE2());
	}
	
	private String nombreE1() 
	{
		int i = panelCargarIncompatibles.cmboxEmpleado1.getSelectedIndex();
		
		return modelo.getEmpleados().get(i).getNombre();
	}
	
	private String nombreE2() 
	{
		int i = panelCargarIncompatibles.cmboxEmpleado2.getSelectedIndex();
		
		return modelo.getEmpleados().get(i).getNombre();
	}

	private String puestoE1()
	{
		int i = panelCargarIncompatibles.cmboxEmpleado1.getSelectedIndex();
		
		return modelo.getEmpleados().get(i).getPuesto();
	}
	
	private String puestoE2()
	{
		int i = panelCargarIncompatibles.cmboxEmpleado2.getSelectedIndex();
		
		return modelo.getEmpleados().get(i).getPuesto();
	}
	
	
}
