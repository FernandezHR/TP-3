package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Empleado;
import modelo.Modelo;
import vista.VentanaPrincipal;

public class CtrlVentanaPrincipal implements ActionListener
{
	private Modelo modelo;
	private VentanaPrincipal vPrincipal;
	
	private ArrayList<Empleado> empleados;
	
	public CtrlVentanaPrincipal(Modelo modelo, VentanaPrincipal vPrincipal) 
	{
		this.modelo = modelo;
		this.vPrincipal = vPrincipal;
		
		empleados = new ArrayList<Empleado>();
		
		this.vPrincipal.btnCargar.addActionListener(this);
	}
	
	public void iniciar() 
	{
		vPrincipal.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		if(arg0.getSource() == vPrincipal.btnCargar)
		{
			if(camposEstanLlenos()) 
			{
				crearEmpleado();
				actualizarTablaDeEmpleados();
				resetearCampos();						
			}
			else
				JOptionPane.showMessageDialog(null, "Rellene todos los campos.", "Atencion", JOptionPane.WARNING_MESSAGE);
		}
	}

	private void crearEmpleado() 
	{
		String nombre = vPrincipal.txtNombre.getText() + " " + vPrincipal.txtApellido.getText();
		String puesto = vPrincipal.cBoxPuestos.getSelectedItem().toString();
		
		if(!existeEmpleado(nombre)) 
		{
			Empleado empleado = new Empleado(nombre, puesto);
			empleados.add(empleado);
		}
		else
			JOptionPane.showMessageDialog(null, "El empleado ya existe.", "Atencion", JOptionPane.WARNING_MESSAGE);
	}

	private void actualizarTablaDeEmpleados() 
	{
		String matriz[][] = new String[empleados.size()][2];
		
		for(int i=0; i < empleados.size(); i++) 
		{
			matriz[i][0] = empleados.get(i).getNombre();
			matriz[i][1] = empleados.get(i).getPuesto();
		}
		
		vPrincipal.tablaEmpleados.setModel(new DefaultTableModel(matriz, new String[] {"Nombre", "Puesto"}));
	}

	private void resetearCampos() 
	{
		vPrincipal.txtNombre.setText(null);
		vPrincipal.txtApellido.setText(null);
		vPrincipal.cBoxPuestos.setSelectedItem(null);
	}
	
	
	//METODOS AUXILIARES
	private boolean existeEmpleado(String nombre) 
	{
		for(Empleado empleado : empleados)
			if(empleado.getNombre().equals(nombre))
				return true;
		
		return false;
	}
	
	private boolean camposEstanLlenos() 
	{
		if(vPrincipal.txtNombre.getText().equals(""))
			return false;
		
		if(vPrincipal.txtApellido.getText().equals(""))
			return false;
		
		if(vPrincipal.cBoxPuestos.getSelectedItem() == null)
			return false;
		
		return true;
	}
}
