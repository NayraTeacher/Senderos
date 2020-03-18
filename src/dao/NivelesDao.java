package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Dificultad;

public class NivelesDao {
	
	private ConnDB conn;
	
	public NivelesDao(ConnDB conn) {
		this.conn = conn;
	}
	
	public List<Dificultad> getAll(){
        try {
            String sql = "select * from nivelesdificultad order by idnivel";
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            List<Dificultad> list = new LinkedList<>();
            Dificultad nivel;
            while (rs.next()) {
            	nivel = new Dificultad();
            	nivel.setId(rs.getInt("idnivel"));
            	nivel.setNivel(rs.getString("descripcion"));
                 // Add nivel object to the list
                list.add(nivel);
            }
            return list;

        } catch (SQLException e) {            
            System.out.println("Error NivelesDao.getAll: " + e.getMessage());
            return null;
        }
	}

}
