package data;
import entities.Persona;
import entities.Reserva;
import entities.Elemento;
import java.sql.*;
import java.util.ArrayList;
import java.security.KeyStore.ProtectionParameter;

public class DataElemento {

	public ArrayList<Elemento> getAll(){
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Elemento> elementos = new ArrayList<Elemento>();
		try {
			stmt =  FactoryConexion.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("select * from Elemento");
			if(rs!=null){
				while(rs.next()){
					Elemento t = new Elemento();
					t.setIdElemento(rs.getInt("idElemento"));
					t.setDescripcion(rs.getString("descripcion"));
					t.setCapacidad(rs.getInt("capacidad"));
					t.setTipo(rs.getInt("idTipoElemento"));
					elementos.add(t);
					}	
				}
			}catch (Exception e) {
				e.printStackTrace();
			}try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				FactoryConexion.getInstancia().releaseConn();
				} catch (SQLException e) {
					e.printStackTrace();
					}
			return elementos;
		}
	
	public ArrayList<Reserva> getReservas(int idElemento){
	PreparedStatement stmt=null;
	ResultSet rs = null;
	ArrayList<Reserva> reservas = new ArrayList<Reserva>();
	try{
		stmt=FactoryConexion.getInstancia().getConn().prepareStatement
				("select idReserva, fechaInicio, fechaFin, idElemento  from Reservas where idElemento = ?");
		stmt.setFloat(1, idElemento);
		rs = stmt.executeQuery();
		if(rs!=null){
			while(rs.next()){
				Reserva t = new Reserva();
				t.setIdReserva(rs.getInt("idReserva"));
				t.setFechaInicio(rs.getDate("fechaInicio"));
				t.setFechaFin(rs.getDate("fechaFin"));
				t.setIdElemento(rs.getInt("idElemento"));
				reservas.add(t);
				}	
			}
		}catch (Exception e) {
			e.printStackTrace();
		}try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
				}
		return reservas;

	}
	public Elemento getById(Elemento ele){
		Elemento t = null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement
			("select * from Elementos where idElemento = ?");
			stmt.setInt(1, ele.getIdElemento());
			rs = stmt.executeQuery();
			if(rs!=null && rs.next()){
					t = new Elemento();
					t.setIdElemento(rs.getInt("idElemento"));
					t.setDescripcion(rs.getString("descripcion"));
					t.setCapacidad(rs.getInt("capacidad"));
					t.setTipo(rs.getInt("idTipoElemento"));
					}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return t;
	}
}