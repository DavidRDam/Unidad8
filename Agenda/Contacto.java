package Agenda;

import java.io.Serializable;

public class Contacto implements Serializable{
	public String nombre;
	public String telefono;
	public String direccion;
	public String correo;
	
	public Contacto(String nombre, String telefono, String direccion, String correo) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
		this.correo = correo;
	}
	
	public Contacto() {
		super();
		this.nombre = "";
		this.telefono = "";
		this.direccion = "";
		this.correo = "";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Override
	public String toString() {
		return "Contacto [nombre=" + nombre + ", telefono=" + telefono + ", direccion=" + direccion + ", correo="
				+ correo + "]";
	}
	
	
}
