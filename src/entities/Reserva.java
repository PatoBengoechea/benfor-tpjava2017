package entities;

import java.sql.Date;
import java.util.ArrayList;

import controlers.*;


public class Reserva {
	int idReserva;
	Date fechaInicio;
	Date fechaFin;
	Elemento elemento;
	Persona persona;
	private CtrlABMCElemento ctrlElemento;
	private CtrlABMCPersona ctrlPersona;
	
	public Reserva(Elemento t1, Date datei, Date datef) {
		this.elemento = t1;
		this.fechaInicio = datei;
		this.fechaFin = datef;
	}

	public Reserva(){}
	
	
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
	public void setFechaInicio(Date fInicio) {
		this.fechaInicio = fInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fFin) {
		this.fechaFin = fFin;
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
//	
//	public void setElemento(int id) {
//		Elemento elemento = new Elemento();
//		elemento.setIdElemento(id);
//		ctrlElemento = new CtrlABMCElemento();
//		this.elemento = ctrlElemento.buscarElemento(elemento);
//	}
//	
//	public void setPersona(int id) {
//		Persona persona = new Persona();
//		persona.setIdPersona(id);
//		ctrlPersona=new CtrlABMCPersona();
//		this.persona = ctrlPersona.buscarPersonaID(persona);
//	}
}
