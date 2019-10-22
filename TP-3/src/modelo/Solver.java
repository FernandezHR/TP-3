package modelo;

import java.util.HashSet;
import java.util.Set;

import com.sun.xml.internal.txw2.IllegalAnnotationException;

public class Solver 
{
	private Grafo grafo;
	private Set<Integer> conjuntoActual;

	
	public Solver(Grafo g)
	{
		grafo = g;
	}
	
	
	public Set<Integer> resolver()
	{
		conjuntoActual = new HashSet<Integer>();
		
		throw new IllegalAnnotationException("Aun no implementado");
	}

}