package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class MostrarSolucion extends JPanel
{	
	public JTable tablaEquipo;
	public JLabel lblMensajeResultado;
	private JPanel panelLider, panelArquitecto, panelProgramador, panelTester;
	
	private Color verde, verde2;

	public MostrarSolucion() 
	{
		verde = new Color(21, 182, 141);
		verde2 = new Color(16, 163, 125);
		
		this.setBackground(verde);
		this.setLayout(new BorderLayout());
		
		inicializar();
	}

	private void inicializar() 
	{
		JPanel panelEquipo = new JPanel();
		panelEquipo.setBorder(new MatteBorder(10, 0, 0, 0, verde));
		panelEquipo.setLayout(new BoxLayout(panelEquipo, BoxLayout.Y_AXIS));
		this.add(panelEquipo, BorderLayout.CENTER);
		
		JScrollPane scrollLider = new JScrollPane();
		scrollLider.setBorder(new MatteBorder(0, 300, 0, 300, verde));
		panelEquipo.add(scrollLider);
		
		panelLider = new JPanel();
		panelLider.setBackground(verde2);
		panelLider.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));
		scrollLider.setViewportView(panelLider);
		
		JScrollPane scrollArquitecto = new JScrollPane();
		scrollArquitecto.setBorder(new MatteBorder(0, 200, 0, 200, verde));
		panelEquipo.add(scrollArquitecto);
		
		panelArquitecto = new JPanel();
		panelArquitecto.setBackground(verde2);
		panelArquitecto.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));
		scrollArquitecto.setViewportView(panelArquitecto);
		
		JScrollPane scrollProgramador = new JScrollPane();
		scrollProgramador.setBorder(new MatteBorder(0, 100, 0, 100, verde));
		panelEquipo.add(scrollProgramador);
		
		panelProgramador = new JPanel();
		panelProgramador.setBackground(verde2);
		panelProgramador.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));
		scrollProgramador.setViewportView(panelProgramador);
		
		JScrollPane scrollTester = new JScrollPane();
		scrollTester.setBorder(new MatteBorder(0, 0, 0, 0, verde));
		panelEquipo.add(scrollTester);
		
		panelTester = new JPanel();
		panelTester.setBackground(verde2);
		panelTester.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));
		scrollTester.setViewportView(panelTester);

		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(verde);
		panelSuperior.setPreferredSize(new Dimension(496,40));
		panelSuperior.setLayout(new FlowLayout(FlowLayout.LEADING, 70, 5));
		this.add(panelSuperior, BorderLayout.NORTH);
		
		JButton btnEstadisticas = new JButton("Estadistica");
		btnEstadisticas.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/iconos/estadistica.png")));
		panelSuperior.add(btnEstadisticas);
		
		lblMensajeResultado = new JLabel("Equipo que cumple con los requisitos");
		lblMensajeResultado.setFont(new Font("Nirmala UI", Font.BOLD, 16));
		lblMensajeResultado.setForeground(Color.WHITE);
		panelSuperior.add(lblMensajeResultado);	
	}
	
	public void limpiarFotos() 
	{
		panelLider.removeAll();
		panelArquitecto.removeAll();
		panelProgramador.removeAll();
		panelTester.removeAll();
	}
	
	public void agregarLider(String nombre, ImageIcon foto) 
	{
		panelLider.add(panel(nombre, foto));
	}
	
	public void agregarArquitecto(String nombre, ImageIcon foto) 
	{
		panelArquitecto.add(panel(nombre, foto));
	}
	
	public void agregarProgramador(String nombre, ImageIcon foto) 
	{
		panelProgramador.add(panel(nombre, foto));
	}
	
	public void agregarTester(String nombre, ImageIcon foto) 
	{
		panelTester.add(panel(nombre, foto));
	}
	
	private JPanel panel(String nombre, ImageIcon imagen) 
	{	
		JPanel panel = new JPanel();
		panel.setBackground(verde2);
		panel.setPreferredSize(new Dimension(70,90));
		panel.setToolTipText(nombre);
		panel.setLayout(new BorderLayout());
		
		JLabel lblImagen = new JLabel();
		lblImagen.setPreferredSize(new Dimension(70,70));
		lblImagen.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT)));
		panel.add(lblImagen, BorderLayout.CENTER);
		
		JLabel lblNombre = new JLabel(recortar(nombre));
		lblNombre.setForeground(Color.white);
		lblNombre.setPreferredSize(new Dimension(70,20));
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNombre, BorderLayout.SOUTH);
	
		return panel;
	}

	private String recortar(String nombre) 
	{
		String[] array = nombre.split(" ");
		nombre = array[0] + " " + array[1].charAt(0) + ".";
		
		return nombre;
	}
}