package Ferreteria;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Utilidades {
	public ArrayList<Pieza> leerPiezas(String filename) {
		ArrayList<Pieza> u=new ArrayList<>();
		try {
			Scanner entrada=new Scanner(new File(filename));
			String cadena;
			String linea[];
			//Salto la línea de cabecera
			cadena=entrada.nextLine();
			while(entrada.hasNext()) {
				cadena=entrada.nextLine();
				linea=cadena.split(";");
				//El parse lo que sea sirve àra convertir el string que le estamos pasando a lo que diga el parse por ejemple el parseInt pasa un String a Int
				u.add(new Pieza(Integer.parseInt(linea[0]),linea[1],Integer.parseInt(linea[2]),Double.parseDouble(linea[3])));
			}
//			for(Pieza p: u) {
//				System.out.println(p);
//			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
		
	}
	
	 public ArrayList<Proveedor> leerProveedor(String filename) {
			ArrayList<Proveedor> u=new ArrayList<>();
			try {
				Scanner entrada=new Scanner(new File(filename));
				String cadena;
				String linea[];
				//Salto la línea de cabecera
				cadena=entrada.nextLine();
				while(entrada.hasNext()) {
					cadena=entrada.nextLine();
					linea=cadena.split(";");
					u.add(new Proveedor(Integer.parseInt(linea[0]),linea[1],linea[2]));
				}
//				for(Proveedor p: u) {
//					System.out.println(p);
//				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return u;
	 }
		public static void main(String[] args) {
			Utilidades ut=new Utilidades();
			ut.leerPiezas("piezas.csv");
			ut.leerProveedor("proveedores.csv");
			
		}
}
