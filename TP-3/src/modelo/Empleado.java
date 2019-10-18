package modelo;

public class Empleado 
{
	private String nombre;
	private String puesto;
	
	public Empleado(String nombre, String puesto) 
	{
		this.nombre = nombre;
		this.puesto = puesto;
	}
	
	public String getNombre() 
	{
		return nombre;
	}
	
	public String getPuesto() 
	{
		return puesto;
	}

}
