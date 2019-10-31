package controlador;

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
	private CtrlCargarDatos ctrlCargarDatos;
	private CtrlMostrarSolucion ctrlMostrarSolucion;
	
	public CtrlVentanaPrincipal(Modelo modelo, VentanaPrincipal vPrincipal) 
	{
		this.modelo = modelo;
		this.vPrincipal = vPrincipal;
		
		ctrlCargarEmpleados = new CtrlCargarEmpleados(modelo, vPrincipal.panelCargarEmpleado);
		ctrlCargarDatos = new CtrlCargarDatos(modelo, vPrincipal.panelCargarDatos);
		ctrlMostrarSolucion = new CtrlMostrarSolucion(modelo, vPrincipal.panelMostrarSolucion);
		
		this.vPrincipal.btnAvanzar.addActionListener(this);
	}
	
	public void iniciar() 
	{
		ctrlCargarEmpleados.iniciar();
		vPrincipal.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		if(arg0.getSource() == vPrincipal.btnAvanzar) 
			cambiarDePanel();
	}

	private void cambiarDePanel() 
	{
		if(vPrincipal.estaEnCargarEmpleados()) 
		{
			if(ctrlCargarEmpleados.tieneDatosSuficientes()) 
			{
				modelo.confirmarListaDeEmpleados();
			
				comenzarCargarDatos();
			}
			else
				JOptionPane.showMessageDialog(null, "Debe cargar al menos un empleado de cada puesto", "Advertencia", JOptionPane.WARNING_MESSAGE);	
		}
		
		else if(vPrincipal.estaEnCargarRequerimientos())
		{
			if(!ctrlCargarDatos.hayInconvenientes())
			{	
				ctrlCargarDatos.ejecutar();
				comenzarBusquedaDeSolucion();
			}
		}
		
		else if(vPrincipal.estaEnMostrarSolucion())
		{
			vPrincipal.activarVistaCargarRequerimientos();
		}
	}

	private void comenzarCargarDatos() 
	{
		vPrincipal.activarVistaCargarRequerimientos();
		ctrlCargarDatos.iniciar();
	}
	
	private void comenzarBusquedaDeSolucion() 
	{
		vPrincipal.activarVistaBuscarSolucion();
		
		Thread buscarSolucion = new Thread(new Runnable() 
		{
			@Override
			public void run() 
			{	
				modelo.resolver();
				
				comenzarMuestraDeSolucion();
			}
		});
		buscarSolucion.start();
	}
	
	private void comenzarMuestraDeSolucion() 
	{
		vPrincipal.activarVistaMostrarSolucion();
		ctrlMostrarSolucion.iniciar();
	}

}
