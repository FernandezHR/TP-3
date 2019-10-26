package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;

@SuppressWarnings("serial")
public class CargarRequerimientos extends JPanel
{
	public JSpinner minArquitecto, maxArquitecto;
	public JSpinner minProgramador, maxProgramador;
	public JSpinner minTester, maxTester;
	public JButton btnConfirmar;
	private Color verde, verde2;
	
	public CargarRequerimientos(JTable tablaEmpleados, JTable tablaIncompatibles) 
	{
		verde = new Color(21, 182, 141);
		verde2 = new Color(16, 163, 125);
		
		this.setBackground(verde);
		this.setLayout(new BorderLayout());
		
		inicializar(tablaEmpleados, tablaIncompatibles);
	}
	
	private void inicializar(JTable tablaEmpleados, JTable tablaIncompatibles) 
	{
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		this.add(tabbedPane, BorderLayout.CENTER);
		
		JScrollPane scrollPaneTE = new JScrollPane();
		scrollPaneTE.setPreferredSize(new Dimension(496, 508));
		scrollPaneTE.setViewportView(tablaEmpleados);
		tabbedPane.add("Lista de Empleados", scrollPaneTE);
		
		JScrollPane scrollPaneTI = new JScrollPane();
		scrollPaneTI.setPreferredSize(new Dimension(496, 508));
		scrollPaneTI.setViewportView(tablaIncompatibles);
		tabbedPane.add("Lista de Incompatibles", scrollPaneTI);
		
		
		//INICIALIZACION DE LOS COMPONENTES DEL PANEL IZQUIERDO
		JPanel panelIzq = new JPanel();
		panelIzq.setPreferredSize(new Dimension(240,0));
		panelIzq.setBackground(verde);
		panelIzq.setLayout(new BoxLayout(panelIzq, BoxLayout.Y_AXIS));
		add(panelIzq, BorderLayout.WEST);
		
		iniPanelArquitecto(panelIzq);
		
		iniPanelProgramador(panelIzq);
		
		iniPanelTester(panelIzq);
		
		iniBtnConfirmar(panelIzq);
	}

	private void iniPanelArquitecto(JPanel panelIzq) 
	{
		JPanel panelArquitecto = new JPanel();
		panelArquitecto.setBorder(new MatteBorder(10, 10, 0, 10, verde));
		panelArquitecto.setPreferredSize(new Dimension(250,250));
		panelArquitecto.setBackground(verde2);
		panelArquitecto.setLayout(new FlowLayout(FlowLayout.CENTER, 5, -5));
		panelIzq.add(panelArquitecto);
		
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
	
	private void iniPanelProgramador(JPanel panelIzq) 
	{
		JPanel panelProgramador = new JPanel();
		panelProgramador.setBorder(new MatteBorder(10, 10, 0, 10, verde));
		panelProgramador.setPreferredSize(new Dimension(250,250));
		panelProgramador.setBackground(verde2);
		panelProgramador.setLayout(new FlowLayout(FlowLayout.CENTER, 5, -5));
		panelIzq.add(panelProgramador);
		
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
	
	private void iniPanelTester(JPanel panelIzq) 
	{
		JPanel panelTester = new JPanel();
		panelTester.setBorder(new MatteBorder(10, 10, 0, 10, verde));
		panelTester.setPreferredSize(new Dimension(250,250));
		panelTester.setBackground(verde2);
		panelTester.setLayout(new FlowLayout(FlowLayout.CENTER, 5, -5));
		panelIzq.add(panelTester);
		
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
	
	private void iniBtnConfirmar(JPanel panelIzq) 
	{
		JPanel panelConfirmar = new JPanel();
		panelConfirmar.setBackground(verde);
		panelConfirmar.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 15));
		panelConfirmar.setPreferredSize(new Dimension(0, 50));
		panelIzq.add(panelConfirmar);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setPreferredSize(new Dimension(100,30));
		btnConfirmar.setFont(new Font("Nirmala UI", Font.BOLD, 13));
		btnConfirmar.setBackground(verde2.darker());
		btnConfirmar.setForeground(Color.WHITE);
		btnConfirmar.setFocusable(false);
		btnConfirmar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) 
			{
				btnConfirmar.setFont(new Font("Nirmala UI", Font.BOLD, 12));
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) 
			{
				btnConfirmar.setFont(new Font("Nirmala UI", Font.BOLD, 13));
			}
		});
		panelConfirmar.add(btnConfirmar);		
	}
}
