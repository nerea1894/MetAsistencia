package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connectionDB.ConnectionDB;
import model.Amonestacion;

public class AmonestacionDAO {
	
	private static final String INSERT = "INSERT INTO amonestacion(motivo, id_asignatura, id_alumno) VALUES(?,?,?);";
	
	public int insert(Amonestacion amonestacion) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = ConnectionDB.getConnection();
			stmt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, amonestacion.getMotivo());
			stmt.setInt(2, amonestacion.getId_clase());
			stmt.setInt(3, amonestacion.getId_alumno());
			
			int result = stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			
			if (rs.next()) {
				amonestacion.setId(rs.getInt(1));
			}
			
			return result;
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			ConnectionDB.closeStatement(stmt);
			ConnectionDB.closeConnection(conn);
		}
	}

}
