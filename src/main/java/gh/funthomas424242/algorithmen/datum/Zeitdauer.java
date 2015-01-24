package gh.funthomas424242.algorithmen.datum;

public class Zeitdauer {
	
	protected int jahre;
	
	protected int monate;
	
	protected int tage;
	
	public Zeitdauer(final int jahre,final int monate, final int tage){
		this.jahre=jahre;
		this.monate=monate;
		this.tage=tage;
	}

	public int getJahre(){
		return jahre;
	}
	
	public int getMonate() {
		return monate;
	}

	public int getTage() {
		return tage;
	}
	
	

}
