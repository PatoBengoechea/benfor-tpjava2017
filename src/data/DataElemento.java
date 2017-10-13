package data;

import entities.TipoElemento;
import entities.Elemento;
import java.sql.*;
import java.util.ArrayList;


public class DataElemento {
	
	public void add(Elemento el){
		PreparedStatement stmt=null;
		ResultSet keyResultSet=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn()
					.prepareStatement(
					"insert into Elemento(ubicacion, descripcion, capacidad, idTipo) values (?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS
					);
			stmt.setString(1, el.getUbicacion());
			stmt.setString(2, el.getDescripcion());
			stmt.setInt(3, el.getCapacidad());
			stmt.setInt(4, el.getTipo().getIdTipo());
			stmt.executeUpdate();
			keyResultSet=stmt.getGeneratedKeys();
			if(keyResultSet!=null && keyResultSet.next()){
				el.setIdElemento(keyResultSet.getInt(1));
			}
		} catch (Exception e) {
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
					t.setUbicacion(rs.getString("ubicacion"));
					t.setDescripcion(rs.getString("descripcion"));
					t.setCapacidad(rs.getInt("capacidad"));
					t.setTipo(rs.getInt("idTipo"));
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
	
	/*public ArrayList<Reserva> getReservas(int idElemento){
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

	}*/
	
	public Elemento getById(Elemento ele){
		Elemento t = null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement
			("select idElemento, descripcion, ubicacion, capacidad, idTipo from Elemento where idElemento = ?");
			stmt.setInt(1, ele.getIdElemento());
			rs = stmt.executeQuery();
			if(rs!=null && rs.next()){
					t = new Elemento();
					t.setIdElemento(rs.getInt("idElemento"));
					t.setDescripcion(rs.getString("descripcion"));
					t.setUbicacion(rs.getString("ubicacion"));
					t.setCapacidad(rs.getInt("capacidad"));
					t.setTipo(rs.getInt("idTipo"));
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
	
	public ArrayList<Elemento> getByTipo(TipoElemento tipo){
//		Elemento e;
//		TipoElemento te;
//		DataTipoElemento dte;
		ArrayList<Elemento> es = new ArrayList<Elemento>();
//		PreparedStatement stmt=null;
//		ResultSet rs=null;
//		try {
//			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
//					"select e.idElemento, e.ubicacion, e.descripcion, e.capacidad, te.idTipo from Elemento e leftjoin TipoElemento te where te.idTipo = ?");
//			stmt.setInt(1, tipo.getIdTipo());
//			rs=stmt.executeQuery();
//			if(rs!=null && rs.next()){
//					e=new Elemento();
//					te = new TipoElemento();
//					dte = new DataTipoElemento();
//					e.setIdElemento(rs.getInt("e.idElemento"));
//					e.setUbicacion(rs.getString("e.ubicacion"));
//					e.setDescripcion(rs.getString("e.descripcion"));
//					e.setCapacidad(rs.getInt("e.capacidad"));
//					te.setIdTipo(rs.getInt("te.idTipo"));
//					te = dte.getById(te);
//					e.setTipo(te);
//					es.add(e);
//					
//					
//			}
//			
//		} catch (SQLException ex) {
//			ex.printStackTrace();
//		}
//		
//		try {
//			if(rs!=null)rs.close();
//			if(stmt!=null)stmt.close();
//			FactoryConexion.getInstancia().releaseConn();
//		} catch (SQLException ex) {
//			ex.printStackTrace();
//		}
//		
		return es;
	}
}