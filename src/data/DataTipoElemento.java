package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import entities.TipoElemento;

public class DataTipoElemento {
	
	public ArrayList<TipoElemento> getAll(){
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<TipoElemento> tipoelementos = new ArrayList<TipoElemento>();
		try {
			stmt = FactoryConexion.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("select * from tipoelemento");
			if(rs!=null){
				while(rs.next()){
					TipoElemento te = new TipoElemento();
					te.setIdTipo(rs.getInt("idTipo"));
					te.setDescTipo(rs.getString("descripcion"));
					te.setCantdiasMax(rs.getInt("cantDiasMax"));
					tipoelementos.add(te);
				}
			} 
		}catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	return tipoelementos;
	}

	public TipoElemento getById(TipoElemento t){
		TipoElemento tipoelemento = new TipoElemento();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select idTipo, descripcion from tipoelemento where idTipo = ?");
			stmt.setInt(1, t.getIdTipo());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){	
				tipoelemento.setIdTipo(rs.getInt("idTipo"));
				tipoelemento.setDescTipo(rs.getString("descripcion"));
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
		return tipoelemento;
	}
	
	public void add(TipoElemento tipoe){
		PreparedStatement stmt=null;
		ResultSet keyResultSet=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn()
					.prepareStatement(
					"insert into TipoElemento(idTipo, descripcion, cantDiasMax) values (?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS
					);
			stmt.setInt(1, tipoe.getIdTipo());
			stmt.setString(2, tipoe.getDescTipo());
			stmt.setInt(3, tipoe.getCantdiasMax());
			stmt.executeUpdate();
			keyResultSet=stmt.getGeneratedKeys();
			if(keyResultSet!=null && keyResultSet.next()){
				tipoe.setIdTipo(keyResultSet.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(keyResultSet!=null)keyResultSet.close();
			if(stmt!=null)stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
