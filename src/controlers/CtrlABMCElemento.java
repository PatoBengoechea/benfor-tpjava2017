package controlers;
import entities.Elemento;
import entities.TipoElemento;

import java.util.ArrayList;

import data.DataElemento;


public class CtrlABMCElemento {
	private DataElemento datatipo;
	public CtrlABMCElemento() {
		datatipo = new DataElemento();
	}
	
	public void Add(Elemento elemento) {
		datatipo.add(elemento);
	}
	
	public Elemento buscarElemento(Elemento elemento){
		return datatipo.getById(elemento);
	}
	
	public ArrayList<Elemento> getAll(){
		return datatipo.getAll();
	}
}
	
	

