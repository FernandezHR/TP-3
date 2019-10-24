package controlador;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.Modelo;
import vista.VentanaPrincipal;

public class CtrlVentanaPrincipal implements ActionListener
{
	private Modelo modelo;
	private VentanaPrincipal vPrincipal;
	
	private CtrlCargarEmpleados ctrlCargarEmpleados;
	private CtrlCargarIncompatibles ctrlCargarIncompatibles;
	
	public CtrlVentanaPrincipal(Modelo modelo, VentanaPrincipal vPrincipal) 
	{
		this.modelo = modelo;
		this.vPrincipal = vPrincipal;
		
		this.vPrincipal.btnSiguinte.addActionListener(this);
	}
	
	public void iniciar() 
	{
		ctrlCargarEmpleados = new CtrlCargarEmpleados(modelo, vPrincipal.panelCargarEmpleado);
		ctrlCargarEmpleados.iniciar();
		
		vPrincipal.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		if(arg0.getSource() == vPrincipal.btnSiguinte) 
			cambiarDePanel();
	}

	private void cambiarDePanel() 
	{
		if(esPanelCargarEmpleado()) 
		{
			if(ctrlCargarEmpleados.tieneDatosSuficientes()) 
			{
				modelo.iniMalasRelaciones();
			
				iniciarCargaIncompatibles();
				
			}
			else
				JOptionPane.showMessageDialog(null, "Debe cargar al menos un empleado de cada puesto", "Advertencia", JOptionPane.WARNING_MESSAGE);	
		}
		
		else if(esPanelCargarIncompatibles()) 
		{
			vPrincipal.getContentPane().add(vPrincipal.panelCargarRequerimientos, BorderLayout.CENTER);
			vPrincipal.panelCargarIncompatibles.setVisible(false);
		}
			
	}

	private void iniciarCargaIncompatibles() 
	{
		ctrlCargarIncompatibles = new CtrlCargarIncompatibles(modelo, vPrincipal.panelCargarIncompatibles);
		ctrlCargarIncompatibles.iniciar();

		vPrincipal.getContentPane().add(vPrincipal.panelCargarIncompatibles, BorderLayout.CENTER);
		vPrincipal.panelCargarEmpleado.setVisible(false);
	}

	private boolean esPanelCargarEmpleado() 
	{
		if(vPrincipal.panelCargarEmpleado.isVisible())
			return true;
		return false;
	}

	private boolean esPanelCargarIncompatibles() 
	{
		if(vPrincipal.panelCargarIncompatibles.isVisible())
			return true;
		return false;
	}
}
