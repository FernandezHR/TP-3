package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

@SuppressWarnings("serial")
public class MostrarSolucion extends JPanel
{	
	private Color verde;
	
	public JTable tablaEquipo;
	
	public MostrarSolucion() 
	{
		verde = new Color(21, 182, 141);
		
		this.setBackground(verde);
		this.setLayout(new BorderLayout());
		
		inicializar();
		
	}

	private void inicializar() 
	{
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new MatteBorder(10, 50, 40, 50, verde));
		scrollPane.setPreferredSize(new Dimension(496, 508));
		this.add(scrollPane, BorderLayout.CENTER);
		
		tablaEquipo = new JTable(new Object[][] {}, new String[] {"Nombre","Puesto"}) 
		{
			@Override //Sobreescribmos este metodo para desactivar la edicion de celdas
			public boolean isCellEditable(int i, int j) 
			{
				return false;
			}
		};
		scrollPane.setViewportView(tablaEquipo);

		JPanel panel = new JPanel();
		panel.setBackground(verde);
		panel.setPreferredSize(new Dimension(496,30));
		this.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Equipo que cumple con los requisitos");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setPreferredSize(new Dimension(400,30));
		lblNewLabel.setFont(new Font("Nirmala UI", Font.BOLD, 16));
		lblNewLabel.setForeground(Color.WHITE);
		panel.add(lblNewLabel);
	
	}


}
