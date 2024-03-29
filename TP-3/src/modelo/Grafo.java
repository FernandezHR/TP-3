package modelo;

import java.util.HashSet;
import java.util.Set;

public class Grafo
{
	// Representamos el grafo por su matriz de adyacencia
	private boolean[][] A;
	
	// El conjunto de v�rtices est� fijo
	public Grafo(int vertices)
	{
		A = new boolean[vertices][vertices];
	}
	
	// Operaciones sobre aristas
	public void agregarArista(int i, int j)
	{
		verificarIndices(i, j);
		A[i][j] = A[j][i] = true;
	}
	public void borrarArista(int i, int j)
	{
		verificarIndices(i, j);
		A[i][j] = A[j][i] = false;
	}
	public boolean existeArista(int i, int j)
	{
		verificarIndices(i, j);
		return A[i][j];
	}

	// Vecinos de un vertice
	public Set<Integer> vecinos(int i)
	{
		verificarVertice(i);
		
		Set<Integer> ret = new HashSet<Integer>();
		for(int j=0; j<tamanio(); ++j) if( i!=j && existeArista(i,j) )
			ret.add(j);
		
		return ret;
	}

	// Cantidad de vertices
	public int tamanio()
	{
		return A.length;
	}

	// Lanza excepciones si los �ndices no son v�lidos
	private void verificarIndices(int i, int j)
	{
		verificarVertice(i);
		verificarVertice(j);
		
		if( i == j )
			throw new IllegalArgumentException("No existen aristas entre un vertice y si mismo! vertice = " + i);
	}
	private void verificarVertice(int i)
	{
		if( i < 0 || i >= tamanio() )
			throw new IllegalArgumentException("El vertice " + i + " no existe!");
	}

}
