package vista;


import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class VentanaPrincipal extends JFrame
{
	public CargarEmpleados panelCargarEmpleado;
	public CargarIncompatibles panelCargarIncompatibles;
	
	private Color verde;

	public JButton btnSiguinte;
	
	public VentanaPrincipal() 
	{
		verde = new Color(21, 182, 141);
		
		setBounds(100, 100, 750, 580);
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
		panelCargarIncompatibles = new CargarIncompatibles();
		
		getContentPane().add(panelCargarEmpleado, BorderLayout.CENTER);
		
		btnSiguinte = new JButton("Siguiente");
		btnSiguinte.setForeground(Color.WHITE);
		btnSiguinte.setFont(new Font("Nirmala UI", Font.BOLD, 13));
		btnSiguinte.setFocusable(false);
		btnSiguinte.setBackground(new Color(11, 53, 42));
		getContentPane().add(btnSiguinte, BorderLayout.SOUTH);
				
	}
}
