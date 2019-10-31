package controlador;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import modelo.Modelo;
import vista.CargarRequerimientos;

public class CtrlCargarRequerimientos implements ActionListener
{
	private Modelo modelo;
	private CargarRequerimientos panelCargarRequerimientos;
	private CtrlCargarIncompatibles ctrlCargarIncompatibles;
	private CtrlCargarCotas ctrlCargarCotas;
	
	public CtrlCargarRequerimientos(Modelo modelo, CargarRequerimientos panelCargarRequerimientos) 
	{
		this.modelo = modelo;
		this.panelCargarRequerimientos = panelCargarRequerimientos;
		this.ctrlCargarIncompatibles = new CtrlCargarIncompatibles(modelo, panelCargarRequerimientos);
		this.ctrlCargarCotas = new CtrlCargarCotas(modelo, panelCargarRequerimientos.panelCargarCotas);
	}

	public void iniciar() 
	{
		ctrlCargarIncompatibles.iniciar();
		ctrlCargarCotas.iniciar();
		
		llenarTablaEmpleados();
		
		this.panelCargarRequerimientos.btnAnterior.addActionListener(this);
		this.panelCargarRequerimientos.btnSiguiente.addActionListener(this);
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
		panelCargarRequerimientos.tablaEmpleados.setModel(dtm);
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
		if(arg0.getSource() == panelCargarRequerimientos.btnSiguiente) 
			cambiarACargarCotas();
		
		if(arg0.getSource() == panelCargarRequerimientos.btnAnterior) 
			cambiarACargarIncompatibles();
	}
	
	private void cambiarACargarCotas() 
	{
		panelCargarRequerimientos.panelCargarIncompatibles.setVisible(false);
		panelCargarRequerimientos.panelCargarCotas.setVisible(true);
		panelCargarRequerimientos.panelControles.add(panelCargarRequerimientos.panelCargarCotas, BorderLayout.CENTER);
		desactivarBotones();
	}
	
	private void cambiarACargarIncompatibles() 
	{
		panelCargarRequerimientos.panelCargarCotas.setVisible(false);
		panelCargarRequerimientos.panelCargarIncompatibles.setVisible(true);
		panelCargarRequerimientos.panelControles.add(panelCargarRequerimientos.panelCargarIncompatibles, BorderLayout.CENTER);
		desactivarBotones();
	}
	
	private void desactivarBotones() 
	{
		if(panelCargarRequerimientos.panelCargarCotas.isVisible()) 
		{
			panelCargarRequerimientos.btnSiguiente.setEnabled(false);
			panelCargarRequerimientos.btnAnterior.setEnabled(true);
		}
		
		if(panelCargarRequerimientos.panelCargarIncompatibles.isVisible())
		{
			panelCargarRequerimientos.btnAnterior.setEnabled(false);
			panelCargarRequerimientos.btnSiguiente.setEnabled(true);
		}
	}
}
