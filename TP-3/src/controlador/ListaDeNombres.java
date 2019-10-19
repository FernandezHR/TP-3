package controlador;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import javax.management.RuntimeErrorException;

public class ListaDeNombres 
{
	private ArrayList<String> nombres;
	
	public ListaDeNombres() 
	{
		nombres = generarNombres();
	}
	
	private ArrayList<String> generarNombres()
	{
		ArrayList<String> nombres = cargarNombres();
		ArrayList<String> apellidos = cargarApellidos();
		
		ArrayList<String> nombresCompletos = new ArrayList<String>();
		
		for(String nombre : nombres) 
			for(String apellido : apellidos)
				nombresCompletos.add(nombre + " " + apellido);
			
		return nombresCompletos;	
	}

	private ArrayList<String> cargarNombres() 
	{
		ArrayList<String> nombres = new ArrayList<String>();
		
		//FALTA IMPLEMENTAR
		
		return nombres;
	}
	
	private ArrayList<String> cargarApellidos() 
	{
		ArrayList<String> apellidos = new ArrayList<String>();

		//FALTA IMPLEMENTAR
		
		return apellidos;
	}

	public String dameUno() 
	{
		if(cantidad() == 0)
			throw new RuntimeErrorException(null, "La lista ya no puede dar mas nombres, esta vacia.");
		
		Random r = new Random();
		int i = r.nextInt(nombres.size());
		
		String nombre = nombres.get(i);
		
		nombres.remove(i);

		return nombre;
	}
	
	public void eliminarSiExiste(String n)
	{
		for(String nombre : nombres)
		{
			if(nombre.equals(n)) 
			{
				nombres.remove(nombre);
				break;
			}
		}
	}
	
	public int cantidad()
	{
		return nombres.size();
	}
	
	
}
