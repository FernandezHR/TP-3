package controlador;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Modelo;
import vista.VentanaPrincipal;

public class CtrlVentanaPrincipal implements ActionListener
{
	private Modelo modelo;
	private VentanaPrincipal vPrincipal;
	
	public CtrlVentanaPrincipal(Modelo modelo, VentanaPrincipal vPrincipal) 
	{
		this.modelo = modelo;
		this.vPrincipal = vPrincipal;

		this.vPrincipal.btnSiguinte.addActionListener(this);
	}
	
	public void iniciar() 
	{
		CtrlCargarEmpleados ctrlCargarEmpleados = new CtrlCargarEmpleados(modelo, vPrincipal.panelCargarEmpleado);
		ctrlCargarEmpleados.iniciar();
		
		vPrincipal.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		if(arg0.getSource() == vPrincipal.btnSiguinte) 
			cambiarDePanel();
	}

	private void cambiarDePanel() 
	{
//		if(empleados.size() <= 1)
//			JOptionPane.showMessageDialog(null, "Debe cargar mas empleados", "Advertencia", JOptionPane.WARNING_MESSAGE);

		modelo.iniMalasRelaciones();
		
		CtrlCargarIncompatibles ctrlCargarIncompatibles = new CtrlCargarIncompatibles(modelo, vPrincipal.panelCargarIncompatibles);
		ctrlCargarIncompatibles.iniciar();
		
		vPrincipal.getContentPane().add(vPrincipal.panelCargarIncompatibles, BorderLayout.CENTER);
		vPrincipal.panelCargarEmpleado.setVisible(false);

	}

}
