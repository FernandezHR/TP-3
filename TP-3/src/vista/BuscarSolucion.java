package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
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
		
		iniComponentes();
	}

	private void iniComponentes() 
	{ 
		JPanel panelBarraProgreso = new JPanel();
		panelBarraProgreso.setBorder(new MatteBorder(180, 0, 0, 0, verde));
		panelBarraProgreso.setBackground(verde);
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
