package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Ruta;

public class RutasDao {
	
	   private ConnDB conn;

		public RutasDao(ConnDB conn) {
	        this.conn = conn;
	    }

	    /**
	     * Metodo para insertar un registro en la tabla rutas
	     *
	     * @param servidor
	     * @return Regresa el id generado por la base de datos
	     * @throws Exception
	     */
	    public boolean insert(Ruta ruta) {

	        try {
	        	//INSERT INTO `senderos`.`rutas` (`NOMBRE`, `DISTANCIA`, `DESNIVEL`, `FECHA`, `LOCALIZACION`, `DIFICULTAD`,USUARIO) VALUES ('Prueba', '20', '400', '14/03/2020', 'Madrid', '3','NAY');
	            String sql = "insert into senderos.rutas (NOMBRE, DISTANCIA, DESNIVEL, FECHA, LOCALIZACION, DIFICULTAD, USUARIO) values (?,?,?,?,?,?,?)";
	            PreparedStatement preparedStatement = conn.getConn().prepareStatement(sql);
	            //preparedStatement.setInt(1, ruta.getId());
	            preparedStatement.setString(1, ruta.getNombre());
	            preparedStatement.setInt(2, ruta.getDistancia());
	            preparedStatement.setInt(3, ruta.getDesnivel());
	            preparedStatement.setString(4, ruta.getFecha());
	            preparedStatement.setString(5, ruta.getLocalizacion());
	            preparedStatement.setInt(6, ruta.getDificultad());
	            preparedStatement.setString(7, ruta.getUsuario());
	            preparedStatement.executeUpdate();
	            return true;

	        } catch (SQLException e) {
	            System.out.println("Error RutasDao.insert: " + e.getMessage());
	            return false;
	        }
	    }

	    /**
	     * Metodo que regresa una lista con los 3 ultimos senderos que seran
	     * mostrados en la pagina principal
	     *
	     * @return
	     * @throws Exception
	     */
	    public List<Ruta> getUltimos3() {
	        try {
	            String sql = "select * from rutas order by idruta desc limit 3";
	            PreparedStatement preparedStatement = conn.getConn().prepareStatement(sql);
	            ResultSet rs = preparedStatement.executeQuery();
	            List<Ruta> list = new LinkedList<>();
	            Ruta ruta;
	            while (rs.next()) {
	            	ruta = new Ruta();
	            	ruta.setId(rs.getInt("idruta"));
	            	ruta.setNombre(rs.getString("nombre"));
	            	ruta.setDistancia(rs.getInt("distancia"));
	            	ruta.setDesnivel(rs.getInt("desnivel"));
	                // Add ruta object to the list
	                list.add(ruta);
	            }
	            System.out.println(list);
	            return list;

	        } catch (SQLException e) {            
	            System.out.println("Error RutasDao.getUltimos3: " + e.getMessage());
	            return null;
	        }
	    }

	    /**
	     * Metodo para buscar en la base de datos un registro de Servidor por
	     * medio del id
	     *
	     * @param idServidor
	     * @return Objeto de tipo servidor. Si no lo encuentra, regresa null
	     * @throws Exception
	     */
	    public Ruta getById(int id){
	        try {
	            String sql = "select * from rutas where idruta=? limit 1";
	            PreparedStatement preparedStatement = conn.getConn().prepareStatement(sql);
	            preparedStatement.setInt(1, id); // Set idServidor
	            ResultSet rs = preparedStatement.executeQuery();
	            Ruta ruta = new Ruta();
	            while (rs.next()) {
	                // Create an object for the movie
	            	ruta.setId(rs.getInt("idruta"));
	            	ruta.setNombre(rs.getString("nombre"));
	            	ruta.setDistancia(rs.getInt("distancia"));
	            	ruta.setDesnivel(rs.getInt("desnivel"));
	            	ruta.setDificultad(rs.getInt("dificultad"));
	            	ruta.setFecha(rs.getString("fecha"));
	            	ruta.setLocalizacion(rs.getString("localizacion"));
	            }
	            return ruta;

	        } catch (SQLException e) {            
	            System.out.println("Error RutasDao.getById: " + e.getMessage());
	            return null;
	        }
	    }

	    /**
	     * Metodo que regresa una lista con todos los servidores.
	     *
	     * @return Lista de todos los objetos servidor
	     * @throws Exception
	     */
	    public List<Ruta> getAll(){
	        try {
	            String sql = "select * from rutas order by idruta desc";
	            PreparedStatement preparedStatement = conn.getConn().prepareStatement(sql);
	            ResultSet rs = preparedStatement.executeQuery();
	            List<Ruta> list = new LinkedList<>();
	            Ruta ruta;
	            while (rs.next()) {
	            	ruta = new Ruta();
	            	ruta.setId(rs.getInt("idruta"));
	            	ruta.setNombre(rs.getString("nombre"));
	            	ruta.setDistancia(rs.getInt("distancia"));
	            	ruta.setDesnivel(rs.getInt("desnivel"));
	                // Add ruta object to the list
	                list.add(ruta);
	            }
	            return list;

	        } catch (SQLException e) {            
	            System.out.println("Error ServidorDao.getAll: " + e.getMessage());
	            return null;
	        }
	    }

	
	    public List<Ruta> getByQuery(String query){

	        try {
	        	//Buscaremos por dos posibilidades, nombre y ubicacion
	            String sql = "select * from rutas where (localizacion like ? or nombre like ?) order by idruta desc";
	            PreparedStatement preparedStatement = conn.getConn().prepareStatement(sql);
	            preparedStatement.setString(1, "%" + query + "%");
	            preparedStatement.setString(2, "%" + query + "%");
	            ResultSet rs = preparedStatement.executeQuery();
	            List<Ruta> list = new LinkedList<>();
	            Ruta ruta;
	            while (rs.next()) {
	            	ruta = new Ruta();
	            	ruta.setId(rs.getInt("idruta"));
	            	ruta.setNombre(rs.getString("nombre"));
	            	ruta.setDistancia(rs.getInt("distancia"));
	            	ruta.setDesnivel(rs.getInt("desnivel"));
	                // Add ruta object to the list
	                list.add(ruta);
	            }
	            return list;

	        } catch (SQLException e) {            
	            System.out.println("Error RutasDao.getByQuery: " + e.getMessage());
	            return null;
	        }
	    }
	    
	    
	    /**
	     * Metodo para eliminar un ruta.
	     * @param idServidor
	     * @return No. de filas afectadas
	     */
	    public int delete(int id) {
	        try {
	            String sql = "delete from rutas where idruta=?";
	            PreparedStatement preparedStatement = conn.getConn().prepareStatement(sql);
	            preparedStatement.setInt(1, id);
	            int rows = preparedStatement.executeUpdate();
	            return rows;

	        } catch (SQLException e) {            
	            System.out.println("Error RutasDao.eliminar: " + e.getMessage());
	            return 0;
	        }
	    }

}
