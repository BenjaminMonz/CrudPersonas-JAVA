package presentacion.vista;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entidad.Persona;

public class MainWindow extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	//private static DefaultListModel<Persona> ListaPelis=new DefaultListModel<Persona>();

	private JMenuBar MenuBar = new JMenuBar();
	private JMenu menu = new JMenu("Persona");
	
	
	private JMenuItem MenuAgregar = new JMenuItem("Agregar");
	private JMenuItem MenuModificar = new JMenuItem("Modificar");
	private JMenuItem MenuEliminar = new JMenuItem("Eliminar");
	private JMenuItem MenuListar = new JMenuItem("Listado");
	
	private Font Fuente =  new Font("Segoe UI", Font.PLAIN, 18);

	
	public MainWindow() {

		setTitle("Programa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 400, 400);
		setJMenuBar(MenuBar);
		MenuBar.add(menu);
		menu.setFont(Fuente);
		menu.add(MenuAgregar);
		menu.add(MenuModificar);
		menu.add(MenuEliminar);
		menu.add(MenuListar);
		
		this.setVisible(true);	
		}

	public void DoListado() {
		MenuListar.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		MenuListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setBounds(500, 100, 700, 500);
				contentPane.removeAll();
				ListaPanel panel = new ListaPanel();
				//panel.setDefaultListModel(ListaPelis);
				contentPane.add(panel);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		
		menu.add(MenuListar);
	}

	public JMenuItem getMenuAgregar() {
		return MenuAgregar;
	}

	public void setMenuAgregar(JMenuItem menuAgregar) {
		MenuAgregar = menuAgregar;
	}

	public JMenuItem getMenuModificar() {
		return MenuModificar;
	}

	public void setMenuModificar(JMenuItem menuModificar) {
		MenuModificar = menuModificar;
	}

	public JMenuItem getMenuEliminar() {
		return MenuEliminar;
	}

	public void setMenuEliminar(JMenuItem menuEliminar) {
		MenuEliminar = menuEliminar;
	}

	public JMenuItem getMenuListar() {
		return MenuListar;
	}

	public void setMenuListar(JMenuItem menuListar) {
		MenuListar = menuListar;
	}
}
