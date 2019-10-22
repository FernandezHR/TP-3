package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JComboBox;
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
			panelCargarIncompatibles.cmboxEmpleado1.addItem(empleado.getNombre() + " - " + empleado.getPuesto());
			panelCargarIncompatibles.cmboxEmpleado2.addItem(empleado.getNombre() + " - " + empleado.getPuesto());
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
		int empleado1 = panelCargarIncompatibles.cmboxEmpleado1.getSelectedIndex();
		int empleado2 = panelCargarIncompatibles.cmboxEmpleado2.getSelectedIndex();
		
		if(losEmpleadosSonValidos(empleado1, empleado2))
		{
			modelo.agregarMalaRelacion(empleado1, empleado2);
			actualizarTablaDeIncompatibles();
		}	
		
		else
			JOptionPane.showMessageDialog(null, "Seleccione empleados distintos y/o no agregados", "Advertencia", JOptionPane.WARNING_MESSAGE);
	}

	private boolean losEmpleadosSonValidos(int empleado1, int empleado2) 
	{
		return empleado1 != empleado2 && !relacionFueAgregada(empleado1,empleado2);
	}

	private boolean relacionFueAgregada(int e1, int e2)
	{
		return modelo.existeMalaRelacionEntre(e1,e2);
	}
	
	private void actualizarTablaDeIncompatibles() 
	{
		DefaultTableModel tablaModelo = (DefaultTableModel) panelCargarIncompatibles.tablaIncompatibles.getModel();
		
		int e1 = panelCargarIncompatibles.cmboxEmpleado1.getSelectedIndex();
		int e2 = panelCargarIncompatibles.cmboxEmpleado2.getSelectedIndex();
		
		String nombreE1 = modelo.getEmpleados().get(e1).getNombre();
		String puestoE1 = modelo.getEmpleados().get(e1).getPuesto();
		String nombreE2 = modelo.getEmpleados().get(e2).getNombre();
		String puestoE2 = modelo.getEmpleados().get(e2).getPuesto();
		
		tablaModelo.addRow(new String[]{nombreE1, puestoE1, nombreE2, puestoE2});
	}

	
}
