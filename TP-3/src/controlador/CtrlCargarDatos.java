package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.stream.IntStream;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Empleado;
import modelo.Modelo;
import vista.CargarDatos;

public class CtrlCargarDatos implements ActionListener
{
	private Modelo modelo;
	private CargarDatos panelCargarDatos;
	
	private CtrlCargarIncompatibles ctrlCargarIncompatibles;
	private CtrlCargarCotas ctrlCargarCotas;
	
	public CtrlCargarDatos(Modelo modelo, CargarDatos panelCargarRequerimientos) 
	{
		this.modelo = modelo;
		this.panelCargarDatos = panelCargarRequerimientos;
		this.ctrlCargarIncompatibles = new CtrlCargarIncompatibles(modelo, panelCargarRequerimientos);
		this.ctrlCargarCotas = new CtrlCargarCotas(modelo, panelCargarRequerimientos);
	}

	public void iniciar() 
	{
		ctrlCargarIncompatibles.iniciar();
		ctrlCargarCotas.iniciar();
		
		llenarTablaEmpleados();
		
		this.panelCargarDatos.btnAnterior.addActionListener(this);
		this.panelCargarDatos.btnSiguiente.addActionListener(this);
	}
	
	private void llenarTablaEmpleados() 
	{
		ArrayList<Empleado> empleados = modelo.getEmpleados();
		
		String matriz[][] = new String[empleados.size()][2];
		
		IntStream.range(0, empleados.size())
		.forEach(i -> {
			matriz[i][0] = empleados.get(i).getNombre();
			matriz[i][1] = empleados.get(i).getPuesto();
		});
		
		DefaultTableModel dtm = new DefaultTableModel(matriz, new String[] {"Nombre", "Puesto"});
		panelCargarDatos.tablaEmpleados.setModel(dtm);
	}

	public void ejecutar() 
	{
		ctrlCargarCotas.ejecutar();
	}
	
	public boolean hayInconvenientes() 
	{
		if(!ctrlCargarCotas.tieneCotasValidas())
		{		
			JOptionPane.showMessageDialog(null, "Verifique que las cotas minimas no superen las maximas.", "Advertencia", JOptionPane.WARNING_MESSAGE);
			return true;
		}
		return false;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		if(arg0.getSource() == panelCargarDatos.btnSiguiente) 
			panelCargarDatos.cambiarPanel();
		
		if(arg0.getSource() == panelCargarDatos.btnAnterior)
			panelCargarDatos.cambiarPanel();
	}		
}