package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Modelo;
import vista.BuscarSolucion;

public class CtrlBuscarSolucion implements ActionListener
{
	private Modelo modelo;
	private BuscarSolucion panelBuscarSolucion;
	
	private Thread buscarSolucion;
	
	public CtrlBuscarSolucion(Modelo modelo, BuscarSolucion panelBuscandoSolucion) 
	{
		this.modelo = modelo;
		this.panelBuscarSolucion = panelBuscandoSolucion;
		
		buscarSolucion = new Thread(new Runnable() {
			@Override
			public void run() 
			{
				modelo.resolver();
			}
		});
		
	}
	
	public void iniciar() 
	{
		buscarSolucion.start();	
	}
	
	
	public void esperar() 
	{
		try {
			buscarSolucion.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
