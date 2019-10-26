package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import rojerusan.componentes.RSProgressCircleAnimatedUno;
import java.awt.Dimension;

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
		
		RSProgressCircleAnimatedUno progressCircleAnimatedUno = new RSProgressCircleAnimatedUno();
		progressCircleAnimatedUno.setPreferredSize(new Dimension(400, 400));
		progressCircleAnimatedUno.setColorText(Color.WHITE);
		progressCircleAnimatedUno.setForeground(Color.WHITE);
		progressCircleAnimatedUno.setString("Buscando Solucion...");
		panelBarraProgreso.add(progressCircleAnimatedUno);
		
		
		
		
		
	}
}
