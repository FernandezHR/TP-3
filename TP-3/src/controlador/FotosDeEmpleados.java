package controlador;

import java.util.HashMap;

import javax.swing.ImageIcon;

public class FotosDeEmpleados 
{
	private static HashMap<String, ImageIcon> fotosDeEmpleados = new HashMap<String, ImageIcon>();
	
	public static void agregarFoto(String nombre, ImageIcon foto) 
	{
		fotosDeEmpleados.put(nombre, foto);
	}
	
	public static void eliminar(String nombre) 
	{
		fotosDeEmpleados.remove(nombre);
	}
	
	public static ImageIcon getFoto(String nombre)
	{
		return fotosDeEmpleados.get(nombre);
	}
}
