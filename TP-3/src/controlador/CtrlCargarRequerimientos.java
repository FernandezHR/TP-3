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
	
	private boolean cargoRequerimientos;
	
	public CtrlCargarRequerimientos(Modelo modelo, CargarRequerimientos cargarRequerimientos) 
	{
		this.modelo = modelo;
		this.cargarRequerimientos = cargarRequerimientos;
		
		cargoRequerimientos = false;
	}

	public void iniciar() 
	{
		configurarLimites();
		cargarRequerimientos.btnCargar.addActionListener(this);
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
		if(arg0.getSource() == cargarRequerimientos.btnCargar)
		{
			cargarCantidadArquitecto();
			cargarCantidadProgramador();
			cargarCantidadTester();	
			cargoRequerimientos = true;
		}
	}

	private void cargarCantidadTester() 
	{
		int min = (int) cargarRequerimientos.minTester.getValue();
		int max = (int) cargarRequerimientos.maxTester.getValue();
		
		if(losValoresSonValidos(min,max))
			modelo.setCondicionTester(min, max);	
		else
			JOptionPane.showMessageDialog(null, "El valor de la cota Max debe ser mayor al de la Min!!", "Advertencia", JOptionPane.WARNING_MESSAGE);

	}

	private boolean losValoresSonValidos(int min, int max)
	{
		return max >= min;
	}

	private void cargarCantidadProgramador() 
	{
		int min = (int) cargarRequerimientos.minProgramador.getValue();
		int max = (int) cargarRequerimientos.maxProgramador.getValue();
		
		if(losValoresSonValidos(min, max))
			modelo.setCondicionProgramador(min, max);
		else
			JOptionPane.showMessageDialog(null, "El valor de la cota Max debe ser mayor al de la Min!!", "Advertencia", JOptionPane.WARNING_MESSAGE);

	}

	private void cargarCantidadArquitecto() 
	{
		int min = (int) cargarRequerimientos.minArquitecto.getValue();
		int max = (int) cargarRequerimientos.maxArquitecto.getValue();
		if(losValoresSonValidos(min, max))
			modelo.setCondicionArquitecto(min, max);
		else
			JOptionPane.showMessageDialog(null, "El valor de la cota Max debe ser mayor al de la Min!!", "Advertencia", JOptionPane.WARNING_MESSAGE);

	}

	public boolean cargoRequerimientos() 
	{
		if(cargoRequerimientos)
			return true;
		return false;
	}
	
	
	
}
