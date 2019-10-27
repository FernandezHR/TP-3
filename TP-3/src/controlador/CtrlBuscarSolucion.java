package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Modelo;
import vista.BuscarSolucion;

public class CtrlBuscarSolucion implements ActionListener
{
	private Modelo modelo;
	private BuscarSolucion panelBuscarSolucion;
	
	public CtrlBuscarSolucion(Modelo modelo, BuscarSolucion panelBuscandoSolucion) 
	{
		this.modelo = modelo;
		this.panelBuscarSolucion = panelBuscandoSolucion;	
	}
	
	public void iniciar() 
	{
		modelo.resolver();	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		
	}

}
