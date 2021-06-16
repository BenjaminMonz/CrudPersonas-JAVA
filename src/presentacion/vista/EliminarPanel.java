package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.ScrollPane;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.ListModel;

import entidad.Persona;

import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class EliminarPanel extends JPanel {
	
	private JLabel lblEliminar= new JLabel("Eliminar Usuarios");
	private JButton BTN_Eliminar=new JButton("Eliminar");
	private JList Listado=new JList();
	private JScrollPane scrollPane =  new JScrollPane();
	DefaultListModel<Persona> dlModel= new DefaultListModel<Persona>();

	public EliminarPanel() {
		setLayout(null);
		BTN_Eliminar.setBounds(164, 241, 108, 34);
		add(BTN_Eliminar);
		lblEliminar.setBounds(164, 32, 161, 23);
		add(lblEliminar);
		Listado.setBounds(252, 55, 0, 0);
		add(Listado);
		scrollPane.setBounds(10, 62, 445, 173);
		add(scrollPane);
		scrollPane.setViewportView(Listado);
	}
	
	public JLabel getLblEliminar() {
		return lblEliminar;
	}

	public void setLblEliminar(JLabel lblEliminar) {
		this.lblEliminar = lblEliminar;
	}

	public JButton getBTN_Eliminar() {
		return BTN_Eliminar;
	}

	public void setBTN_Eliminar(JButton bTN_Eliminar) {
		BTN_Eliminar = bTN_Eliminar;
	}

	public JList getListado() {
		return Listado;
	}

	public void setListado(JList listado) {
		Listado = listado;
	}

	public JButton getBtnEliminar() {
		return BTN_Eliminar;
	}
	
	public void setBtnEliminar(JButton btnEliminar) {
		this.BTN_Eliminar = btnEliminar;
	}
	
	public void mostrarMensaje(String mensaje)
	{
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
	public void llenarTabla(ArrayList<Persona> personasEnTabla) {
		this.dlModel.removeAllElements();
		
		for (Persona p : personasEnTabla)
		{
			this.dlModel.addElement(p);
		}

		this.Listado.setModel(dlModel);
	}
	
}
