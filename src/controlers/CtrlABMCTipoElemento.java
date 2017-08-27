package controlers;

import java.util.ArrayList;

import data.DataTipoElemento;
import entities.TipoElemento;

public class CtrlABMCTipoElemento {
	
	private DataTipoElemento datatipo;
	public CtrlABMCTipoElemento() {
		datatipo = new DataTipoElemento();
	}
	
	public void Add(TipoElemento tipoe) {
		datatipo.add(tipoe);
	}
	
	public TipoElemento buscarTipoElemento(TipoElemento tipoe){
		return datatipo.getById(tipoe);
	}
	
	public ArrayList<TipoElemento> getAll(){
		return datatipo.getAll();
	}
}