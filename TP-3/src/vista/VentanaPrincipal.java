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
	public CargarIncompatibles panelCargarIncompatibles;
	public CargarRequerimientos panelCargarRequerimientos;
	public BuscarSolucion panelBuscarSolucion;
	public MostrarSolucion panelMostrarSolucion;
	
	public JButton btnCambiarPanel;

	
	private Color verde;
	
	public VentanaPrincipal() 
	{
		verde = new Color(21, 182, 141);
		
		setMinimumSize(new Dimension(750,580));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().setBackground(verde);
		
		inicializar();
	}

	private void inicializar() 
	{
		panelCargarEmpleado = new CargarEmpleados();
		getContentPane().add(panelCargarEmpleado, BorderLayout.CENTER);
		
		btnCambiarPanel = new JButton("Siguiente");
		btnCambiarPanel.setForeground(Color.WHITE);
		btnCambiarPanel.setFont(new Font("Nirmala UI", Font.BOLD, 13));
		btnCambiarPanel.setFocusable(false);
		btnCambiarPanel.setBackground(new Color(11, 53, 42));
		getContentPane().add(btnCambiarPanel, BorderLayout.SOUTH);
				
	}
}
