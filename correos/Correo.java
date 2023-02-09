package correos;

public class Correo {
	private String nombre;
	private String appellido1;
	private String curso;
	private String correo;
	
	public Correo(String nombre, String appellido1, String curso, String correo) {
		super();
		this.nombre = nombre;
		this.appellido1 = appellido1;
		this.curso = curso;
		this.correo = correo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAppellido1() {
		return appellido1;
	}

	public void setAppellido1(String appellido1) {
		this.appellido1 = appellido1;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Override
	public String toString() {
		return "Correo [nombre=" + nombre + ", appellido1=" + appellido1 + ", curso=" + curso + ", correo=" + correo
				+ "]";
	}
	
	
}
