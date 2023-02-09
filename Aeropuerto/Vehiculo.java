package Aeropuerto;

public abstract class Vehiculo{
	public String Matrícula;
	public String Color;
	public String Marca;
	public String Modelo;
	
	public Vehiculo() {
		Matrícula = "";
		Color = "";
		Marca = "";
		Modelo = "";
	}
	
	public Vehiculo(String matrícula, String color, String marca, String modelo) {
		Matrícula = matrícula;
		Color = color;
		Marca = marca;
		Modelo = modelo;
	}
	public String getMatrícula() {
		return Matrícula;
	}
	public void setMatrícula(String matrícula) {
		Matrícula = matrícula;
	}
	public String getColor() {
		return Color;
	}
	public void setColor(String color) {
		Color = color;
	}
	public String getMarca() {
		return Marca;
	}
	public void setMarca(String marca) {
		Marca = marca;
	}
	public String getModelo() {
		return Modelo;
	}
	public void setModelo(String modelo) {
		Modelo = modelo;
	}
	
	
}
