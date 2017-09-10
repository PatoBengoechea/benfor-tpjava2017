package controlers;
import entities.Elemento;
import entities.TipoElemento;

import java.util.ArrayList;

import data.DataElemento;


public class CtrlABMCElemento {
	private DataElemento de;
	public CtrlABMCElemento() {
		de = new DataElemento();
	}
	
	public void Add(Elemento elemento) {
		de.add(elemento);
	}
	
	public Elemento buscarElemento(Elemento elemento){
		return de.getById(elemento);
	}
	
	public ArrayList<Elemento> getAll(){
		return de.getAll();
	}
	
	public ArrayList<Elemento> getByTipo(int idTipo){
		return de.getByTipo(idTipo);
	}
			
}
	
	

