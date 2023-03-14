package proyectoGimnasia.interfaces;

import proyectoGimnasia.model.Competicion;

public interface iControllerComp {
	void empezar();
	void execMainMenu();
	void controlMainMenu(int option);
	void execRegistrarComp();
	void registrarComp(Competicion c);
	void execBorrarComp();
	void borrarComp(String n);
	void execUpdate();
	void update(int index, Competicion c, Competicion aux);
	void ListarComp();
	void execRegistrarPrueba();
	void registrarPrueba(int index, Prueba c);
	void execRemovePrueba();
	void removePrueba(int index, String nombre);
	void execUpdatePrueba();
	void updatePrueba(int index, String nombre);
}
