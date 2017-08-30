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
	
	
	public void AddReserva(Reserva r){
		datar.add(r);
	}
	
	public ArrayList<Reserva> GetAll()
	{
		return datar.getAll();
	}
}
