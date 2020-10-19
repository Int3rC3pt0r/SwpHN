package dbmodel;

public class Artikel {
	int aID;
	int bID;
	String headline;
	String zusammenfassung;
	String artikelText;
	boolean istGesperrt = false;
	int tID;
	int aufrufe = 0;
	public Artikel(int aID, int bID, String headline, String zusammenfassung, String artikelText, int tID,
			int aufrufe) {
		super();
		this.aID = aID;
		this.bID = bID;
		this.headline = headline;
		this.zusammenfassung = zusammenfassung;
		this.artikelText = artikelText;
		this.tID = tID;
		this.aufrufe = aufrufe;
	}
	public int getaID() {
		return aID;
	}
	public void setaID(int aID) {
		this.aID = aID;
	}
	public int getbID() {
		return bID;
	}
	public void setbID(int bID) {
		this.bID = bID;
	}
	public String getHeadline() {
		return headline;
	}
	public void setHeadline(String headline) {
		this.headline = headline;
	}
	public String getZusammenfassung() {
		return zusammenfassung;
	}
	public void setZusammenfassung(String zusammenfassung) {
		this.zusammenfassung = zusammenfassung;
	}
	public String getArtikelText() {
		return artikelText;
	}
	public void setArtikelText(String artikelText) {
		this.artikelText = artikelText;
	}
	public boolean isIstGesperrt() {
		return istGesperrt;
	}
	public void setIstGesperrt(boolean istGesperrt) {
		this.istGesperrt = istGesperrt;
	}
	public int gettID() {
		return tID;
	}
	public void settID(int tID) {
		this.tID = tID;
	}
	public int getAufrufe() {
		return aufrufe;
	}
	public void setAufrufe(int aufrufe) {
		this.aufrufe = aufrufe;
	}
	@Override
	public String toString() {
		return "Artikel [aID=" + aID + ", bID=" + bID + ", headline=" + headline + ", zusammenfassung="
				+ zusammenfassung + ", artikelText=" + artikelText + ", istGesperrt=" + istGesperrt + ", tID=" + tID
				+ ", aufrufe=" + aufrufe + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + aID;
		result = prime * result + ((artikelText == null) ? 0 : artikelText.hashCode());
		result = prime * result + aufrufe;
		result = prime * result + bID;
		result = prime * result + ((headline == null) ? 0 : headline.hashCode());
		result = prime * result + (istGesperrt ? 1231 : 1237);
		result = prime * result + tID;
		result = prime * result + ((zusammenfassung == null) ? 0 : zusammenfassung.hashCode());
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
		Artikel other = (Artikel) obj;
		if (aID != other.aID)
			return false;
		if (artikelText == null) {
			if (other.artikelText != null)
				return false;
		} else if (!artikelText.equals(other.artikelText))
			return false;
		if (aufrufe != other.aufrufe)
			return false;
		if (bID != other.bID)
			return false;
		if (headline == null) {
			if (other.headline != null)
				return false;
		} else if (!headline.equals(other.headline))
			return false;
		if (istGesperrt != other.istGesperrt)
			return false;
		if (tID != other.tID)
			return false;
		if (zusammenfassung == null) {
			if (other.zusammenfassung != null)
				return false;
		} else if (!zusammenfassung.equals(other.zusammenfassung))
			return false;
		return true;
	}
	
}
