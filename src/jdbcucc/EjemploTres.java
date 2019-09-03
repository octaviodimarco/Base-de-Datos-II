package jdbcucc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Scanner;

public class EjemploTres {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ucc2019", "root", "root");

		Scanner s=new Scanner(System.in);
		
		String sql=s.nextLine();
		
		PreparedStatement pst = c.prepareStatement(sql);
		
		//PreparedStatement tomi =c.prepareStatement("SELECT id FROM productos ORDER BY id DESC LIMIT 1");
				
		
		ResultSet rs = pst.executeQuery();
		
		ResultSetMetaData metadata=rs.getMetaData();
		
		
		for(int t=0; t<metadata.getColumnCount(); t++) {
			System.out.print(metadata.getColumnName(t+1)+"\t");
			
		}
		System.out.println("\n-------------------------------------------------------------------------");
		
		
		while (rs.next()) {
			for(int t=0; t<metadata.getColumnCount(); t++) {
			//	System.out.print(metadata.getColumnName(rs.getInt(1))+"\t");
				
				System.out.print(rs.getString(metadata.getColumnName(t+1))+"\t");
			}
			System.out.println();
			
			
		}
	
	
}
}
