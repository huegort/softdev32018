package ie.gmit.week10.enums;

public enum Month {
	JAN(31,"January"),
	FEB(28,"February"),
	MAR(31,"March");
	
	
	int days;
	String dispay;
	
	 Month(int days, String display) {
		this.days = days;
		this.dispay = display;
	}
	public int getDays() {
		return this.days;
	}
	@Override
	public String toString() {
		return this.dispay;
	}

}
