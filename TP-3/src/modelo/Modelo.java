package modelo;

import java.util.ArrayList;

import javax.management.RuntimeErrorException;

public class Modelo 
{
	private Grafo malasRelaciones;
	private ArrayList<Empleado> empleados;
	
	private int minArquitecto, maxArquitecto;
	private int minProgramador, maxProgramador;
	private int minTester, maxTester;
	
	public Modelo() 
	{
		empleados = new ArrayList<Empleado>();
		
		minArquitecto = minProgramador = minTester = 1;
		maxArquitecto = maxProgramador = maxTester = 1;
	}
	
	public void agregarEmpleado(String nombre, String puesto) 
	{
		verificarAgregacion(nombre, puesto);
		
		empleados.add(new Empleado(nombre, puesto));
	}

	public void eliminarEmpleado(String nombre) 
	{
		verificarEliminacion(nombre);
		
		for(Empleado empleado : empleados)
		{
			if(empleado.getNombre().equals(nombre))
			{
				empleados.remove(empleado);
				break;
			}
		}
	}
	
	public void confirmarListaDeEmpleados() 
	{
		malasRelaciones = new Grafo(empleados.size());
	}
	
	public void agregarMalaRelacion(String nombreE1, String nombreE2)
	{
		if(!listaFueConfirmada())
			throw new RuntimeErrorException(null, "No puede agregar, no confirmo la lista de empleados.");
		
		if(!existeEmpleado(nombreE1) || !existeEmpleado(nombreE2))
			throw new RuntimeErrorException(null, "No se puede agregar, uno o ambos no existen.");
		
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

	public void setCondicionArquitecto(int min, int max) 
	{
		verificarCondicion(min, max);
		
		minArquitecto = min;
		maxArquitecto = max;
	}

	public void setCondicionProgramador(int min, int max) 
	{
		verificarCondicion(min, max);
		
		minProgramador = min;
		maxProgramador = max;
	}
	
	public void setCondicionTester(int min, int max) 
	{
		verificarCondicion(min, max);
		
		minTester = min;
		maxTester = max;
	}
	
	public void resolver()
	{	
		Solver solver = new Solver(armarInstancia());
		
		ArrayList<Empleado> respuesta = solver.resolver();
		
		if(respuesta.size() == 0)
		{
			System.out.println("No se encontro ningun conjunto que cumpla esas condiciones");
		}
		else
		{
			for(Empleado empleado : respuesta) 
			{
				System.out.println(empleado.getNombre() + ", " + empleado.getPuesto());
			}
		}
	}
	
	private void verificarAgregacion(String nombre, String puesto) 
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
	
	private void verificarCondicion(int min, int max) 
	{
		if(min <= 0 || max <= 0)
			throw new RuntimeErrorException(null, "No puede agregar un minimo o maximo menor/igual a cero");
		
		if(min > max)
			throw new RuntimeErrorException(null, "El minimo no puede ser mayor al maximo");
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
		if(!listaFueConfirmada())
			throw new RuntimeErrorException(null, "No confirmo la lista de empleados.");
	
		if(!existeEmpleado(nombreE1) || !existeEmpleado(nombreE2))
			throw new RuntimeErrorException(null, "Uno o ambos empleados no existe.");
		
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
	
	private boolean listaFueConfirmada() 
	{
		if(malasRelaciones == null)
			return false;
		return true;
	}
	
	private Instancia armarInstancia() 
	{
		System.out.println(minArquitecto + " " + maxArquitecto);
		System.out.println(minProgramador + " " + maxProgramador);
		System.out.println(minProgramador + " " + maxTester);
		
		Instancia instancia = new Instancia(empleados, malasRelaciones);
		instancia.setCantidadArquitecto(minArquitecto, maxArquitecto);
		instancia.setCantidadProgramador(minProgramador, maxProgramador);
		instancia.setCantidadTester(minTester, maxTester);
		
		return instancia;
	}

	private boolean esValido(String puesto) 
	{
		if(puesto.equals("Programador") || puesto.equals("Lider de Proyecto") || puesto.equals("Arquitecto") || puesto.equals("Tester"))
			return true;
		return false;
	}
	
	//GETTERS
	@SuppressWarnings("unchecked")
	public ArrayList<Empleado> getEmpleados() 
	{
		return (ArrayList<Empleado>) empleados.clone();
	}
	
	
	public static void main(String[] args) 
	{
		Modelo modelo = new Modelo();
		
		modelo.agregarEmpleado("Lider1", "Lider de Proyecto");
		
		modelo.agregarEmpleado("Arq1", "Arquitecto");
		modelo.agregarEmpleado("Arq2", "Arquitecto");
		modelo.agregarEmpleado("Arg3", "Arquitecto");
		
		modelo.agregarEmpleado("Prog1", "Programador");
		modelo.agregarEmpleado("Prog2", "Programador");
		modelo.agregarEmpleado("Prog3", "Programador");
		
		modelo.agregarEmpleado("Tester1", "Tester");
		modelo.agregarEmpleado("Tester2", "Tester");
		modelo.agregarEmpleado("Tester3", "Tester");
		
		modelo.confirmarListaDeEmpleados();
		
		modelo.setCondicionArquitecto(1, 3);
		modelo.setCondicionProgramador(1, 3);
		modelo.setCondicionTester(1, 3);
		
		modelo.resolver();	
	}
}
