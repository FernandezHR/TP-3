package modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

public class Assert
{
	public static void iguales(ArrayList<Empleado> expected, ArrayList<Empleado> obtained)
	{
		assertEquals(expected.size(), obtained.size());
		
		for(Empleado empleado: expected)
			assertTrue( obtained.contains(empleado) );
	}
}
