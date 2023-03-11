package proyectoGimnasia.model;

public class Prueba {
	private String nombre;

	public Prueba(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "     Prueba nombre=" + nombre ;
	}
	
	
}
