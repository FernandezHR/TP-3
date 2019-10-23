package modelo;

import java.util.ArrayList;
import javax.management.RuntimeErrorException;

public class Modelo 
{
//	private Grafo relaciones;
	private Grafo malasRelaciones;
	private ArrayList<Empleado> empleados;
	
	public Modelo() 
	{
		empleados = new ArrayList<Empleado>();
	}
	
	public void agregarEmpleado(String nombre, String puesto) 
	{
		if(existeEmpleado(nombre))
			throw new RuntimeErrorException(null, "El empleado '" + nombre + "' ya fue agregado.");
		
		empleados.add(new Empleado(nombre, puesto));
	}
	
	public void eliminarEmpleado(String nombre) 
	{
		if(!existeEmpleado(nombre))
			throw new RuntimeErrorException(null, "El empleado '" + nombre + "' nunca fue agregado.");
		
		for(Empleado empleado : empleados)
		{
			if(empleado.getNombre().equals(nombre))
			{
				empleados.remove(empleado);
				break;
			}
		}
	}
	
	public void iniMalasRelaciones() 
	{
		malasRelaciones = new Grafo(empleados.size());
	}
	
	public void agregarMalaRelacion(String nombreE1, String nombreE2)
	{
		int e1 = 0;
		int e2 = 0;
		for(int i=0; i < empleados.size(); i++) 
		{
			if(empleados.get(i).getNombre().equals(nombreE1))
				e1 = i;
			
			if(empleados.get(i).getNombre().equals(nombreE2))
				e2 = i;
		}
		
		malasRelaciones.agregarArista(e1,e2);
	}

	//Metodos Auxiliares
	public boolean existeEmpleado(String nombre) 
	{
		for(Empleado empleado : empleados)
			if(empleado.getNombre().equals(nombre))
				return true;
		
		return false;
	}

	public boolean existeMalaRelacionEntre(String nombreE1, String nombreE2)
	{
		int e1 = 0;
		int e2 = 0;
		for(int i=0; i < empleados.size(); i++) 
		{
			if(empleados.get(i).getNombre().equals(nombreE1))
				e1 = i;
			
			if(empleados.get(i).getNombre().equals(nombreE2))
				e2 = i;
		}
		
		return malasRelaciones.existeArista(e1, e2);
	}
	
	public void resolver()
	{
		Solver solver = new Solver(malasRelaciones);
		
		System.out.println(solver.resolver());
	}
	
	//GETTERS
	@SuppressWarnings("unchecked")
	public ArrayList<Empleado> getEmpleados() 
	{
		return (ArrayList<Empleado>) empleados.clone();
	}
	
}
