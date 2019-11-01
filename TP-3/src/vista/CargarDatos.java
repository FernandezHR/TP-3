package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class CargarDatos extends JPanel
{
	public JPanel panelControles;
	public CargarIncompatibles panelCargarIncompatibles;
	public CargarCotas panelCargarCotas;
	public JTable tablaEmpleados, tablaIncompatibles;
	public JButton btnSiguiente, btnAnterior;
	
	private Color verde;
	
	public CargarDatos() 
	{
		verde = new Color(21, 182, 141);

		this.setBackground(verde);
		this.setLayout(new BorderLayout());
		
		inicializarComponentes();
	}
	
	private void inicializarComponentes() 
	{
		iniciarTablas();
		
		panelControles = new JPanel();
		panelControles.setPreferredSize(new Dimension(240,0));
		panelControles.setBackground(verde);
		panelControles.setLayout(new BorderLayout());
		this.add(panelControles, BorderLayout.WEST);
			
		panelCargarCotas = new CargarCotas();
		panelCargarCotas.setVisible(false);
		
		panelCargarIncompatibles = new CargarIncompatibles();
		panelControles.add(panelCargarIncompatibles, BorderLayout.CENTER);
		
		//INICIALIZACION DE BOTONES
		JPanel panelBotones = new JPanel();
		panelBotones.setBackground(verde);
		panelBotones.setPreferredSize(new Dimension(300,50));
		panelBotones.setLayout(new FlowLayout());
		panelControles.add(panelBotones, BorderLayout.SOUTH);
		
		btnAnterior = new JButton();
		btnAnterior.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/iconos/flechaIzq.png")));
		btnAnterior.setFont(new Font("Nirmala UI", Font.BOLD, 13));
		btnAnterior.setFocusable(false);
		btnAnterior.setBackground(new Color(11, 53, 42));
		btnAnterior.setEnabled(false);
		panelBotones.add(btnAnterior);
		
		btnSiguiente = new JButton();
		btnSiguiente.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/iconos/flechaDer.png")));
		btnSiguiente.setFont(new Font("Nirmala UI", Font.BOLD, 13));
		btnSiguiente.setFocusable(false);
		btnSiguiente.setBackground(new Color(11, 53, 42));
		panelBotones.add(btnSiguiente);
	}

	private void iniciarTablas() 
	{
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		this.add(tabbedPane, BorderLayout.CENTER);
		
		JScrollPane scrollPaneTI = new JScrollPane();
		scrollPaneTI.setPreferredSize(new Dimension(496, 508));
		tabbedPane.add("Lista de Incompatibles", scrollPaneTI);
		
		tablaIncompatibles = new JTable(new DefaultTableModel(new Object[][] {}, new String[] {"Empleado 1", "Puesto 1", "Empleado 2", "Puesto 2"})) 
		{
			@Override //Sobreescribmos este metodo para desactivar la edicion de celdas
			public boolean isCellEditable(int i, int j) 
			{
				return false;
			}
		};
		scrollPaneTI.setViewportView(tablaIncompatibles);
		
		JScrollPane scrollPaneTE = new JScrollPane();
		scrollPaneTE.setPreferredSize(new Dimension(496, 508));
		tabbedPane.add("Lista de Empleados", scrollPaneTE);
		
		tablaEmpleados = new JTable(new DefaultTableModel(new Object[][] {}, new String[] {"Nombre", "Puesto"})) 
		{
			@Override //Sobreescribmos este metodo para desactivar la edicion de celdas
			public boolean isCellEditable(int i, int j) 
			{
				return false;
			}
		};
		scrollPaneTE.setViewportView(tablaEmpleados);
	}
	
	public void cambiarPanel() 
	{
		if(panelCargarCotas.isVisible()) 
		{
			panelCargarCotas.setVisible(false);
			panelCargarIncompatibles.setVisible(true);
			panelControles.add(panelCargarIncompatibles, BorderLayout.CENTER);
			btnSiguiente.setEnabled(true);
			btnAnterior.setEnabled(false);
		}
		
		else if(panelCargarIncompatibles.isVisible())
		{
			panelCargarIncompatibles.setVisible(false);
			panelCargarCotas.setVisible(true);
			panelControles.add(panelCargarCotas, BorderLayout.CENTER);
			btnSiguiente.setEnabled(false);
			btnAnterior.setEnabled(true);
			System.out.println("XD");
		}
	}

}
