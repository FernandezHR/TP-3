package vista;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CargarIncompatibles extends JPanel
{
	public JComboBox<String> cmboxEmpleado1;
	public JComboBox<String> cmboxEmpleado2;
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
		JPanel panel = new JPanel();
		panel.setBounds(10, 150, 218, 170);
		panel.setBackground(verde2);
		panel.setLayout(null);
		add(panel);

		cmboxEmpleado1 = new JComboBox<String>();
		cmboxEmpleado1.setBounds(10, 23, 200, 26);
		panel.add(cmboxEmpleado1);
		
		cmboxEmpleado2 = new JComboBox<String>();
		cmboxEmpleado2.setBounds(10, 60, 200, 26);
		panel.add(cmboxEmpleado2);
				
		btnAgregar = new JButton("Agregar");
		btnAgregar.setFont(new Font("Nirmala UI", Font.BOLD, 13));
		btnAgregar.setBounds(54, 107, 107, 30);
		btnAgregar.setBackground(verde2.darker());
		btnAgregar.setForeground(Color.WHITE);
		btnAgregar.setFocusable(false);
		panel.add(btnAgregar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(238, 0, 496, 508);
		add(scrollPane);
		
		DefaultTableModel dtm = new DefaultTableModel(new Object[0][0], new String[] {"Empleado 1", "Empleado 2"})
		{
			@Override //Sobreescribmos este metodo para desactivar la edicion de celdas
			public boolean isCellEditable(int i, int j) 
			{
				return false;
			}
		};
		tablaIncompatibles = new JTable(dtm);
		scrollPane.setViewportView(tablaIncompatibles);
	}
}
