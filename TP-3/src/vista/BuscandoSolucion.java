package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import rojerusan.componentes.RSProgressCircleAnimatedUno;
import java.awt.Dimension;
import javax.swing.JProgressBar;

@SuppressWarnings("serial")
public class BuscandoSolucion extends JPanel
{
	private Color verde, verde2;
	
	public BuscandoSolucion() 
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
		this.add(panelBarraProgreso, BorderLayout.CENTER);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setIndeterminate(true);
		panelBarraProgreso.add(progressBar);
		
		
		
		
		
		
		
	}
}
