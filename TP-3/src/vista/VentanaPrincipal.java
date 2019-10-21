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
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.ImageIcon;
import javax.swing.SpinnerNumberModel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;

public class VentanaPrincipal extends JFrame
{
	public JPanel primerPanel;
	public JTextField txtNombre, txtApellido;
	public JComboBox<String> cmboxPuestos;
	public JButton btnCargar, btnEliminar, btnGenerar;
	public JSpinner cantProgramador, cantLiderDeProyecto, cantArquitecto, cantTester;
	public JLabel lblCantNombres;
	public JTable tablaEmpleados;
	public JButton btnSiguinte;
	
	public JPanel segundoPanel;
	public JTable tabla, tablaIncompatibles;
	public JButton btnRemover1, btnRemover2,  btnAgregar;
	
	public JComboBox<String> cmboxIncompat;
	public JComboBox<String> cmboxIncompat2;

	
	private Color verde, verde2;
	
	
	public VentanaPrincipal() 
	{
		verde = new Color(21, 182, 141);
		verde2 = new Color(16, 163, 125);
		
		setBounds(100, 100, 750, 546);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().setBackground(verde);
		
		inicializarPrimerPanel();
		inicializarSegundoPanel();
	}

	private void inicializarPrimerPanel() 
	{
		
		primerPanel = new JPanel();
		primerPanel.setLayout(null);
		primerPanel.setBackground(verde);
		getContentPane().add(primerPanel, BorderLayout.CENTER);

		JPanel panelCrearEmpleado = new JPanel();
		panelCrearEmpleado.setBackground(verde2);
		panelCrearEmpleado.setBounds(10, 22, 218, 178);
		panelCrearEmpleado.setLayout(null);
		primerPanel.add(panelCrearEmpleado);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Nirmala UI", Font.BOLD, 11));
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setBounds(10, 14, 50, 30);
		panelCrearEmpleado.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Nirmala UI", Font.BOLD, 11));
		lblApellido.setForeground(Color.WHITE);
		lblApellido.setBounds(10, 55, 50, 30);
		panelCrearEmpleado.add(lblApellido);
		
		JLabel lblPuesto = new JLabel("Puesto:");
		lblPuesto.setFont(new Font("Nirmala UI", Font.BOLD, 11));
		lblPuesto.setForeground(Color.WHITE);
		lblPuesto.setBounds(10, 96, 50, 30);
		panelCrearEmpleado.add(lblPuesto);	
		
		txtNombre = new JTextField();
		txtNombre.setBounds(70, 14, 138, 30);
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
		
		txtApellido = new JTextField();
		txtApellido.setBounds(70, 55, 138, 30);
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
		
		cmboxPuestos = new JComboBox<String>();
		cmboxPuestos.setBounds(70, 96, 138, 30);
		cmboxPuestos.setModel(new DefaultComboBoxModel<String>(new String[] {null, "Lider de Proyecto", "Arquitecto", "Programador", "Tester"}));
		panelCrearEmpleado.add(cmboxPuestos);
	
		btnCargar = new JButton("Cargar");
		btnCargar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) 
			{
				btnCargar.setFont(new Font("Nirmala UI", Font.BOLD, 12));
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) 
			{
				btnCargar.setFont(new Font("Nirmala UI", Font.BOLD, 13));
			}
		});
		btnCargar.setFont(new Font("Nirmala UI", Font.BOLD, 13));
		btnCargar.setBounds(59, 137, 107, 30);
		btnCargar.setBackground(verde2.darker());
		btnCargar.setForeground(Color.WHITE);
		btnCargar.setFocusable(false);
		panelCrearEmpleado.add(btnCargar);
		
		JPanel panelGenerarEmpleado = new JPanel();
		panelGenerarEmpleado.setBackground(verde2);
		panelGenerarEmpleado.setBounds(10, 211, 218, 178);
		panelGenerarEmpleado.setLayout(null);
		primerPanel.add(panelGenerarEmpleado);
		
		JLabel lblLiderDeProyecto = new JLabel("Lider de Proyecto");
		lblLiderDeProyecto.setFont(new Font("Nirmala UI", Font.BOLD, 11));
		lblLiderDeProyecto.setForeground(Color.WHITE);
		lblLiderDeProyecto.setBounds(10, 11, 95, 21);
		panelGenerarEmpleado.add(lblLiderDeProyecto);
		
		JLabel lblArquitecto = new JLabel("Arquitecto");
		lblArquitecto.setFont(new Font("Nirmala UI", Font.BOLD, 11));
		lblArquitecto.setForeground(Color.WHITE);
		lblArquitecto.setBounds(125, 11, 95, 21);
		panelGenerarEmpleado.add(lblArquitecto);
		
		JLabel lblProgramador = new JLabel("Programador");
		lblProgramador.setFont(new Font("Nirmala UI", Font.BOLD, 11));
		lblProgramador.setForeground(Color.WHITE);
		lblProgramador.setBounds(10, 59, 95, 21);
		panelGenerarEmpleado.add(lblProgramador);
		
		JLabel lblTester = new JLabel("Tester");
		lblTester.setFont(new Font("Nirmala UI", Font.BOLD, 11));
		lblTester.setForeground(Color.WHITE);
		lblTester.setBounds(125, 59, 95, 21);
		panelGenerarEmpleado.add(lblTester);
		
		cantProgramador = new JSpinner();
		cantProgramador.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		cantProgramador.setBounds(10, 83, 83, 25);
		cantProgramador.setEditor(new JSpinner.DefaultEditor(cantProgramador));
		panelGenerarEmpleado.add(cantProgramador);
		
		cantLiderDeProyecto = new JSpinner();
		cantLiderDeProyecto.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		cantLiderDeProyecto.setBounds(10, 30, 83, 25);
		cantLiderDeProyecto.setEditor(new JSpinner.DefaultEditor(cantLiderDeProyecto));
		panelGenerarEmpleado.add(cantLiderDeProyecto);
		
		cantArquitecto = new JSpinner();
		cantArquitecto.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		cantArquitecto.setBounds(125, 30, 83, 25);
		cantArquitecto.setEditor(new JSpinner.DefaultEditor(cantArquitecto));
		panelGenerarEmpleado.add(cantArquitecto);
		
		cantTester = new JSpinner();
		cantTester.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		cantTester.setBounds(125, 83, 83, 25);
		cantTester.setEditor(new JSpinner.DefaultEditor(cantTester));
		panelGenerarEmpleado.add(cantTester);
		
		btnGenerar = new JButton("Generar");
		btnGenerar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) 
			{
				btnGenerar.setFont(new Font("Nirmala UI", Font.BOLD, 12));
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) 
			{
				btnGenerar.setFont(new Font("Nirmala UI", Font.BOLD, 13));
			}
		});
		btnGenerar.setFont(new Font("Nirmala UI", Font.BOLD, 13));
		btnGenerar.setBackground(verde2.darker());
		btnGenerar.setForeground(Color.WHITE);
		btnGenerar.setBounds(125, 130, 83, 30);
		btnGenerar.setFocusable(false);
		panelGenerarEmpleado.add(btnGenerar);
		
		lblCantNombres = new JLabel("");
		lblCantNombres.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				lblCantNombres.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/iconos/advertencia32px.png")));
			}
			
			@Override
			public void mouseExited(MouseEvent e) 
			{
				lblCantNombres.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/iconos/advertencia24px.png")));
			}
		});
		lblCantNombres.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantNombres.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/iconos/advertencia24px.png")));
		lblCantNombres.setBounds(35, 125, 40, 40);
		panelGenerarEmpleado.add(lblCantNombres);	
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) 
			{
				btnEliminar.setFont(new Font("Nirmala UI", Font.BOLD, 12));
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) 
			{
				btnEliminar.setFont(new Font("Nirmala UI", Font.BOLD, 13));
			}
		});
		btnEliminar.setFont(new Font("Nirmala UI", Font.BOLD, 13));
		btnEliminar.setBounds(76, 400, 86, 30);
		btnEliminar.setBackground(verde2.darker());
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setEnabled(false);
		btnEliminar.setFocusable(false);
		primerPanel.add(btnEliminar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(238, 0, 496, 508);
		primerPanel.add(scrollPane);
		
		tablaEmpleados = new JTable(new Object[][] {}, new String[] {"Nombre", "Puesto"});
		scrollPane.setViewportView(tablaEmpleados);
		
		btnSiguinte = new JButton("Siguiente");
		btnSiguinte.setForeground(Color.WHITE);
		btnSiguinte.setFont(new Font("Nirmala UI", Font.BOLD, 13));
		btnSiguinte.setFocusable(false);
		btnSiguinte.setBackground(new Color(11, 114, 87));
		btnSiguinte.setBounds(10, 455, 218, 30);
		primerPanel.add(btnSiguinte);
				
	}
	
	private void inicializarSegundoPanel() 
	{
		segundoPanel = new JPanel();
		segundoPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 230, 508);
		segundoPanel.add(scrollPane);
		
		tabla = new JTable();
		scrollPane.setViewportView(tabla);
		tabla.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Puesto"
			}
		));
		tabla.setBackground(Color.LIGHT_GRAY);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(504, 0, 230, 508);
		segundoPanel.add(scrollPane_1);
		
		tablaIncompatibles = new JTable();
		tablaIncompatibles.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {
				"Empleado 1", "Empleado 2"
			}
		));
		tablaIncompatibles.setBackground(Color.LIGHT_GRAY);
		scrollPane_1.setViewportView(tablaIncompatibles);
		
		JPanel panel = new JPanel();
		panel.setBounds(230, 0, 275, 508);
		segundoPanel.add(panel);
		panel.setLayout(null);

		cmboxIncompat = new JComboBox<String>();
		cmboxIncompat.setBounds(10, 144, 213, 26);
		panel.add(cmboxIncompat);
		
		cmboxIncompat2 = new JComboBox<String>();
		cmboxIncompat2.setBounds(10, 176, 213, 26);
		panel.add(cmboxIncompat2);
				
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(10, 216, 254, 23);
		panel.add(btnAgregar);
		
		btnRemover1 = new JButton("X");
		btnRemover1.setBounds(226, 145, 39, 23);
		panel.add(btnRemover1);
		
		btnRemover2 = new JButton("X");
		btnRemover2.setBounds(226, 177, 39, 23);
		panel.add(btnRemover2);
	}
}
