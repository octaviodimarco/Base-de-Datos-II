package jdbcucc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EjemploDos {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ucc2019", "root", "root");

		PreparedStatement pst = c.prepareStatement("SELECT id, nombre, precio FROM productos");
		
		//PreparedStatement tomi =c.prepareStatement("SELECT id FROM productos ORDER BY id DESC LIMIT 1");
				
		
		ResultSet rs = pst.executeQuery();
		
		while (rs.next()) {
			int id = rs.getInt(1);
			String nombre= rs.getString(2);
			int precio = rs.getInt(3);
			//String nombre= rs.getString("nombre");
			System.out.printf("%s\t%s\t%s%n", id, nombre, precio);
		}
	}
}

