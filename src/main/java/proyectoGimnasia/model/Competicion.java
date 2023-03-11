package proyectoGimnasia.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Competicion {
	private String nombre;
	private String descripcion;
	List<Prueba> pruebas = new ArrayList<>();
	
	public Competicion(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.pruebas = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Prueba> getPruebas() {
		return pruebas;
	}

	public void setPruebas(List<Prueba> pruebas) {
		this.pruebas = pruebas;
	}
	
	public boolean addPrueba(Prueba prueba) {
		if(!pruebas.contains(prueba)) {
			return this.getPruebas().add(prueba);
		}else {
			return false;
		}
	}
	
	public boolean removePrueba(String n) {
		boolean result = false;
		Iterator<Prueba> it = pruebas.iterator();
		while(it.hasNext()) {
			Prueba aux = it.next();
			if(aux.getNombre().trim().equals(n.trim())) {
				it.remove();
				result = true;
			}
		}
		return result;
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Competicion other = (Competicion) obj;
		return Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Competicion: \n" +
				"  Nombre = " + nombre + 
				"  Descripcion = " + descripcion + 
				"  Pruebas: \n" + pruebas;
	}
	
	
	
}
