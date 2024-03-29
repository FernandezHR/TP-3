package modelo;

import java.util.ArrayList;
import java.util.stream.IntStream;

import javax.management.RuntimeErrorException;

public class Modelo 
{
	private ArrayList<Empleado> empleados;
	private Grafo malasRelaciones;
	private Requerimiento requerimiento;
	private ArrayList<Empleado> solucion;
	
	private Solver solver;

	public Modelo() 
	{
		empleados = new ArrayList<Empleado>();
		requerimiento = new Requerimiento();
	}
	
	public void agregarEmpleado(String nombre, String puesto) 
	{
		verificarAgregado(nombre, puesto);
		
		empleados.add(new Empleado(nombre, puesto));
	}

	public void eliminarEmpleado(String nombre) 
	{
		verificarEliminacion(nombre);
		
		empleados.removeIf(e -> e.getNombre().equals(nombre));
	}
	
	public void confirmarListaDeEmpleados() 
	{	
		verificarLista();
		
		malasRelaciones = new Grafo(cantEmpleados());
	}

	public void agregarMalaRelacion(String nombreE1, String nombreE2)
	{
		verificarRelacion(nombreE1, nombreE2);
		
		malasRelaciones.agregarArista(getIndice(nombreE1), getIndice(nombreE2));
	}
	
	public void eliminarMalaRelacion(String nombreE1, String nombreE2)
	{
		verificarRelacion(nombreE1, nombreE2);
		
		malasRelaciones.borrarArista(getIndice(nombreE1), getIndice(nombreE2));
	}

	public void setCondicionArquitecto(int min, int max) 
	{
		verificarCondicion(min, max);
		
		requerimiento.setMinArquitectos(min); 
		requerimiento.setMaxArquitectos(max);
	}

	public void setCondicionProgramador(int min, int max) 
	{
		verificarCondicion(min, max);
		
		requerimiento.setMinProgramadores(min);
		requerimiento.setMaxProgramadores(max);
	}
	
	public void setCondicionTester(int min, int max) 
	{
		verificarCondicion(min, max);
		
		requerimiento.setMinTesters(min);
		requerimiento.setMaxTesters(max);
	}
	
	public void resolver()
	{	
		solver = new Solver(new Instancia(empleados, malasRelaciones, requerimiento));
		
		solucion = solver.resolver();
	}
	
	private void verificarAgregado(String nombre, String puesto) 
	{
		if(listaFueConfirmada())
			throw new RuntimeErrorException(null, "No se puede agregar empleados una vez confirmada la lista.");
		
		if(existeEmpleado(nombre))
			throw new RuntimeErrorException(null, "El empleado '" + nombre + "' ya fue agregado.");
		
		if(!esValido(puesto))
			throw new RuntimeErrorException(null, "El puesto '" + puesto + "' no es valido.");
	}
	
	private void verificarEliminacion(String nombre) 
	{
		if(listaFueConfirmada())
			throw new RuntimeErrorException(null, "No se puede eliminar empleados una vez confirmada la lista.");
		
		if(!existeEmpleado(nombre))
			throw new RuntimeErrorException(null, "El empleado '" + nombre + "' nunca fue agregado.");
	}
	
	private void verificarLista() 
	{
		if(!listaEstaCompleta())
			throw new RuntimeErrorException(null, "La lista debe contener 1 empleado de cada puesto");
	}
	
	private void verificarRelacion(String nombreE1, String nombreE2) 
	{
		if(!listaFueConfirmada())
			throw new RuntimeErrorException(null, "No puede agregar, no confirmo la lista de empleados.");
		
		if(!existeEmpleado(nombreE1) || !existeEmpleado(nombreE2))
			throw new RuntimeErrorException(null, "No se puede agregar, uno o ambos no existen.");
	}

	private void verificarCondicion(int min, int max) 
	{
		if(min <= 0 || max <= 0)
			throw new IllegalArgumentException("No puede agregar un minimo o maximo menor/igual a cero");
		
		if(min > max)
			throw new IllegalArgumentException("El minimo no puede ser mayor al maximo");
	}
	
	//Metodos Auxiliares
	public boolean existeEmpleado(String nombre) 
	{
		return empleados.contains(new Empleado(nombre, "Tester"));
	}

	public boolean existeMalaRelacionEntre(String nombreE1, String nombreE2)
	{
		verificarRelacion(nombreE1, nombreE2);
		
		return malasRelaciones.existeArista(getIndice(nombreE1), getIndice(nombreE2));
	}
	
	private boolean listaEstaCompleta() 
	{
		long lideres = empleados.stream().filter(e -> e.getPuesto().equals("Lider de Proyecto")).count();
		long arquitectos = empleados.stream().filter(e -> e.getPuesto().equals("Arquitecto")).count();
		long programadores = empleados.stream().filter(e -> e.getPuesto().equals("Programador")).count();
		long testers = empleados.stream().filter(e -> e.getPuesto().equals("Tester")).count();
		
		if(lideres > 0 && arquitectos > 0 && programadores > 0 && testers > 0)
			return true;
		return false;
	}
	
	private boolean listaFueConfirmada() 
	{
		if(malasRelaciones == null)
			return false;
		return true;
	}
	
	private boolean esValido(String puesto) 
	{
		if(puesto.equals("Programador") || puesto.equals("Lider de Proyecto") || puesto.equals("Arquitecto") || puesto.equals("Tester"))
			return true;
		return false;
	}
	
	public boolean existeSolucion()
	{
		return !solucion.isEmpty();
	}
	
	private int getIndice(String nombre) 
	{
		 return IntStream
				.range(0, cantEmpleados())
				.filter(i -> empleados.get(i).getNombre().equals(nombre))
				.findFirst()
				.getAsInt();
	}
	
	public int cantEmpleados() 
	{
		return empleados.size();
	}
	
	public ArrayList<Empleado> getSolucion() 
	{
		if(solucion == null)
			throw new RuntimeErrorException(null, "Llame primero a la funcion resolver()");
		
		return solucion;
	}
	
	public String getEstadisticas()
	{
		return "Tiempo total de ejecución: " + solver.getTiempoTotal() + " seg"+ "\n"
				+ "Cantidad de ejecuciones del caso base: " + solver.getCantIteraciones();
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Empleado> getEmpleados() 
	{
		return (ArrayList<Empleado>) empleados.clone();
	}
	
	public Grafo getMalasRelaciones()
	{
		return malasRelaciones;
	}
}
