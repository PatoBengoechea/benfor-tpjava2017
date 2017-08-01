package data;
import entities.Persona;
import entities.Televisor;
import java.sql.*;
import java.util.ArrayList;
import java.security.KeyStore.ProtectionParameter;

public class DataTelevisor {

	public ArrayList<Televisor> getAll(){
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Televisor> televisores = new ArrayList<Televisor>();
		try {
			stmt =  FactoryConexion.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("select * from televisor");
			if(rs!=null){
				while(rs.next()){
					Televisor t = new Televisor();
					t.setIdTelevisor(rs.getInt("idTelevisor"));
					t.setMarca(rs.getString("marca"));
					t.setModelo(rs.getString("modelo"));
					t.setDescripcion(rs.getString("descripcion"));
					t.setCantidad(rs.getInt("cantidad"));
					t.setPrecio(rs.getFloat("precio"));
					televisores.add(t);
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
			return televisores;
		}
	
	public ArrayList<Televisor> getByPrecioMax(float precio){
	PreparedStatement stmt=null;
	ResultSet rs = null;
	ArrayList<Televisor> televisores = new ArrayList<Televisor>();
	try{
		stmt=FactoryConexion.getInstancia().getConn().prepareStatement
				("select idTelevisor, marca, modelo, precio, descripcion, cantidad  from televisor where precio <= ?");
		stmt.setFloat(1, precio);
		rs = stmt.executeQuery();
		if(rs!=null){
			while(rs.next()){
				Televisor t = new Televisor();
				t.setIdTelevisor(rs.getInt("idTelevisor"));
				t.setMarca(rs.getString("marca"));
				t.setModelo(rs.getString("modelo"));
				t.setDescripcion(rs.getString("descripcion"));
				t.setCantidad(rs.getInt("cantidad"));
				t.setPrecio(rs.getFloat("precio"));
				televisores.add(t);
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
		return televisores;

	}
	public Televisor getById(Televisor tel){
		Televisor t = null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement
			("select idTelevisor, marca, modelo, precio, descripcion, cantidad  from televisor where idTelevisor <= ?");
			stmt.setInt(1, tel.getIdTelevisor());
			rs = stmt.executeQuery();
			if(rs!=null && rs.next()){
					t = new Televisor();
					t.setIdTelevisor(rs.getInt("idTelevisor"));
					t.setMarca(rs.getString("marca"));
					t.setModelo(rs.getString("modelo"));
					t.setDescripcion(rs.getString("descripcion"));
					t.setCantidad(rs.getInt("cantidad"));
					t.setPrecio(rs.getFloat("precio"));
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