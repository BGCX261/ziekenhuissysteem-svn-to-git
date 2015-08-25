package patients;

import java.util.List;

import scheduling.ScheduleResource;
import scheduling.TimePeriod;

public class Patient implements ScheduleResource {
	private int id;
	private String name;
	private boolean discharged;
	private PatientFile patientFile;
	private List<Diagnosis> diagnosisList;
	
	/**
	 * Maak een nieuwe patient, met naam
	 * @param name	de naam van de nieuwe patient
	 */
	public Patient(String name) {
		this.name = name;
		this.discharged = false;
		this.patientFile = new PatientFile(this);
	}

	/**
	 * 
	 * @return De unieke identifier van de patient
	 */
	public int getId() {
		return id;
	}

	/**
	 * zet een unieke id voor de patient
	 * @param id	de identifier, als integer
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 *
	 * @return de naam van de patient
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return	true als de patient ontslagen is uit het ziekenhuis
	 */
	public boolean isDischarged() {
		return discharged;
	}

	/**
	 * @param discharged True als de patient ontslagen is uit het ziekenhuis
	 */
	public void setDischarged(boolean discharged) {
		this.discharged = discharged;
	}
	
	/**
	 * 
	 * @return het dosier van de patient als patientFile
	 */
	public PatientFile getPatientFile() {
		return patientFile;
	}

	@Override
	public String toString() {
		return "" + id + ". " + name;
	}

	/**
	 * Een patient heeft altijd tijd, d.w.z. een patient die in het systeem zit
	 * kan altijd gescheduled worden.
	 */
	@Override
	public boolean isWorking(TimePeriod period) {
		return true;
	}

	public List<Diagnosis> getDiagnosisList() {
		return diagnosisList;
	}

	public void setDiagnosisList(List<Diagnosis> diagnosisList) {
		this.diagnosisList = diagnosisList;
	}
	
	public boolean untreatedDiagnosis() {
		for (Diagnosis diagnosis : getDiagnosisList()) {
			if (!diagnosis.isApproved())
				return true;
		}
		return false;
	}

	@Override
	public TimePeriod notWorking(TimePeriod period) {
		return null;
	}
}
