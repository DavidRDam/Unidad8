package Ferreteria;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Programa {
	ArrayList<Pieza> piezas;
	ArrayList<Proveedor> prov;
	
	public Programa() {
		super();
		this.piezas = new ArrayList<Pieza>();
		this.prov = new ArrayList<Proveedor>();
	}
	public ArrayList<Pieza> getPiezas() {
		return piezas;
	}
	public void setPiezas(ArrayList<Pieza> piezas) {
		this.piezas = piezas;
	}
	public ArrayList<Proveedor> getProv() {
		return prov;
	}
	public void setProv(ArrayList<Proveedor> prov) {
		this.prov = prov;
	}
	
	public static void main(String[] args) {
		Programa p=new Programa();
		Utilidades u=new Utilidades();
		p.setPiezas(u.leerPiezas("piezas.csv"));
		p.setProv(u.leerProveedor("proveedores.csv"));
		p.generarFichero("ProveedorPiezas.txt");
		

		
	}
	private void generarFichero(String filename) {
		PrintWriter salida;
		double peso=0;
		try {
			salida = new PrintWriter(new File(filename));
			for (Proveedor prov:this.getProv()) {
				salida.println("El proveedor "+prov.getNombreProveedor());
				peso=0;
				for(Pieza piezas: this.getPiezas()) {
					if(piezas.getProveedor()==prov.getCodProveedor()) {
						peso=peso+piezas.getPeso();
						salida.println("\t*)"+Character.toUpperCase(piezas.getNombrePieza().charAt(0))+piezas.getNombrePieza().substring(1));
					}
				}
				salida.println("Peso total: "+peso);
				
			}
			System.out.println("El Fichero ha sido generado");
			salida.flush();
			salida.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
