package treatments;



public class Cast extends Treatment {
	private static final int DURATIONOFCREATION=120;
	
	private String bodyPart;
	private int durationInDays;
	
	public Cast(String bodyPart, int durationInDays) {
		super(DURATIONOFCREATION);
		setBodyPart(bodyPart);
		setDurationInDays(durationInDays);
	}
	
	public int getDurationInDays() {
		return durationInDays;
	}
	
	public void setDurationInDays(int durationInDays) throws IllegalArgumentException{
		if (durationInDays>=0) this.durationInDays = durationInDays;
		else throw new IllegalArgumentException();
	}

	public String getBodyPart() {
		return bodyPart;
	}

	public void setBodyPart(String bodyPart) {
		this.bodyPart = bodyPart;
	}
	
	@Override
	public String toString() {
		return "Body Part: " + bodyPart + "Duration: " + durationInDays;
	}
}
