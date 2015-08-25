package patients;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import treatments.Treatment;


import medicaltestresults.Result;
import medicaltests.MedicalTest;

public class PatientFile {
	private Patient patient;
	private boolean closed;
	private Diagnosis diagnosis;
	private List<MedicalTest> medicalTests;
	private List<Treatment> treatments;
	private List<Result> results;
	
	public PatientFile(Patient patient) {
		this.patient = patient;
		this.closed = false;
		this.diagnosis = null;
		this.medicalTests = new ArrayList<MedicalTest>();
		this.results = new ArrayList<Result>();
		this.treatments = new ArrayList<Treatment>();
	}
	
	public Patient getPatient() {
		return patient;
	}
	
	public boolean isClosed() {
		return closed;
	}

	public void setClosed(boolean closed) {
		this.closed = closed;
	}
	
	public Diagnosis getDiagnosis() {
		return diagnosis;
	}
	
	public void setDiagnosis(Diagnosis diagnosis) {
		this.diagnosis = diagnosis;
	}
	
	public List<MedicalTest> getMedicalTests() {
		return Collections.unmodifiableList(medicalTests);
	}
	
	public List<Result> getResults() {
		return Collections.unmodifiableList(results);
	}
	
	public void addMedicalTest(MedicalTest medicalTest) {
		medicalTests.add(medicalTest);
	}
	
	public void addTreatment(Treatment treatment) {
		treatments.add(treatment);
	}
}
