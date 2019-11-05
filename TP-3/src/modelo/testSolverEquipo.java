package modelo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

public class testSolverEquipo
{

	@Test //Prueba que se devuelva al conjunto entero si todos son compatibles
	public void testTodosCompatibles()
	{
		Modelo modelo = new Modelo();
		
		cargarPocosEmpleados(modelo);
		
		modelo.setCondicionArquitecto(1, 3);
		modelo.setCondicionProgramador(1, 3);
		modelo.setCondicionTester(1, 3);
		
		ArrayList<Empleado> esperado = new ArrayList<Empleado>();

		esperado.add(new Empleado("Lider", "Lider de Proyecto"));
		esperado.add(new Empleado("Arq1", "Arquitecto"));
		esperado.add(new Empleado("Arq2", "Arquitecto"));
		esperado.add(new Empleado("Progr1", "Programador"));
		esperado.add(new Empleado("Tester1", "Tester"));
		
		modelo.resolver();
	
		Assert.iguales(esperado,  modelo.getSolucion());	
	}
	
	@Test 
	public void testTodosIncompatibles()
	{
		Modelo modelo = new Modelo();
		cargarEmpleados(modelo);
		
		enemistarEmpleados(modelo);
		
		modelo.resolver();
		
		assertFalse(modelo.existeSolucion());
	}
	
	@Test (expected = RuntimeException.class)
	public void testEquipoIncompleto() 
	{
		Modelo modelo = new Modelo();
		modelo.agregarEmpleado("Arq1", "Arquitecto");
		modelo.agregarEmpleado("Arq2", "Arquitecto");
		
		modelo.confirmarListaDeEmpleados();
	}
	
	@Test //Prueba que se devuelva un puesto por equipo
	public void testEquipoUnoCadaPuesto()
	{
		Modelo modelo = new Modelo();
		cargarEmpleados(modelo);
		
		modelo.setCondicionArquitecto(1, 1);
		modelo.setCondicionProgramador(1, 1);
		modelo.setCondicionTester(1, 1);
		
		modelo.resolver();
		
		assertTrue(modelo.getSolucion().size() == 4);
	}
	
	@Test //Prueba que en el equipo no este el mal relacionado
	public void testMalaRelacionConLider()
	{
		Modelo modelo  = new Modelo();
		cargarPocosEmpleados(modelo);
		
		modelo.agregarMalaRelacion("Lider", "Arq2");
		Empleado victima = new Empleado("Arq2","Arquitecto");
		
		modelo.resolver();
		
		assertFalse(modelo.getSolucion().contains(victima));
	}
	
	@Test //Prueba que se obtenga el equipo optimo con varias relaciones malas
	public void testVariasMalasRelaciones()
	{
		Modelo modelo = new Modelo();
		
		cargarEmpleados(modelo);
		
		modelo.agregarMalaRelacion("Arq1", "Prog1");
		modelo.agregarMalaRelacion("Prog2", "Lider1");
		modelo.agregarMalaRelacion("Tester1", "Arq2");
		modelo.agregarMalaRelacion("Lider1", "Prog3");
		modelo.agregarMalaRelacion("Tester3", "Prog1");
		
		modelo.setCondicionArquitecto(1, 3);
		modelo.setCondicionProgramador(1, 3);
		modelo.setCondicionTester(1, 3);
		
		ArrayList<Empleado> esperado = new ArrayList<Empleado>();
		
		esperado.add(new Empleado("Lider1","Lider de Proyecto"));
		esperado.add(new Empleado("Arq2","Arquitecto"));
		esperado.add(new Empleado("Arq3","Arquitecto"));
		esperado.add(new Empleado("Prog1","Programador"));
		esperado.add(new Empleado("Tester2","Tester"));
		
		modelo.resolver();
		
		Assert.iguales(esperado, modelo.getSolucion());
	}

	//Prueba que no exista optimo cuando se pide mas empleados de los cargados
	@Test 
	public void testMasDeLosDisponibles()
	{
		Modelo modelo = new Modelo();
		cargarPocosEmpleados(modelo);
		
		modelo.setCondicionArquitecto(3, 3);
		modelo.resolver();
		
		assertFalse(modelo.existeSolucion());
	}
	
	//Prueba que no exista equipo cuando no se cumplen los requisitos minimos
	@Test 
	public void testNoCumpleRequisitosMinimos()
	{
		Modelo modelo = new Modelo();
		cargarPocosEmpleados(modelo);
		
		modelo.agregarMalaRelacion("Lider", "Arq1");
		modelo.agregarMalaRelacion("Lider", "Arq2");
		modelo.setCondicionArquitecto(1, 2);
		modelo.resolver();
		
		assertFalse(modelo.existeSolucion());
	}

	//Metodos Auxiliares
	private void cargarPocosEmpleados(Modelo modelo) 
	{
		modelo.agregarEmpleado("Lider", "Lider de Proyecto");
		modelo.agregarEmpleado("Arq1", "Arquitecto");
		modelo.agregarEmpleado("Arq2", "Arquitecto");
		modelo.agregarEmpleado("Progr1", "Programador");
		modelo.agregarEmpleado("Tester1", "Tester");

		modelo.confirmarListaDeEmpleados();

	}
	

	private void cargarEmpleados(Modelo modelo) 
	{
		modelo.agregarEmpleado("Lider1", "Lider de Proyecto");
		
		modelo.agregarEmpleado("Arq1", "Arquitecto");
		modelo.agregarEmpleado("Arq2", "Arquitecto");
		modelo.agregarEmpleado("Arq3", "Arquitecto");
		
		modelo.agregarEmpleado("Prog1", "Programador");
		modelo.agregarEmpleado("Prog2", "Programador");
		modelo.agregarEmpleado("Prog3", "Programador");
		
		modelo.agregarEmpleado("Tester1", "Tester");
		modelo.agregarEmpleado("Tester2", "Tester");
		modelo.agregarEmpleado("Tester3", "Tester");
		
		modelo.confirmarListaDeEmpleados();
	}
	
	private void enemistarEmpleados(Modelo modelo) 
	{	
		for(Empleado empleado: modelo.getEmpleados())
			for(Empleado empleado2: modelo.getEmpleados())
				if(!empleado.equals(empleado2))
					modelo.agregarMalaRelacion(empleado.getNombre(), empleado2.getNombre());
	}
}
