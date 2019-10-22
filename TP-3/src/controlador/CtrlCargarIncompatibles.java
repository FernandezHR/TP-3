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
	private JComboBox<String> boxEmpleado1,boxEmpleado2;
	
	public CtrlCargarIncompatibles(Modelo modelo, CargarIncompatibles panelCargarIncompatibles) 
	{
		this.modelo = modelo;
		this.panelCargarIncompatibles = panelCargarIncompatibles;	
		this.boxEmpleado1 = panelCargarIncompatibles.cmboxEmpleado1;
		this.boxEmpleado2 = panelCargarIncompatibles.cmboxEmpleado2;
	}
	
	public void iniciar() 
	{
		for(Empleado empleado: modelo.getEmpleados())
		{
			boxEmpleado1.addItem(empleado.getNombre() + " - " + empleado.getPuesto());
			boxEmpleado2.addItem(empleado.getNombre() + " - " + empleado.getPuesto());
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
		int empleado1 = obtenerEmpleadoSeleccionado(boxEmpleado1);
		int empleado2 = obtenerEmpleadoSeleccionado(boxEmpleado2);
		
		if(losEmpleadosSonValidos(empleado1, empleado2))
		{
			modelo.agregarMalaRelacion(empleado1, empleado2);
			actualizarTablaDeIncompatibles();
		}	
		
		else
			JOptionPane.showMessageDialog(null, "Seleccione empleados distintos y/o no agregados", "Advertencia", JOptionPane.WARNING_MESSAGE);
	}
	
	private int obtenerEmpleadoSeleccionado(JComboBox<?> cmBox)
	{
		return cmBox.getSelectedIndex();
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
		
		int e1 = obtenerEmpleadoSeleccionado(boxEmpleado1);
		int e2 = obtenerEmpleadoSeleccionado(boxEmpleado2);
		
		String nombreE1 = modelo.getEmpleados().get(e1).getNombre();
		String puestoE1 = modelo.getEmpleados().get(e1).getPuesto();
		String nombreE2 = modelo.getEmpleados().get(e2).getNombre();
		String puestoE2 = modelo.getEmpleados().get(e2).getPuesto();
		
		tablaModelo.addRow(new String[]{nombreE1, puestoE1, nombreE2, puestoE2});
	}

	
}
