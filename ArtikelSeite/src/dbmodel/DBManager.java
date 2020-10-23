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
			String sql = "SELECT * FROM Benutzer where benutzerid = ?";
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
				boolean istGesperrt = rs.getBoolean(8);

				result = new Benutzer(id,eMail,vName,nName,pw,nickName,pw,istGesperrt);
			}
		} 
		finally {
			if (stm != null) stm.close();
		}
		return result;
	}
	
	
	public boolean benutzerAnmeldungIstOk(Connection con, String email, String pwd) 
			throws SQLException {
		boolean result = false;
		PreparedStatement stm = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT email FROM Benutzer where email = ? and passwort = ?";
			stm = con.prepareStatement(sql);
			stm.setString(1, email);
			stm.setString(2, pwd);
			rs = stm.executeQuery();
			if(rs.next()) result = true;
		}
		finally {
			if(stm != null) stm.close();
		}
		return result;
	}
	
	public void speichereNeuenBenutzer(Connection con, Benutzer b) 
			throws SQLException {
		PreparedStatement stm = null;
		
		try {
			String sql = "INSERT INTO Benutzer VALUES (null,?,?,?,?,?,?,?)";
			stm = con.prepareStatement(sql);
			stm.setString(1, b.getEmail());
			stm.setString(2, b.getvName());
			stm.setString(3, b.getnName());
			stm.setString(4, b.getPw());
			stm.setString(5, b.getNickname());
			stm.setString(6, b.getUsergroup());
			stm.setBoolean(7, b.isIstGesperrt());
			
			stm.executeUpdate();
		} finally {
			if(stm != null) stm.close();
		}
	}
	
	public boolean benutzerEmailIstVorhanden (Connection con, String email) 
			throws SQLException {
		boolean result = false;
		PreparedStatement stm = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT email FROM Benutzer where email = ?";
			stm = con.prepareStatement(sql);
			stm.setString(1, email);
			rs = stm.executeQuery();
			if(rs.next()) result = true;
		}
		finally {
			if(stm != null) stm.close();
		}
		return result;
	}
	public boolean benutzerNicknameIstVorhanden (Connection con, String nickname) 
			throws SQLException {
		boolean result = false;
		PreparedStatement stm = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT nickname FROM Benutzer where nickname = ?";
			stm = con.prepareStatement(sql);
			stm.setString(1, nickname);
			rs = stm.executeQuery();
			if(rs.next()) result = true;
		}
		finally {
			if(stm != null) stm.close();
		}
		return result;
	}
	
	public ArrayList<Themengebiet> leseAlleThemengebiete(Connection con) 
			throws SQLException {
		ArrayList<Themengebiet> result = new ArrayList<Themengebiet>();
		PreparedStatement stm = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM themengebiete";
			stm = con.prepareStatement(sql);
			rs = stm.executeQuery();
			while(rs.next()) {
				Themengebiet tmp = new Themengebiet(rs.getInt(1), rs.getString(2));
				result.add(tmp);
			}
		}
		finally {
			if(stm != null) stm.close();
		}
		return result;
	}
	
	public ArrayList<Artikel> leseArtikelVonThemenebiet(Connection con, int themengebietid) 
			throws SQLException {
		ArrayList<Artikel> result = new ArrayList<Artikel>();
		PreparedStatement stm = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from artikel where themengebietid = (select themengebietid from themengebiete where themengebietid = ?)";
			stm = con.prepareStatement(sql);
			stm.setInt(1, themengebietid);
			rs = stm.executeQuery();
			while(rs.next()) {
				Artikel tmp = new Artikel(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getBoolean(6), rs.getInt(7));
				result.add(tmp);
			}
		}
		finally {
			if(stm != null) stm.close();
		}
		return result;
	}
	
	public void speichereNeuenKommentar(Connection con, Kommentar k) 
			throws SQLException {
		PreparedStatement stm = null;
		try {
			String sql = "INSERT INTO Kommentare VALUES (null,?,?,?,null,?,?)";
			stm = con.prepareStatement(sql);
			stm.setInt(1, k.getbID());
			stm.setInt(2, k.getaID());
			stm.setString(3, k.getKommentar());
			if(k.getZuKID() > 0) {
				stm.setInt(4, k.getZuKID());
			} else {
				stm.setNull(4, java.sql.Types.INTEGER);
			}
			stm.setBoolean(5, k.isIstGesperrt());
			stm.executeUpdate();
			
		} finally {
			if(stm != null) stm.close();
		}
	}
	
	public ArrayList<Kommentar> leseKommentareZuArtikel(Connection con, int artikelid) 
			throws SQLException {
		ArrayList<Kommentar> result = new ArrayList<Kommentar>();
		PreparedStatement stm = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from kommentare where zuartikelid = ?";
			stm = con.prepareStatement(sql);
			stm.setInt(1, artikelid);
			rs = stm.executeQuery();
			while(rs.next()) {
				Kommentar tmp = new Kommentar(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getTimestamp(5), rs.getInt(6), rs.getBoolean(7));
				result.add(tmp);
			}
		}
		finally {
			if(stm != null) stm.close();
		}
		return result;
	}
}