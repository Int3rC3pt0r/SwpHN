package test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbmodel.*;

public class DBTest {

	public static void main(String[] args)
		throws SQLException, ClassNotFoundException{
		
		DBManager db = new DBManager();
		Connection con = null;
		
		try {
			con = db.getConnection();
			System.out.println("DB Verbindung OK");
			
			
			List<Abteilung> al = db.getAbteilungen(con);
			for(Abteilung tmp : al) {
				System.out.println(tmp);
			}
		} finally {
			if(con != null) 
				db.releaseConnection(con);
			
		}
		System.out.println("BD close OK");
	}

}
