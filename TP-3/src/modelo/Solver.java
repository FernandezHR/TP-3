package modelo;

import java.util.HashSet;
import java.util.Set;

import com.sun.xml.internal.txw2.IllegalAnnotationException;

public class Solver 
{
	private Grafo grafo;
	private Set<Integer> conjuntoActual, equipoActual;

	
	public Solver(Grafo g)
	{
		grafo = g;
	}
	
	
	public Set<Integer> resolver()
	{
		conjuntoActual = new HashSet<Integer>();
		equipoActual = new HashSet<Integer>();

		recursion(0);
		
		return equipoActual;
	}
	
	private void recursion(int inicial)
	{
		//Caso base
		if( inicial == grafo.tamano())
		{
			if( conjuntoActualEsEquipo() && conjuntoActual.size() > equipoActual.size())
				equipoActual = clonarConjuntoActual();
			
			return;
		}
		
		// Caso recursivo
		conjuntoActual.add(inicial);
		recursion(inicial+1);
				
		conjuntoActual.remove(inicial);
		recursion(inicial+1);
	}

	private Set<Integer> clonarConjuntoActual()
	{
		Set<Integer> ret = new HashSet<Integer>();
		for(Integer i: conjuntoActual)
			ret.add(i);
		
		return ret;
	}
	

	private boolean conjuntoActualEsEquipo() 
	{		
		for (Integer i : conjuntoActual) 
			for (Integer j : conjuntoActual) 
				if ( i != j && grafo.existeArista(i, j))
					return false;
			
		return true;
		
	}

}