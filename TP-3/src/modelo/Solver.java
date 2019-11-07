package modelo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Solver 
{
	private Instancia instancia;
	private Set<Integer> conjuntoActual;
	private ArrayList<Empleado> equipoMasOptimo;
	
	//Variables de estadistica
	private int totalIteraciones = 0;
	private double tiempoTotal = 0;
	
	public Solver(Instancia instancia)
	{
		this.instancia = instancia;
	}
	
	public ArrayList<Empleado> resolver()
	{
		conjuntoActual = new HashSet<Integer>();
		equipoMasOptimo = new ArrayList<Empleado>();

		long inicio = System.currentTimeMillis();
		
		recursion(0);
		
		long fin = System.currentTimeMillis();
		tiempoTotal = (double) (fin - inicio)/1000;
		
		return equipoMasOptimo;
	}
	
	private void recursion(int inicial)
	{
		//Caso base
		if( inicial == instancia.getTamanio())
		{
			totalIteraciones++;
			if(conjuntoActualNoTieneIncompatibles() && conjuntoActualCumpleMinimos())
			{
				ArrayList<Empleado> equipoMaximo = armarMaximoEquipo();
				
				if(equipoMaximo.size() > equipoMasOptimo.size())
					equipoMasOptimo = equipoMaximo;
			}
			return;
		}
		
		// Caso recursivo
		conjuntoActual.add(inicial);
		recursion(inicial+1);
				
		conjuntoActual.remove(inicial);
		recursion(inicial+1);
	}

	private ArrayList<Empleado> armarMaximoEquipo() 
	{
		ArrayList<Empleado> equipoMaximo = new ArrayList<Empleado>();
		
		int contLider = 0, contArquitecto = 0, contProgramador = 0, contTester = 0;
		
		for(Integer i : conjuntoActual)
		{
			if(esLider(i) && contLider < instancia.maxLideres())
			{
				equipoMaximo.add(instancia.getEmpleados().get(i));
				contLider++;
			}
			
			if(esArquitecto(i) && contArquitecto < instancia.maxArquitectos())
			{
				equipoMaximo.add(instancia.getEmpleados().get(i));
				contArquitecto++;
			}
			
			if(esProgramador(i) && contProgramador < instancia.maxProgramadores())
			{
				equipoMaximo.add(instancia.getEmpleados().get(i));
				contProgramador++;
			}
			
			if(esTester(i) && contTester < instancia.maxTesters())
			{
				equipoMaximo.add(instancia.getEmpleados().get(i));
				contTester++;
			}	
		}
	
		return equipoMaximo;
	}

	private boolean conjuntoActualNoTieneIncompatibles()
	{	
		for (Integer i : conjuntoActual) 
			for (Integer j : conjuntoActual) 
				if ( i != j && instancia.sonIncompatibles(i, j))
					return false;
			
		return true;
	}
	
	private boolean conjuntoActualCumpleMinimos() 
	{
		int cantLider = (int) conjuntoActual.stream().filter(i -> esLider(i)).count();
		int cantProg = (int) conjuntoActual.stream().filter(i -> esArquitecto(i)).count();
		int cantArq = (int) conjuntoActual.stream().filter(i -> esProgramador(i)).count();
		int cantTest = (int) conjuntoActual.stream().filter(i -> esTester(i)).count();
	
		return cantLider >= instancia.minLideres() && cantArq >= instancia.minArquitectos() 
				&& cantProg >= instancia.minProgramadores() && cantTest >= instancia.minTesters();
	}

	private boolean esTester(Integer i) 
	{
		return instancia.getEmpleados().get(i).getPuesto().equals("Tester");
	}

	private boolean esProgramador(Integer i) 
	{
		return instancia.getEmpleados().get(i).getPuesto().equals("Programador");
	}

	private boolean esArquitecto(Integer i) 
	{
		return instancia.getEmpleados().get(i).getPuesto().equals("Arquitecto");
	}

	private boolean esLider(Integer i) 
	{
		return instancia.getEmpleados().get(i).getPuesto().equals("Lider de Proyecto");
	}
	
	public int getCantIteraciones() 
	{
		return totalIteraciones;
	}
	
	public double getTiempoTotal()
	{
		return tiempoTotal;
	}
}