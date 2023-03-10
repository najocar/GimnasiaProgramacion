package proyectoGimnasia.controller;

import proyectoGimnasia.interfaces.iGui;
import proyectoGimnasia.view.Gui;

public class Controller {
private iGui miGui= new Gui();
	
	public void ejecutarMenuPrincipal() {
		int opcion;
		do {
			miGui.muestraMenuPrincipal();
			opcion = miGui.leeEntero("Elige una opción: ");
			controlarMenuPrincipal(opcion);
		}while(opcion!=3);
	}
	
	public void controlarMenuPrincipal(int opcion) {
		switch (opcion) {
		case 1:
			ejecutarGestionGimnasta();
			break;
		case 2:
			ejecutarGestionCompeticion();
			break;
		case 3:
			salir();
			break;
		
		default: 
			miGui.muestraMensaje("Opción incorrecta");
		}
	}
	
	public void ejecutarGestionGimnasta() {
		
		
	}
	
	public void ejecutarGestionCompeticion() {
		
		
	}
	
	public void salir() {
        System.exit(0);
	}
}
