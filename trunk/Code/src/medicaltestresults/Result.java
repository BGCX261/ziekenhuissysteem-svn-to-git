package medicaltestresults;

import patients.PatientFile;

/**
 * This class represents a result of a medical test or treatment.
 *
 */
public class Result {
	private int id;
	private PatientFile patientFile;
	
	/**
	 * 
	 * @param patientFile	Het gegevensbestand van de patient
	 */
	public Result(PatientFile patientFile) {
		this.patientFile = patientFile;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PatientFile getPatientFile() {
		return patientFile;
	}
	
	public String getDetails() {
		return "";
	}
	
	@Override
	public String toString() {
		return "" + id + ". ";
	}
}
