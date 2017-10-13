package controlers;

import java.util.ArrayList;

import data.DataReserva;
import entities.Reserva;
import entities.Elemento;
import entities.Persona;

public class CtrlABMCReserva {
	
	private DataReserva datar;
	public CtrlABMCReserva()
	{
		datar = new DataReserva();
	}
	
	
	public void addReserva(Reserva r){
		datar.add(r);
	}
	
	public ArrayList<Reserva> getAll()
	{
		return datar.getAll();
	}
	public ArrayList<Reserva> getAll(Elemento e)
	{
		return datar.getAll(e);
	}
	
	public void delete(Reserva r)
	{
		datar.delete(r);
	}
	
	public ArrayList<Reserva> getAll(Persona per){
		ArrayList<Reserva> resers = datar.getAll();
		ArrayList<Reserva> reserPer = new ArrayList<Reserva>();
		for (Reserva reserva : resers) {
			if(reserva.getPersona().getIdPersona() == per.getIdPersona())
			{
				reserPer.add(reserva);
			}
		}
		return reserPer;
	}
}
