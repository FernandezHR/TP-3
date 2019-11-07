package modelo;

import java.util.ArrayList;

public class Instancia 
{
	private Grafo malasRelaciones;
	private ArrayList<Empleado> empleados;
	private Requerimiento requerimiento;
	
	public Instancia(ArrayList<Empleado> empleados, Grafo malasRelaciones, Requerimiento requerimiento) 
	{
		this.empleados = empleados; 
		this.malasRelaciones = malasRelaciones;
		this.requerimiento = requerimiento;
	}
	
	public boolean sonIncompatibles(int i, int j) 
	{
		return malasRelaciones.existeArista(i, j);
	}
	
	public int minLideres() 
	{
		return requerimiento.getMinLideres();
	}
	
	public int maxLideres() 
	{
		return requerimiento.getMaxLideres();
	}
	
	public int minArquitectos() 
	{
		return requerimiento.getMinArquitectos();
	}
	
	public int maxArquitectos() 
	{
		return requerimiento.getMaxArquitectos();
	}
	
	public int minProgramadores() 
	{
		return requerimiento.getMinProgramadores();
	}
	
	public int maxProgramadores() 
	{
		return requerimiento.getMaxProgramadores();
	}
	
	public int minTesters() 
	{
		return requerimiento.getMinTesters();
	}
	
	public int maxTesters() 
	{
		return requerimiento.getMaxTesters();
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