package dbmodel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBManager {

	
	public Connection getConnection() 
			throws ClassNotFoundException, SQLException {
		
		Connection con = null;		
		Class.forName("com.mysql.jdbc.Driver");		
		con = DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/ArtikelSeite",  // DB
					"root",                                		 // User
					""                                      	 // Passwort
					);
		return con;
	}
	
	public void releaseConnection (Connection con) 
			throws SQLException {
		
			if (con != null)
				con.close();	
	}
	
	public Benutzer getBenutzer(Connection con, int bid) 
			throws SQLException {		
		Benutzer result = new Benutzer();
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM Abteilung where benutzerid = ?";
			stm = con.prepareStatement(sql);
			stm.setInt(1, bid);
			rs = stm.executeQuery();
			int rbid;
			
			if (rs.next()) {
				int id = rs.getInt(1);
				String eMail = rs.getString(2);
				String vName = rs.getString(3);
				String nName = rs.getString(4);
				String pw = rs.getString(5);
				String nickName = rs.getString(6);
				String userGroup = rs.getString(7);
				int tmpIstGesperrt = rs.getInt(8);
				boolean istGesperrt;
				if(tmpIstGesperrt == 0) {
					istGesperrt = false;
				}
				else {
					istGesperrt = true;
				}
				result = new Benutzer(id,eMail,vName,nName,userGroup,nickName,istGesperrt,pw);
			}
		} 
		finally {
			if (stm != null)
				stm.close();
		}
		return result;
	}
	
}