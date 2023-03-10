package proyectoGimnasia.view;

import java.util.Scanner;

import proyectoGimnasia.interfaces.iGui;

public class Gui implements iGui{
	
	public void muestraMenuPrincipal() {
        System.out.println("1. Gestión Gimnastas");
        System.out.println("2. Gestión Competición");
        System.out.println("3. Salir");
	}

	public int leeEntero(String msg) {
		System.out.println(msg);
		Scanner teclado = new Scanner(System.in);
		return teclado.nextInt();
	}

	public String leeString(String msg) {
		System.out.println(msg);
		Scanner teclado = new Scanner(System.in);
		return teclado.next();
	}

	public void muestraMensaje(String msg) {
		System.out.println(msg);
	}
}
