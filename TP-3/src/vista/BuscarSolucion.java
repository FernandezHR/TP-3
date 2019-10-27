package vista;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.MatteBorder;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class BuscarSolucion extends JPanel
{
	private Color verde, verde2;
	
	public BuscarSolucion() 
	{
		verde = new Color(21, 182, 141);
		verde2 = new Color(16, 163, 125);
		
		this.setLayout(new BorderLayout());
		this.setBackground(verde);	
		
		inicializarComponentes();
	}

	private void inicializarComponentes() 
	{ 
		JPanel panelBarraProgreso = new JPanel();
		panelBarraProgreso.setBackground(verde);
		panelBarraProgreso.setBorder(new MatteBorder(170, 0, 0, 0, verde));
		this.add(panelBarraProgreso, BorderLayout.CENTER);
		
		JLabel lblBuscando = new JLabel("Buscando solucion...");
		lblBuscando.setHorizontalAlignment(SwingConstants.LEFT);
		lblBuscando.setPreferredSize(new Dimension(500,50));
		lblBuscando.setFont(new Font("Nirmala UI", Font.BOLD, 17));
		lblBuscando.setForeground(Color.WHITE);
		panelBarraProgreso.add(lblBuscando);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBackground(verde);
		progressBar.setPreferredSize(new Dimension(500, 50));
		progressBar.setIndeterminate(true);
		panelBarraProgreso.add(progressBar);
				
	}
}
