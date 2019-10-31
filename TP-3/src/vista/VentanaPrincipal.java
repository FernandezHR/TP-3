package vista;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

@SuppressWarnings("serial")
public class VentanaPrincipal extends JFrame
{
	public CargarEmpleados panelCargarEmpleado;
	public CargarDatos panelCargarDatos;
	public BuscarSolucion panelBuscarSolucion;
	public MostrarSolucion panelMostrarSolucion;
	
	public JButton btnAvanzar;
	
	private Color verde;
	
	public VentanaPrincipal() 
	{
		verde = new Color(21, 182, 141);
		
		this.setMinimumSize(new Dimension(750,580));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().setBackground(verde);
		
		inicializar();
	}

	private void inicializar() 
	{	
		panelCargarEmpleado = new CargarEmpleados();
		this.getContentPane().add(panelCargarEmpleado, BorderLayout.CENTER);
		
		panelCargarDatos = new CargarDatos();
		panelBuscarSolucion = new BuscarSolucion();
		panelMostrarSolucion = new MostrarSolucion();
		
		btnAvanzar = new JButton("Siguiente");
		btnAvanzar.setForeground(Color.WHITE);
		btnAvanzar.setFont(new Font("Nirmala UI", Font.BOLD, 13));
		btnAvanzar.setFocusable(false);
		btnAvanzar.setBackground(new Color(11, 53, 42));
		this.getContentPane().add(btnAvanzar, BorderLayout.SOUTH);			
	}
	
	public void activarVistaCargarRequerimientos() 
	{
		btnAvanzar.setText("BuscarSolucion");
		panelCargarEmpleado.setVisible(false);
		panelBuscarSolucion.setVisible(false);
		panelMostrarSolucion.setVisible(false);
		panelCargarDatos.setVisible(true);
		this.getContentPane().add(panelCargarDatos, BorderLayout.CENTER);
		this.validate();
	}
	
	public void activarVistaBuscarSolucion() 
	{
		btnAvanzar.setVisible(false);
		panelCargarEmpleado.setVisible(false);
		panelCargarDatos.setVisible(false);
		panelMostrarSolucion.setVisible(false);
		panelBuscarSolucion.setVisible(true);
		this.getContentPane().add(panelBuscarSolucion, BorderLayout.CENTER);
		this.validate();
	}
	
	public void activarVistaMostrarSolucion() 
	{
		btnAvanzar.setText("Volver");
		btnAvanzar.setVisible(true);
		this.getContentPane().add(btnAvanzar, BorderLayout.SOUTH);
		
		panelCargarEmpleado.setVisible(false);
		panelCargarDatos.setVisible(false);
		panelBuscarSolucion.setVisible(false);
		panelMostrarSolucion.setVisible(true);
		this.getContentPane().add(panelMostrarSolucion, BorderLayout.CENTER);
		this.validate();	
	}
	
	public boolean estaEnCargarEmpleados() 
	{
		if(panelCargarEmpleado.isVisible())
			return true;
		return false;
	}
	
	public boolean estaEnCargarRequerimientos() 
	{
		if(panelCargarDatos.isVisible())
			return true;
		return false;
	}
	
	public boolean estaEnMostrarSolucion() 
	{
		if(panelMostrarSolucion.isVisible())
			return true;
		return false;
	}
}
