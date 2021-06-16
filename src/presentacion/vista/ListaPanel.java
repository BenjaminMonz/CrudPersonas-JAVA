package presentacion.vista;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;
import java.util.TreeSet;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entidad.Persona;

public class ListaPanel  extends JPanel{

	
	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	private JTable TAB_Personas = new JTable();
	private DefaultTableModel TabModelPers= new DefaultTableModel();
	private String[] NameColumns = {"Nombre","Apellido","Dni"};
	
	
	public String[] getNameColumns() {
		return this.NameColumns;
	} 
	
	public void setNameColumns(String[] NombreComlumnas) {
		this.NameColumns=NombreComlumnas;
	} 
	
	public JTable getTABPersonas() {
		return TAB_Personas;
	}

	public void setTABPersonas(JTable tAB_Personas) {
		TAB_Personas = tAB_Personas;
	}

	public DefaultTableModel getDefaultTablePersonas() {
		return TabModelPers;
	}

	public void setDefaultTablePersonas(DefaultTableModel defaultTable_Personas) {
		TabModelPers = defaultTable_Personas;
	}

	public ListaPanel() {
		super();
		initialize();
	}
	
	public void initialize() {
				
	
			GridBagLayout gridBagLayout = new GridBagLayout();
			gridBagLayout.columnWidths = new int[]{30, 0, 0, 0, 30, 0};
			gridBagLayout.rowHeights = new int[]{30, 0, 0, 0, 0, 0, 30, 0};
			gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
			gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
			setLayout(gridBagLayout);
			
			
			
			scrollPane= new JScrollPane();
			
			GridBagConstraints gbc_scrollPane = new GridBagConstraints();
			gbc_scrollPane.gridheight = 5;
			gbc_scrollPane.gridwidth = 5;
			gbc_scrollPane.insets = new Insets(0, 0, 0, 0);
			gbc_scrollPane.fill = GridBagConstraints.BOTH;
			gbc_scrollPane.gridx = 0;
			gbc_scrollPane.gridy = 2;
			add(scrollPane, gbc_scrollPane);

			
			TabModelPers = new DefaultTableModel(null,NameColumns);
			TAB_Personas = new JTable(TabModelPers);
			
			TAB_Personas.getColumnModel().getColumn(0).setPreferredWidth(50);
			TAB_Personas.getColumnModel().getColumn(0).setResizable(true);
			TAB_Personas.getColumnModel().getColumn(1).setPreferredWidth(50);
			TAB_Personas.getColumnModel().getColumn(1).setResizable(true);
			TAB_Personas.getColumnModel().getColumn(2).setPreferredWidth(50);
			TAB_Personas.getColumnModel().getColumn(2).setResizable(true);
			scrollPane.setViewportView(TAB_Personas);
			
		}

	public void llenarTabla(List<Persona> personasEnTabla) {
		this.getDefaultTablePersonas().setRowCount(0); //Para vaciar la tabla
		this.getDefaultTablePersonas().setColumnCount(0);
		this.getDefaultTablePersonas().setColumnIdentifiers(this.getNameColumns());

		for (Persona p : personasEnTabla)
		{
			String nombre = p.getNombre();
			String apellido = p.getApellido();
			String dni = p.getDNIPersona();
			
			Object[] fila = {nombre,apellido, dni};
			
			this.getDefaultTablePersonas().addRow(fila);
		}
		
	}
	
	public void mostrarMensaje(String mensaje)
	{
		JOptionPane.showMessageDialog(null, mensaje);
	}
}


