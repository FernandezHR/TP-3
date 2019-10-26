package controlador;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import modelo.Modelo;
import vista.CargarRequerimientos;
import vista.VentanaPrincipal;

public class CtrlVentanaPrincipal implements ActionListener
{
	private Modelo modelo;
	private VentanaPrincipal vPrincipal;
	
	private CtrlCargarEmpleados ctrlCargarEmpleados;
	private CtrlCargarIncompatibles ctrlCargarIncompatibles;
	private CtrlCargarRequerimientos ctrlCargarRequerimientos;
	
	public CtrlVentanaPrincipal(Modelo modelo, VentanaPrincipal vPrincipal) 
	{
		this.modelo = modelo;
		this.vPrincipal = vPrincipal;
		
		this.vPrincipal.btnCambiarPanel.addActionListener(this);
	}
	
	public void iniciar() 
	{
		ctrlCargarEmpleados = new CtrlCargarEmpleados(modelo, vPrincipal.panelCargarEmpleado);
		ctrlCargarEmpleados.iniciar();
		
		vPrincipal.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		if(arg0.getSource() == vPrincipal.btnCambiarPanel) 
			cambiarDePanel();
	}

	private void cambiarDePanel() 
	{
		if(actualEs(vPrincipal.panelCargarEmpleado)) 
		{
			if(ctrlCargarEmpleados.tieneDatosSuficientes()) 
			{
				modelo.confirmarListaDeEmpleados();
			
				iniciarCargarIncompatibles();
			}
			else
				JOptionPane.showMessageDialog(null, "Debe cargar al menos un empleado de cada puesto", "Advertencia", JOptionPane.WARNING_MESSAGE);	
		}
		
		else if(actualEs(vPrincipal.panelCargarIncompatibles)) 
		{
			iniciarCargarRequerimientos();
		}
		
		else if(actualEs(vPrincipal.panelCargarRequerimientos))
		{
			if(ctrlCargarRequerimientos.confirmoCotas())
				modelo.resolver();
			else
				JOptionPane.showMessageDialog(null, "Es posible que no haya confimado las cotas o que haya habido cambios.", "Advertencia", JOptionPane.WARNING_MESSAGE);
		}
	}

	private void iniciarCargarIncompatibles() 
	{
		ctrlCargarIncompatibles = new CtrlCargarIncompatibles(modelo, vPrincipal.panelCargarIncompatibles);
		ctrlCargarIncompatibles.iniciar();

		vPrincipal.getContentPane().add(vPrincipal.panelCargarIncompatibles, BorderLayout.CENTER);
		vPrincipal.panelCargarEmpleado.setVisible(false);
	}
	
	private void iniciarCargarRequerimientos() 
	{
		vPrincipal.panelCargarRequerimientos = new CargarRequerimientos(vPrincipal.panelCargarEmpleado.tablaEmpleados, vPrincipal.panelCargarIncompatibles.tablaIncompatibles);
		
		ctrlCargarRequerimientos = new CtrlCargarRequerimientos(modelo, vPrincipal.panelCargarRequerimientos);
		ctrlCargarRequerimientos.iniciar();
		
		vPrincipal.getContentPane().add(vPrincipal.panelCargarRequerimientos, BorderLayout.CENTER);
		vPrincipal.panelCargarIncompatibles.setVisible(false);
		vPrincipal.btnCambiarPanel.setText("Buscar Solucion");
	}

	private boolean actualEs(JPanel panel)
	{
		if(panel.isVisible())
			return true;
		return false;
	}
}
