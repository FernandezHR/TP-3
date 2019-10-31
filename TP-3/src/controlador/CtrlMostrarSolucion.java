package controlador;

import javax.swing.table.DefaultTableModel;
import modelo.Modelo;
import vista.MostrarSolucion;

public class CtrlMostrarSolucion
{
	private MostrarSolucion panelMostrarSolucion;
	private Modelo modelo;
	
	public CtrlMostrarSolucion(Modelo modelo, MostrarSolucion mtrSolucion )
	{
		this.modelo = modelo;
		this.panelMostrarSolucion = mtrSolucion;
	}
	
	public void iniciar() 
	{
		if(seEncontroSolucion()) 
			panelMostrarSolucion.lblMensajeResultado.setText("Equipo que cumple con los requisitos");
		else
			panelMostrarSolucion.lblMensajeResultado.setText("No fue posible formar un equipo con los requerimientos dados");
		
		cargarEmpleadosFinales();
	}
	
	private void cargarEmpleadosFinales()
	{
		String matriz[][] = new String[modelo.getSolucion().size()][2];
		
		for(int i=0; i < modelo.getSolucion().size() ; i++) 
		{
			matriz[i][0] = modelo.getSolucion().get(i).getNombre();
			matriz[i][1] = modelo.getSolucion().get(i).getPuesto();
		}
		
		DefaultTableModel dtm = new DefaultTableModel(matriz, new String[] {"Nombre", "Puesto"});
		panelMostrarSolucion.tablaEquipo.setModel(dtm);
	
	}
	
	private boolean seEncontroSolucion() 
	{
		return !modelo.getSolucion().isEmpty();
	}

}

