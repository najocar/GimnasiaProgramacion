package proyectoGimnasia.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RepComp {
	List<Competicion> competiciones = new ArrayList<>();
	
	public boolean registrarComp(Competicion c) {
		if(!competiciones.contains(c)) {
			return competiciones.add(c);
		}else {
			return false;
		}
	}
	
	public String ListarComp() {
		String result = "";
		int n = 1;
		for (Competicion c : competiciones) {
			if (c != null) {
				result += String.valueOf(n) + " " + c + "\n";
				n++;
			}
		}
		return result;
	}
	
	public boolean borrarComp(String n) {
		boolean result = false;
		Iterator<Competicion> it = competiciones.iterator();
		while(it.hasNext()) {
			Competicion aux = it.next();
			if(aux.getNombre().trim().equals(n.trim())) {
				it.remove();
				result = true;
			}
		}
		return result;
	}
	
	public Competicion find(String n) {
		Competicion result = null;
		Iterator<Competicion> it = competiciones.iterator();
		while(it.hasNext()) {
			Competicion aux = it.next();
			if(aux.getNombre().trim().equals(n.trim())) {
				result = aux;
			}
		}
		return result;
	}
	
	public int findIndex(Competicion c) {
		return competiciones.indexOf(c);
	}
	
	public boolean updateComp(int n, Competicion c, Competicion aux) {
		if(!competiciones.contains(c) || c.equals(aux)) {
			if(!aux.getPruebas().isEmpty()) {
				competiciones.set(n, c);
				for (Prueba prueba : aux.getPruebas()) {
					addPrueba(n, prueba);
				}
				return true;
			}else {
				competiciones.set(n, c);
				return true;
			}
		}else {
			return false;
		}
	}
	
	public boolean addPrueba(int n, Prueba p) {
		return competiciones.get(n).addPrueba(p);
	}
	
	public boolean removePrueba(int n, String nombre) {
		return competiciones.get(n).removePrueba(nombre);
	}
}
