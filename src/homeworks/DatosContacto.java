package homeworks;

public class DatosContacto {
	
	String nombre;
	String mensaje;
	public String asunto;
	public String email;
	
	public DatosContacto( String nombre, String mensaje, String asunto, String email) {
		this.nombre = nombre;
		this.asunto = asunto;
		this.email = email;
		this.mensaje = mensaje;
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getMensaje() {
		return mensaje;
	}

	public String getAsunto() {
		return asunto;
	}

	public String getEmail() {
		return email;
	}

}
