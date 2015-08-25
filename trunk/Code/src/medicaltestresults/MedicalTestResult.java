package medicaltestresults;

import medicaltests.MedicalTest;

public abstract class MedicalTestResult extends Result{

	private MedicalTest medicalTest; 

	/**
	 * 
	 * @param medicalTest	De medicaltest waarover het resultaat gaat
	 */
	public MedicalTestResult(MedicalTest medicalTest){
		super(null);
		setMedicalTest(medicalTest);
	}

	/**
	 * @return	De medicaltest waarover het resultaat gaat.
	 */
	public MedicalTest getMedicalTest() {
		return medicalTest;
	}
	
	public void setMedicalTest(MedicalTest medicalTest) {
		this.medicalTest = medicalTest;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}

