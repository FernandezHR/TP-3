package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
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
	
	JPanel panelSur;
	public JButton btnCambiarPanel, btnNuevo;
	
	private Color verde,verde2, naranja;
	
	public VentanaPrincipal() 
	{
		verde = new Color(21, 182, 141);
		verde2 = new Color(11, 53, 42);
		naranja = new Color(140, 95, 5);
		
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
		
		panelSur = new JPanel();
		panelSur.setLayout(new BorderLayout());
		panelSur.setBackground(verde);
		this.getContentPane().add(panelSur, BorderLayout.SOUTH);
		
		btnCambiarPanel = new JButton("Siguiente");
		btnCambiarPanel.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/iconos/flechaDer2.png")));
		btnCambiarPanel.setPreferredSize(new Dimension(375,30));
		btnCambiarPanel.setForeground(Color.WHITE);
		btnCambiarPanel.setFont(new Font("Nirmala UI", Font.BOLD, 13));
		btnCambiarPanel.setFocusable(false);
		btnCambiarPanel.setBackground(verde2);
		panelSur.add(btnCambiarPanel, BorderLayout.CENTER);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.setForeground(Color.WHITE);
		btnNuevo.setFont(new Font("Nirmala UI", Font.BOLD, 13));
		btnNuevo.setFocusable(false);
		btnNuevo.setBackground(naranja);
	}
	
	public void activarVistaCargarDatos() 
	{
		btnCambiarPanel.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/iconos/lupa.png")));
		btnCambiarPanel.setText("Buscar Solucion");
		panelSur.remove(btnNuevo);
		panelSur.add(btnCambiarPanel, BorderLayout.CENTER);
	
		panelCargarEmpleado.setVisible(false);
		panelBuscarSolucion.setVisible(false);
		panelMostrarSolucion.setVisible(false);
		panelCargarDatos.setVisible(true);
		this.getContentPane().add(panelCargarDatos, BorderLayout.CENTER);
		this.validate();
	}
	
	public void activarVistaBuscarSolucion() 
	{
		panelSur.setVisible(false);
		panelCargarEmpleado.setVisible(false);
		panelCargarDatos.setVisible(false);
		panelMostrarSolucion.setVisible(false);
		panelBuscarSolucion.setVisible(true);
		this.getContentPane().add(panelBuscarSolucion, BorderLayout.CENTER);
		this.validate();
	}
	
	public void activarVistaMostrarSolucion() 
	{
		btnCambiarPanel.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/iconos/flechaIzq2.png")));
		btnCambiarPanel.setText("Volver");
		panelSur.add(btnCambiarPanel, BorderLayout.WEST);
		panelSur.add(btnNuevo, BorderLayout.CENTER);
		panelSur.setVisible(true);
		
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
	
	public boolean estaEnCargarDatos() 
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
