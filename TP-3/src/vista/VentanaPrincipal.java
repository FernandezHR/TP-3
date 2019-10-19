package vista;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VentanaPrincipal extends JFrame
{

	public JTable tablaEmpleados;
	public JTextField txtNombre, txtApellido;
	public JComboBox<String> cBoxPuestos;
	public JButton btnCargar, btnEliminar;

	public VentanaPrincipal() 
	{
		setBounds(100, 100, 600, 520);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		initialize();
	}

	private void initialize() 
	{
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 172, 564, 256);
		getContentPane().add(scrollPane);
		
		tablaEmpleados = new JTable(new Object[][] {}, new String[] {"Nombre", "Puesto"});
		scrollPane.setViewportView(tablaEmpleados);
	
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(190, 33, 70, 30);
		getContentPane().add(lblNombre);
		
		JLabel lblPuesto = new JLabel("Puesto:");
		lblPuesto.setBounds(190, 115, 70, 30);
		getContentPane().add(lblPuesto);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(190, 74, 70, 30);
		getContentPane().add(lblApellido);
		
		txtNombre = new JTextField();
		txtNombre.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyTyped(KeyEvent arg0) 
			{
				if(!Character.isLetter(arg0.getKeyChar()))
					arg0.consume();
			}
		});
		txtNombre.setBounds(270, 33, 100, 30);
		getContentPane().add(txtNombre);
		
		txtApellido = new JTextField();
		txtApellido.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyTyped(KeyEvent arg0) 
			{
				if(!Character.isLetter(arg0.getKeyChar()))
					arg0.consume();
			}
		});
		txtApellido.setBounds(270, 74, 100, 30);
		getContentPane().add(txtApellido);
		
		cBoxPuestos = new JComboBox<String>();
		cBoxPuestos.setModel(new DefaultComboBoxModel<String>(new String[] {null, "Lider de Proyecto", "Arquitecto", "Programador", "Tester"}));
		cBoxPuestos.setBounds(270, 115, 100, 30);
		getContentPane().add(cBoxPuestos);
		
		btnCargar = new JButton("Cargar");
		btnCargar.setBounds(381, 74, 86, 30);
		getContentPane().add(btnCargar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(238, 439, 86, 30);
		btnEliminar.setEnabled(false);
		getContentPane().add(btnEliminar);
		
	}
}
