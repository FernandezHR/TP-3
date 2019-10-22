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
			panelCargarIncompatibles.cmboxEmpleado1.addItem(empleado.getNombre());
			panelCargarIncompatibles.cmboxEmpleado2.addItem(empleado.getNombre());
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
		
		if(empleado1 != empleado2)
		{
			modelo.agregarMalaRelacion(empleado1, empleado2);
			actualizarTablaDeIncompatibles();
		}	
		
		else
			JOptionPane.showMessageDialog(null, "Seleccione empleados distintos", "Advertencia", JOptionPane.WARNING_MESSAGE);
	}

	private void actualizarTablaDeIncompatibles() 
	{
		DefaultTableModel tablaModelo = (DefaultTableModel) panelCargarIncompatibles.tablaIncompatibles.getModel();
		
		String empleado1 = (String) panelCargarIncompatibles.cmboxEmpleado1.getSelectedItem();
		String empleado2 = (String) panelCargarIncompatibles.cmboxEmpleado2.getSelectedItem();
		
		tablaModelo.addRow(new String[]{empleado1, empleado2});
	}

}
