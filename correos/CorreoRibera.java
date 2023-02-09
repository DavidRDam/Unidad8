package correos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class CorreoRibera {
	private ArrayList<Correo> listacorreos;

	public CorreoRibera(ArrayList<Correo> listacorreos) {
		this.listacorreos = new ArrayList<>();
	}
	
	
	public CorreoRibera() {
		this.listacorreos = new ArrayList<>();
	}


	public ArrayList<Correo> getListacorreos() {
		return listacorreos;
	}

	public void setListacorreos(ArrayList<Correo> listacorreos) {
		this.listacorreos = listacorreos;
	}

	public static void main(String[] args) {
		CorreoRibera c=new CorreoRibera();
		String curso="";
		Scanner entrada;
		try {
			entrada = new Scanner(new File ("AlumnosDAM.csv"));
			//Saltar 5 líneas
			entrada.nextLine();
			entrada.nextLine();
			entrada.nextLine();
			entrada.nextLine();
			entrada.nextLine();
			String cadena="";
			String linea[];
			while(entrada.hasNext()) {
				cadena=entrada.nextLine();
				linea=cadena.split(";");
				String nombreApe=linea[0];
				curso=linea[2];
				String abreviacionCurso=curso.substring(0, curso.length()-1).toLowerCase();
//				System.out.println(nombreApe+" "+curso);
				String nombre=c.getNombre(nombreApe);
				String ap1=c.getApellido1(nombreApe);

//				System.out.println("Correo: "+nombre+ap1+"@"+curso+".es");
				String correo=abreviacionCurso+"_"+nombre+ap1+"@riberadeltajo.es";
				c.getListacorreos().add(new Correo(nombre,ap1,curso,correo));
			}
//			for (int i = 0; i < c.getListacorreos().size(); i++) {
//				System.out.println(c.getListacorreos().get(i).getCorreo());
//			}
			
			c.generarFicheroTexto(curso);
			c.generarFicheroCSV(curso);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	private void generarFicheroCSV(String curso) {
		try {
			PrintWriter salida=new PrintWriter(new File("Correos"+curso+".csv"));
			salida.println("Número;Alumno");
			salida.println(curso);
			int numero=1;
			for(Correo c: this.listacorreos) {
				salida.println(numero+";"+c.getCorreo());
				numero++;
			}
			salida.flush();
			salida.close();
			System.out.println("Fichero Correos"+curso+".csv creado");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	private void generarFicheroTexto(String curso) {
		
		try {
			PrintWriter salida=new PrintWriter(new File("Correos"+curso+".txt"));
			salida.println("Correos de "+curso);
			salida.println();
			salida.println();
			for(Correo c: this.listacorreos) {
				salida.println(c.getCorreo());
			}
			salida.flush();
			salida.close();
			System.out.println("Fichero Correos"+curso+".txt creado");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	private String getApellido1(String nombreApe) {
		String palabra[]=nombreApe.split(",");
		String nombre=palabra[0].trim().toLowerCase();
		
		return this.quitarTildes(nombre);
	}


	private String getNombre(String nombreApe) {
		String palabra[]=nombreApe.split(",");
		String nombre=palabra[1].trim().toLowerCase();
			for (int i = 0; i < nombre.length(); i++) {
				if(nombre.charAt(i)==' ') {
					palabra=nombre.split(" ");
					nombre=palabra[0]+palabra[1];
			}
		}

		return this.quitarTildes(nombre);
	}
	
	private String quitarTildes(String nombre) {
		String palabra[];
//			if(nombre.charAt(i)=='á') {
			nombre=nombre.replace('á', 'a');
//			}
//			if(nombre.charAt(i)=='é') {
			nombre=nombre.replace('é', 'e');
//			}
//			if(nombre.charAt(i)=='í') {
			nombre=nombre.replace('í', 'i');	
//			}
//			if(nombre.charAt(i)=='ó') {
			nombre=nombre.replace('ó', 'o');
//		}
//			if(nombre.charAt(i)=='ú') {
			nombre=nombre.replace('ú', 'u');
//			}
			nombre=nombre.replace('ñ', 'n');
		return nombre;
		
	}
	
}
