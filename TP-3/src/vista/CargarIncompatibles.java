package vista;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;

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
		setLayout(null);
		
		inicializar();
	}
	
	private void inicializar() 
	{
		JPanel panel1 = new JPanel();
		panel1.setBounds(10, 115, 218, 90);
		panel1.setBackground(verde2);
		panel1.setLayout(null);
		add(panel1);
		
		JLabel lblEmpleado1 = new JLabel("Empleado 1:");
		lblEmpleado1.setFont(new Font("Nirmala UI", Font.PLAIN, 13));
		lblEmpleado1.setForeground(Color.WHITE);
		lblEmpleado1.setBounds(10, 11, 75, 22);
		panel1.add(lblEmpleado1);

		cmboxEmpleado1 = new JComboBox<String>();
		cmboxEmpleado1.setBounds(10, 44, 200, 26);
		panel1.add(cmboxEmpleado1);
		
		JPanel panel2 = new JPanel();
		panel2.setBounds(10, 216, 218, 90);
		panel2.setBackground(verde2);
		panel2.setLayout(null);
		add(panel2);
		
		JLabel lblEmpleado2 = new JLabel("Empleado 2:");
		lblEmpleado2.setForeground(Color.WHITE);
		lblEmpleado2.setFont(new Font("Nirmala UI", Font.PLAIN, 13));
		lblEmpleado2.setBounds(10, 11, 75, 22);
		panel2.add(lblEmpleado2);

		cmboxEmpleado2 = new JComboBox<String>();
		cmboxEmpleado2.setBounds(10, 44, 200, 26);
		panel2.add(cmboxEmpleado2);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(54, 400, 107, 30);
		add(btnAgregar);
		btnAgregar.setFont(new Font("Nirmala UI", Font.BOLD, 13));
		btnAgregar.setBackground(verde2.darker());
		btnAgregar.setForeground(Color.WHITE);
		btnAgregar.setFocusable(false);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(238, 0, 496, 508);
		add(scrollPane);
		
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
