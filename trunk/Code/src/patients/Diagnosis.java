package patients;

import staff.Doctor;

public class Diagnosis {
	private int id;
	private Doctor doctor;
	private Patient patient;
	private String description;
	private Doctor secondDoctor;
	private String secondOpinion;
	private boolean requiresSecondOpinion;
	private boolean approved; // Thijs: needed for diagnosisController.java
	private String decision;
	
	/**
	 * 
	 * @param description
	 */
	public Diagnosis(Doctor doctor, Patient patient, String description) {
		this.doctor = doctor;
		this.patient = patient;
		this.description = description;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getSecondDoctor() {
		return secondDoctor;
	}

	public void setSecondDoctor(Doctor secondDoctor) {
		this.secondDoctor = secondDoctor;
	}

	public String getSecondOpinion() {
		return secondOpinion;
	}

	public void setSecondOpinion(String secondOpinion) {
		this.secondOpinion = secondOpinion;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public String getDecision() {
		return decision;
	}

	public void setDecision(String decision) {
		this.decision = decision;
	}

	public boolean requiresSecondOpinion() {
		return requiresSecondOpinion;
	}

	public void setRequiresSecondOpinion(boolean requiresSecondOpinion) {
		this.requiresSecondOpinion = requiresSecondOpinion;
	}
	
	@Override
	public String toString() {
		return "" + id + ". Diagnosis: Doctor: " + doctor.getName() + " Patient: " + patient.getName();
	}
}
