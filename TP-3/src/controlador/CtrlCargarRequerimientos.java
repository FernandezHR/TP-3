package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import modelo.Empleado;
import modelo.Modelo;
import vista.CargarRequerimientos;

public class CtrlCargarRequerimientos implements ActionListener
{
	private Modelo modelo;
	private CargarRequerimientos cargarRequerimientos;
	
	private boolean confirmoCotas;
	int minArq, maxArq, minProg, maxProg, minTest, maxTest;
	
	public CtrlCargarRequerimientos(Modelo modelo, CargarRequerimientos cargarRequerimientos) 
	{
		this.modelo = modelo;
		this.cargarRequerimientos = cargarRequerimientos;
		
		confirmoCotas = false;
	}

	public void iniciar() 
	{
		configurarLimites();
		cargarRequerimientos.btnConfirmar.addActionListener(this);
	}
	
	private void configurarLimites() 
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
		cargarRequerimientos.minArquitecto.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), new Integer(contArquitecto), new Integer(1)));
		cargarRequerimientos.minProgramador.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), new Integer(contProgramador), new Integer(1)));
		cargarRequerimientos.minTester.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), new Integer(contTester), new Integer(1)));
		
		//CONFIGURAMOS LOS MAXIMOS
		cargarRequerimientos.maxArquitecto.setModel(new SpinnerNumberModel(new Integer(contArquitecto), new Integer(1), new Integer(contArquitecto), new Integer(1)));
		cargarRequerimientos.maxProgramador.setModel(new SpinnerNumberModel(new Integer(contProgramador), new Integer(1), new Integer(contProgramador), new Integer(1)));
		cargarRequerimientos.maxTester.setModel(new SpinnerNumberModel(new Integer(contTester), new Integer(1), new Integer(contTester), new Integer(1)));
	
		//DESACTIVAMOS LA EDICION POR TECLADO
		cargarRequerimientos.minArquitecto.setEditor(new JSpinner.DefaultEditor(cargarRequerimientos.minArquitecto));
		cargarRequerimientos.minProgramador.setEditor(new JSpinner.DefaultEditor(cargarRequerimientos.minProgramador));
		cargarRequerimientos.minTester.setEditor(new JSpinner.DefaultEditor(cargarRequerimientos.minTester));
		cargarRequerimientos.maxArquitecto.setEditor(new JSpinner.DefaultEditor(cargarRequerimientos.maxArquitecto));
		cargarRequerimientos.maxProgramador.setEditor(new JSpinner.DefaultEditor(cargarRequerimientos.maxProgramador));
		cargarRequerimientos.maxTester.setEditor(new JSpinner.DefaultEditor(cargarRequerimientos.maxTester));
		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		if(arg0.getSource() == cargarRequerimientos.btnConfirmar)
		{
			if(valoresSonValidos()) 
			{
				cargarCantidadArquitecto();
				cargarCantidadProgramador();
				cargarCantidadTester();	
				confirmoCotas = true;
			}
			else
				JOptionPane.showMessageDialog(null, "Verifique que las cotas minimas no sean mayor a las cotas maximas.", "Advertencia", JOptionPane.WARNING_MESSAGE);
		}
	}

	private void cargarCantidadArquitecto() 
	{
		minArq = (int) cargarRequerimientos.minArquitecto.getValue();
		maxArq = (int) cargarRequerimientos.maxArquitecto.getValue();
		
		modelo.setCondicionArquitecto(minArq, maxArq);
	}
	
	private void cargarCantidadProgramador() 
	{
		minProg = (int) cargarRequerimientos.minProgramador.getValue();
		maxProg = (int) cargarRequerimientos.maxProgramador.getValue();
		
		modelo.setCondicionProgramador(minProg, maxProg);
	}
	
	private void cargarCantidadTester() 
	{
		minTest = (int) cargarRequerimientos.minTester.getValue();
		maxTest = (int) cargarRequerimientos.maxTester.getValue();
		
		modelo.setCondicionTester(minTest, maxTest);	
	}
	
	private boolean valoresSonValidos() 
	{
		int min = (int) cargarRequerimientos.minArquitecto.getValue();
		int max = (int) cargarRequerimientos.maxArquitecto.getValue();
		
		if(min > max)
			return false;
		
		min = (int) cargarRequerimientos.minProgramador.getValue();
		max = (int) cargarRequerimientos.maxProgramador.getValue();
		
		if(min > max)
			return false;
		
		min = (int) cargarRequerimientos.minTester.getValue();
		max = (int) cargarRequerimientos.maxTester.getValue();
		
		if(min > max)
			return false;
		
		return true;
	}

	public boolean confirmoCotas() 
	{
		chequearCambios();
		
		if(confirmoCotas)
			return true;
		return false;
	}

	private void chequearCambios() 
	{
		int min = (int) cargarRequerimientos.minArquitecto.getValue();
		int max = (int) cargarRequerimientos.maxArquitecto.getValue();
		
		if(min != minArq || max != maxArq)
			confirmoCotas = false;
		
		min = (int) cargarRequerimientos.minProgramador.getValue();
		max = (int) cargarRequerimientos.maxProgramador.getValue();
		
		if(min != minProg || max != maxProg)
			confirmoCotas = false;
		
		min = (int) cargarRequerimientos.minTester.getValue();
		max = (int) cargarRequerimientos.maxTester.getValue();
		
		if(min != minTest || max != maxTest)
			confirmoCotas = false;
		
	}
	
}
