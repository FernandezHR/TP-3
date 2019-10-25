package modelo;

import java.util.ArrayList;

public class Instancia 
{
	private Grafo malasRelaciones;
	private ArrayList<Empleado> empleados;
	
	private int minLider, maxLider;
	private int minArquitecto, maxArquitecto;
	private int minProgramador, maxProgramador;
	private int minTester, maxTester;
	
	public Instancia(ArrayList<Empleado> empleados, Grafo malasRelaciones) 
	{
		this.empleados = empleados; 
		this.malasRelaciones = malasRelaciones;
		
		minLider = minArquitecto = minProgramador = minTester = 1;
		maxLider = maxArquitecto = maxProgramador = maxTester = 1;
	}
	
	public void setCantidadArquitecto(int min, int max) 
	{
		minArquitecto = min;
		maxArquitecto = max;
	}
	
	public void setCantidadProgramador(int min, int max) 
	{
		minProgramador = min;
		maxProgramador = max;
	}
	
	public void setCantidadTester(int min, int max) 
	{
		minTester = min;
		maxTester = max;
	}
	
	public boolean sonIncompatibles(int i, int j) 
	{
		return malasRelaciones.existeArista(i, j);
	}
	
	public int maxLider() 
	{
		return maxLider;
	}
	
	public int maxArquitecto() 
	{
		return maxArquitecto;
	}
	
	public int maxProgramador() 
	{
		return maxProgramador;
	}
	
	public int maxTester() 
	{
		return maxTester;
	}
	
	public int minLider() 
	{
		return minLider;
	}
	
	public int minArquitecto() 
	{
		return minArquitecto;
	}
	
	public int minProgramador() 
	{
		return minProgramador;
	}
	
	public int minTester() 
	{
		return minTester;
	}
	
	public ArrayList<Empleado> getEmpleados()
	{
		return empleados;
	}
	
	public int getTamanio() 
	{
		return empleados.size();
	}
	
	
}
