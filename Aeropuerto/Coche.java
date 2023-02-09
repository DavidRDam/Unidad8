package Aeropuerto;

public class Coche extends Vehiculo implements Valida{
	int numeroPuertas;

	public Coche() {
		super();
		this.numeroPuertas = 0;
	}

	public Coche(String matrícula, String color, String marca, String modelo, int numeroPuertas) {
		super(matrícula, color, marca, modelo);
		this.numeroPuertas = numeroPuertas;
	}



	public int getNumeroPuertas() {
		return numeroPuertas;
	}


	public void setNumeroPuertas(int numeroPuertas) {
		this.numeroPuertas = numeroPuertas;
	}


	@Override
	public String toString() {
		return "Coche [numeroPuertas=" + numeroPuertas + ", Matrícula=" + Matrícula + ", Color=" + Color + ", Marca="
				+ Marca + ", Modelo=" + Modelo + "]";
	}

	@Override
	public boolean valida(String cadena) {
		if(cadena.matches("^[0-9]{4}+-+[A-Z]$")) {
			return true;
		}else {
			return false;
		}
	}
}
