package Banco;

public class Cuenta {
	private String IBAN;
	private String cuenta;
	private String codigoTitualar;
	private String codigoAutorizado;
	private double saldo;
	
	
	public Cuenta(String iBAN, String cuenta, String codigoTitualar, String codigoAutorizado, double saldo) {
		super();
		IBAN = iBAN;
		this.cuenta = cuenta;
		this.codigoTitualar = codigoTitualar;
		this.codigoAutorizado = codigoAutorizado;
		this.saldo = saldo;
	}
	
	public String getIBAN() {
		return IBAN;
	}
	public void setIBAN(String iBAN) {
		IBAN = iBAN;
	}
	public String getCuenta() {
		return cuenta;
	}
	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}
	public String getCodigoTitualar() {
		return codigoTitualar;
	}
	public void setCodigoTitualar(String codigoTitualar) {
		this.codigoTitualar = codigoTitualar;
	}
	public String getCodigoAutorizado() {
		return codigoAutorizado;
	}
	public void setCodigoAutorizado(String codigoAutorizado) {
		this.codigoAutorizado = codigoAutorizado;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	void Ingresar(double cantidad) {
		this.setSaldo(this.getSaldo()+cantidad);
	}
	void retirarSaldo(double cantidad) {
		if(cantidad>this.getSaldo()) {
			System.out.println("No dispone de saldo suficiente");
		}
		else {
			this.setSaldo(this.getSaldo()-cantidad);
			System.out.println(this.getSaldo());
		}
		
	}
		

	@Override
	public String toString() {
		return "IBAN: " + IBAN + "\ncuenta: " + cuenta + "\n codigoTitualar: " + codigoTitualar
				+ "\n codigoAutorizado:" + codigoAutorizado + "\n saldo: " + saldo+" €";
	}
	
	public static void main(String[] args) {
		Cuenta c=new Cuenta("Es34423", "1234", "5678", "1234", 1000);
		System.out.println(c.toString());
		System.out.println(c.getSaldo());
		c.Ingresar(200);
		System.out.println(c.getSaldo());
		c.retirarSaldo(2000);
		c.retirarSaldo(200);
		System.out.println(c.getSaldo());
		
	}
	
}
