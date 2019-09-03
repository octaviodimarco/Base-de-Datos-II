package jdbcucc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EjemploUno {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ucc2019", "root", "root");

		//Statement s = c.createStatement();
		//int filas = s.executeUpdate("INSERT INTO productos (id, nombre, precio) VALUES (33, 'pan', 60)");
		//PreparedStatement pst = c.prepareStatement("INSERT INTO productos (nombre, precio) VALUES ('pan', 60)");
		
		//int filas = pst.executeUpdate();
		
		PreparedStatement pst = c.prepareStatement("INSERT INTO productos (nombre, precio) VALUES (?, ?)");
		 
		PreparedStatement mirco =c.prepareStatement("SELECT id FROM productos ORDER BY id DESC LIMIT 1");
		
		
		
		ResultSet rs = mirco.executeQuery();
		rs.next();
		
		PreparedStatement ejemplo2 =c.prepareStatement("select distinct last_insert_id() from productos");
		ResultSet rs1 = ejemplo2.executeQuery();
		rs1.next();
		
		
		int idmirco = rs.getInt("id");
		
		int opcion2 = rs1.getInt("last_insert_id()");
		
		for(int t=0; t<100; t++) {
			pst.setString(1, "producto"+(opcion2+t));
			pst.setInt(2, opcion2+t);
			pst.executeUpdate();
		}
		
		//System.out.println(filas);
	}

}

