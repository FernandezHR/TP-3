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
	private CtrlCargarRequerimientos ctrlCargarRequerimientos;
	private CtrlMostrarSolucion ctrlMostrarSolucion;
	
	public CtrlVentanaPrincipal(Modelo modelo, VentanaPrincipal vPrincipal) 
	{
		this.modelo = modelo;
		this.vPrincipal = vPrincipal;
		
		ctrlCargarEmpleados = new CtrlCargarEmpleados(modelo, vPrincipal.panelCargarEmpleado);
		ctrlCargarRequerimientos = new CtrlCargarRequerimientos(modelo, vPrincipal.panelCargarRequerimientos);
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
			
				comenzarCargarRequerimientos();
			}
			else
				JOptionPane.showMessageDialog(null, "Debe cargar al menos un empleado de cada puesto", "Advertencia", JOptionPane.WARNING_MESSAGE);	
		}
		
		else if(vPrincipal.estaEnCargarRequerimientos())
		{
			if(!ctrlCargarRequerimientos.hayInconvenientes())
			{	
				ctrlCargarRequerimientos.ejecutar();
				comenzarBusquedaDeSolucion();
			}
		}
		
		else if(vPrincipal.estaEnMostrarSolucion())
		{
			vPrincipal.activarVistaCargarRequerimientos();
		}
	}

	private void comenzarCargarRequerimientos() 
	{
		vPrincipal.activarVistaCargarRequerimientos();
		ctrlCargarRequerimientos.iniciar();
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
