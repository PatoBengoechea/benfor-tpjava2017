package entities;

import java.sql.Date;

public class Reserva {
	int idReserva;
	Date fechaInicio;
	Date fechaFin;
	Elemento elemento;
	Persona persona;
	
	public Persona getPersona() {
		return persona;
	}
	public int getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public Elemento getElemento() {
		return elemento;
	}
	public void setElemento(Elemento elemento) {
		this.elemento = elemento;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
}
