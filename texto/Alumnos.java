package texto;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Alumnos {
	
	public static void main(String[] args) {
		//Leer el fichero notas.txt
		try {
			Scanner entrada=new Scanner(new File ("notas.txt"));
			String cadena="";
			String linea[];
			while (entrada.hasNext()) {
				cadena=entrada.nextLine();//Lee con espacios en blanco
				linea=cadena.split(" ");//coratar por espacios en blanco
				double suma = 0;
				for(int i=2;i<linea.length;i++) {
					suma+=Integer.parseInt(linea[i]);
				}
				System.out.println(linea[0]+" "+linea[1]+" Tiene una nota media de "+((suma)/linea.length-2));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.err.println("El fichero no existe");
		}
		
	}
}
