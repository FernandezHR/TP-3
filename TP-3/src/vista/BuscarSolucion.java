package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import rojerusan.componentes.RSProgressCircleAnimatedUno;
import java.awt.Font;

@SuppressWarnings("serial")
public class BuscarSolucion extends JPanel
{
	private Color verde;
	
	public BuscarSolucion() 
	{
		verde = new Color(21, 182, 141);
		
		this.setLayout(new BorderLayout());
		this.setBackground(verde);	
		
		inicializarComponentes();
	}

	private void inicializarComponentes() 
	{ 
		JPanel panelBarraVircular = new JPanel();
		panelBarraVircular.setBackground(verde);
		panelBarraVircular.setBorder(new MatteBorder(100, 100, 100, 100, verde));
		panelBarraVircular.setLayout(new BorderLayout());
		this.add(panelBarraVircular, BorderLayout.CENTER);
		
		RSProgressCircleAnimatedUno barraCicular = new RSProgressCircleAnimatedUno();
		barraCicular.setFont(new Font("Nirmala UI", Font.BOLD, 15));
		barraCicular.setColorText(Color.WHITE);
		barraCicular.setForeground(Color.WHITE);
		barraCicular.setString("Buscando Solucion");	
		panelBarraVircular.add(barraCicular, BorderLayout.CENTER);
		
//		JLabel lblBuscando = new JLabel("Buscando solucion...");
//		lblBuscando.setHorizontalAlignment(SwingConstants.LEFT);
//		lblBuscando.setPreferredSize(new Dimension(500,50));
//		lblBuscando.setFont(new Font("Nirmala UI", Font.BOLD, 17));
//		lblBuscando.setForeground(Color.WHITE);
//		panelBarraProgreso.add(lblBuscando);
//		
//		JProgressBar progressBar = new JProgressBar();
//		progressBar.setBackground(verde);
//		progressBar.setPreferredSize(new Dimension(500, 50));
//		progressBar.setIndeterminate(true);
//		panelBarraProgreso.add(progressBar);
				
	}
}
