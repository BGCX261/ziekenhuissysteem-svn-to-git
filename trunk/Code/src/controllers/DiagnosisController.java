package controllers;

import java.util.List;

import patients.Diagnosis;
import patients.Patient;
import repositories.PatientRepository;
import repositories.StaffRepository;
import staff.Doctor;

public class DiagnosisController
{
    private StaffRepository   staffRepository;
    private PatientRepository patientRepository;

    public DiagnosisController( StaffRepository staffRepository, PatientRepository patientRepository )
    {
        this.staffRepository = staffRepository;
        this.patientRepository = patientRepository;
    }

    public void enterDiagnosis( int doctorID, int patientID, String description, int secondDoctorID )
    {
        Doctor doctor = (Doctor) staffRepository.getStaffMemberByID( doctorID );
        Patient patient = patientRepository.getPatientByID( patientID );

        Diagnosis diagnosis = new Diagnosis( doctor, patient, description );
        if ( secondDoctorID != 0 )
        {
            Doctor secondDoctor = (Doctor) staffRepository.getStaffMemberByID( secondDoctorID );
            diagnosis.setSecondDoctor( secondDoctor );
            secondDoctor.addNeedSecondOpinion( diagnosis );
        }
        patient.getPatientFile().setDiagnosis( diagnosis );
    }

    public List<Diagnosis> getSecondOpinionDiagnosis( int doctorID )
    {
        Doctor doctor = (Doctor) staffRepository.getStaffMemberByID( doctorID );
        return doctor.getSecondOpinionDiagnosis();
    }

    public Diagnosis getDiagnosisByID( int doctorID, int diagnosisID )
    {
        Doctor doctor = (Doctor) staffRepository.getStaffMemberByID( doctorID );
        for ( Diagnosis diagnosis : doctor.getSecondOpinionDiagnosis() )
        {
            if ( diagnosis.getId() == diagnosisID )
            {
                return diagnosis;
            }
        }

        return null;
    }

    // Hospital hospital;
    //
    // public DiagnosisController(Hospital hospital) {
    // this.hospital = hospital;
    // }
    // public static void main(String[] args) {
    // System.out.println("testje");
    // }
    // public void enterDiagnosis() {
    // // TODO: input form
    // }
    //
    // public void registerDiagnosis(String description) {
    // Diagnosis diagnosis = new Diagnosis(description);
    // diagnosis.setDoctor(null);
    // // TODO: add to list of diagnosis
    // }
    //
    // public void requestOpinion(Diagnosis diagnosis) {
    // System.out.println(listDoctors());
    // Doctor secondDoctor = selectSecondDoctor();
    // String secondOpinion = enterSecondOpinion();
    // registerSecondOpinion(secondDoctor, secondOpinion);
    // }
    //
    // public String listDoctors() {
    // return null;
    // }
    //
    // public String enterSecondOpinion() {
    // String secondOpinion = null;
    // return secondOpinion;
    // }
    //
    // public Doctor selectSecondDoctor() {
    // Doctor secondDoctor = null; //TODO
    // return secondDoctor;
    // }
    //
    // public void registerSecondOpinion(Doctor doctor, String description) {
    // // TODO
    // }
    //
    //
    // // Controller for review diagnosis use case
    // private Diagnosis selectedDiagnosis;
    //
    // // flowstep 1: The doctor indicates s/he wants to review a diagnosis
    // public void reviewDiagnosis(Diagnosis diagnosis) {
    //
    // }
    //
    // // flowstep 2: The system displays the list of diagnoses which require a
    // second opinion from the current doctor
    // public String listDiagnosisThatRequireSecondOpinion() {
    // return null;
    // }
    //
    // // flowstep 3: The doctor selects the appropriate diagnosis from the list
    // public void selectDiagnosis(Diagnosis diagnosis) {
    // selectedDiagnosis = diagnosis;
    // }
    //
    // // flowstep 4: The system displays the details of the diagnosis and oers
    // the doctor to review the patient's previous test/treatment results
    //
    // public String displayDetailsSelectedDiagnosis() {
    // // if (wantToReviewPreviousResults == true)
    // reviewPreviousResults();
    // return selectedDiagnosis.toString();
    // }
    //
    //
    // public void reviewPreviousResults() {
    // // TODO: selectedTreatment.getPatient().getResults();
    // }
    //
    // // flowstep 5: The doctor approves the diagnosis that has been determined
    // by his/her colleague
    // public void approveDiagnosis() {
    // selectedDiagnosis.setApproved(true);
    // }
    //
    // // flowstep 6: The system stores the decision ...
    // public void storeDecision() {
    // selectedDiagnosis.setDecision(selectedDiagnosis.getDescription());
    // }
    //
    // // flowstep 6: ... and schedules the treatment associated with the
    // diagnosis
    // public void scheduleTreatment() {
    // // TODO Vincent
    // }
    //
    // // flowstep 7: The system displays the scheduled treatment and its
    // details to the doctor
    // public String showDetailsScheduledTreatment() {
    // // TODO Vincent
    // return null;
    // }
    //
    // // Alternate flowstep 1: The doctor signals his/her disagreement to the
    // system
    // public void disapproveDiagnosis() {
    // selectedDiagnosis.setApproved(false);
    // informDisagreement();
    // }
    //
    // public void informDisagreement() {
    // // TODO
    // }
    //
    // // Alternate flowstep 2: The system marks the original diagnosis as
    // invalid (the associated treatment is discarded and not scheduled)
    // public void discardDiagnosis() {
    // selectedDiagnosis.discardTreatment();
    // }
    //
    // /* TODO: (slightly different from enterDiagnosis() ? 3. The system asks
    // the doctor to enter a new diagnosis: include use case \Enter Diag-
    // nosis", but automatically requires the doctor of the original diagnosis
    // to give his/her
    // second opinion about the new diagnosis */
    //
    //
    //
    //
}
