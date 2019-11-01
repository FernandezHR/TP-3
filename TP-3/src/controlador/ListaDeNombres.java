package controlador;


import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Stream;

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
		ArrayList<String> nombres = leerFichero("nombres.txt");
		ArrayList<String> apellidos = leerFichero("apellidos.txt");
		
		nombres.stream().forEach(n ->
			apellidos.stream().forEach(a -> 
				listaDeNombres.add(n + " " + a)));				
	}
	
	private ArrayList<String> leerFichero(String fichero) 
	{
		ArrayList<String> lineas = new ArrayList<String>();
		
		Path path = Paths.get("src/archivos/" + fichero);
		
		try (Stream <String> stream = Files.lines(path, Charset.forName("Cp1252"))) 
		{
			stream.filter(x -> !x.isEmpty()).forEach(x -> lineas.add(x));
		} 
		catch (IOException e1) 
		{	
			e1.printStackTrace();
		}
	
		return lineas;
	}
	

	public String dameUno() 
	{
		if(cantidad() == 0)
			throw new RuntimeErrorException(null, "La lista ya no puede dar mas nombres, esta vacia.");
			
		String nombre = listaDeNombres.get(new Random().nextInt(listaDeNombres.size()));
		
		listaDeNombres.remove(nombre);

		return nombre;
	}
	
	public void eliminar(String n)
	{
		listaDeNombres.remove(n);
	}
	
	public int cantidad()
	{
		return listaDeNombres.size();
	}
	
	
}
