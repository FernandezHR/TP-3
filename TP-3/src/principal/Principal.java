package principal;

import javax.swing.UIManager;

import controlador.CtrlVentanaPrincipal;
import modelo.Modelo;
import vista.VentanaPrincipal;

public class Principal 
{
	public static void main(String[] args) 
	{
		try{ 
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		Modelo modelo = new Modelo();
		VentanaPrincipal vista = new VentanaPrincipal();

		CtrlVentanaPrincipal controlador = new CtrlVentanaPrincipal(modelo, vista);		
		controlador.iniciar();
		
	}
}
