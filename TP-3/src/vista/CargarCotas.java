package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

@SuppressWarnings("serial")
public class CargarCotas extends JPanel
{
	public JSpinner minArquitecto, maxArquitecto;
	public JSpinner minProgramador, maxProgramador;
	public JSpinner minTester, maxTester;

	private Color verde, verde2;
	
	public CargarCotas() 
	{
		verde = new Color(21, 182, 141);
		verde2 = new Color(16, 163, 125);
		
		this.setBackground(verde);
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 0,10));
		
		iniPanelArquitecto();
		iniPanelProgramador();
		iniPanelTester();
	}

	private void iniPanelArquitecto() 
	{
		JPanel panelArquitecto = new JPanel();
		panelArquitecto.setBorder(new MatteBorder(0, 10, 0, 10, verde));
		panelArquitecto.setPreferredSize(new Dimension(250,140));
		panelArquitecto.setBackground(verde2);
		panelArquitecto.setLayout(new FlowLayout(FlowLayout.CENTER, 5, -5));
		this.add(panelArquitecto);
		
		JLabel lblArquitecto = new JLabel("Arquitecto");
		lblArquitecto.setHorizontalAlignment(SwingConstants.CENTER);
		lblArquitecto.setPreferredSize(new Dimension(250, 50));
		lblArquitecto.setForeground(Color.WHITE);
		lblArquitecto.setFont(new Font("Nirmala UI", Font.BOLD, 13));
		panelArquitecto.add(lblArquitecto);
		
		JLabel lblCotaMinima = new JLabel("Cota Minima:");
		lblCotaMinima.setHorizontalAlignment(SwingConstants.LEFT);
		lblCotaMinima.setPreferredSize(new Dimension(90, 50));
		lblCotaMinima.setForeground(Color.WHITE);
		lblCotaMinima.setFont(new Font("Nirmala UI", Font.BOLD, 13));
		panelArquitecto.add(lblCotaMinima);
		
		minArquitecto = new JSpinner();
		minArquitecto.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		minArquitecto.setPreferredSize(new Dimension(60,25));
		panelArquitecto.add(minArquitecto);
		
		JLabel lblCotaMaxima = new JLabel("Cota Maxima:");
		lblCotaMaxima.setHorizontalAlignment(SwingConstants.LEFT);
		lblCotaMaxima.setPreferredSize(new Dimension(90, 50));
		lblCotaMaxima.setForeground(Color.WHITE);
		lblCotaMaxima.setFont(new Font("Nirmala UI", Font.BOLD, 13));
		panelArquitecto.add(lblCotaMaxima);
		
		maxArquitecto = new JSpinner();
		maxArquitecto.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		maxArquitecto.setPreferredSize(new Dimension(60,25));
		panelArquitecto.add(maxArquitecto);
	}
	
	private void iniPanelProgramador() 
	{
		JPanel panelProgramador = new JPanel();
		panelProgramador.setBorder(new MatteBorder(0, 10, 0, 10, verde));
		panelProgramador.setPreferredSize(new Dimension(250,140));
		panelProgramador.setBackground(verde2);
		panelProgramador.setLayout(new FlowLayout(FlowLayout.CENTER, 5, -5));
		this.add(panelProgramador);
		
		JLabel lblProgramador = new JLabel("Programador");
		lblProgramador.setHorizontalAlignment(SwingConstants.CENTER);
		lblProgramador.setPreferredSize(new Dimension(250, 50));
		lblProgramador.setForeground(Color.WHITE);
		lblProgramador.setFont(new Font("Nirmala UI", Font.BOLD, 13));
		panelProgramador.add(lblProgramador);
		
		JLabel lblCotaMinima = new JLabel("Cota Minima:");
		lblCotaMinima.setHorizontalAlignment(SwingConstants.LEFT);
		lblCotaMinima.setPreferredSize(new Dimension(90, 50));
		lblCotaMinima.setForeground(Color.WHITE);
		lblCotaMinima.setFont(new Font("Nirmala UI", Font.BOLD, 13));
		panelProgramador.add(lblCotaMinima);
		
		minProgramador = new JSpinner();
		minProgramador.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		minProgramador.setPreferredSize(new Dimension(60,25));
		panelProgramador.add(minProgramador);
		
		JLabel lblCotaMaxima = new JLabel("Cota Maxima:");
		lblCotaMaxima.setHorizontalAlignment(SwingConstants.LEFT);
		lblCotaMaxima.setPreferredSize(new Dimension(90, 50));
		lblCotaMaxima.setForeground(Color.WHITE);
		lblCotaMaxima.setFont(new Font("Nirmala UI", Font.BOLD, 13));
		panelProgramador.add(lblCotaMaxima);
		
		maxProgramador = new JSpinner();
		maxProgramador.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		maxProgramador.setPreferredSize(new Dimension(60,25));
		panelProgramador.add(maxProgramador);
	}
	
	private void iniPanelTester() 
	{
		JPanel panelTester = new JPanel();
		panelTester.setBorder(new MatteBorder(0, 10, 0, 10, verde));
		panelTester.setPreferredSize(new Dimension(250,140));
		panelTester.setBackground(verde2);
		panelTester.setLayout(new FlowLayout(FlowLayout.CENTER, 5, -5));
		this.add(panelTester);
		
		JLabel lblTester = new JLabel("Tester");
		lblTester.setHorizontalAlignment(SwingConstants.CENTER);
		lblTester.setPreferredSize(new Dimension(250, 50));
		lblTester.setForeground(Color.WHITE);
		lblTester.setFont(new Font("Nirmala UI", Font.BOLD, 13));
		panelTester.add(lblTester);
		
		JLabel lblCotaMinima = new JLabel("Cota Minima:");
		lblCotaMinima.setHorizontalAlignment(SwingConstants.LEFT);
		lblCotaMinima.setPreferredSize(new Dimension(90, 50));
		lblCotaMinima.setForeground(Color.WHITE);
		lblCotaMinima.setFont(new Font("Nirmala UI", Font.BOLD, 13));
		panelTester.add(lblCotaMinima);
		
		minTester = new JSpinner();
		minTester.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		minTester.setPreferredSize(new Dimension(60,25));
		panelTester.add(minTester);
		
		JLabel lblCotaMaxima = new JLabel("Cota Maxima:");
		lblCotaMaxima.setHorizontalAlignment(SwingConstants.LEFT);
		lblCotaMaxima.setPreferredSize(new Dimension(90, 50));
		lblCotaMaxima.setForeground(Color.WHITE);
		lblCotaMaxima.setFont(new Font("Nirmala UI", Font.BOLD, 13));
		panelTester.add(lblCotaMaxima);
		
		maxTester = new JSpinner();
		maxTester.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		maxTester.setPreferredSize(new Dimension(60,25));
		panelTester.add(maxTester);
	}
}
