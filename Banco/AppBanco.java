package Banco;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class AppBanco {

	private ArrayList<Cliente> clientes;
	
	
	public AppBanco() {
		this.clientes = new ArrayList<>();
	}

	public AppBanco(ArrayList<Cliente> clientes) {
		this.clientes = new ArrayList<>();
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	public static void main(String[] args) {
		Cuenta c1=new Cuenta("ES234211", "Nomina", "B123", "A123", 1000);
		Cuenta c2=new Cuenta("ES234212", "Ahorro", "B123", "A125", 10000);
		Cliente cli=new Cliente("B123", "123H", "Francisco", "Álvarez");
		cli.getCuentas().add(c1);
		cli.getCuentas().add(c2);
		Cuenta c3=new Cuenta("ES234211", "Ahorro Boda", "B124", "A128", 14200);
		Cuenta c4=new Cuenta("ES234212", "Compartida", "B124", "A129", 17000);
		Cliente cli2=new Cliente("B124", "11111J", "Marta", "López", new ArrayList<>());
		cli2.getCuentas().add(c4);
		cli2.getCuentas().add(c3);
		////////////////////////////////////////////////////
		AppBanco app=new AppBanco();
		app.getClientes().add(cli);
		app.getClientes().add(cli2);
		int opcion=0;
		Scanner teclado=new Scanner(System.in);
		
		do {
		app.menu();
		opcion=teclado.nextInt();
		switch(opcion) {
		case 1:
		app.nuevoCliente();
		break;
		case 2:
		app.mostrarClientes();
		break;
		case 3:
		System.out.println("Codigo cliente:");
		String codigo=teclado.next();
		app.accesoCliente(codigo);
		break;
		}
		}while(opcion!=4);
		}


	

	@SuppressWarnings("unlikely-arg-type")
	private void accesoCliente(String codigo) {
		double total=0;
		Scanner teclado=new Scanner(System.in);
		int op=0;
		for(int i=0; i<this.getClientes().size(); i++) {
			if(codigo.equals(this.getClientes().get(i).getCodigoCliente())) {
					System.out.println("Código cliente: ");
					System.out.println(getClientes().get(i).getCodigoCliente());
					for (int j = 0; j < this.getClientes().get(i).getCuentas().size(); j++) {
						System.out.println("\t"+getClientes().get(i).getCuentas().get(j).getCuenta()+" "+getClientes().get(i).getCuentas().get(j).getSaldo()+"€");
						total+=getClientes().get(i).getCuentas().get(j).getSaldo();
					}
					
					System.out.println("Total: "+total+"€");
					System.out.println("¿De que cuenta quieres operar?");
					int cuenta=teclado.nextInt();
					cuenta=cuenta-1;
							System.out.println("1. Ingresar");
							System.out.println("2. Retirar");
							op=teclado.nextInt();
							if(op==1) {
								System.out.println("¿Qué cantidad quieres introducir?");
								double dinero=teclado.nextDouble();
								getClientes().get(i).getCuentas().get(cuenta).Ingresar(dinero);
							}
							if(op==2) {
								System.out.println("¿Qué cantidad quieres sacar?");
								double dinero=teclado.nextDouble();
								getClientes().get(i).getCuentas().get(cuenta).retirarSaldo(dinero);
							}
						}
						
					}
						
					}
					
			
		
		
	

	private void mostrarClientes() {
		for (Cliente cli : clientes) {
			System.out.println(cli.getNombre());
			System.out.println("\tcodigoCliente: "+cli.getCodigoCliente());
			System.out.println("\tdniCliente: "+cli.getDni());
		}
	}

	private void nuevoCliente() {
		Scanner teclado=new Scanner(System.in);
			String codigo="B"+(int) (1+Math.random()*999);
			System.out.println("DNI: ");
			String dni=teclado.next();
			System.out.println("Nombre: ");
			String nombre=teclado.next();
			System.out.println("Apellidos: ");
			String apellidos=teclado.next();
			Cliente cliente=new Cliente(codigo, dni, nombre, apellidos);
			clientes.add(cliente);
		}
	

	private void menu() {
		System.out.println("1. Alta cliente");
		System.out.println("2. Mostrar clientes");
		System.out.println("3. Acceso a cliente");
		System.out.println("\t1. Ingresar");
		System.out.println("\t2. Retirar");
		System.out.println("4. Salir");
	}
}
