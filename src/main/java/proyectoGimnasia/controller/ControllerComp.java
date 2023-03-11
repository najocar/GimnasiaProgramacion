package proyectoGimnasia.controller;

import proyectoGimnasia.interfaces.iControllerComp;
import proyectoGimnasia.interfaces.iUtils;
import proyectoGimnasia.model.Competicion;
import proyectoGimnasia.model.Prueba;
import proyectoGimnasia.model.RepComp;
import proyectoGimnasia.utils.Utils;
import proyectoGimnasia.view.GuiComp;

public class ControllerComp implements iControllerComp{
	private GuiComp gui = new GuiComp();
	private iUtils utils = new Utils();
	private RepComp repComp = new RepComp();
	
	public void empezar(){
		execMainMenu();
	}
	
	public void execMainMenu() {
		int opcion = 0;
		do {
			gui.showMainMenu();
			opcion = utils.readInt();
			controlMainMenu(opcion);
		}while(opcion != 3);
	}
	
	public void controlMainMenu(int option) {
		switch (option) {
		case 1:
			execRegistrarComp();
			break;
		case 2:
			execBorrarComp();
			break;
		case 3:
			execUpdate();
			break;
		case 4:
			ListarComp();
			execMainMenu();
			break;
		case 5:
			execRegistrarPrueba();
			break;
		case 6:
			execRemovePrueba();
			break;

		default:
			utils.print("Incorrecto");
			execMainMenu();
			break;
		}
	}
	
	@Override
	public void execRegistrarComp() {
		String nombre = utils.readString("Nombre: ");
		String descripcion = utils.readString("Descripcion: ");
		Competicion nueva = new Competicion(nombre, descripcion);
		registrarComp(nueva);
	}

	@Override
	public void registrarComp(Competicion c) {
		if (repComp.registrarComp(c)) {
			utils.print("Registrado correctamente");
		}else {
			utils.print("Error, no ha podido ser registrado");
		}
		
	}

	@Override
	public void execBorrarComp() {
		ListarComp();
		String nombre = utils.readString("Escribe el nombre de la competición que quieres borrar: ");
		borrarComp(nombre);
	}

	@Override
	public void borrarComp(String n) {
		if (repComp.borrarComp(n)) {
			utils.print("Eliminado correctamente");
		}else {
			utils.print("Error, no ha podido ser eliminado");
		}
	}

	@Override
	public void execUpdate() {
		ListarComp();
		String nombreComp = utils.readString("Escribe el nombre de la competición que quieres Editar: ");
		Competicion comp = repComp.find(nombreComp);
		if(comp != null) {
			utils.print("Elige un nuevo nombre, el anterior es: " + comp.getNombre());
			String nombre = utils.readString("Nombre: ");
			utils.print("Elige una nueva descripcion, la anterior es: " + comp.getDescripcion());
			String descripcion = utils.readString("Descripcion: ");
			Competicion nueva = new Competicion(nombre, descripcion);
			update(repComp.findIndex(comp), nueva, comp);
		}else {
			utils.print("Competición no encontrada");
			execMainMenu();
		}
	}

	@Override
	public void update(int index, Competicion c, Competicion aux) {
		if (repComp.updateComp(index, c, aux)) {
			utils.print("Editado correctamente");
		}else {
			utils.print("Error, no ha podido ser editado (ya existe una competición con el mismo nombre)");
		}
		execMainMenu();
	}

	@Override
	public void ListarComp() {
		String competiciones = repComp.ListarComp();
		utils.print(competiciones);
		
	}
	
	public void execRegistrarPrueba() {
		ListarComp();
		String nombreComp = utils.readString("Escribe el nombre de la competición a la que quieres añadir pruebas: ");
		Competicion comp = repComp.find(nombreComp);
		if(comp != null) {
			utils.print(comp.toString());
			String nombre = utils.readString("Escribe el nombre de la prueba: ");
			Prueba nueva = new Prueba(nombre);
			registrarPrueba(repComp.findIndex(comp), nueva);
		}else {
			utils.print("Competición no encontrada");
			execMainMenu();
		}
	}
	
	public void registrarPrueba(int index, Prueba c) {
		if (repComp.addPrueba(index, c)) {
			utils.print("Añadida correctamente");
		}else {
			utils.print("Error, no ha podido ser añadida");
		}
		execMainMenu();
	}
	
	public void execRemovePrueba() {
		ListarComp();
		String nombreComp = utils.readString("Escribe el nombre de la competición a la que quieres eliminar pruebas: ");
		Competicion comp = repComp.find(nombreComp);
		if(comp != null) {
			utils.print(comp.toString());
			String nombre = utils.readString("Escribe el nombre de la prueba: ");
			removePrueba(repComp.findIndex(comp), nombre);
		}else {
			utils.print("Competición no encontrada");
			execMainMenu();
		}
	}
	
	public void removePrueba(int index, String nombre) {
		if (repComp.removePrueba(index, nombre)) {
			utils.print("Eliminada correctamente");
		}else {
			utils.print("Error, no ha podido ser eliminada");
		}
		execMainMenu();
	}
	
	//contrucción --------------------------------
	public void execUpdatePrueba() {
		ListarComp();
		String nombreComp = utils.readString("Escribe el nombre de la competición a la que quieres editar pruebas: ");
		Competicion comp = repComp.find(nombreComp);
		if(comp != null) {
			utils.print(comp.toString());
			String nombre = utils.readString("Escribe el nombre de la prueba: ");
			removePrueba(repComp.findIndex(comp), nombre);
		}else {
			utils.print("Competición no encontrada");
			execMainMenu();
		}
	}
	
	public void updatePrueba(int index, String nombre) {
		if (repComp.removePrueba(index, nombre)) {
			utils.print("Eliminada correctamente");
		}else {
			utils.print("Error, no ha podido ser eliminada");
		}
		execMainMenu();
	}

}
