import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import Mensajes.*;
public class paso03 {
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
			String sql2="select count(*) as numclientes from clientes";
			rs=stmt.executeQuery(sql2);
			if(rs.next()) {
				int numClientes=rs.getInt("numclientes");
				if(numClientes>0) {
					Mensaje.verMensaje("Existen "+numClientes+" clientes");
				}else {
					Mensaje.verMensaje("No existen clientes");
				}
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {  
			e.printStackTrace();
		}
	}
}
//Calculamos cuantos clientes hay en la tabla y lo sacamos por pantalla