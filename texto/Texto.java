package texto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Texto {
	public static void main(String[] args) {
//		//Crear Fichero
//		File f=new File("numeros.txt");
//		Scanner teclado=new Scanner(System.in);
//		try {
//			PrintWriter salida=new PrintWriter(f);
//			int numero=0;
//			do {
//				System.out.println("Dame un número");
//				numero=teclado.nextInt();
//				salida.println(numero);
//			}while(numero!=0);
//			
//			salida.flush();
//			salida.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		Scanner teclado=new Scanner(System.in);
		FileWriter f=null;
		try {
			 f=new FileWriter("numeros.txt",true);
			 PrintWriter salida=new PrintWriter(f);
				int numero=0;
				do {
					System.out.println("Dame un número");
					numero=teclado.nextInt();
					salida.println(numero);
				}while(numero!=0);
				
				salida.flush();
				salida.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Leemos de fichero");
		//Leer fichero
		try {
			Scanner entrada=new Scanner(new File("numeros.txt"));
			int num=0;
			while(entrada.hasNext()) {
				num=entrada.nextInt();
				System.out.println(num);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
