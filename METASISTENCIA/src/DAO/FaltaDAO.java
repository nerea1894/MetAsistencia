package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectionDB.ConnectionDB;
import model.Falta;

public class FaltaDAO {
	
	private static final String INSERT = "INSERT INTO falta(id_alumno, id_asignatura) VALUES(?,?);";
	private static final String FECHA = "SELECT fecha FROM falta WHERE id_alumno=? AND id_asignatura=?;";
	private static final String FIND_BY_ALUMNO = "SELECT * FROM falta WHERE id_alumno=? GROUP BY fecha;";
	
	@SuppressWarnings("resource")
	public String insert(Falta falta) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = ConnectionDB.getConnection();
			stmt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, falta.getId_alumno());
			stmt.setInt(2, falta.getId_asignatura());
			stmt = null;
			
			stmt = conn.prepareStatement(FECHA);
			stmt.setInt(1, falta.getId_alumno());
			stmt.setInt(2, falta.getId_asignatura());
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				String fecha;
				fecha = (rs.getString("fecha"));
				
				falta.setFecha(fecha);
				
				return fecha;
			} else {
				return null;
			}
			
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			ConnectionDB.closeStatement(stmt);
			ConnectionDB.closeConnection(conn);
		}
	}
	
	public ArrayList<Falta> findByAlumno(int id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ArrayList<Falta> faltas = new ArrayList<Falta>();
		
		try {
			conn = ConnectionDB.getConnection();
			stmt = conn.prepareStatement(FIND_BY_ALUMNO);
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Falta falta = new Falta();
				falta.setId_alumno(rs.getInt("id_alumno"));
				falta.setId_asignatura(rs.getInt("id_asignatura"));
				falta.setFecha(rs.getString("fecha"));
				
				faltas.add(falta);
			} 

			return faltas;
			
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			ConnectionDB.closeStatement(stmt);
			ConnectionDB.closeConnection(conn);
		}
	}

}
