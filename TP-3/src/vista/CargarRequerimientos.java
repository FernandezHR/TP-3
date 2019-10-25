package vista;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SpinnerNumberModel;

@SuppressWarnings("serial")
public class CargarRequerimientos extends JPanel
{
	public JSpinner minArquitecto, maxArquitecto;
	public JSpinner minProgramador, maxProgramador;
	public JSpinner minTester, maxTester;
	
	public JButton btnCargar;
	
	private Color verde, verde2;
	
	public CargarRequerimientos() 
	{
		verde = new Color(21, 182, 141);
		verde2 = new Color(16, 163, 125);
		
		setBackground(verde);
		
		inicializar();
	}
	
	private void inicializar() 
	{
		iniPanelArquitecto();
		
		iniPanelProgramador();
		
		iniPanelTester();
		
		btnCargar = new JButton("Confirmar");
		add(btnCargar);
	}


	private void iniPanelArquitecto() 
	{
		JPanel panelArquitecto = new JPanel();
		panelArquitecto.setPreferredSize(new Dimension(250,250));
		panelArquitecto.setBackground(verde2);
		add(panelArquitecto);
		
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
		panelProgramador.setPreferredSize(new Dimension(250,250));
		panelProgramador.setBackground(verde2);
		add(panelProgramador);
		
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
		panelTester.setPreferredSize(new Dimension(250,250));
		panelTester.setBackground(verde2);
		add(panelTester);
		
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
