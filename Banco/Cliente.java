package Banco;

import java.util.ArrayList;

public class Cliente {
	private String codigoCliente;
	private String dni;
	private String nombre;
	private String apellidos;
	private ArrayList<Cuenta> cuentas;
	
//	getters and seters
	
	public String getCodigoCliente() {
		return codigoCliente;
	}
	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public ArrayList<Cuenta> getCuentas() {
		return cuentas;
	}
	public void setCuentas(ArrayList<Cuenta> cuentas) {
		this.cuentas = new ArrayList<>();
	}
//	constructor con todos los parametros
	public Cliente(String codigoCliente, String dni, String nombre, String apellidos, ArrayList<Cuenta> cuentas) {
		super();
		this.codigoCliente = codigoCliente;
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.cuentas = cuentas;
	}
	
//	Constructor con todos los parámetros menos el ALç
	
public Cliente(String codigoCliente, String dni, String nombre, String apellidos) {
	super();
	this.codigoCliente = codigoCliente;
	this.dni = dni;
	this.nombre = nombre;
	this.apellidos = apellidos;
	this.cuentas=new ArrayList<>();
}
@Override
public String toString() {
	return "Cliente: " + codigoCliente + ", dni=" + dni + ", nombre=" + nombre + ", apellidos="+ apellidos;
}

private void mostrarCuentas() {
	int cont=0;
	for (Cuenta a : cuentas) {
		System.out.println(cont+"º Cuenta: " +a.getCuenta() );
		System.out.println("\tSaldo: " +a.getSaldo() );
		cont++;
	}
}
private void totalCuentas() {
	float suma=0;
	for (Cuenta a : cuentas) {
		suma=(float) (suma+a.getSaldo());
	}
}

}

