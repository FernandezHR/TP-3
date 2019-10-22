package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

public class CargarIncompatibles extends JPanel
{
	public JComboBox<String> cmboxEmpleado1, cmboxEmpleado2;
	public JButton btnAgregar;
	public JTable tablaIncompatibles;
	
	private Color verde, verde2;

	public CargarIncompatibles() 
	{
		verde = new Color(21, 182, 141);
		verde2 = new Color(16, 163, 125);
		
		setBackground(verde);
		setLayout(new BorderLayout());
		
		inicializar();
	}
	
	private void inicializar() 
	{
		JPanel panelIzq = new JPanel();
		panelIzq.setLayout(new BorderLayout());
		panelIzq.setPreferredSize(new Dimension(240,0));
		panelIzq.setBackground(verde);
		add(panelIzq, BorderLayout.WEST);
		
		//INICIALIZACION DEL PANEL IZQ DEL EMPLEADO 1
		JPanel panelE1 = new JPanel();
		panelE1.setBorder(new MatteBorder(50, 10, 1, 10, verde));
		panelE1.setPreferredSize(new Dimension(0,200));
		panelE1.setBackground(verde2);
		panelE1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 15));
		panelIzq.add(panelE1, BorderLayout.NORTH);
		
		JLabel lblEmpleado1 = new JLabel("Empleado 1:");
		lblEmpleado1.setFont(new Font("Nirmala UI", Font.PLAIN, 13));
		lblEmpleado1.setForeground(Color.WHITE);
		lblEmpleado1.setPreferredSize(new Dimension(200,45));
		panelE1.add(lblEmpleado1);

		cmboxEmpleado1 = new JComboBox<String>();
		cmboxEmpleado1.setPreferredSize(new Dimension(200,45));
		panelE1.add(cmboxEmpleado1);
		
		//INICIALIZACION DEL PANEL IZQ DEL EMPLEADO 2
		JPanel panelE2 = new JPanel();
		panelE2.setBorder(new MatteBorder(1, 10, 50, 10, verde));
		panelE2.setPreferredSize(new Dimension(0,200));
		panelE2.setBackground(verde2);
		panelE2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 15));
		panelIzq.add(panelE2, BorderLayout.SOUTH);
		
		JLabel lblEmpleado2 = new JLabel("Empleado 2:");
		lblEmpleado2.setForeground(Color.WHITE);
		lblEmpleado2.setFont(new Font("Nirmala UI", Font.PLAIN, 13));
		lblEmpleado2.setPreferredSize(new Dimension(200,45));
		panelE2.add(lblEmpleado2);

		cmboxEmpleado2 = new JComboBox<String>();
		cmboxEmpleado2.setPreferredSize(new Dimension(200,45));
		panelE2.add(cmboxEmpleado2);
		
		
		////INICIALIZACION DEL PANEL IZQ DEL BTN AGREGAR
		JPanel panelAgregar = new JPanel();
		panelAgregar.setBorder(new MatteBorder(0, 10, 0, 10, verde));
		panelAgregar.setBackground(verde);
		panelAgregar.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 30));
		panelIzq.add(panelAgregar, BorderLayout.CENTER);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setPreferredSize(new Dimension(100,50));
		btnAgregar.setFont(new Font("Nirmala UI", Font.BOLD, 13));
		btnAgregar.setBackground(verde2.darker());
		btnAgregar.setForeground(Color.WHITE);
		btnAgregar.setFocusable(false);
		panelAgregar.add(btnAgregar, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(238, 0, 496, 508);
		add(scrollPane, BorderLayout.CENTER);
		
		tablaIncompatibles = new JTable(new DefaultTableModel(new Object[][] {}, new String[] {"Empleado 1", "Puesto", "Empleado 2", "Puesto"})) 
		{
			@Override //Sobreescribmos este metodo para desactivar la edicion de celdas
			public boolean isCellEditable(int i, int j) 
			{
				return false;
			}};
		scrollPane.setViewportView(tablaIncompatibles);
	}
}
