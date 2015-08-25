package controllers;

import java.util.List;

import medicaltestresults.Result;
import patients.*;
import repositories.*;
import staff.Doctor;

public class PatientFileController
{
    private PatientRepository patientRepository;
    private StaffRepository   staffRepository;
    private Patient           selectedPatient;

    public PatientFileController( PatientRepository patientRepository, StaffRepository staffRepository )
    {
        this.patientRepository = patientRepository;
        this.staffRepository = staffRepository;
    }

    public List<Patient> getNonDischargedPatients()
    {
        return patientRepository.getNonDischargedPatients();
    }

    // FIXME Geef verantwoording voor gebruik IDs en niet rechtstreeks objecten (hoeft niet per se veranderd te worden! ik wil gewoon uitleg)
    public List<Result> consultPatientFile( int doctorID, int patientID )
    {
        selectedPatient = patientRepository.getPatientByID( patientID );
        PatientFile selectedPatientFile = selectedPatient.getPatientFile();
        Doctor doctor = (Doctor) staffRepository.getStaffMemberByID( doctorID ); // FIXME Kan beter, laat de check gebeuren door het domein ipv hier te steunen op een ClassCastException
        PatientFile lastOpenedPatientFile = doctor.getLastOpenedPatientFile();

        if ( lastOpenedPatientFile != null && !lastOpenedPatientFile.isClosed() )
        {
            lastOpenedPatientFile.setClosed( true );
        }
        selectedPatientFile.setClosed( false );
        doctor.setLastOpenedPatientFile( selectedPatientFile );

        return selectedPatientFile.getResults();
    }

    public List<Result> getResults( int patientID )
    {
        Patient patient = patientRepository.getPatientByID( patientID );
        PatientFile patientFile = patient.getPatientFile();

        return patientFile.getResults();
    }

    public void closePatientFile()
    {
        selectedPatient.getPatientFile().setClosed( true );
    }

    public boolean dischargePatient()
    {
        if ( selectedPatient.untreatedDiagnosis() ) return false;
        else
        {
            selectedPatient.setDischarged( true );
            return true;
        }
    }

    public Result getResult( int resultID )
    {
        List<Result> results = selectedPatient.getPatientFile().getResults();
        for ( Result result : results )
        {
            if ( result.getId() == resultID )
            {
                return result;
            }
        }

        return null;
    }

    // private List<PatientFile> nonDischargedPatientFiles;
    // private List<Patient> nonDischargedPatients;
    // private PatientFile patientFileCurrentlyConsulting;
    // private Patient selectedPatient;
    //
    // public PatientFileController(Hospital hospital) {
    // this.hospital = hospital;
    // }
    //
    // // TODO flowstep 1
    // public void consultPatientFile() {
    //
    // }
    //
    // // flowstep 2
    // public String ListNonDischargedPatients() {
    // String nonDischargedPatients = "";
    // // TODO: find nonDischargedPatients
    // List<Patient> nonDischargedPatientsList = new ArrayList<Patient>();
    // for(Patient patient : nonDischargedPatientsList) {
    // nonDischargedPatients += patient.getId() + patient.getName() + "\n";
    // }
    // return nonDischargedPatients;
    // }
    //
    // // flowstep 3
    // public void selectedPatient(int id) {
    // for (Patient nonDischargedPatient: getNonDischargedPatients()) {
    // if (nonDischargedPatient.getId() == id) {
    // setSelectedPatient(nonDischargedPatient);
    // }
    // }
    // }
    //
    // // flowstep 4
    // public void consultPatientFile(Patient patient) {
    // closeOldOpenedPatientFile();
    // this.patientFileCurrentlyConsulting = new PatientFile(patient);
    // }
    //
    // public void closeOldOpenedPatientFile() {
    //
    // }
    //
    // // flowstep 5: The system displays a list of all the medical test and
    // treatment results of the selected patient (if any)
    // public String listMedicalTestAndTreatmentResult() {
    // String results = "";
    // List<Result> medicalTestAndTreatmentResults = new ArrayList<Result>();
    // for(Result result : medicalTestAndTreatmentResults) {
    // results += ""; // TODO: Result class doesn't have attributes
    // }
    // return results;
    // }
    //
    // // flowstep 6: The doctor can review any of these results in detail
    // public void getResultDetails(Result result) {
    // System.out.println(result); // TODO
    // }
    //
    // public void closePatientFile() {
    // if (patientFileCurrentlyConsulting != null) {
    // patientFileCurrentlyConsulting.setClosed(true);
    // }
    // }
    //
    //
    //
    // public List<PatientFile> getNonDischargedPatientFiles() {
    // return nonDischargedPatientFiles;
    // }
    //
    // public void setNonDischargedPatientFiles(List<PatientFile>
    // nonDischargedPatients) {
    // this.nonDischargedPatientFiles = nonDischargedPatientFiles;
    // }
    //
    // public List<Patient> getNonDischargedPatients() {
    // return nonDischargedPatients;
    // }
    //
    // public void setNonDischargedPatients(List<Patient> nonDischargedPatients)
    // {
    // this.nonDischargedPatients = nonDischargedPatients;
    // }
    //
    // public Patient getSelectedPatient() {
    // return selectedPatient;
    // }
    //
    // public void setSelectedPatient(Patient selectedPatient) {
    // this.selectedPatient = selectedPatient;
    // }
}
