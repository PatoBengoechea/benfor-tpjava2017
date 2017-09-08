package controlers;

import java.util.ArrayList;

import data.DataReserva;
import entities.Reserva;

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
	
	public void delete(Reserva r)
	{
		datar.delete(r);
	}
}
