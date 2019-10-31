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
	public JTable tablaEquipo;
	public JLabel lblMensajeResultado;
	
	private Color verde;

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

		JPanel panelMsj = new JPanel();
		panelMsj.setBackground(verde);
		panelMsj.setPreferredSize(new Dimension(496,30));
		this.add(panelMsj, BorderLayout.NORTH);
		
		lblMensajeResultado = new JLabel("Equipo que cumple con los requisitos");
		lblMensajeResultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensajeResultado.setPreferredSize(new Dimension(480,30));
		lblMensajeResultado.setFont(new Font("Nirmala UI", Font.BOLD, 16));
		lblMensajeResultado.setForeground(Color.WHITE);
		panelMsj.add(lblMensajeResultado);	
	}
}
