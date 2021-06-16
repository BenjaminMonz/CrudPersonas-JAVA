package presentacion.vista;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import entidad.Persona;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;

public class AgregarPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JButton BTN_Aceptar = new JButton("Aceptar");
	private DefaultListModel<Persona> Lista= new DefaultListModel<Persona>();
	private JTextField TB_Nombre =new JTextField();
	private JTextField TB_Apellido= new JTextField();
	private JTextField TB_DNI =new JTextField();
	private JLabel LBL_Nombre = new JLabel("Nombre: ");
	private JLabel LBL_Apellido=new JLabel("Apellido: ");
	private JLabel LBL_DNI = new JLabel("DNI: ");
	
	public AgregarPanel() {
		super();
		initialize();
	}
	
	public void initialize() {
		setBounds(500, 100, 600, 300);
		Font fuenteComun = new Font("Tahoma", Font.PLAIN, 22);	
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{30, 0, 0, 0, 30, 0};
		//gridBagLayout.rowHeights = new int[]{30, 0, 0, 0, 0, 30, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		//FILA 1
		GridBagConstraints GB_LBL_Nombre_L = ConstruirGRIDWEST(1,1);
		LBL_Nombre.setFont(fuenteComun);
		add(LBL_Nombre, GB_LBL_Nombre_L);
		
		GridBagConstraints GB_LBL_Nombre_R = ConstruirGRIDHORIZONTAL(2,1);
		TB_Nombre.setFont(fuenteComun);
		add(TB_Nombre, GB_LBL_Nombre_R);
		TB_Nombre.setColumns(10);
		TB_Nombre.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				 int key = e.getKeyChar();
		          boolean numeros = key >= 57;
		            if (!numeros)
		            {
		                e.consume();
		            }
			}
		});
		//FILA 2
		GridBagConstraints GB_LBL_Genero_L = ConstruirGRIDWEST(1,2);
		LBL_Apellido.setFont(fuenteComun);
		add(LBL_Apellido, GB_LBL_Genero_L);
		
		GridBagConstraints GB_LBL_Genero_R = ConstruirGRIDHORIZONTAL(2,2);
		TB_Apellido.setFont(fuenteComun);
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
		add(TB_Apellido, GB_LBL_Genero_R);
	
		//FILA 3
		GridBagConstraints GW_LBL_ID_L = ConstruirGRIDWEST(1,3);
		LBL_DNI.setFont(fuenteComun);
		add(LBL_DNI, GW_LBL_ID_L);
		
		GridBagConstraints GB_LBL_ID_R = ConstruirGRIDHORIZONTAL(2,3);
		TB_DNI.setFont(fuenteComun);
		TB_DNI.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				 int key = e.getKeyChar();
		          boolean numeros = key >= 48 && key <= 57;
		            if (!numeros)
		            {
		                e.consume();
		            }
			}
		});
		add(TB_DNI, GB_LBL_ID_R);
		//
		BTN_Aceptar.setFont(fuenteComun);
		
		GridBagConstraints GB_BTN_Aceptar = ConstruirGRIDWEST(1, 4);
	
		add(BTN_Aceptar, GB_BTN_Aceptar);
	}

	public JButton getBTNAceptar() {
		return BTN_Aceptar;
	}

	public void setBTNAceptar(JButton bTN_Aceptar) {
		BTN_Aceptar = bTN_Aceptar;
	}

	public JTextField getTBNombre() {
		return TB_Nombre;
	}

	public void setTBNombre(JTextField tB_Nombre) {
		TB_Nombre = tB_Nombre;
	}

	public JTextField getTBApellido() {
		return TB_Apellido;
	}

	public void setTBApellido(JTextField tB_Apellido) {
		TB_Apellido = tB_Apellido;
	}

	public JTextField getTBDNI() {
		return TB_DNI;
	}

	public void setTBDNI(JTextField tB_DNI) {
		TB_DNI = tB_DNI;
	}

	
	public void mostrarMensaje(String mensaje)
	{
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
	public void setDefaultListModel(DefaultListModel<Persona> ModelReceived)
	{
		this.Lista = ModelReceived;
	}
		
	public GridBagConstraints ConstruirGRIDWEST(int X,int Y) {
		
		GridBagConstraints AUX_GB = new GridBagConstraints();
		AUX_GB.insets = new Insets(0, 0, 5, 5);
		AUX_GB.anchor = GridBagConstraints.CENTER;
		
		AUX_GB.gridx = X;
		AUX_GB.gridy = Y;
		return AUX_GB;
	}
		
	public GridBagConstraints ConstruirGRIDHORIZONTAL(int X,int Y) {
		
		GridBagConstraints AUX_GB = new GridBagConstraints();
		AUX_GB.insets = new Insets(0, 0, 5, 5);
		AUX_GB.fill = GridBagConstraints.HORIZONTAL;
		
		AUX_GB.gridx = X;
		AUX_GB.gridy = Y;
		return AUX_GB;
	}


}