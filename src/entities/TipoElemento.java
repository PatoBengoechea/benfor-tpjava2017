package entities;

public class TipoElemento {
	private int idTipo;
	private String descTipo;
	private static int ult;
	
	public TipoElemento(){}
	
	public TipoElemento(String dTipo){
		this.setIdTipo(this.getUlt());
		this.setDescTipo(dTipo);
		actualizarUltimo();
	}

	private void actualizarUltimo() {
		this.setUlt(this.getUlt()+1);
	}

	public int getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}

	public String getDescTipo() {
		return descTipo;
	}

	public void setDescTipo(String descTipo) {
		this.descTipo = descTipo;
	}

	public static int getUlt() {
		return ult;
	}

	public static void setUlt(int ult) {
		TipoElemento.ult = ult;
	}
}


