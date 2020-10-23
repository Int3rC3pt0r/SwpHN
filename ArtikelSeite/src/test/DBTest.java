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
			
			boolean login1 = db.benutzerAnmeldungIstOk(con, "b1@mail.at", "nutzer1");
			System.out.println(login1);
			boolean login2 = db.benutzerAnmeldungIstOk(con, "b1@mail.at", "wrongPW");
			System.out.println(login2);
			boolean login3 = db.benutzerAnmeldungIstOk(con, "false@mail.at", "nutzer1");
			System.out.println(login3);
			boolean login4 = db.benutzerAnmeldungIstOk(con, "false@mail.at", "wrongPW");
			System.out.println(login4);
			
			Benutzer testInsert = new Benutzer("test@insert.com","test","insert","testPW","AusmProgramm","A",false);
			db.speichereNeuenBenutzer(con, testInsert);
			
			System.out.println(db.benutzerEmailIstVorhanden(con, "test@insert.com"));
			System.out.println(db.benutzerEmailIstVorhanden(con, "false@again.com"));
			
			System.out.println(db.benutzerNicknameIstVorhanden(con, "AusmProgramm"));
			System.out.println(db.benutzerNicknameIstVorhanden(con, "nichtVorhanden"));
			
			ArrayList<Themengebiet> alleThemen = db.leseAlleThemengebiete(con);
			for(Themengebiet t : alleThemen) {
				System.out.printf("%s\t%s\n",t.gettID(), t.getThemengebiet());
			}
			
			ArrayList<Artikel> eSportAritkel = db.leseArtikelVonThemenebiet(con, 3);
			for(Artikel a : eSportAritkel) {
				System.out.printf("%s\n\t%s\n\n",a.getHeadline(), a.getZusammenfassung());
			}
			
			Kommentar k = new Kommentar(2,1,"Das ist eine Kommentar",-1,false);
			db.speichereNeuenKommentar(con, k);
			
			ArrayList<Kommentar> kList = db.leseKommentareZuArtikel(con, 1);
			for(Kommentar ko : kList) {
				System.out.println(ko);
			}
			
			
		} finally {
			if(con != null) 
				db.releaseConnection(con);
			
		}
		System.out.println("BD close OK");
	}

}
