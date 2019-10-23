package vista;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SpinnerNumberModel;

@SuppressWarnings("serial")
public class CargarRequerimientos extends JPanel
{
	public JSpinner cantMinimaLider, cantMaximaLider;
	public JSpinner cantMinimaArquitecto, cantMaximaArquitecto;
	public JSpinner cantMinimaProgramador, cantMaximaProgramador;
	public JSpinner cantMinimaTester, cantMaximaTester;
	
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
		iniPanelLider();
		
		iniPanelArquitecto();
		
		iniPanelProgramador();
		
		iniPanelTester();
	}

	private void iniPanelLider() 
	{
		JPanel panelLider = new JPanel();
		panelLider.setPreferredSize(new Dimension(250,250));
		panelLider.setBackground(verde2);
		add(panelLider);
		
		JLabel lblLider = new JLabel("Lider de Proyecto");
		lblLider.setHorizontalAlignment(SwingConstants.CENTER);
		lblLider.setPreferredSize(new Dimension(250, 50));
		lblLider.setForeground(Color.WHITE);
		lblLider.setFont(new Font("Nirmala UI", Font.BOLD, 13));
		panelLider.add(lblLider);
		
		JLabel lblCotaMinima = new JLabel("Cota Minima:");
		lblCotaMinima.setHorizontalAlignment(SwingConstants.LEFT);
		lblCotaMinima.setPreferredSize(new Dimension(90, 50));
		lblCotaMinima.setForeground(Color.WHITE);
		lblCotaMinima.setFont(new Font("Nirmala UI", Font.BOLD, 13));
		panelLider.add(lblCotaMinima);
		
		cantMinimaLider = new JSpinner();
		cantMinimaLider.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		cantMinimaLider.setPreferredSize(new Dimension(60,25));
		panelLider.add(cantMinimaLider);
		
		JLabel lblCotaMaxima = new JLabel("Cota Maxima:");
		lblCotaMaxima.setHorizontalAlignment(SwingConstants.LEFT);
		lblCotaMaxima.setPreferredSize(new Dimension(90, 50));
		lblCotaMaxima.setForeground(Color.WHITE);
		lblCotaMaxima.setFont(new Font("Nirmala UI", Font.BOLD, 13));
		panelLider.add(lblCotaMaxima);
		
		cantMaximaLider = new JSpinner();
		cantMaximaLider.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		cantMaximaLider.setPreferredSize(new Dimension(60,25));
		panelLider.add(cantMaximaLider);
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
		
		cantMinimaArquitecto = new JSpinner();
		cantMinimaArquitecto.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		cantMinimaArquitecto.setPreferredSize(new Dimension(60,25));
		panelArquitecto.add(cantMinimaArquitecto);
		
		JLabel lblCotaMaxima = new JLabel("Cota Maxima:");
		lblCotaMaxima.setHorizontalAlignment(SwingConstants.LEFT);
		lblCotaMaxima.setPreferredSize(new Dimension(90, 50));
		lblCotaMaxima.setForeground(Color.WHITE);
		lblCotaMaxima.setFont(new Font("Nirmala UI", Font.BOLD, 13));
		panelArquitecto.add(lblCotaMaxima);
		
		cantMaximaArquitecto = new JSpinner();
		cantMaximaArquitecto.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		cantMaximaArquitecto.setPreferredSize(new Dimension(60,25));
		panelArquitecto.add(cantMaximaArquitecto);
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
		
		cantMinimaProgramador = new JSpinner();
		cantMinimaProgramador.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		cantMinimaProgramador.setPreferredSize(new Dimension(60,25));
		panelProgramador.add(cantMinimaProgramador);
		
		JLabel lblCotaMaxima = new JLabel("Cota Maxima:");
		lblCotaMaxima.setHorizontalAlignment(SwingConstants.LEFT);
		lblCotaMaxima.setPreferredSize(new Dimension(90, 50));
		lblCotaMaxima.setForeground(Color.WHITE);
		lblCotaMaxima.setFont(new Font("Nirmala UI", Font.BOLD, 13));
		panelProgramador.add(lblCotaMaxima);
		
		cantMaximaProgramador = new JSpinner();
		cantMaximaProgramador.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		cantMaximaProgramador.setPreferredSize(new Dimension(60,25));
		panelProgramador.add(cantMaximaProgramador);
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
		
		cantMinimaTester = new JSpinner();
		cantMinimaTester.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		cantMinimaTester.setPreferredSize(new Dimension(60,25));
		panelTester.add(cantMinimaTester);
		
		JLabel lblCotaMaxima = new JLabel("Cota Maxima:");
		lblCotaMaxima.setHorizontalAlignment(SwingConstants.LEFT);
		lblCotaMaxima.setPreferredSize(new Dimension(90, 50));
		lblCotaMaxima.setForeground(Color.WHITE);
		lblCotaMaxima.setFont(new Font("Nirmala UI", Font.BOLD, 13));
		panelTester.add(lblCotaMaxima);
		
		cantMaximaTester = new JSpinner();
		cantMaximaTester.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		cantMaximaTester.setPreferredSize(new Dimension(60,25));
		panelTester.add(cantMaximaTester);
	}
}
