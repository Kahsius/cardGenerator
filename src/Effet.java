
public class Effet {
	public String name;
	public boolean isMaitrisable;
	public boolean needValue;
	public boolean modifFight;
	public int value;
	public double param;
	
	public Effet(String name, boolean iM, boolean nV, boolean mF, double param) {
		this.name = name;
		this.isMaitrisable = iM;
		this.needValue = nV;
		this.modifFight = mF;
		this.param = param;
	}
}
