package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.MatteBorder;

@SuppressWarnings("serial")
public class CargarIncompatibles extends JPanel
{
	public JComboBox<String> cmboxEmpleado1, cmboxEmpleado2;
	public JButton btnAgregar, btnEliminar;
	
	private Color verde, verde2;

	public CargarIncompatibles() 
	{
		verde = new Color(21, 182, 141);
		verde2 = new Color(16, 163, 125);
		
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
		this.setBackground(verde);
		
		iniComponentes();
	}
	
	private void iniComponentes() 
	{
		//INICIALIZACION DEL PANEL IZQ DEL EMPLEADO 1
		JPanel panelE1 = new JPanel();
		panelE1.setBorder(new MatteBorder(0, 10, 0, 10, verde));
		panelE1.setPreferredSize(new Dimension(250,170));
		panelE1.setBackground(verde2);
		panelE1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 15));
		this.add(panelE1);
		
		JLabel lblEmpleado1 = new JLabel("Empleado 1:");
		lblEmpleado1.setFont(new Font("Nirmala UI", Font.PLAIN, 13));
		lblEmpleado1.setForeground(Color.WHITE);
		lblEmpleado1.setPreferredSize(new Dimension(200,45));
		panelE1.add(lblEmpleado1);

		cmboxEmpleado1 = new JComboBox<String>();
		cmboxEmpleado1.setPreferredSize(new Dimension(200,40));
		panelE1.add(cmboxEmpleado1);
		
		//INICIALIZACION DEL PANEL IZQ DEL EMPLEADO 2
		JPanel panelE2 = new JPanel();
		panelE2.setBorder(new MatteBorder(0, 10, 0, 10, verde));
		panelE2.setPreferredSize(new Dimension(250,170));
		panelE2.setBackground(verde2);
		panelE2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 15));
		this.add(panelE2);
		
		JLabel lblEmpleado2 = new JLabel("Empleado 2:");
		lblEmpleado2.setForeground(Color.WHITE);
		lblEmpleado2.setFont(new Font("Nirmala UI", Font.PLAIN, 13));
		lblEmpleado2.setPreferredSize(new Dimension(200,45));
		panelE2.add(lblEmpleado2);

		cmboxEmpleado2 = new JComboBox<String>();
		cmboxEmpleado2.setPreferredSize(new Dimension(200,40));
		panelE2.add(cmboxEmpleado2);
		
		////INICIALIZACION DEL PANEL IZQ DEL BTN AGREGAR
		JPanel panelAgregar = new JPanel();
		panelAgregar.setBackground(verde);
		panelAgregar.setLayout(new BorderLayout());
		this.add(panelAgregar);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setPreferredSize(new Dimension(100,50));
		btnAgregar.setFont(new Font("Nirmala UI", Font.BOLD, 13));
		btnAgregar.setBackground(verde2.darker());
		btnAgregar.setForeground(Color.WHITE);
		btnAgregar.setFocusable(false);
		panelAgregar.add(btnAgregar, BorderLayout.CENTER);
		
		JPanel panelEliminar = new JPanel();
		panelEliminar.setBackground(verde);
		panelEliminar.setLayout(new BorderLayout());
		this.add(panelEliminar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setPreferredSize(new Dimension(100,50));
		btnEliminar.setFont(new Font("Nirmala UI", Font.BOLD, 13));
		btnEliminar.setBackground(verde2.darker());
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setFocusable(false);
		panelEliminar.add(btnEliminar, BorderLayout.CENTER);
	}
	
	public void agregarOpcion(String opcion) 
	{
		cmboxEmpleado1.addItem(opcion);
		cmboxEmpleado2.addItem(opcion);
	}
}
