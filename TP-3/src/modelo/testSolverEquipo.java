package modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class testSolverEquipo {

	@Test
	public void testIncompatiblesEnlazados()
	{
		Grafo grafo = new Grafo(4);
		grafo.agregarArista(0, 1);
		grafo.agregarArista(1, 2);
		grafo.agregarArista(2, 3);
		
		Solver solver = new Solver(grafo);
		
		assertTrue(solver.resolver().size() == 2); //Es decir si el conjunto devuelto es [0,2]
	}
	
	@Test
	public void testUnIncompatible()
	{
		Grafo grafo = new Grafo(3);
		grafo.agregarArista(0, 1);
		
		Solver solver = new Solver(grafo);
		
		assertTrue(solver.resolver().size() == 2); //Es decir si el conjunto devuelto es [0,2]
	}

	@Test
	public void testMezclados()
	{
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(0, 1);
		grafo.agregarArista(1, 4);
		grafo.agregarArista(4, 2);
		
		Solver solver = new Solver(grafo);
		
		assertTrue(solver.resolver().size() == 3); //Es decir si el conjunto devuelto es [0,2,3]
	}
	
	@Test
	public void todosIncompatibles()
	{
		Grafo grafo = new Grafo(4);
		grafo.agregarArista(0, 1);
		grafo.agregarArista(0, 2);
		grafo.agregarArista(0, 3);

		grafo.agregarArista(1, 2);
		grafo.agregarArista(1, 3);
		
		grafo.agregarArista(2, 3);

		Solver solver = new Solver(grafo);
		
		assertTrue(solver.resolver().size() == 1); //Es decir si el conjunto devuelto es [0]

	}
}
