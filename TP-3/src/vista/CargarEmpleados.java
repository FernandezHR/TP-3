package vista;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.border.MatteBorder;
import java.awt.FlowLayout;

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
		
		setLayout(new BorderLayout());
		setBackground(verde);
		
		inicializar();
	}
	
	private void inicializar() 
	{		
		JPanel panelIzq = new JPanel();
		panelIzq.setLayout(new BorderLayout());
		panelIzq.setPreferredSize(new Dimension(240,0));
		panelIzq.setBackground(verde);
		add(panelIzq, BorderLayout.WEST);
		
		///INICIALIZACION DEL PRIMER PANEL DEL PANEL IZQUIERDO
		JPanel panelCrearEmpleado = new JPanel();
		panelCrearEmpleado.setBorder(new MatteBorder(10, 10, 10, 10, verde));
		panelCrearEmpleado.setBackground(verde2);
		panelCrearEmpleado.setPreferredSize(new Dimension(0,210));
		panelCrearEmpleado.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 15));
		panelIzq.add(panelCrearEmpleado, BorderLayout.NORTH);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Nirmala UI", Font.BOLD, 11));
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setPreferredSize(new Dimension(50,30));
		panelCrearEmpleado.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setPreferredSize(new Dimension(131,30));
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
		
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Nirmala UI", Font.BOLD, 11));
		lblApellido.setForeground(Color.WHITE);
		lblApellido.setPreferredSize(new Dimension(50,30));
		panelCrearEmpleado.add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setPreferredSize(new Dimension(131,30));
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
		
		JLabel lblPuesto = new JLabel("Puesto:");
		lblPuesto.setFont(new Font("Nirmala UI", Font.BOLD, 11));
		lblPuesto.setForeground(Color.WHITE);
		lblPuesto.setPreferredSize(new Dimension(50,30));
		panelCrearEmpleado.add(lblPuesto);	
		
		cmboxPuestos = new JComboBox<String>();
		cmboxPuestos.setPreferredSize(new Dimension(131,30));
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
		btnCargar.setBackground(verde2.darker());
		btnCargar.setForeground(Color.WHITE);
		btnCargar.setFocusable(false);
		panelCrearEmpleado.add(btnCargar);
		
		
		///INICIALIZACION DEL SEGUNDO PANEL DEL PANEL IZQUIERDO
		JPanel panelGenerarEmpleado = new JPanel();
		panelGenerarEmpleado.setBorder(new MatteBorder(0, 10, 5, 10, verde));
		panelGenerarEmpleado.setBackground(verde2);
		panelGenerarEmpleado.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 15));
		panelIzq.add(panelGenerarEmpleado, BorderLayout.CENTER);
		
		JLabel lblLiderDeProyecto = new JLabel("Lider de Proyecto");
		lblLiderDeProyecto.setFont(new Font("Nirmala UI", Font.BOLD, 11));
		lblLiderDeProyecto.setForeground(Color.WHITE);
		lblLiderDeProyecto.setPreferredSize(new Dimension(95,30));
		panelGenerarEmpleado.add(lblLiderDeProyecto);
		
		cantLiderDeProyecto = new JSpinner();
		cantLiderDeProyecto.setPreferredSize(new Dimension(86,30));
		cantLiderDeProyecto.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		cantLiderDeProyecto.setEditor(new JSpinner.DefaultEditor(cantLiderDeProyecto));
		panelGenerarEmpleado.add(cantLiderDeProyecto);
		
		JLabel lblArquitecto = new JLabel("Arquitecto");
		lblArquitecto.setFont(new Font("Nirmala UI", Font.BOLD, 11));
		lblArquitecto.setForeground(Color.WHITE);
		lblArquitecto.setPreferredSize(new Dimension(95,30));
		panelGenerarEmpleado.add(lblArquitecto);
		
		cantArquitecto = new JSpinner();
		cantArquitecto.setPreferredSize(new Dimension(86,30));
		cantArquitecto.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		cantArquitecto.setEditor(new JSpinner.DefaultEditor(cantArquitecto));
		panelGenerarEmpleado.add(cantArquitecto);
		
		JLabel lblProgramador = new JLabel("Programador");
		lblProgramador.setFont(new Font("Nirmala UI", Font.BOLD, 11));
		lblProgramador.setForeground(Color.WHITE);
		lblProgramador.setPreferredSize(new Dimension(95,30));
		panelGenerarEmpleado.add(lblProgramador);
		
		cantProgramador = new JSpinner();
		cantProgramador.setPreferredSize(new Dimension(86,30));
		cantProgramador.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		cantProgramador.setEditor(new JSpinner.DefaultEditor(cantProgramador));
		panelGenerarEmpleado.add(cantProgramador);
		
		JLabel lblTester = new JLabel("Tester");
		lblTester.setFont(new Font("Nirmala UI", Font.BOLD, 11));
		lblTester.setForeground(Color.WHITE);
		lblTester.setPreferredSize(new Dimension(95,30));
		panelGenerarEmpleado.add(lblTester);
		
		cantTester = new JSpinner();
		cantTester.setPreferredSize(new Dimension(86,30));
		cantTester.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		cantTester.setEditor(new JSpinner.DefaultEditor(cantTester));
		panelGenerarEmpleado.add(cantTester);
		
		lblCantNombres = new JLabel("");
		lblCantNombres.setPreferredSize(new Dimension(86,30));
		lblCantNombres.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantNombres.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/iconos/advertencia24px.png")));
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
		panelGenerarEmpleado.add(lblCantNombres);	
		
		btnGenerar = new JButton("Generar");
		btnGenerar.setPreferredSize(new Dimension(86,30));
		btnGenerar.setFont(new Font("Nirmala UI", Font.BOLD, 13));
		btnGenerar.setBackground(verde2.darker());
		btnGenerar.setForeground(Color.WHITE);
		btnGenerar.setFocusable(false);
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
		panelGenerarEmpleado.add(btnGenerar);
		
		
		///INICIALIZACION DEL BOTON ELIMINAR PANEL IZQUIERDO
		JPanel panelEliminar = new JPanel();
		panelEliminar.setBackground(verde);
		panelEliminar.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 15));
		panelEliminar.setPreferredSize(new Dimension(0,60));
		panelIzq.add(panelEliminar, BorderLayout.SOUTH);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setPreferredSize(new Dimension(100,30));
		btnEliminar.setFont(new Font("Nirmala UI", Font.BOLD, 13));
		btnEliminar.setBounds(76, 423, 86, 30);
		btnEliminar.setBackground(verde2.darker());
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setFocusable(false);
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
		panelEliminar.add(btnEliminar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(496, 508));
		add(scrollPane, BorderLayout.CENTER);
		
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
