package modelo;

public class Requerimiento 
{
	private int minLideres, maxLideres;
	private int minArquitectos, maxArquitectos;
	private int minProgramadores, maxProgramadores;
	private int minTesters, maxTesters;
	
	public Requerimiento() 
	{
		minLideres = maxLideres = 1;
		
		minArquitectos = minProgramadores = minTesters = 1;
		maxArquitectos = maxProgramadores = maxTesters = 1;
	}
	
	public void setMinLideres(int min) 
	{
		minLideres = min;
	}
	
	public void setMaxLideres(int max) 
	{
		maxLideres = max;
	}
	
	public void setMinArquitectos(int min) 
	{
		minArquitectos = min;	
	}

	public void setMaxArquitectos(int max) 
	{
		maxArquitectos = max;	
	}
	
	public void setMinProgramadores(int min) 
	{
		minProgramadores = min;	
	}

	public void setMaxProgramadores(int max) 
	{
		maxProgramadores = max;	
	}
	
	public void setMinTesters(int min) 
	{
		minTesters = min;	
	}

	public void setMaxTesters(int max) 
	{
		maxTesters = max;	
	}

	public int getMinLideres() 
	{
		return minLideres;
	}
	
	public int getMaxLideres() 
	{
		return maxLideres;
	}
	
	public int getMinArquitectos() 
	{
		return minArquitectos;
	}

	public int getMaxArquitectos() 
	{	
		return maxArquitectos;
	}

	public int getMinProgramadores() 
	{
		return minProgramadores;
	}

	public int getMaxProgramadores() 
	{
		return maxProgramadores;
	}

	public int getMinTesters() 
	{
		return minTesters;
	}

	public int getMaxTesters() 
	{
		return maxTesters;
	}
}
