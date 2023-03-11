package proyectoGimnasia.interfaces;

import proyectoGimnasia.model.Competicion;

public interface iControllerComp {
	void execRegistrarComp();
	void registrarComp(Competicion c);
	void execBorrarComp();
	void borrarComp(String n);
	void execUpdate();
	void update(int index, Competicion c, Competicion aux);
	void ListarComp();
}
