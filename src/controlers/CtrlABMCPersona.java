package controlers;

import java.util.ArrayList;

import entities.Persona;
import data.DataPersona;

public class CtrlABMCPersona {
	private DataPersona datap;
	public CtrlABMCPersona(){
		datap = new DataPersona();
	}
	
	public Persona buscarUsuario(Persona usu) {
		ArrayList<Persona> personas = new ArrayList<Persona>();
		personas = datap.getAll();
		Persona pers = new Persona();
		pers.setUsuario("vacio");
		pers.setPassword("vacio");
		for (Persona per : personas) {
			if((per.getUsuario().equals(usu.getUsuario())) 
					&& (per.getPassword().equals(usu.getPassword())))
			{
				pers = per;
			}
		}
		return pers;
	}

	public void addPersona(Persona per){
		datap.add(per);
	}
	
	public void updatePersona(Persona per){
		datap.update(per);
	}
	public Persona buscarPersona(Persona per){
		return datap.getByDni(per);
	}

	public Persona buscarPersonaID(Persona per){
		return datap.getById(per);
	}
	public ArrayList<Persona> getAll()
	{
		return datap.getAll();
	}
	
 	public void validoUser() {
		
	}
	
}
