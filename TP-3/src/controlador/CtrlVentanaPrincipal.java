package controlador;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import modelo.Modelo;
import vista.BuscarSolucion;
import vista.CargarIncompatibles;
import vista.CargarRequerimientos;
import vista.MostrarSolucion;
import vista.VentanaPrincipal;

public class CtrlVentanaPrincipal implements ActionListener
{
	private Modelo modelo;
	private VentanaPrincipal vPrincipal;
	
	private CtrlCargarEmpleados ctrlCargarEmpleados;
	private CtrlCargarIncompatibles ctrlCargarIncompatibles;
	private CtrlCargarRequerimientos ctrlCargarRequerimientos;
	private CtrlMostrarSolucion ctrlMostrarSolucion;
	
	public CtrlVentanaPrincipal(Modelo modelo, VentanaPrincipal vPrincipal) 
	{
		this.modelo = modelo;
		this.vPrincipal = vPrincipal;
	}
	
	public void iniciar() 
	{
		ctrlCargarEmpleados = new CtrlCargarEmpleados(modelo, vPrincipal.panelCargarEmpleado);
		ctrlCargarEmpleados.iniciar();
		
		this.vPrincipal.btnCambiarPanel.addActionListener(this);
		vPrincipal.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		if(arg0.getSource() == vPrincipal.btnCambiarPanel) 
			cambiarDePanel();
	}

	private void cambiarDePanel() 
	{
		
		if(actualEs(vPrincipal.panelCargarEmpleado)) 
		{
			if(ctrlCargarEmpleados.tieneDatosSuficientes()) 
			{
				modelo.confirmarListaDeEmpleados();
			
				iniciarCargarIncompatibles();
			}
			else
				JOptionPane.showMessageDialog(null, "Debe cargar al menos un empleado de cada puesto", "Advertencia", JOptionPane.WARNING_MESSAGE);	
		}
		
		else if(actualEs(vPrincipal.panelCargarIncompatibles)) 
		{
			iniciarCargarRequerimientos();
		}
		
		else if(actualEs(vPrincipal.panelCargarRequerimientos))
		{
			if(ctrlCargarRequerimientos.confirmoCotas()) 
				iniciarBuscarSolucion();
			
			else
				JOptionPane.showMessageDialog(null, "Es posible que no haya confirmado las cotas o que haya habido cambios.", "Advertencia", JOptionPane.WARNING_MESSAGE);
		}
			
	}

	private void iniciarCargarIncompatibles() 
	{
		vPrincipal.panelCargarEmpleado.setVisible(false);
		vPrincipal.panelCargarIncompatibles = new CargarIncompatibles();
		vPrincipal.getContentPane().add(vPrincipal.panelCargarIncompatibles, BorderLayout.CENTER);
		
		ctrlCargarIncompatibles = new CtrlCargarIncompatibles(modelo, vPrincipal.panelCargarIncompatibles);
		ctrlCargarIncompatibles.iniciar();
	}
	
	private void iniciarCargarRequerimientos() 
	{
		vPrincipal.panelCargarIncompatibles.setVisible(false);
		vPrincipal.btnCambiarPanel.setVisible(true);

		vPrincipal.panelCargarRequerimientos = new CargarRequerimientos(vPrincipal.panelCargarEmpleado.tablaEmpleados, vPrincipal.panelCargarIncompatibles.tablaIncompatibles);
		vPrincipal.getContentPane().add(vPrincipal.panelCargarRequerimientos, BorderLayout.CENTER);
		vPrincipal.btnCambiarPanel.setText("Buscar Solucion");
		
		ctrlCargarRequerimientos = new CtrlCargarRequerimientos(modelo, vPrincipal.panelCargarRequerimientos);
		ctrlCargarRequerimientos.iniciar();
	}
	
	private void iniciarBuscarSolucion() 
	{
		vPrincipal.panelCargarRequerimientos.setVisible(false);
		vPrincipal.panelBuscarSolucion = new BuscarSolucion();
		vPrincipal.getContentPane().add(vPrincipal.panelBuscarSolucion, BorderLayout.CENTER);
		vPrincipal.btnCambiarPanel.setVisible(false);
		
		Thread buscarSolucion = new Thread(new Runnable() 
		{
			@Override
			public void run() 
			{	
				modelo.resolver();
	
				iniciarMostrarResultados();
			}
			
		});

		buscarSolucion.start();
	}
	
	private void iniciarMostrarResultados() 
	{
		if(modelo.existeSolucion())
		{
			vPrincipal.panelBuscarSolucion.setVisible(false);
			vPrincipal.panelMostrarSolucion = new MostrarSolucion();
			vPrincipal.getContentPane().add(vPrincipal.panelMostrarSolucion, BorderLayout.CENTER);
			vPrincipal.validate();
		
			ctrlMostrarSolucion = new CtrlMostrarSolucion(modelo,vPrincipal.panelMostrarSolucion);
			ctrlMostrarSolucion.cargarEmpleadosFinales();	
		}
		
		else
		{
			vPrincipal.panelBuscarSolucion.setVisible(false);		
			iniciarCargarRequerimientos();
			
			JOptionPane.showMessageDialog(null, "No es posible formar un equipo con los requerimientos dados", "Advertencia", JOptionPane.WARNING_MESSAGE);
		}
	}
	

	private boolean actualEs(JPanel panel)
	{
		if(panel.isVisible())
			return true;
		return false;
	}
}
