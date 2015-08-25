package controllers;

import java.util.List;

import patients.Patient;

import repositories.PatientRepository;

public class PatientController {
	private PatientRepository patientRepository;
	private Patient selectedPatient;
	
	public PatientController(PatientRepository patientRepository) {
		this.patientRepository = patientRepository;
	}
	
	public List<Patient> getPreviouslyRegisteredPatients() {
		return patientRepository.getPatients();
	}
	
	public Patient getSelectedPatient() {
		return selectedPatient;
	}
	
	public void addPatient(String name) {
		int patientID = patientRepository.addPatient(name);
		registerPatient(patientID);
	}

	public void registerPatient(int patientID) {
		selectedPatient = patientRepository.getPatientByID(patientID);
	}
	
	public Patient getPatientByPatientID(int patientID) {
		for (Patient patient : patientRepository.getPatients()) {
			if (patient.getId() == patientID) {
				return patient;
			}
		}
		
		return null;
	}
	
//	// select a patient from previous registered patients
//	public void selectPatient() {
//		
//		System.out.println("Please enter the patient\'s ID.");
//		Scanner scan = new Scanner(System.in);
//		int patientId = scan.nextInt();
//		for (Patient patient: getHospital().getPreviouslyRegisteredPatients()) {
//			if (patient.getId() == patientId) {
//				setSelectedPatient(patient);
//			}
//		}
//		// patient is a new patient without history
//		if (getSelectedPatient() == null) {
//			createNewPatient();
//		}
//	}
//	
//	public Patient getSelectedPatient() {
//		return selectedPatient;
//	}
//
//	public void setSelectedPatient(Patient selectedPatient) {
//		this.selectedPatient = selectedPatient;
//	}
//
//	public void selectCheckinPatient(Calendar checkin) {
//		// TODO Vincent
//	}
//	
//	public void selectDoctor() {
//		// TODO Vincent
//	}
//	
//	public void createDoctorAppointment() {
//		// TODO Vincent
//	}
//	
//	// create the new patient without history 
//	public void createNewPatient() {
//		Patient patient = requestPatientDetails();
//		getHospital().addPatient(patient); // system registers new patient
//		setSelectedPatient(patient); // continue with step 4
//	}
//	
//	public Patient requestPatientDetails() {
//		System.out.println("Enter the patient's full name.");
//		Scanner scan = new Scanner(System.in);
//		String patientName = scan.nextLine();
//		Patient patient = new Patient(patientName);
//		patient.setId(generateValidId());
//		return patient;
//	}
//	
//	public int generateValidId() {
//		int newId = -1;
//		for (Patient registeredPatient: getAllRegisteredPatients()) {
//			if (registeredPatient.getId() > newId)
//				newId = registeredPatient.getId();
//		}
//		return newId+1;
//	}
//
//	private List<Patient> getAllRegisteredPatients() {
//		return null; // TODO
//	}
//	
//	// DISCHARGE PATIENT CONTROLLER
//	
//	// 1. A doctor indicates s/he wants to discharge the currently selected patient
//	// 2. The system marks the patient as discharged
//	public void dischargeSelectedPatient() {
//		getSelectedPatient().discharge();
//	}
//	
//	// The patient has a diagnosis that has not been cleared by a doctor (i.e. a diagnosis which
//	// has no treatments, or which was not explicitly marked as successfully treated)
//	// 1. The system signals an error
//	public void signalUnclearTreatment() {
//		// TODO
//	}
}
