package controlador;

import javax.swing.table.DefaultTableModel;

import modelo.Modelo;
import vista.MostrarSolucion;

public class CtrlMostrarSolucion 
{
	private MostrarSolucion mostrarSolucion;
	private Modelo modelo;
	
	public CtrlMostrarSolucion(Modelo modelo, MostrarSolucion mtrSolucion )
	{
		this.modelo = modelo;
		this.mostrarSolucion = mtrSolucion;
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
}
