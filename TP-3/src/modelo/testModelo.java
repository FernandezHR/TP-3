package modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class testModelo 
{
	//Test sobre agregarEmpleado()//
	@Test 
	public void empleadoInexistenteTest()
	{
		Modelo modelo = new Modelo();
		assertFalse(modelo.existeEmpleado("Fernando"));
	}
	
	@Test
	public void agregarTest()
	{
		Modelo modelo = new Modelo();
		modelo.agregarEmpleado("Luciano", "Arquitecto");

		assertTrue(modelo.existeEmpleado("Luciano"));
	}
	
	@Test
	public void agregarVariosTest()
	{
		Modelo modelo = new Modelo();
		modelo.agregarEmpleado("Andres", "Tester");
		modelo.agregarEmpleado("Rodrigo", "Lider de Proyecto");
		
		assertEquals(modelo.getEmpleados().size(), 2);
	}
	
	@Test (expected = RuntimeException.class)
	public void agregarRepetido()
	{
		Modelo modelo = new Modelo();
		modelo.agregarEmpleado("Ignacio", "Tester");
		modelo.agregarEmpleado("Ignacio", "Tester");
	}
	
	@Test (expected = RuntimeException.class)
	public void agregarConListaConfirmada()
	{
		Modelo modelo = new Modelo();
		modelo.confirmarListaDeEmpleados();
		
		modelo.agregarEmpleado("Luciano", "Arquitecto");
	}
	
	@Test (expected = RuntimeException.class)
	public void AgregarPuestoInvalidoTest()
	{
		Modelo modelo = new Modelo();
		modelo.agregarEmpleado("Marcos", "Jardinero");
	}

	//Test sobre eliminarEmpleado()//
	@Test (expected = RuntimeException.class)
	public void eliminarExistenteTest()
	{
		Modelo modelo = new Modelo();
		modelo.eliminarEmpleado("Luis");
	}
	
	@Test (expected = RuntimeException.class)
	public void eliminarConListaConfirmadaTest()
	{
		Modelo modelo = new Modelo();
		modelo.agregarEmpleado("Luis", "Tester");
		modelo.confirmarListaDeEmpleados();
		
		modelo.eliminarEmpleado("Luis");
	}
	
	@Test
	public void verificarEmpleadoEliminadoTest()
	{
		Modelo modelo = new Modelo();
		modelo.agregarEmpleado("Luis", "Programador");
		
		assertTrue(modelo.existeEmpleado("Luis"));
		
		modelo.eliminarEmpleado("Luis");
		assertFalse(modelo.existeEmpleado("Luis"));
	}
	
	//Test sobre agregarMalaRelacion()//
	@Test (expected = RuntimeException.class)
	public void relacionConDosInexistentesTest()
	{
		Modelo modelo = new Modelo();
		modelo.confirmarListaDeEmpleados();
		modelo.agregarMalaRelacion("Luis", "Fernando");
	}
	
	@Test (expected = RuntimeException.class)
	public void relacionConUnInexistenteTest()
	{
		Modelo modelo = new Modelo();
		modelo.agregarEmpleado("Luis", "Tester");
		modelo.confirmarListaDeEmpleados();
		
		modelo.agregarMalaRelacion("Luis", "Fernando");
	}
	
	@Test (expected = RuntimeException.class)
	public void relacionSinListaConfirmadaTest()
	{
		Modelo modelo = new Modelo();
		modelo.agregarMalaRelacion("Luis", "Fernando");
	}

	@Test
	public void agregarMalaRelacionTest()
	{
		Modelo modelo = new Modelo();
		modelo.agregarEmpleado("Jose", "Tester");
		modelo.agregarEmpleado("Martin", "Arquitecto");
		modelo.confirmarListaDeEmpleados();
		modelo.agregarMalaRelacion("Jose", "Martin");
		
		assertTrue(modelo.existeMalaRelacionEntre("Jose", "Martin"));
	}
	  
	//Test sobre eliminarMalaRelacion()//
	@Test (expected = RuntimeException.class)
	public void buenaRelacionDosInvalidosTest()
	{
		Modelo modelo = new Modelo();
		modelo.confirmarListaDeEmpleados();
		modelo.eliminarMalaRelacion("Luis", "Fernando");
	}
	
	@Test (expected = RuntimeException.class)
	public void buenaRelacionUnInvalidoTest()
	{
		Modelo modelo = new Modelo();
		modelo.agregarEmpleado("Luis", "Tester");
		modelo.confirmarListaDeEmpleados();
		
		modelo.eliminarMalaRelacion("Luis", "Fernando");
	}
	
	@Test (expected = RuntimeException.class)
	public void buenaRelacionSinConfirmarListaTest()
	{
		Modelo modelo = new Modelo();
		modelo.eliminarMalaRelacion("Luis", "Fernando");
	}

	@Test
	public void eliminarMalaRelacionTest()
	{
		Modelo modelo = new Modelo();
		modelo.agregarEmpleado("Jose", "Tester");
		modelo.agregarEmpleado("Martin", "Arquitecto");
		modelo.confirmarListaDeEmpleados();
		modelo.eliminarMalaRelacion("Jose", "Martin");
		
		assertFalse(modelo.existeMalaRelacionEntre("Jose", "Martin"));
	}
	  
	//Test de funciones auxiliares//
	@Test
	public void ConfirmarListaVaciaTest()
	{
		Modelo modelo = new Modelo();
		modelo.confirmarListaDeEmpleados();
		
		assertTrue(modelo.getMalasRelaciones().tamano() == modelo.getEmpleados().size());	
	}
	
	@Test
	public void ConfirmarListaCompletaTest()
	{
		Modelo modelo = new Modelo();
		modelo.agregarEmpleado("Emanuel", "Arquitecto");
		modelo.confirmarListaDeEmpleados();
		
		assertTrue(modelo.getMalasRelaciones().tamano() == modelo.getEmpleados().size());	
	}
	
	@Test (expected = RuntimeException.class)
	public void setCondicionArquitectoNegativo1Test()
	{
		Modelo modelo = new Modelo();
		modelo.setCondicionArquitecto(-1, 2);
	}
	
	@Test (expected = RuntimeException.class)
	public void setCondicionArquitectoNegativo2Test()
	{
		Modelo modelo = new Modelo();
		modelo.setCondicionArquitecto(2, -1);
	}
	
	@Test (expected = RuntimeException.class)
	public void minMayorAlMaxTest()
	{
		Modelo modelo = new Modelo();
		modelo.setCondicionArquitecto(2, 1);
	}
	
	@Test
	public void setCondicionValidaTest()
	{
		Modelo modelo = new Modelo();
		modelo.setCondicionArquitecto(2, 3);	
	}
	
}
