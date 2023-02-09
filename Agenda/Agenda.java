package Agenda;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Agenda{
	private ArrayList<Contacto>Lista;

	public Agenda() {
		super();
		this.Lista = new ArrayList<Contacto>();
	}

	public ArrayList<Contacto> getLista() {
		return Lista;
	}

	public void setLista(ArrayList<Contacto> lista) {
		Lista = lista;
	}
	
	public void cargarAgenda(String filename) {
		try {
			FileInputStream fi=new FileInputStream(filename);
			ObjectInputStream is=new ObjectInputStream(fi);
			Contacto c=null;
			while(is!=null) {
				try {
					c=(Contacto)is.readObject();
					this.añadirContacto(c);
					
				} catch (Exception e) {
					is=null;
				}
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void guardarAgenda(String filename) {
		try {
			FileOutputStream fo=new FileOutputStream(filename);
			ObjectOutputStream os=new ObjectOutputStream(fo);
			for(Contacto c:this.getLista()) {
				//Escribimos cada objeto en el fichero
				os.writeObject(c);
			}
				fo.close();
				os.close();
				
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void imprimirAgenda() {
		System.out.println("Los contactos son:");
		for(Contacto c: this.getLista()) {
			System.out.println(c.getNombre()+" "+c.getTelefono());
		}
	}
	
	public void añadirContacto(Contacto c) {
		this.getLista().add(c);
	}
	
	public void borrarContacto(String nombre) {
		for (int i = 0; i < this.getLista().size(); i++) {
			if(this.getLista().get(i).getNombre().equalsIgnoreCase(nombre)) {
				this.getLista().remove(i);
			}
		}
	}
	public static void main(String[] args) {
		Agenda agenda=new Agenda();
		Contacto c=new Contacto("Marta","12345","tupu","marta@mail.com");
		Contacto c1=new Contacto("Paco","64565","tuma","marta@mail.com");
		Contacto c2=new Contacto("Luis","89845","tupa","marta@mail.com");
		
		agenda.añadirContacto(c1);
		agenda.añadirContacto(c);
		agenda.añadirContacto(c2);
		agenda.guardarAgenda("Contactos.bin");
		agenda.getLista().clear();
		//Cargar lso contactos en el fichero
		agenda.cargarAgenda("Contactos.bin");
		agenda.imprimirAgenda();
	}
	}

