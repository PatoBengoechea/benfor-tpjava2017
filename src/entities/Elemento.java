package entities;

import java.util.ArrayList;

import entities.Reserva;

public class Elemento {
	private int idElemento;
	private String ubicacion;
	private String descripcion;
	private int capacidad;
	private TipoElemento tipo;
	private ArrayList<Reserva> reservas;
	private static int ult = 0;
	
	public ArrayList<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(ArrayList<Reserva> reservas) {
		this.reservas = reservas;
	}

	public Elemento(){}
	
	public Elemento(String desc, int cap,String ubi,TipoElemento tip  ){
		this.setIdElemento();
		this.setDescripcion(desc);
		this.setCapacidad(cap);
		this.setUbicacion(ubi);
		this.setTipo(tip);
		}
	
	public TipoElemento getTipo() {
		return tipo;
	}
	public void setTipo(TipoElemento tipo) {
		this.tipo = tipo;
	}
	public void setTipo(int idtipo) {
		//this.tipo = tipos;
	}
	public int getIdElemento() {
		return idElemento;
	}
	public void setIdElemento() {
		ult = ult + 1;
		this.idElemento = ult;
	}
	public void setIdElemento(int i) {
		this.idElemento = i;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

}
