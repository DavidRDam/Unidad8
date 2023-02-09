package Agenda;

import java.util.Scanner;

public class Programa {
	public static void main(String[] args) {
		Scanner teclado=new Scanner(System.in);
		Agenda a=new Agenda();
		a.cargarAgenda("Contactos.bin");
		int opcion=0;
		do{
			menu();
			opcion=teclado.nextInt();
			switch(opcion) {
			case 1:
				a.imprimirAgenda();
				break;
			case 2:
				System.out.println("¿Cúal es su nombre?");
				String nombre=teclado.next();
				System.out.println("¿Cúal es su teléfono?");
				String telefono=teclado.next();
				System.out.println("¿Cúal es su dirección?");
				String direccion=teclado.next();
				System.out.println("¿Cúal es su correo?");
				String email=teclado.next();
				a.añadirContacto(new Contacto(nombre,telefono,direccion,email));
				break;
			case 3:
				System.out.println("Dime el nombre del contacto que quieres eliminar");
				nombre=teclado.next();
				a.borrarContacto(nombre);
				break;
			case 4:
				a.guardarAgenda("Contactos.bin");
				System.out.println("Guardando y Saliendo...");
				break;
			
			}
		}while(opcion!=4);
	}

	private static void menu() {
		System.out.println();
		System.out.println("1)Imprimir agenda");
		System.out.println("2)Añadir contacto");
		System.out.println("3)Eliminar contacto");
		System.out.println("4)Salir");
	}
}
