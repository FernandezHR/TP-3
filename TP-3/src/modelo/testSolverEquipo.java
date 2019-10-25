//package modelo;
//
//
//import org.junit.Test;
//
//public class testSolverEquipo {
//
//	@Test //Prueba que se elijan los primeros empleados compatibles
//	public void testIncompatiblesEnlazados()
//	{
//		Grafo grafo = new Grafo(4);
//		grafo.agregarArista(0, 1);
//		grafo.agregarArista(1, 2);
//		grafo.agregarArista(2, 3);
//		
//		int [] equipo = {0,2};
//		Solver solver = new Solver(grafo);
//		
//		Assert.iguales(equipo, solver.resolver());
//	}
//	
//	@Test 
//	public void testUnIncompatible()
//	{
//		Grafo grafo = new Grafo(3);
//		grafo.agregarArista(0, 1);
//		
//		int [] equipo = {0,2};
//		Solver solver = new Solver(grafo);
//		
//		Assert.iguales(equipo, solver.resolver());
//	}
//
//	@Test
//	public void testMezclados()
//	{
//		Grafo grafo = new Grafo(5);
//		grafo.agregarArista(0, 1);
//		grafo.agregarArista(1, 4);
//		grafo.agregarArista(4, 2);
//		
//		int [] equipo = {0,2,3};
//		Solver solver = new Solver(grafo);
//		
//		Assert.iguales(equipo, solver.resolver());
//	}
//	
//	@Test //Prueba que se devuelva al primer empleado si ninguno es compatible
//	public void todosIncompatibles()
//	{
//		Grafo grafo = new Grafo(4);
//		grafo.agregarArista(0, 1);
//		grafo.agregarArista(0, 2);
//		grafo.agregarArista(0, 3);
//
//		grafo.agregarArista(1, 2);
//		grafo.agregarArista(1, 3);
//		
//		grafo.agregarArista(2, 3);
//
//		int [] equipo = {0};
//		Solver solver = new Solver(grafo);
//		
//		Assert.iguales(equipo, solver.resolver());
//
//	}
//}
