package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entities.Elemento;
import entities.Persona;
import entities.Reserva;
import entities.TipoElemento;

	public class DataReserva {
			
		public void add(Reserva r){
			PreparedStatement stmt=null;
			ResultSet keyResultSet=null;
			try {
				stmt=FactoryConexion.getInstancia().getConn()
						.prepareStatement(
						"insert into Reserva(idPersona, fechaInicio, fechaFin, idElemento) values (?,?,?,?)",
						PreparedStatement.RETURN_GENERATED_KEYS
						);
				
				stmt.setInt(1, r.getPersona().getIdPersona());
				stmt.setDate(2, r.getFechaInicio());
				stmt.setDate(3, r.getFechaFin());
				stmt.setInt(4, r.getElemento().getIdElemento());
				stmt.executeUpdate();
				keyResultSet=stmt.getGeneratedKeys();
				if(keyResultSet!=null && keyResultSet.next()){
					r.setIdReserva(keyResultSet.getInt(1));
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

//			public ArrayList<Reserva> getAll(){
//				Statement stmt = null;
//				ResultSet rs = null;
//				ArrayList<Reserva> reservas = new ArrayList<Reserva>();
//				try {
//					stmt =  FactoryConexion.getInstancia().getConn().createStatement();
//					rs = stmt.executeQuery("select r.idReserva, p.idPersona, p.dni, p.habilitado, p.usuario, p.contraseï¿½a, r.fechaInicio, r.fechaFin, e.idElemento, e.capacidad, e.ubicacion, e.descripcion, te.descripcion, te.idTipo from Reserva r left join Persona p on r.idPersona = p.idPersona left join Elemento e on r.idElemento = e.idElemento left join TipoElemento te on e.idTipo = te.idTipo");
//					if(rs!=null){
//						while(rs.next()){
//							Reserva r = new Reserva();
//							Persona p = new Persona();
//							Elemento e = new Elemento();
//							TipoElemento te = new TipoElemento();
//							
//							te.setIdTipo(rs.getInt("te.idTipo"));
//							te.setDescTipo(rs.getString("te.descripcion"));
//							
//							e.setCapacidad(rs.getInt("e.capacidad"));
//							e.setDescripcion(rs.getString("e.descripcion"));
//							e.setIdElemento(rs.getInt("e.idElemento"));
//							e.setTipo(te);
//							e.setUbicacion(rs.getString("e.ubicacion"));
//							
//							p.setApellido(rs.getString("p.apellido"));
//							p.setDni(rs.getString("p.dni"));
//							p.setHabilitado(rs.getBoolean("p.habilitado"));
//							p.setIdPersona(rs.getInt("p.idPersona"));
//							p.setNombre(rs.getString("p.nombre"));
//							p.setPassword(rs.getString("p.contraseÃ±a"));
//							p.setUsuario(rs.getString("p.usuario"));
//							
//							r.setElemento(e);
//							r.setPersona(p);
//							r.setFechaFin(rs.getDate("r.fechaFin"));
//							r.setFechaInicio(rs.getDate("r.fechaInicio"));
//							r.setIdReserva(rs.getInt("r.idReserva"));
//							
//							e.setReservas(this.getAll(e));
//						
//							reservas.add(r);
//							}	
//						}
//					}catch (Exception e) {
//						e.printStackTrace();
//					}try {
//						if(rs!=null) rs.close();
//						if(stmt!=null) stmt.close();
//						FactoryConexion.getInstancia().releaseConn();
//						} catch (SQLException e) {
//							e.printStackTrace();
//							}
//					return reservas;
//				}
			
			public ArrayList<Reserva> getAll(){
				Statement stmt = null;
				ResultSet rs = null;
				ArrayList<Reserva> reservas = new ArrayList<Reserva>();
				try {
					stmt =  FactoryConexion.getInstancia().getConn().createStatement();
					rs = stmt.executeQuery("select r.idReserva, p.idPersona,p.nombre, p.apellido, p.dni, p.habilitado, p.usuario, p.contraseña, r.fechaInicio, r.fechaFin, e.idElemento, e.capacidad, e.ubicacion, e.descripcion, te.descripcion, te.idTipo from Reserva r left join Persona p on r.idPersona = p.idPersona left join Elemento e on r.idElemento = e.idElemento left join TipoElemento te on e.idTipo = te.idTipo");
					if(rs!=null){
						while(rs.next()){
							Reserva r = new Reserva();
							Persona p = new Persona();
							Elemento e = new Elemento();
							TipoElemento te = new TipoElemento();
							
							te.setIdTipo(rs.getInt("te.idTipo"));
							te.setDescTipo(rs.getString("te.descripcion"));
							
							e.setCapacidad(rs.getInt("e.capacidad"));
							e.setDescripcion(rs.getString("e.descripcion"));
							e.setIdElemento(rs.getInt("e.idElemento"));
							e.setTipo(te);
							e.setUbicacion(rs.getString("e.ubicacion"));
							
							p.setApellido(rs.getString("p.apellido"));
							p.setDni(rs.getString("p.dni"));
							p.setHabilitado(rs.getBoolean("p.habilitado"));
							p.setIdPersona(rs.getInt("p.idPersona"));
							p.setNombre(rs.getString("p.nombre"));
							p.setPassword(rs.getString("p.contraseña"));
							p.setUsuario(rs.getString("p.usuario"));
							
							r.setElemento(e);
							r.setPersona(p);
							r.setFechaFin(rs.getDate("r.fechaFin"));
							r.setFechaInicio(rs.getDate("r.fechaInicio"));
							r.setIdReserva(rs.getInt("r.idReserva"));
							
//							e.setReservas(this.getAll(e));
						
							reservas.add(r);
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
			
//			public ArrayList<Reserva> getAll(){
//				Statement stmt = null;
//				ResultSet rs = null;
//				ArrayList<Reserva> reservas = new ArrayList<Reserva>();
//				try {
//					stmt =  FactoryConexion.getInstancia().getConn().createStatement();
//					rs = stmt.executeQuery("select idReserva, idPersona, fechaInicio, fechaFin, idElemento from reserva");
//					if(rs!=null){
//						while(rs.next()){
//							Reserva r = new Reserva();
//							r.setIdReserva(rs.getInt("idReserva"));
//							r.setPersona(rs.getInt("idPersona"));
//							r.setFechaFin(rs.getDate("fechaFin"));
//							r.setFechaInicio(rs.getDate("fechaInicio"));
//							r.setElemento(rs.getInt("idElemento"));
//							reservas.add(r);
//							}	
//						}
//					}catch (Exception e) {
//						e.printStackTrace();
//					}try {
//						if(rs!=null) rs.close();
//						if(stmt!=null) stmt.close();
//						FactoryConexion.getInstancia().releaseConn();
//						} catch (SQLException e) {
//							e.printStackTrace();
//							}
//					return reservas;
//				}
		
			public ArrayList<Reserva> getAll(Elemento el){
				PreparedStatement stmt = null;
				ResultSet rs = null;
				ArrayList<Reserva> susReservas = new ArrayList<Reserva>();
				try {
					
					stmt=FactoryConexion.getInstancia().getConn().prepareStatement
							("select r.idReserva, p.nombre, p.idPersona, p.apellido, p.dni, p.habilitado, p.usuario, p.contraseña, r.fechaInicio, r.fechaFin, e.idElemento, e.capacidad, e.ubicacion, e.descripcion, te.descripcion, te.idTipo from Reserva r left join Persona p on r.idPersona = p.idPersona left join Elemento e on e.idElemento=? left join TipoElemento te on e.idTipo = te.idTipo");
						stmt.setInt(1, el.getIdElemento());	
						rs = stmt.executeQuery();
					if(rs!=null){
						while(rs.next()){
							Reserva r = new Reserva();
							Persona p = new Persona();
							Elemento e = new Elemento();
							TipoElemento te = new TipoElemento();
							te.setIdTipo(rs.getInt("te.idTipo"));
							te.setDescTipo(rs.getString("te.descripcion"));
							
							e.setCapacidad(rs.getInt("e.capacidad"));
							e.setDescripcion(rs.getString("e.descripcion"));
							e.setIdElemento(rs.getInt("e.idElemento"));
							e.setTipo(te);
							e.setUbicacion(rs.getString("e.ubicacion"));
							
							p.setApellido(rs.getString("p.apellido"));
							p.setDni(rs.getString("p.dni"));
							p.setHabilitado(rs.getBoolean("p.habilitado"));
							p.setIdPersona(rs.getInt("p.idPersona"));
							p.setNombre(rs.getString("p.nombre"));
							p.setPassword(rs.getString("p.contraseña"));
							p.setUsuario(rs.getString("p.usuario"));
							
							r.setElemento(e);
							r.setPersona(p);
							r.setFechaFin(rs.getDate("r.fechaFin"));
							r.setFechaInicio(rs.getDate("r.fechaInicio"));
							r.setIdReserva(rs.getInt("r.idReserva"));
						
						
							susReservas.add(r);
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
					return susReservas;
				}
			
			public void delete(Reserva r) {
				PreparedStatement stmt=null;
				ResultSet rs = null;
				try {
					stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
							"delete from Reserva where id = ?");
					stmt.setInt(1, r.getIdReserva() );
					rs=stmt.executeQuery();
					
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
			}

			

		
}
