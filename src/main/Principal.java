package main;

import negocio.PersonaNegocio;
import negocioImpl.PersonaNegocioImpl;
import presentacion.controlador.Controlador;
import presentacion.vista.MainWindow;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainWindow vista = new MainWindow();
		PersonaNegocio negocio = new PersonaNegocioImpl();
		Controlador controlador = new Controlador(vista, negocio);
		controlador.inicializar();
	}
	

}
