package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

public class Modelo 
{
	private Grafo relaciones;
	private Grafo malasRelaciones;
	private List<Empleado> empleados;
	
	public Modelo() 
	{
		empleados = new ArrayList<Empleado>();
	}
	
	public void agregarEmpleado(String nombre, String puesto) 
	{
		if(existeEmpleado(nombre))
			throw new RuntimeErrorException(null, "El empleado '" + nombre + "' ya existe.");
		
		empleados.add(new Empleado(nombre, puesto));
	}
	
	public void iniMalasRelaciones() 
	{
		malasRelaciones = new Grafo(empleados.size());
	}
	
	public void agregarMalaRelacion(int e1, int e2)
	{
		malasRelaciones.agregarArista(e1,e2);
	}

	//Metodos Auxiliares
	private boolean existeEmpleado(String nombre) 
	{
		for(Empleado empleado : empleados)
			if(empleado.getNombre().equals(nombre))
				return true;
		
		return false;
	}
	
	public List<Empleado> getEmpleados() 
	{
		return empleados;
	}

	public boolean existeMalaRelacionEntre(int e1, int e2)
	{
		return malasRelaciones.existeArista(e1, e2);
	}
	
	public void resolver()
	{
		Solver solver = new Solver(malasRelaciones);
		
		System.out.println(solver.resolver());
	}
}
