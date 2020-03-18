package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/** 
 * Clase para crear la conexion con la base de datos.
 * @author Nayra
 *
 */

public class ConnDB {
	static String bd = "senderos";
	static String login = "root";
	static String password = "daw1001";
	static String ip = "localhost";
	static String url = "jdbc:mysql://"+ip+"/" + bd;
	   // Esta variable va a guardar la conexion
	private Connection conn = null;
	
	//Un costructor para crear la conexion con labbdd
	/**
	 * Metodo constructor que obtiene el driver jdbc y genera el objeto conexión 
	 * con la base de datos, usando para ello los atributos estáticos definidos 
	 * en la clase: url, login y password
	 * Si se modifican los datos de conexion, es decir, hay un login distinto o la base de datos
	 * está en una IP diferente, hay que modificar esta clase. 
	 */
	public ConnDB() {
	     try {
	         //obtenemos el driver para mysql
	         Class.forName("com.mysql.jdbc.Driver");
	         //obtenemos una conexion con los parametros especificados anteriormente 
	         conn = DriverManager.getConnection(url, login, password);
	         // Si conn no es nulo, significa que pudimos conectarnos
	         if (conn != null) {
	            System.out.println("Connecting database [" + conn + "] OK");
	         }
	      } catch (SQLException e) // Excepcion ocurrida por la conexion 
	      {
	         System.out.println("Excepcion conexion: " + e.getMessage());         
	      } catch (ClassNotFoundException e) // Excepcion ocurrida por no encontrar el driver
	      {
	         System.out.println("Excepcion driver: " + e.getMessage());         
	      }
	}
	
	/**Un getter para devolver la conexion una vez creada
	 * 
	 * @return Connection
	 */
	public Connection getConn() {
		return conn;
	}

	/**Un metodo disconnect para cerrar la conexion
	 * 
	 */
	public void disconnect() {
	     System.out.println("Closing database: [" + conn + "] OK");
	      if (conn != null) {
	         try {
	            conn.close();
	         } catch (SQLException e) {
	            System.out.println(e);
	         }
	      }	
	}




}
