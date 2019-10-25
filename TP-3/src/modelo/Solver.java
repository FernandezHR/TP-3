package modelo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Solver 
{
	private Instancia instancia;
	private Set<Integer> conjuntoActual;
	
	private ArrayList<Empleado> equipoMasOptimo;
	
	public Solver(Instancia instancia)
	{
		this.instancia = instancia;
	}
	
	public ArrayList<Empleado> resolver()
	{
		conjuntoActual = new HashSet<Integer>();

		recursion(0);
		
		return equipoMasOptimo;
	}
	
	
	private void recursion(int inicial)
	{
		//Caso base
		if( inicial == instancia.getTamanio())
		{
			if(conjuntoActualPuedeFormarEquipo() && conjuntoActualCumpleMinimos())
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
		
		int contLider, contArquitecto, contProgramador, contTester;
		contLider = contArquitecto = contProgramador = contTester = 0;
		
		for(Integer i : conjuntoActual)
		{
			if(esLider(i) && contLider < instancia.maxLider())
			{
				equipoMaximo.add(instancia.getEmpleados().get(i));
				contLider++;
			}
			
			if(esArquitecto(i) && contArquitecto < instancia.maxArquitecto())
			{
				equipoMaximo.add(instancia.getEmpleados().get(i));
				contArquitecto++;
			}
			
			if(esProgramador(i) && contProgramador < instancia.maxProgramador())
			{
				equipoMaximo.add(instancia.getEmpleados().get(i));
				contProgramador++;
			}
			
			if(esTester(i) && contTester < instancia.maxTester())
			{
				equipoMaximo.add(instancia.getEmpleados().get(i));
				contTester++;
			}
			
		}
		
		return equipoMaximo;
	}

	private boolean conjuntoActualPuedeFormarEquipo()
	{		
		for (Integer i : conjuntoActual) 
			for (Integer j : conjuntoActual) 
				if ( i != j && instancia.sonIncompatibles(i, j))
					return false;
			
		return true;
	}
	
	private boolean conjuntoActualCumpleMinimos() 
	{
		int contLider, contArquitecto, contProgramador, contTester;
		contLider = contArquitecto = contProgramador = contTester = 0;
		
		for(Integer i : conjuntoActual)
		{
			if(esLider(i))
				contLider++;
			
			if(esArquitecto(i))
				contArquitecto++;
			
			if(esProgramador(i))
				contProgramador++;
			
			if(esTester(i))
				contTester++;
		}
		
		return contLider >= instancia.minLider() && contArquitecto >= instancia.minArquitecto() 
				&& contProgramador >= instancia.minProgramador() && contTester >= instancia.minTester();
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
	
}