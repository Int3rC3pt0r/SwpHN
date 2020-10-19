package dbmodel;

public class Themengebiete {
	int tID;
	String themengebiet;
	public Themengebiete(int tID, String themengebiet) {
		super();
		this.tID = tID;
		this.themengebiet = themengebiet;
	}
	public int gettID() {
		return tID;
	}
	public void settID(int tID) {
		this.tID = tID;
	}
	public String getThemengebiet() {
		return themengebiet;
	}
	public void setThemengebiet(String themengebiet) {
		this.themengebiet = themengebiet;
	}
	@Override
	public String toString() {
		return "Themengebiete [tID=" + tID + ", themengebiet=" + themengebiet + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + tID;
		result = prime * result + ((themengebiet == null) ? 0 : themengebiet.hashCode());
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
		Themengebiete other = (Themengebiete) obj;
		if (tID != other.tID)
			return false;
		if (themengebiet == null) {
			if (other.themengebiet != null)
				return false;
		} else if (!themengebiet.equals(other.themengebiet))
			return false;
		return true;
	}
	
}
