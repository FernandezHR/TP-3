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
import javax.swing.table.DefaultTableModel;

import java.awt.FlowLayout;
import javax.swing.BoxLayout;

@SuppressWarnings("serial")
public class CargarEmpleados extends JPanel
{
	private JTextField txtNombre, txtApellido;
	private JComboBox<String> cmboxPuestos;
	private JTextField txtPathFoto;
	public JButton btnElegirFoto, btnCargar;
	private JSpinner cantProgramador, cantLiderDeProyecto, cantArquitecto, cantTester;
	public JButton btnGenerar;
	private JLabel lblCantNombres;
	public JButton btnEliminar;
	public JTable tablaEmpleados;
	
	private Color verde, verde2;	
	
	public CargarEmpleados() 
	{
		verde = new Color(21, 182, 141);
		verde2 = new Color(16, 163, 125);
		
		this.setLayout(new BorderLayout());
		this.setBackground(verde);
		
		inicializar();
	}

	private void inicializar() 
	{		
		JPanel	panelIzq = new JPanel();
		panelIzq.setPreferredSize(new Dimension(240,0));
		panelIzq.setBackground(verde);
		panelIzq.setLayout(new BoxLayout(panelIzq, BoxLayout.Y_AXIS));
		add(panelIzq, BorderLayout.WEST);
		
		iniPrimerPanelIzq(panelIzq);
		
		iniSegundoPanelIzq(panelIzq);
	
		iniBotonEliminar(panelIzq);
			
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

	private void iniPrimerPanelIzq(JPanel panelIzq) 
	{
		JPanel panelCrearEmpleado = new JPanel();
		panelCrearEmpleado.setBorder(new MatteBorder(10, 10, 10, 10, verde));
		panelCrearEmpleado.setBackground(verde2);
		panelCrearEmpleado.setPreferredSize(new Dimension(0,175));
		panelCrearEmpleado.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panelIzq.add(panelCrearEmpleado);
		
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
		cmboxPuestos.setModel(new DefaultComboBoxModel<String>(new String[] {"", "Lider de Proyecto", "Arquitecto", "Programador", "Tester"}));
		panelCrearEmpleado.add(cmboxPuestos);
		
		JLabel lblFoto = new JLabel("Foto:");
		lblFoto.setFont(new Font("Nirmala UI", Font.BOLD, 11));
		lblFoto.setForeground(Color.WHITE);
		lblFoto.setPreferredSize(new Dimension(50,30));
		panelCrearEmpleado.add(lblFoto);
		
		txtPathFoto = new JTextField("Default");
		txtPathFoto.setFont(new Font("Nirmala UI", Font.ITALIC, 11));
		txtPathFoto.setPreferredSize(new Dimension(85,30));
		txtPathFoto.setEditable(false);
		panelCrearEmpleado.add(txtPathFoto);
		
		btnElegirFoto = new JButton("");
		btnElegirFoto.setIcon(new ImageIcon(CargarEmpleados.class.getResource("/iconos/subir.png")));
		btnElegirFoto.setPreferredSize(new Dimension(45, 30));
		btnElegirFoto.setBackground(verde2.darker());
		panelCrearEmpleado.add(btnElegirFoto);
	
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
		
	}
	
	private void iniSegundoPanelIzq(JPanel panelIzq) 
	{
		JPanel panelGenerarEmpleado = new JPanel();
		panelGenerarEmpleado.setBackground(verde2);
		panelGenerarEmpleado.setBorder(new MatteBorder(0, 10, 15, 10, verde));
		panelGenerarEmpleado.setPreferredSize(new Dimension(0, 220));
		panelGenerarEmpleado.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 15));
		panelIzq.add(panelGenerarEmpleado);
		
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
	}
	
	private void iniBotonEliminar(JPanel panelIzq) 
	{
		JPanel panelEliminar = new JPanel();
		panelEliminar.setBackground(verde);
		panelEliminar.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 15));
		panelEliminar.setPreferredSize(new Dimension(0, 30));
		panelIzq.add(panelEliminar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setPreferredSize(new Dimension(100,30));
		btnEliminar.setFont(new Font("Nirmala UI", Font.BOLD, 13));
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
	}
	
	
	//METODOS PUBLICOS
	
	public void resetearCampos() 
	{
		txtNombre.setText(null);
		txtApellido.setText(null);
		cmboxPuestos.setSelectedItem("");
		txtPathFoto.setText("Default");
		cantLiderDeProyecto.setValue(0);
		cantArquitecto.setValue(0);
		cantProgramador.setValue(0);
		cantTester.setValue(0);
	}

	public void setTabla(String[][] matriz) 
	{
		DefaultTableModel dtm = new DefaultTableModel(matriz, new String[] {"Nombre", "Puesto"});
		tablaEmpleados.setModel(dtm);	
	}

	public void setCantNombres(int cantidad) 
	{
		lblCantNombres.setToolTipText("Es posible generar " + cantidad + " empleados.");
	}

	public void setPathFoto(String path) 
	{
		txtPathFoto.setText(path);
	}
	
	public void resetPath() 
	{
		txtPathFoto.setText("Default");
	}

	public String getNombre() 
	{
		return txtNombre.getText();	
	}

	public String getApellido() 
	{
		return txtApellido.getText();
	}

	public String getPuesto() 
	{
		return cmboxPuestos.getSelectedItem().toString();
	}
	
	public String getPathFoto() 
	{
		return txtPathFoto.getText();
	}

	public int getCantLider() 
	{	
		return (int) cantLiderDeProyecto.getValue();
	}
	
	public int getCantArquitecto()
	{
		return (int) cantArquitecto.getValue();
	}
	
	public int getCantProgramador() 
	{
		return (int) cantProgramador.getValue();
	}
	
	public int getCantTester() 
	{
		return (int) cantTester.getValue();
	}
}
