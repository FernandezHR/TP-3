package controlador;

import modelo.Modelo;
import vista.CargarCotas;
import vista.CargarDatos;

public class CtrlCargarCotas 
{
	private Modelo modelo;
	private CargarCotas panelCargarCotas;
	
	public CtrlCargarCotas(Modelo modelo, CargarDatos panelCargarDatos) 
	{
		this.modelo = modelo;
		this.panelCargarCotas = panelCargarDatos.panelCargarCotas;
	}

	public void iniciar() 
	{
		configurarSpinners();
	}
	
	//Setea los valores maximos de los spiners (cotas) segun los empleados cargados
	private void configurarSpinners() 
	{
		int contArquitecto = (int) modelo.getEmpleados().stream().filter(e -> e.getPuesto().equals("Arquitecto")).count();
		int contProgramador = (int) modelo.getEmpleados().stream().filter(e -> e.getPuesto().equals("Programador")).count();
		int contTester = (int) modelo.getEmpleados().stream().filter(e -> e.getPuesto().equals("Tester")).count();
	
		panelCargarCotas.setSpinnerArquitecto(contArquitecto);
		panelCargarCotas.setSpinnerProgramador(contProgramador);
		panelCargarCotas.setSpinnerTester(contTester);		
	}
	
	//Pasa a la logica las cotas min/max que tienen actualmente los spinners
	public void ejecutar() 
	{
		int min = panelCargarCotas.getMinArquitecto();
		int max = panelCargarCotas.getMaxArquitecto();
		
		modelo.setCondicionArquitecto(min, max);
		
		min = panelCargarCotas.getMinProgramador();
		max = panelCargarCotas.getMaxProgramador();
		
		modelo.setCondicionProgramador(min, max);
		
		min = panelCargarCotas.getMinTester();
		max = panelCargarCotas.getMaxTester();
		
		modelo.setCondicionTester(min, max);
	}
	
	//Devuelve verdadero si la cota minima no supera a la maxima
	public boolean tieneCotasValidas() 
	{
		int min = panelCargarCotas.getMinArquitecto();
		int max = panelCargarCotas.getMaxArquitecto();
		
		if(min > max)
			return false;
		
		min = panelCargarCotas.getMinProgramador();
		max = panelCargarCotas.getMaxProgramador();
		
		if(min > max)
			return false;
		
		min = panelCargarCotas.getMinTester();
		max = panelCargarCotas.getMaxTester();
		
		if(min > max)
			return false;
		
		return true;
	}
}
