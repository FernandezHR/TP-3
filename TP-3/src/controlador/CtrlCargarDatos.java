package controlador;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

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
		this.ctrlCargarCotas = new CtrlCargarCotas(modelo, panelCargarRequerimientos.panelCargarCotas);
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
		String matriz[][] = new String[modelo.getEmpleados().size()][2];
		
		for(int i=0; i < modelo.getEmpleados().size() ; i++) 
		{
			matriz[i][0] = modelo.getEmpleados().get(i).getNombre();
			matriz[i][1] = modelo.getEmpleados().get(i).getPuesto();
		}
		
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
			return true;
		return false;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		if(arg0.getSource() == panelCargarDatos.btnSiguiente) 
			cambiarACargarCotas();
		
		if(arg0.getSource() == panelCargarDatos.btnAnterior) 
			cambiarACargarIncompatibles();
	}
	
	private void cambiarACargarCotas() 
	{
		panelCargarDatos.panelCargarIncompatibles.setVisible(false);
		panelCargarDatos.panelCargarCotas.setVisible(true);
		panelCargarDatos.panelControles.add(panelCargarDatos.panelCargarCotas, BorderLayout.CENTER);
		desactivarBotones();
	}
	
	private void cambiarACargarIncompatibles() 
	{
		panelCargarDatos.panelCargarCotas.setVisible(false);
		panelCargarDatos.panelCargarIncompatibles.setVisible(true);
		panelCargarDatos.panelControles.add(panelCargarDatos.panelCargarIncompatibles, BorderLayout.CENTER);
		desactivarBotones();
	}
	
	private void desactivarBotones() 
	{
		if(panelCargarDatos.panelCargarCotas.isVisible()) 
		{
			panelCargarDatos.btnSiguiente.setEnabled(false);
			panelCargarDatos.btnAnterior.setEnabled(true);
		}
		
		if(panelCargarDatos.panelCargarIncompatibles.isVisible())
		{
			panelCargarDatos.btnAnterior.setEnabled(false);
			panelCargarDatos.btnSiguiente.setEnabled(true);
		}
	}
}
