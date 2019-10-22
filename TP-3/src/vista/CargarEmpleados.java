package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class CargarEmpleados extends JPanel
{
	public JTextField txtNombre, txtApellido;
	public JComboBox<String> cmboxPuestos;
	public JButton btnCargar;
	public JSpinner cantProgramador, cantLiderDeProyecto, cantArquitecto, cantTester;
	public JButton btnGenerar;
	public JLabel lblCantNombres;
	public JButton btnEliminar;
	public JTable tablaEmpleados;
	
	private Color verde, verde2;
	
	public CargarEmpleados() 
	{
		verde = new Color(21, 182, 141);
		verde2 = new Color(16, 163, 125);
		
		setLayout(null);
		setBackground(verde);
		
		inicializar();
	}
	
	private void inicializar() 
	{		
		JPanel panelCrearEmpleado = new JPanel();
		panelCrearEmpleado.setBackground(verde2);
		panelCrearEmpleado.setBounds(10, 22, 218, 178);
		panelCrearEmpleado.setLayout(null);
		add(panelCrearEmpleado);
		
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
		add(panelGenerarEmpleado);
		
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
		btnEliminar.setBounds(76, 423, 86, 30);
		btnEliminar.setBackground(verde2.darker());
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setFocusable(false);
		add(btnEliminar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(238, 0, 496, 508);
		add(scrollPane);
		
	
		tablaEmpleados = new JTable(new Object[][] {}, new String[] {"Nombre","Puesto"}) 
		{
			@Override //Sobreescribmos este metodo para desactivar la edicion de celdas
			public boolean isCellEditable(int i, int j) 
			{
				return false;
			}
		};	
		scrollPane.setViewportView(tablaEmpleados);
	}
	
	
	
}
