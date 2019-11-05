package modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class testModelo 
{
	//Test sobre agregarEmpleado()//
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
		
		assertEquals(modelo.cantEmpleados(), 2);
	}
	
	@Test (expected = RuntimeException.class)
	public void agregarNombreRepetidoTest()
	{
		Modelo modelo = new Modelo();
		modelo.agregarEmpleado("Ignacio", "Tester");
		modelo.agregarEmpleado("Ignacio", "Programador");
	}
	
	@Test (expected = RuntimeException.class)
	public void agregarPuestoInvalidoTest()
	{
		Modelo modelo = new Modelo();
		modelo.agregarEmpleado("Marcos", "Jardinero");
	}
	
	@Test 
	public void empleadoInexistenteTest()
	{
		Modelo modelo = new Modelo();
		assertFalse(modelo.existeEmpleado("Fernando"));
	}
	
	//Test sobre confirmarLista()//
	@Test
	public void confirmarListaCompletaTest()
	{
		Modelo modelo = new Modelo();
		modelo.agregarEmpleado("Brian", "Lider de Proyecto");
		modelo.agregarEmpleado("Javier", "Arquitecto");
		modelo.agregarEmpleado("Sandra", "Programador");
		modelo.agregarEmpleado("Camila", "Tester");
		
		modelo.confirmarListaDeEmpleados();
	}
	
	@Test(expected = RuntimeException.class)
	public void confirmarListaSinLider()
	{
		Modelo modelo = new Modelo();
		modelo.agregarEmpleado("Javier", "Arquitecto");
		modelo.agregarEmpleado("Sandra", "Programador");
		modelo.agregarEmpleado("Camila", "Tester");
		
		modelo.confirmarListaDeEmpleados();
	}
	
	@Test(expected = RuntimeException.class)
	public void confirmarListaSinArquitecto()
	{
		Modelo modelo = new Modelo();
		modelo.agregarEmpleado("Javier", "Lider de Proyecto");
		modelo.agregarEmpleado("Sandra", "Programador");
		modelo.agregarEmpleado("Camila", "Tester");
		
		modelo.confirmarListaDeEmpleados();
	}
	
	@Test(expected = RuntimeException.class)
	public void confirmarListaSinProgramador()
	{
		Modelo modelo = new Modelo();
		modelo.agregarEmpleado("Javier", "Lider de Proyecto");
		modelo.agregarEmpleado("Sandra", "Arquitecto");
		modelo.agregarEmpleado("Camila", "Tester");
		
		modelo.confirmarListaDeEmpleados();
	}
	
	@Test(expected = RuntimeException.class)
	public void confirmarListaSinTester()
	{
		Modelo modelo = new Modelo();
		modelo.agregarEmpleado("Javier", "Lider de Proyecto");
		modelo.agregarEmpleado("Sandra", "Arquitecto");
		modelo.agregarEmpleado("Camila", "Programador");
		
		modelo.confirmarListaDeEmpleados();
	}
	
	@Test (expected = RuntimeException.class)
	public void agregarConListaConfirmada()
	{
		Modelo modelo = new Modelo();
		modelo.agregarEmpleado("Raul", "Lider de Proyecto");
		modelo.agregarEmpleado("Nahuel", "Arquitecto");
		modelo.agregarEmpleado("Marco", "Programador");
		modelo.agregarEmpleado("Andres", "Tester");
		
		modelo.confirmarListaDeEmpleados();
		
		modelo.agregarEmpleado("Luciano", "Arquitecto");
	}

	//Test sobre eliminarEmpleado()//
	@Test
	public void eliminarEmpleadoTest()
	{
		Modelo modelo = new Modelo();
		
		modelo.agregarEmpleado("Luis", "Programador");
		assertTrue(modelo.existeEmpleado("Luis"));
		
		modelo.eliminarEmpleado("Luis");
		assertFalse(modelo.existeEmpleado("Luis"));
	}
	
	@Test (expected = RuntimeException.class)
	public void eliminarInexistenteTest()
	{
		Modelo modelo = new Modelo();
		modelo.eliminarEmpleado("Luis");
	}
	
	@Test (expected = RuntimeException.class)
	public void eliminarConListaConfirmadaTest()
	{
		Modelo modelo = new Modelo();
		modelo.agregarEmpleado("Brian", "Lider de Proyecto");
		modelo.agregarEmpleado("Javier", "Arquitecto");
		modelo.agregarEmpleado("Sandra", "Programador");
		modelo.agregarEmpleado("Camila", "Tester");
		
		modelo.confirmarListaDeEmpleados();
		
		modelo.eliminarEmpleado("Luis");
	}
	
	//Test sobre agregarMalaRelacion()//
	@Test
	public void agregarMalaRelacionTest()
	{
		Modelo modelo = new Modelo();
		modelo.agregarEmpleado("Jose", "Lider de Proyecto");
		modelo.agregarEmpleado("Martin", "Arquitecto");
		modelo.agregarEmpleado("Arturo", "Programador");
		modelo.agregarEmpleado("Valentina", "Tester");
		
		modelo.confirmarListaDeEmpleados();
		
		modelo.agregarMalaRelacion("Jose", "Martin");
		
		assertTrue(modelo.existeMalaRelacionEntre("Jose", "Martin"));
	}
	
	
	@Test (expected = RuntimeException.class)
	public void relacionConUnInexistenteTest()
	{
		Modelo modelo = new Modelo();
	
		modelo.agregarEmpleado("Brian", "Lider de Proyecto");
		modelo.agregarEmpleado("Javier", "Arquitecto");
		modelo.agregarEmpleado("Sandra", "Programador");
		modelo.agregarEmpleado("Camila", "Tester");
		
		modelo.confirmarListaDeEmpleados();
		
		modelo.agregarMalaRelacion("Brian", "Fernando");
	}
	
	@Test (expected = RuntimeException.class)
	public void relacionSinListaConfirmadaTest()
	{
		Modelo modelo = new Modelo();
		modelo.agregarMalaRelacion("Luis", "Fernando");
	}
	  
	//Test sobre eliminarMalaRelacion()//
	@Test
	public void eliminarMalaRelacionTest()
	{
		Modelo modelo = new Modelo();
		modelo.agregarEmpleado("Jose", "Lider de Proyecto");
		modelo.agregarEmpleado("Martin", "Arquitecto");
		modelo.agregarEmpleado("Pedro", "Programador");
		modelo.agregarEmpleado("Rodrigo", "Tester");
		
		modelo.confirmarListaDeEmpleados();
		
		modelo.agregarMalaRelacion("Jose", "Martin");
		assertTrue(modelo.existeMalaRelacionEntre("Jose", "Martin"));
		
		modelo.eliminarMalaRelacion("Jose", "Martin");
		assertFalse(modelo.existeMalaRelacionEntre("Jose", "Martin"));
	}
	
	@Test (expected = RuntimeException.class)
	public void eliminarMalaRelacionConUnInexistenteTest()
	{
		Modelo modelo = new Modelo();
		modelo.agregarEmpleado("Jose", "Lider de Proyecto");
		modelo.agregarEmpleado("Martin", "Arquitecto");
		modelo.agregarEmpleado("Pedro", "Programador");
		modelo.agregarEmpleado("Luis", "Tester");
		
		modelo.confirmarListaDeEmpleados();
		
		modelo.eliminarMalaRelacion("Luis", "Fernando");
	}
	
	@Test (expected = RuntimeException.class)
	public void eliminarMalaRelacionSinConfirmarListaTest()
	{
		Modelo modelo = new Modelo();
		modelo.eliminarMalaRelacion("Luis", "Fernando");
	}
	  
	//Test de funciones auxiliares//
	
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
