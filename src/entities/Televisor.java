package entities;

public class Televisor {
	private int idTelevisor;
	private String marca;
	private String descripcion;
	private int cantidad;
	private String modelo;
	private double precio;
	public double getPrecio() {
		return precio;
	}
	public String getSPrecio(){
		return ("" + precio + "");
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getIdTelevisor() {
		return idTelevisor;
	}
	public void setIdTelevisor(int idTelevisor) {
		this.idTelevisor = idTelevisor;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
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
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


}
