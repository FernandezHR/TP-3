package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridBagConstraints;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import javax.swing.JScrollBar;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class MostrarSolucion extends JPanel
{
	public JSpinner cantProgramador, cantLiderDeProyecto, cantArquitecto, cantTester;
	
	private Color verde;
	
	public JTable tablaEquipo;
	
	public MostrarSolucion() 
	{
		verde = new Color(21, 182, 141);
		this.setBackground(verde);
		setLayout(new BorderLayout());
		
		inicializar();
		
	}

	private void inicializar() 
	{

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(496, 508));

		JPanel panel = new JPanel();
		panel.setBackground(verde);
		JLabel lblNewLabel = new JLabel("Equipo que cumple con los requisitos");
		lblNewLabel.setFont(new Font("Nirmala UI", Font.BOLD, 16));
		panel.add(lblNewLabel);
		
		add(panel, BorderLayout.NORTH);
		
		add(scrollPane,BorderLayout.CENTER);
		
		tablaEquipo = new JTable(new Object[][] {}, new String[] {"Nombre","Puesto"}) 
		{
			@Override //Sobreescribmos este metodo para desactivar la edicion de celdas
			public boolean isCellEditable(int i, int j) 
			{
				return false;
			}
		};

		scrollPane.setViewportView(tablaEquipo);
				
	}


}
