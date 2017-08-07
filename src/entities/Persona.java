package entities;

public class Persona {
	
	private String nombre;
	private String apellido;
	private String dni;
	private boolean habilitado;
	private int idPersona;
	public boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}
	private String usuario;
	private String password;
	public static int ultnro;
	
	public Persona() {
		
	}
	
	public Persona(String nom, String ape, String dni, String usu, String contra) {
		this.nombre = nom;
		this.apellido = ape;
		this.dni = dni;
		this.habilitado = true;
		this.usuario = usu;
		this.password = contra;
		this.idPersona = ultnro++;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public int getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(int id) {
		this.idPersona = id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
