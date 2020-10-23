package dbmodel;

public class Benutzer {
	int bID;
	String email;
	String vName;
	String nName;
	String pw;
	String nickname;
	String usergroup;
	boolean istGesperrt;
	
	public Benutzer() {
		super();
		bID = -1;
		email = "";
		vName = "";
		nName = "";
		pw = "";
		nickname = "";
		usergroup = "";
		istGesperrt = false;
	}

	public Benutzer(int bID, String email, String vName, String nName, String pw, String nickname, String usergroup,
			boolean istGesperrt) {
		super();
		this.bID = bID;
		this.email = email;
		this.vName = vName;
		this.nName = nName;
		this.pw = pw;
		this.nickname = nickname;
		this.usergroup = usergroup;
		this.istGesperrt = istGesperrt;
	}
	
	public Benutzer(String email, String vName, String nName, String pw, String nickname, String usergroup,
			boolean istGesperrt) {
		super();
		this.email = email;
		this.vName = vName;
		this.nName = nName;
		this.pw = pw;
		this.nickname = nickname;
		this.usergroup = usergroup;
		this.istGesperrt = istGesperrt;
	}
	
	public int getbID() {
		return bID;
	}
	public void setbID(int bID) {
		this.bID = bID;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getvName() {
		return vName;
	}
	public void setvName(String vName) {
		this.vName = vName;
	}
	public String getnName() {
		return nName;
	}
	public void setnName(String nName) {
		this.nName = nName;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getUsergroup() {
		return usergroup;
	}
	public void setUsergroup(String usergroup) {
		this.usergroup = usergroup;
	}
	public boolean isIstGesperrt() {
		return istGesperrt;
	}
	public void setIstGesperrt(boolean istGesperrt) {
		this.istGesperrt = istGesperrt;
	}
	
	
	
}
