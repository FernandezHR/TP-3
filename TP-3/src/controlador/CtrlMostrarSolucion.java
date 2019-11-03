package controlador;

import java.util.ArrayList;
import modelo.Empleado;
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
			panelMostrarSolucion.setMensaje("Equipo que cumple con los requisitos");
		else
			panelMostrarSolucion.setMensaje("No fue posible formar un equipo con los requerimientos dados");
		
		cargarEquipoElegido();
	}
	
	private void cargarEquipoElegido() 
	{
		panelMostrarSolucion.limpiarFotos();
		
		ArrayList<Empleado> solucion = modelo.getSolucion();
		
		solucion.stream()
		.filter(e -> e.getPuesto().equals("Lider de Proyecto"))
		.forEach(e -> panelMostrarSolucion.agregarLider(e.getNombre(), FotosDeEmpleados.getFoto(e.getNombre())));
		
		solucion.stream()
		.filter(e -> e.getPuesto().equals("Arquitecto"))
		.forEach(e -> panelMostrarSolucion.agregarArquitecto(e.getNombre(), FotosDeEmpleados.getFoto(e.getNombre())));
		
		solucion.stream()
		.filter(e -> e.getPuesto().equals("Programador"))
		.forEach(e -> panelMostrarSolucion.agregarProgramador(e.getNombre(), FotosDeEmpleados.getFoto(e.getNombre())));
		
		solucion.stream()
		.filter(e -> e.getPuesto().equals("Tester"))
		.forEach(e -> panelMostrarSolucion.agregarTester(e.getNombre(), FotosDeEmpleados.getFoto(e.getNombre())));
		
		panelMostrarSolucion.validate();
	}
	
	private boolean seEncontroSolucion() 
	{
		return !modelo.getSolucion().isEmpty();
	}
}

