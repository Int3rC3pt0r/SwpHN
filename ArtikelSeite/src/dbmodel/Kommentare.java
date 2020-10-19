package dbmodel;

public class Kommentare {
	int kID;
	int bID;
	int aID;
	String kommentar;
	int zuKID;
	boolean istGesperrt = false;
	public Kommentare(int kID, int bID, int aID, String kommentar, int zuKID) {
		super();
		this.kID = kID;
		this.bID = bID;
		this.aID = aID;
		this.kommentar = kommentar;
		this.zuKID = zuKID;
	}
	public int getkID() {
		return kID;
	}
	public void setkID(int kID) {
		this.kID = kID;
	}
	public int getbID() {
		return bID;
	}
	public void setbID(int bID) {
		this.bID = bID;
	}
	public int getaID() {
		return aID;
	}
	public void setaID(int aID) {
		this.aID = aID;
	}
	public String getKommentar() {
		return kommentar;
	}
	public void setKommentar(String kommentar) {
		this.kommentar = kommentar;
	}
	public int getZuKID() {
		return zuKID;
	}
	public void setZuKID(int zuKID) {
		this.zuKID = zuKID;
	}
	public boolean isIstGesperrt() {
		return istGesperrt;
	}
	public void setIstGesperrt(boolean istGesperrt) {
		this.istGesperrt = istGesperrt;
	}
	@Override
	public String toString() {
		return "Kommentare [kID=" + kID + ", bID=" + bID + ", aID=" + aID + ", kommentar=" + kommentar + ", zuKID="
				+ zuKID + ", istGesperrt=" + istGesperrt + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + aID;
		result = prime * result + bID;
		result = prime * result + (istGesperrt ? 1231 : 1237);
		result = prime * result + kID;
		result = prime * result + ((kommentar == null) ? 0 : kommentar.hashCode());
		result = prime * result + zuKID;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Kommentare other = (Kommentare) obj;
		if (aID != other.aID)
			return false;
		if (bID != other.bID)
			return false;
		if (istGesperrt != other.istGesperrt)
			return false;
		if (kID != other.kID)
			return false;
		if (kommentar == null) {
			if (other.kommentar != null)
				return false;
		} else if (!kommentar.equals(other.kommentar))
			return false;
		if (zuKID != other.zuKID)
			return false;
		return true;
	}
	
	
}
