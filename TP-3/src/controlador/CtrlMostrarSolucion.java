package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import modelo.Modelo;
import vista.MostrarSolucion;
import vista.VentanaPrincipal;

public class CtrlMostrarSolucion implements ActionListener
{
	private MostrarSolucion mostrarSolucion;
	private Modelo modelo;
	
	public CtrlMostrarSolucion(Modelo modelo, MostrarSolucion mtrSolucion )
	{
		this.modelo = modelo;
		this.mostrarSolucion = mtrSolucion;
		
		this.mostrarSolucion.botonComenzar.addActionListener(this);
	}
	
	public void cargarEmpleadosFinales()
	{
		String matriz[][] = new String[modelo.getSolucion().size()][2];
		
		for(int i=0; i < modelo.getSolucion().size() ; i++) 
		{
			matriz[i][0] = modelo.getSolucion().get(i).getNombre();
			matriz[i][1] = modelo.getSolucion().get(i).getPuesto();
		}
		
		DefaultTableModel dtm = new DefaultTableModel(matriz, new String[] {"Nombre", "Puesto"});
		mostrarSolucion.tablaEquipo.setModel(dtm);
	
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		if(arg0.getSource() == mostrarSolucion.botonComenzar);
		{
			VentanaPrincipal  vPrincipal = new VentanaPrincipal();
			CtrlVentanaPrincipal ctrl = new CtrlVentanaPrincipal(new Modelo(),vPrincipal);
			ctrl.iniciar();
		}
	}
}
