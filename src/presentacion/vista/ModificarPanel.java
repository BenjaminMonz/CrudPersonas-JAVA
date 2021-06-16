package presentacion.vista;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.ScrollPane;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import entidad.Persona;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ModificarPanel extends JPanel{

	private JLabel LBL_Legenda= new JLabel("Seleccione la persona que desea modificar");
	private JButton BtnModificar=new JButton("Modificar");
	private JList<Persona> ListadoPersona=new JList();
	private DefaultListModel< Persona> ListadoModelo =new DefaultListModel<>();
	private JTextField TBNombre = new JTextField();
	private JTextField TB_Apellido= new JTextField();
	private JTextField TB_Dni = new JTextField();
	private String [] NombreColumns = new String [] {"Nombre", "Apellido","Dni"};
	
	private JScrollPane scrollPane =  new JScrollPane();
	
	public JList<Persona> getListadoPersona() {
		return ListadoPersona;
	}

	public void setListadoPersona(JList<Persona> listadoPersona) {
		ListadoPersona = listadoPersona;
	}

	public DefaultListModel<Persona> getListadoModelo() {
		return ListadoModelo;
	}

	public void setListadoModelo(DefaultListModel<Persona> listadoModelo) {
		ListadoModelo = listadoModelo;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}


	public String[] getNombreColumns() {
		return NombreColumns;
	}

	public void setNombreColumns(String[] nombreColumns) {
		NombreColumns = nombreColumns;
	}

	public JButton getBtnModificar() {
		return BtnModificar;
	}

	public void setBtnModificar(JButton btnModificar) {
		BtnModificar = btnModificar;
	}

	public JList getListado() {
		return ListadoPersona;
	}

	public void setListado(JList listado) {
		ListadoPersona = listado;
	}

	public JTextField getTBNombre() {
		return TBNombre;
	}

	public void setTBNombre(JTextField tBNombre) {
		TBNombre = tBNombre;
	}

	public JTextField getTB_Apellido() {
		return TB_Apellido;
	}

	public void setTB_Apellido(JTextField tB_Apellido) {
		TB_Apellido = tB_Apellido;
	}

	public JTextField getTB_Dni() {
		return TB_Dni;
	}

	public void setTB_Dni(JTextField tB_Dni) {
		TB_Dni = tB_Dni;
	}

	

	public ModificarPanel() {
		setLayout(null);

		Font Fuente =  new Font("Tahoma", Font.PLAIN, 15);
		int XWin=1;
		
		LBL_Legenda.setFont(Fuente);
		LBL_Legenda.setBounds(59, 11, 300, 30);
	
		add(LBL_Legenda);
		BtnModificar.setFont(Fuente);
		scrollPane.setBounds(59, 62, 367, 133);
		
		add(scrollPane);
	
		scrollPane.setViewportView(ListadoPersona);
		TBNombre.setToolTipText("");
		
		TBNombre.setBounds(57, 206, 86, 20);
		TBNombre.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				 int key = e.getKeyChar();
		          boolean numeros = key >= 57;
		            if (!numeros)
		            {
		                e.consume();
		            }
			}
		});
		add(TBNombre);
		
		TB_Apellido.setBounds(150, 206, 86, 20);
		TB_Apellido.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				 int key = e.getKeyChar();
		          boolean numeros = key >= 57;
		            if (!numeros)
		            {
		                e.consume();
		            }
			}
		});
		add(TB_Apellido);

		TB_Dni.setBounds(241, 206, 86, 20);
		TB_Dni.setEditable(false);
		TB_Dni.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				 int key = e.getKeyChar();
		          boolean numeros = key >= 48 && key <= 57;
		            if (!numeros)
		            {
		                e.consume();
		            }
			}
		});
		add(TB_Dni);
		
		BtnModificar.setBounds(337, 206, 119, 23);
		add(BtnModificar);
		}

	public void mostrarMensaje(String mensaje)
	{
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
	public void llenarTabla(ArrayList<Persona> personasEnTabla) {
		this.ListadoModelo.removeAllElements();
		
		for (Persona p : personasEnTabla)
		{
			this.ListadoModelo.addElement(p);
		}

		this.ListadoPersona.setModel(ListadoModelo);
	}
	
	
}
