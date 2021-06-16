package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.border.EmptyBorder;
import entidad.Persona;
import negocio.PersonaNegocio;
import presentacion.vista.EliminarPanel;
import presentacion.vista.ListaPanel;
import presentacion.vista.MainWindow;
import presentacion.vista.ModificarPanel;
import presentacion.vista.AgregarPanel;

public class Controlador implements ActionListener   {

	private MainWindow MainWin;
	private AgregarPanel pnlIngresoPersonas;
	private ListaPanel pnlListar;
	private EliminarPanel pnlEliminar;
	private ModificarPanel pnlModify;
	private PersonaNegocio pNeg;
	private ArrayList<Persona> personasEnTabla;
	
	//Constructor
	public Controlador(MainWindow vista, PersonaNegocio pNeg)
	{
		EmptyBorder border=  new EmptyBorder(15, 15, 15, 15);
		
		//Guardo todas las instancias que recibo en el constructor
		this.MainWin = vista;
		this.pNeg = pNeg;
		
		//Instancio los paneles
		this.pnlIngresoPersonas = new AgregarPanel();
		this.pnlIngresoPersonas.setBorder(border);
		
		this.pnlEliminar = new EliminarPanel();
		this.pnlEliminar.setBorder(border);
		
		this.pnlListar= new ListaPanel();
		this.pnlListar.setBorder(border);
		
		this.pnlModify = new ModificarPanel();
		this.pnlModify.setBorder(border);
		//Enlazo todos los eventos
		
		//Eventos menu del Frame principal llamado Ventana
		this.MainWin.getMenuAgregar().addActionListener(b->Click_Open_AgregarPanel(b));
		this.MainWin.getMenuEliminar().addActionListener(a->EventoClickMenu_AbrirPanel_EliminarPersona(a));
		this.MainWin.getMenuListar().addActionListener(a->Click_Open_ListarPanel(a));
		this.MainWin.getMenuModificar().addActionListener(a->EventoClickMenu_AbrirPanel_ModifyPersona(a));
		//Eventos PanelAgregarPersonas
		 this.pnlIngresoPersonas.getBTNAceptar().addActionListener(a->Click_Cargar_Persona(a));
		 //evetnso panelEliminar
		 this.pnlEliminar.getBtnEliminar().addActionListener(a->Click_Eliminar_Persona(a));
			
		 
		 this.pnlModify.getListado().addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
				Persona Selected=(Persona)pnlModify.getListado().getSelectedValue();
					pnlModify.getTBNombre().setText(Selected.getNombre());
					pnlModify.getTB_Apellido().setText(Selected.getApellido());
					pnlModify.getTB_Dni().setText(Selected.getDNIPersona());
				}
			});
			

		 this.pnlModify.getBtnModificar().addActionListener(a->Click_Modify_Persona(a));
		}
	
	

	//HABILITAR PANELES EVENTO
	public void  Click_Open_AgregarPanel(ActionEvent a)
	{		
		MainWin.setBounds(500, 100, 600, 300);
		MainWin.getContentPane().removeAll();
		MainWin.getContentPane().add(pnlIngresoPersonas);
		MainWin.getContentPane().repaint();
		MainWin.getContentPane().revalidate();
	}
	
	public void Click_Open_ListarPanel(ActionEvent a)
	{		
		MainWin.setBounds(500, 100, 700, 500);
		MainWin.getContentPane().removeAll();
		MainWin.getContentPane().add(pnlListar);
		MainWin.getContentPane().repaint();
		MainWin.getContentPane().revalidate();
		refrescarTablaLista();
	}

	public void EventoClickMenu_AbrirPanel_EliminarPersona(ActionEvent a)
	{		
		MainWin.setBounds(500, 100, 500, 500);
		MainWin.getContentPane().removeAll();
		MainWin.getContentPane().add(pnlEliminar);
		MainWin.getContentPane().repaint();
		MainWin.getContentPane().revalidate();
		refrescarTablaEliminar();
	}

	public void EventoClickMenu_AbrirPanel_ModifyPersona(ActionEvent a)
	{		
		MainWin.setBounds(500, 100, 500, 500);
		MainWin.getContentPane().removeAll();
		MainWin.getContentPane().add(pnlModify);
		MainWin.getContentPane().repaint();
		MainWin.getContentPane().revalidate();
		
		refrescarTablaModify();
	}
	
	//EventoClickBoton agregar persona en PanelAgregarPersonas
	public void Click_Cargar_Persona(ActionEvent a) {
		
		String nombre = this.pnlIngresoPersonas.getTBNombre().getText();
		String apellido = this.pnlIngresoPersonas.getTBApellido().getText();
		String dni = this.pnlIngresoPersonas.getTBDNI().getText();
		Persona nuevaPersona = new Persona(dni, nombre, apellido);
		String mensaje="";

		if(nombre.isEmpty() || apellido.isEmpty() || dni.isEmpty()) {
			this.pnlIngresoPersonas.mostrarMensaje("Todas las cajas de texto deben contener informacion");
			return;
		}
		
		boolean Verificado = pNeg.Verify(nuevaPersona);
		
		if (!Verificado) {
			mensaje="Ese Dni ya existe";
			this.pnlIngresoPersonas.mostrarMensaje(mensaje);
			return;
		}
		
		boolean estado  = pNeg.insert(nuevaPersona);
		if(estado==true)
		{
			mensaje="Persona agregada con exito";
			this.pnlIngresoPersonas.getTBNombre().setText("");
			this.pnlIngresoPersonas.getTBApellido().setText("");
			this.pnlIngresoPersonas.getTBDNI().setText("");
		}
		
		this.pnlIngresoPersonas.mostrarMensaje(mensaje);
	
	}
	
	public void Click_Eliminar_Persona(ActionEvent a) {
		Persona Selected=(Persona)pnlEliminar.getListado().getSelectedValue();
        if(pNeg.delete(Selected)) {
        	this.pnlEliminar.mostrarMensaje("Se elimino correctamente a la persona");
        	refrescarTablaEliminar();
        	return;
        }
        this.pnlEliminar.mostrarMensaje("No se pudo eliminar");
        refrescarTablaEliminar();
	}
	
	public void Click_Modify_Persona(ActionEvent a) {
		
		String nombre = this.pnlModify.getTBNombre().getText();
		String apellido = this.pnlModify.getTB_Apellido().getText();
		String dni = this.pnlModify.getTB_Dni().getText();
		Persona nuevaPersona = new Persona(dni, nombre, apellido);
		
		String mensaje = "";
		
		if(nombre.isEmpty()||apellido.isEmpty()||dni.isEmpty()) {
			this.pnlModify.mostrarMensaje("Es necesario completar todos los campos");
			return;
		}
		
		if(pNeg.modify(nuevaPersona))
		{
			mensaje="Persona Modificada con exito";
			this.pnlModify.getTBNombre().setText("");
			this.pnlModify.getTB_Apellido().setText("");
			this.pnlModify.getTB_Dni().setText("");
			this.pnlModify.mostrarMensaje(mensaje);
		}
		else {
			this.pnlModify.mostrarMensaje("No se pudo agregar a la persona");
		}
		this.refrescarTablaModify();
	}
		
	private void refrescarTablaModify()
	{
		this.personasEnTabla = (ArrayList<Persona>) pNeg.readAll();
		this.pnlModify.llenarTabla(this.personasEnTabla);
	}
	
	private void refrescarTablaLista()
	{
		this.personasEnTabla = (ArrayList<Persona>) pNeg.readAll();
	
		this.pnlListar.llenarTabla(this.personasEnTabla);
	}
	
	private void refrescarTablaEliminar()
	{
		this.personasEnTabla = (ArrayList<Persona>) pNeg.readAll();
	
		this.pnlEliminar.llenarTabla(this.personasEnTabla);
	}
	
	public void inicializar()
	{
		this.MainWin.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
