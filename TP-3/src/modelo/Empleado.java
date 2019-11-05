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

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Empleado other = (Empleado) obj;
		
		if(nombre.equals(other.nombre))
			return true;

		return false;
	}
	
	

}
