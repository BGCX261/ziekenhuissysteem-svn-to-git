package medicaltestresults;

import medicaltests.XRayScan;

public class XRayScanResult extends MedicalTestResult {
	private String abnormalities;
	private int numberOfImagesTaken;
	/**
	 * 
	 * @param xRayScan			de medicaltest xrayscan
	 * @param abnormalities		abnormaliteiten
	 * @param numberOfImagesTaken	Het aantal afbeeldingen
	 */
	public XRayScanResult(XRayScan xRayScan, String abnormalities, int numberOfImagesTaken) {
		super(xRayScan);
		setNumberOfImagesTaken(numberOfImagesTaken);
		setAbnormalities(abnormalities);
	}
	
	@Override
	public String toString() {
		return super.toString() + abnormalities;
	}
	

	public void setNumberOfImagesTaken(int numberOfImagesTaken) throws IllegalArgumentException{
		if(numberOfImagesTaken>=0) this.numberOfImagesTaken = numberOfImagesTaken;
		else throw new IllegalArgumentException();
	}
	
	public int getNumberOfImagesTaken() {
		return numberOfImagesTaken;
	}


	public String getAbnormalities() {
		return abnormalities;
	}


	public void setAbnormalities(String abnormalities) {
		this.abnormalities = abnormalities;
	}

}
