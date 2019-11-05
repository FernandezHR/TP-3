package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class MostrarSolucion extends JPanel
{	
	private JLabel lblMensajeResultado;
	private JPanel panelLider, panelArquitectos, panelProgramadores, panelTesters;
	
	private Color verde, verde2;

	public MostrarSolucion() 
	{
		verde = new Color(21, 182, 141);
		verde2 = new Color(16, 163, 125);
		
		this.setBackground(verde);
		this.setLayout(new BorderLayout());
		
		iniComponentes();
	}

	private void iniComponentes() 
	{
		JPanel panelEquipo = new JPanel();
		panelEquipo.setBorder(new MatteBorder(10, 0, 0, 0, verde));
		panelEquipo.setLayout(new BoxLayout(panelEquipo, BoxLayout.Y_AXIS));
		this.add(panelEquipo, BorderLayout.CENTER);
		
		//PANEL LIDER
		JScrollPane scrollLider = new JScrollPane();
		scrollLider.setBorder(new MatteBorder(0, 300, 0, 300, verde));
		panelEquipo.add(scrollLider);
		
		panelLider = new JPanel();
		panelLider.setBackground(verde2);
		panelLider.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));
		scrollLider.setViewportView(panelLider);
		
		//PANEL ARQUITECTOS
		JScrollPane scrollArquitecto = new JScrollPane();
		scrollArquitecto.setBorder(new MatteBorder(0, 200, 0, 200, verde));
		panelEquipo.add(scrollArquitecto);
		
		panelArquitectos = new JPanel();
		panelArquitectos.setBackground(verde2);
		panelArquitectos.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));
		scrollArquitecto.setViewportView(panelArquitectos);
		
		//PANEL PROGRAMADORES
		JScrollPane scrollProgramador = new JScrollPane();
		scrollProgramador.setBorder(new MatteBorder(0, 100, 0, 100, verde));
		panelEquipo.add(scrollProgramador);
		
		panelProgramadores = new JPanel();
		panelProgramadores.setBackground(verde2);
		panelProgramadores.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));
		scrollProgramador.setViewportView(panelProgramadores);
		
		//PANEL TESTERS
		JScrollPane scrollTester = new JScrollPane();
		scrollTester.setBorder(new MatteBorder(0, 0, 0, 0, verde));
		panelEquipo.add(scrollTester);
		
		panelTesters = new JPanel();
		panelTesters.setBackground(verde2);
		panelTesters.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));
		scrollTester.setViewportView(panelTesters);

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
	

	//METODOS PUBLICOS
	public void setMensaje(String mensaje) 
	{
		lblMensajeResultado.setText(mensaje);
	}
	
	public void limpiarFotos() 
	{
		panelLider.removeAll();
		panelArquitectos.removeAll();
		panelProgramadores.removeAll();
		panelTesters.removeAll();
	}
	
	public void agregarLider(String nombre, ImageIcon foto) 
	{
		panelLider.add(panelConFoto(nombre, foto));
	}
	
	public void agregarArquitecto(String nombre, ImageIcon foto) 
	{
		panelArquitectos.add(panelConFoto(nombre, foto));
	}
	
	public void agregarProgramador(String nombre, ImageIcon foto) 
	{
		panelProgramadores.add(panelConFoto(nombre, foto));
	}
	
	public void agregarTester(String nombre, ImageIcon foto) 
	{
		panelTesters.add(panelConFoto(nombre, foto));
	}
	
	private JPanel panelConFoto(String nombre, ImageIcon imagen) 
	{	
		JPanel panel = new JPanel();
		panel.setBackground(verde2);
		panel.setPreferredSize(new Dimension(70,90));
		panel.setToolTipText(nombre);
		panel.setLayout(new BorderLayout());
		
		JLabel lblImagen = new JLabel();
		lblImagen.setPreferredSize(new Dimension(70,70));
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagen.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
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