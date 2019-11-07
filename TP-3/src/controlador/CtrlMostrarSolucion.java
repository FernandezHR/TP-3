package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.Empleado;
import modelo.Modelo;
import vista.MostrarSolucion;

public class CtrlMostrarSolucion implements ActionListener
{
	private MostrarSolucion panelMostrarSolucion;
	private Modelo modelo;
	
	public CtrlMostrarSolucion(Modelo modelo, MostrarSolucion panelMostrarSolucion)
	{
		this.modelo = modelo;
		this.panelMostrarSolucion = panelMostrarSolucion;
		
		this.panelMostrarSolucion.btnEstadisticas.addActionListener(this);
	}
	
	public void iniciar() 
	{
		if(seEncontroSolucion()) 
		{
			panelMostrarSolucion.activarVistaConSolucion();
			cargarEquipoElegido();
		}
		else
			panelMostrarSolucion.activarVistaSinSolucion();
	}
	
	private void cargarEquipoElegido() 
	{
		panelMostrarSolucion.limpiarFotos();
		
		ArrayList<Empleado> solucion = modelo.getSolucion();
		
		solucion
		.stream()
		.filter(e -> e.getPuesto().equals("Lider de Proyecto"))
		.forEach(e -> panelMostrarSolucion.agregarLider(e.getNombre(), FotosDeEmpleados.get(e.getNombre())));
		
		solucion
		.stream()
		.filter(e -> e.getPuesto().equals("Arquitecto"))
		.forEach(e -> panelMostrarSolucion.agregarArquitecto(e.getNombre(), FotosDeEmpleados.get(e.getNombre())));
		
		solucion
		.stream()
		.filter(e -> e.getPuesto().equals("Programador"))
		.forEach(e -> panelMostrarSolucion.agregarProgramador(e.getNombre(), FotosDeEmpleados.get(e.getNombre())));
		
		solucion
		.stream()
		.filter(e -> e.getPuesto().equals("Tester"))
		.forEach(e -> panelMostrarSolucion.agregarTester(e.getNombre(), FotosDeEmpleados.get(e.getNombre())));
		
		panelMostrarSolucion.validate();
	}
	
	private boolean seEncontroSolucion() 
	{
		return !modelo.getSolucion().isEmpty();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		if(arg0.getSource() == panelMostrarSolucion.btnEstadisticas)
			JOptionPane.showMessageDialog(null, modelo.getEstadisticas(), "Estadisticas",JOptionPane.INFORMATION_MESSAGE);	
		
	}
	
	
}

