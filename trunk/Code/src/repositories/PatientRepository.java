package repositories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import patients.Patient;

public class PatientRepository {
	private List<Patient> patients;
	private List<Patient> nonDischargedPatients;
	private int latestGeneratedID;
	
	public PatientRepository() {
		this.patients = new ArrayList<Patient>();
		this.nonDischargedPatients = new ArrayList<Patient>();
		this.latestGeneratedID = 0;
	}
	
	public List<Patient> getPatients() {
		return Collections.unmodifiableList(patients);
	}
	
	public List<Patient> getNonDischargedPatients() {
		return Collections.unmodifiableList(nonDischargedPatients);
	}
	
	public int addPatient(String name) {
		Patient patient = new Patient(name);
		patient.setId(++latestGeneratedID);
		patients.add(patient);
		nonDischargedPatients.add(patient);
		
		return patient.getId();
	}
	
	public Patient getPatientByID(int id) {
		for (Patient patient : patients) {
			if (patient.getId() == id) {
				return patient;
			}
		}
		
		return null;
	}
}
