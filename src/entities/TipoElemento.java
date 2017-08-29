package entities;

public class TipoElemento {
	private int idTipo;
	private String descTipo;
	private int cantdiasMax;
	private static int ult;
	
	public int getCantdiasMax() {
		return cantdiasMax;
	}

	public void setCantdiasMax(int cantdiasMax) {
		this.cantdiasMax = cantdiasMax;
	}

	public TipoElemento(){}
	
	public TipoElemento(String dTipo, int cantD){
		this.setIdTipo(this.getUlt());
		this.setDescTipo(dTipo);
		this.setCantdiasMax(cantD);
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


