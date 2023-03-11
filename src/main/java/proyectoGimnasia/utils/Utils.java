package proyectoGimnasia.utils;

import java.util.Scanner;

import proyectoGimnasia.interfaces.iUtils;

public class Utils implements iUtils{

	@Override
	public int readInt(String msg) {
		Scanner teclado = new Scanner(System.in);
		int n = -1;
		print(msg);
		do {
			try {
				n = teclado.nextInt();
			} catch (Exception e) {
				print("Ha ocurrido un error. Vuelve a introducir el valor \n");
				teclado.next();
			}
		}while(n == -1);
		return n;
	}
	
	@Override
	public int readInt() {
		Scanner teclado = new Scanner(System.in);
		int n = -1;
		do {
			try {
				n = teclado.nextInt();
			} catch (Exception e) {
				print("Ha ocurrido un error. Vuelve a introducir el valor \n");
				teclado.next();
			}
		}while(n == -1);
		return n;
	}

	@Override
	public String readString(String msg) {
		Scanner teclado = new Scanner(System.in);
		teclado.useDelimiter("\n");
		String frase = null;
		print(msg);
		do {
			try {
				frase = teclado.next();
			} catch (Exception e) {
				print("Ha ocurrido un error. Vuelve a introducir el dato \n");
				teclado.next();
			}
		}while(frase == null);
		return frase;
	}

	@Override
	public void print(String msg) {
		System.out.println(msg);
		
	}

}
