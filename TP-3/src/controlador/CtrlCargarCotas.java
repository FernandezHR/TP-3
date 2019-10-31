package controlador;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import modelo.Empleado;
import modelo.Modelo;
import vista.CargarCotas;

public class CtrlCargarCotas 
{
	private Modelo modelo;
	private CargarCotas panelCargarCotas;
	
	public CtrlCargarCotas(Modelo modelo, CargarCotas panelCargarCotas) 
	{
		this.modelo = modelo;
		this.panelCargarCotas = panelCargarCotas;
	}

	public void iniciar() 
	{
		configurarSpinners();
	}
	
	private void configurarSpinners() 
	{
		int contArquitecto, contProgramador, contTester;
		contArquitecto = contProgramador = contTester = 0;
		
		for(Empleado empleado : modelo.getEmpleados())
		{	
			if(empleado.getPuesto().equals("Arquitecto"))
				contArquitecto++;
			
			if(empleado.getPuesto().equals("Programador"))
				contProgramador++;
			
			if(empleado.getPuesto().equals("Tester"))
				contTester++;
		}
		
		//CONFIGURAMOS LOS MINIMOS
		panelCargarCotas.minArquitecto.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), new Integer(contArquitecto), new Integer(1)));
		panelCargarCotas.minProgramador.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), new Integer(contProgramador), new Integer(1)));
		panelCargarCotas.minTester.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), new Integer(contTester), new Integer(1)));
		
		//CONFIGURAMOS LOS MAXIMOS
		panelCargarCotas.maxArquitecto.setModel(new SpinnerNumberModel(new Integer(contArquitecto), new Integer(1), new Integer(contArquitecto), new Integer(1)));
		panelCargarCotas.maxProgramador.setModel(new SpinnerNumberModel(new Integer(contProgramador), new Integer(1), new Integer(contProgramador), new Integer(1)));
		panelCargarCotas.maxTester.setModel(new SpinnerNumberModel(new Integer(contTester), new Integer(1), new Integer(contTester), new Integer(1)));
	
		//DESACTIVAMOS LA EDICION POR TECLADO
		panelCargarCotas.minArquitecto.setEditor(new JSpinner.DefaultEditor(panelCargarCotas.minArquitecto));
		panelCargarCotas.minProgramador.setEditor(new JSpinner.DefaultEditor(panelCargarCotas.minProgramador));
		panelCargarCotas.minTester.setEditor(new JSpinner.DefaultEditor(panelCargarCotas.minTester));
		panelCargarCotas.maxArquitecto.setEditor(new JSpinner.DefaultEditor(panelCargarCotas.maxArquitecto));
		panelCargarCotas.maxProgramador.setEditor(new JSpinner.DefaultEditor(panelCargarCotas.maxProgramador));
		panelCargarCotas.maxTester.setEditor(new JSpinner.DefaultEditor(panelCargarCotas.maxTester));		
		
	}
	
	public void ejecutar() 
	{
		cargarCotasArquitecto();
		cargarCotasProgramador();
		cargarCotasTester();	
	}
	
	private void cargarCotasArquitecto() 
	{
		int min = (int) panelCargarCotas.minArquitecto.getValue();
		int max = (int) panelCargarCotas.maxArquitecto.getValue();
		
		modelo.setCondicionArquitecto(min, max);
	}
	
	private void cargarCotasProgramador() 
	{
		int min = (int) panelCargarCotas.minProgramador.getValue();
		int max = (int) panelCargarCotas.maxProgramador.getValue();
		
		modelo.setCondicionProgramador(min, max);
	}
	
	private void cargarCotasTester() 
	{
		int min = (int) panelCargarCotas.minTester.getValue();
		int max = (int) panelCargarCotas.maxTester.getValue();
		
		modelo.setCondicionTester(min, max);	
	}
	
	public boolean tieneCotasValidas() 
	{
		int min = (int) panelCargarCotas.minArquitecto.getValue();
		int max = (int) panelCargarCotas.maxArquitecto.getValue();
		
		if(min > max)
			return false;
		
		min = (int) panelCargarCotas.minProgramador.getValue();
		max = (int) panelCargarCotas.maxProgramador.getValue();
		
		if(min > max)
			return false;
		
		min = (int) panelCargarCotas.minTester.getValue();
		max = (int) panelCargarCotas.maxTester.getValue();
		
		if(min > max)
			return false;
		
		return true;
	}
}
