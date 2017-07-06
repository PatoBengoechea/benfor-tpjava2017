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
		/*for (Persona per : personas) {
			Persona pers = new Persona();
			if((usu.getUsuario().equals("lio")) && (usu.getContraseña().equals("anto"))){
				pers.setNombre("lionel");
				return pers;
			}
		pers = null;*/
		return null;
	}

	public void addPersona(Persona per){
		datap.add(per);
	}
	
	public void updatePersona(Persona per){
		datap.delete(per);
		datap.add(per);
	}
}
