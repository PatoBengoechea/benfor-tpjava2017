package entities;

public class Elemento {
	private int idElemento;
	private String nombre;
	private String descripcion;
	private int cantidad;
	public int getIdElemento() {
		return idElemento;
	}
	public void setIdElemento(int idElemento) {
		this.idElemento = idElemento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

}
