import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import Mensajes.*;
public class paso02 {
	static Connection conexion=null;
	static java.sql.Statement stmt=null;
	static ResultSet rs;
	
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String direccionPServer="jdbc:mysql://localhost:3306/partes";
			String user="root";
			String password="0000";
			
			conexion =DriverManager.getConnection(direccionPServer,user,password);
			
			stmt=conexion.createStatement();
			String sql="select * from clientes";
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				Mensaje.verMensaje("Cliente: "+rs.getString("nombre")+ "\nNif: "+rs.getString("nif"));
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {  
			e.printStackTrace();
		}
	}
}
//Esta clase saca el nombre y nif por pantalla no hace nada mas, es decir es la clase de antes metiendole el nif y sacandolo por un mensaje