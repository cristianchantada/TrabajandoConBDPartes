import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
public class paso01 {
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
				System.out.println("Cliente: "+rs.getString("nombre"));
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {  
			e.printStackTrace();
		}
	}
}
//Esta clase debería crear la conexion y no hacer una consulta (estuvo repitiendo todo lo del viernes y ha decidido separarlo en dos pasos)