package vista;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.ImageIcon;
import javax.swing.SpinnerNumberModel;

public class VentanaPrincipal extends JFrame
{
	public JTable tablaEmpleados;
	public JTextField txtNombre, txtApellido;
	public JComboBox<String> cmboxPuestos;
	public JButton btnCargar, btnEliminar, btnGenerar;
	public JSpinner cantProgramador, cantLiderDeProyecto, cantArquitecto, cantTester;
	public JLabel lblCantNombres;

	public VentanaPrincipal() 
	{
		setBounds(100, 100, 600, 546);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		initialize();
	}

	private void initialize() 
	{
		JPanel panelCrearEmpleado = new JPanel();
		panelCrearEmpleado.setBackground(Color.LIGHT_GRAY);
		panelCrearEmpleado.setBounds(10, 11, 189, 178);
		getContentPane().add(panelCrearEmpleado);
		panelCrearEmpleado.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 14, 50, 30);
		panelCrearEmpleado.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(10, 55, 50, 30);
		panelCrearEmpleado.add(lblApellido);
		
		JLabel lblPuesto = new JLabel("Puesto:");
		lblPuesto.setBounds(10, 96, 50, 30);
		panelCrearEmpleado.add(lblPuesto);	
		
		txtApellido = new JTextField();
		txtApellido.setBounds(70, 55, 100, 30);
		txtApellido.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyTyped(KeyEvent arg0) 
			{
				if(!Character.isLetter(arg0.getKeyChar()))
					arg0.consume();
			}
		});
		panelCrearEmpleado.add(txtApellido);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(70, 14, 100, 30);
		txtNombre.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyTyped(KeyEvent arg0) 
			{
				if(!Character.isLetter(arg0.getKeyChar()))
					arg0.consume();
			}
		});
		panelCrearEmpleado.add(txtNombre);
		
		cmboxPuestos = new JComboBox<String>();
		cmboxPuestos.setBounds(70, 96, 100, 30);
		panelCrearEmpleado.add(cmboxPuestos);
		cmboxPuestos.setModel(new DefaultComboBoxModel<String>(new String[] {null, "Lider de Proyecto", "Arquitecto", "Programador", "Tester"}));
	
		btnCargar = new JButton("Cargar");
		btnCargar.setBounds(49, 137, 86, 30);
		panelCrearEmpleado.add(btnCargar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(238, 467, 86, 30);
		btnEliminar.setEnabled(false);
		getContentPane().add(btnEliminar);
		
		JPanel panelGenerarEmpleado = new JPanel();
		panelGenerarEmpleado.setBackground(Color.LIGHT_GRAY);
		panelGenerarEmpleado.setBounds(372, 11, 202, 178);
		panelGenerarEmpleado.setLayout(null);
		getContentPane().add(panelGenerarEmpleado);
		
		JLabel lblLiderDeProyecto = new JLabel("Lider de Proyecto");
		lblLiderDeProyecto.setBounds(10, 11, 93, 21);
		panelGenerarEmpleado.add(lblLiderDeProyecto);
		
		JLabel lblArquitecto = new JLabel("Arquitecto");
		lblArquitecto.setBounds(113, 11, 93, 21);
		panelGenerarEmpleado.add(lblArquitecto);
		
		JLabel lblProgramador = new JLabel("Programador");
		lblProgramador.setBounds(10, 59, 93, 21);
		panelGenerarEmpleado.add(lblProgramador);
		
		JLabel lblTester = new JLabel("Tester");
		lblTester.setBounds(113, 59, 93, 21);
		panelGenerarEmpleado.add(lblTester);
		
		cantProgramador = new JSpinner();
		cantProgramador.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		cantProgramador.setBounds(10, 81, 83, 25);
		panelGenerarEmpleado.add(cantProgramador);
		
		cantLiderDeProyecto = new JSpinner();
		cantLiderDeProyecto.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		cantLiderDeProyecto.setBounds(10, 28, 83, 25);
		panelGenerarEmpleado.add(cantLiderDeProyecto);
		
		cantArquitecto = new JSpinner();
		cantArquitecto.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		cantArquitecto.setBounds(113, 28, 83, 25);
		panelGenerarEmpleado.add(cantArquitecto);
		
		cantTester = new JSpinner();
		cantTester.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		cantTester.setBounds(113, 81, 83, 25);
		panelGenerarEmpleado.add(cantTester);
		
		btnGenerar = new JButton("Generar");
		btnGenerar.setBounds(110, 137, 86, 30);
		panelGenerarEmpleado.add(btnGenerar);
		
		lblCantNombres = new JLabel("");
		lblCantNombres.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantNombres.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/iconos/aviso.png")));
		lblCantNombres.setBounds(30, 125, 46, 30);
		panelGenerarEmpleado.add(lblCantNombres);	
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 200, 564, 256);
		getContentPane().add(scrollPane);
		
		tablaEmpleados = new JTable(new Object[][] {}, new String[] {"Nombre", "Puesto"});
		scrollPane.setViewportView(tablaEmpleados);
		
	}
}
