package modelo;


public class Modelo 
{
	Grafo relaciones;
	
	public Modelo() 
	{
	}
	
	public void inicializar(int cantidad)
	{
		relaciones = new Grafo(cantidad);
	}
	
	public void agregarConflictoEntre(int e1, int e2)
	{
		relaciones.agregarArista(e1,e2);
	}
	
	public boolean existeMalaRelacion(int e1, int e2)
	{		
		return relaciones.existeArista(e1, e2);
	}

	
	
	
	
}
