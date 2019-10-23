package controlador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.management.RuntimeErrorException;

public class ListaDeNombres 
{
	private ArrayList<String> listaDeNombres;
	
	public ListaDeNombres() 
	{
		listaDeNombres = new ArrayList<String>();
		
		generarNombres();
	}
	
	private void generarNombres()
	{
		ArrayList<String> nombres = cargarNombres();
		ArrayList<String> apellidos = cargarApellidos();
		
		for(String nombre : nombres) 
			for(String apellido : apellidos)
				listaDeNombres.add(nombre + " " + apellido);
				
	}

	private ArrayList<String> cargarNombres()  
	{
		ArrayList<String> nombres = new ArrayList<String>();
		
		try 
		{
			BufferedReader br = new BufferedReader(new FileReader("./src/archivos/nombres.txt"));
			
			String linea;
			while(!(linea = br.readLine()).equals(""))
				nombres.add(linea);
			
			br.close();
			
		} 
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		
		return nombres;
	}
	
	private ArrayList<String> cargarApellidos() 
	{
		ArrayList<String> apellidos = new ArrayList<String>();
		
		try 
		{
			BufferedReader br = new BufferedReader(new FileReader("./src/archivos/apellidos.txt"));
			
			String linea;
			while(!(linea = br.readLine()).equals(""))
				apellidos.add(linea);
			
			br.close();
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		return apellidos;
	}

	public String dameUno() 
	{
		if(cantidad() == 0)
			throw new RuntimeErrorException(null, "La lista ya no puede dar mas nombres, esta vacia.");
		
		int i = new Random().nextInt(listaDeNombres.size());
		
		String nombre = listaDeNombres.get(i);
		
		listaDeNombres.remove(i);

		return nombre;
	}
	
	public void eliminar(String n)
	{
		for(String nombre : listaDeNombres)
		{
			if(nombre.equals(n)) 
			{
				listaDeNombres.remove(nombre);
				break;
			}
		}
	}
	
	public int cantidad()
	{
		return listaDeNombres.size();
	}
	
	
}
