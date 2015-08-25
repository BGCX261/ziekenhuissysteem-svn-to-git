package controllers;

import medicaltests.BloodAnalysis;
import medicaltests.MedicalTest;
import medicaltests.UltrasoundScan;
import medicaltests.XRayScan;
import patients.Patient;
import repositories.PatientRepository;
import scheduling.Scheduler;

public class OrderMedicalTestController
{
    private PatientRepository patientRepository;
    private Scheduler         scheduler;

    public OrderMedicalTestController( PatientRepository patientRepository, Scheduler scheduler )
    {
        this.patientRepository = patientRepository;
        this.scheduler = scheduler;
    }

    public MedicalTest orderBloodAnalysis( int patientID, String focus, int numberOfAnalyses )
    {
        BloodAnalysis analysis = new BloodAnalysis( focus, numberOfAnalyses );
        Patient patient = patientRepository.getPatientByID( patientID );
        patient.getPatientFile().addMedicalTest( analysis );

        analysis.setPatient( patient );
        try
        {
            scheduler.schedule( analysis );
        }
        catch ( Exception e )
        {
            // FIXME Mja, exceptions inslikken...
            // Op zich goed voor die ellendige checked exceptions
            // Maar hier impliceert de docs dat een exception mogelijk is
            // en je doet er niks mee
            // Moet men dan van buitenaf altijd checken of de analysis wel juist
            // gescheduled werd?
        }

        return analysis;
    }

    public MedicalTest orderUltrasoundScan( int patientID, String focus, boolean recordVideo, boolean recordImages )
    {
        UltrasoundScan ultrasoundScan = new UltrasoundScan( focus, recordVideo, recordImages );
        Patient patient = patientRepository.getPatientByID( patientID );
        patient.getPatientFile().addMedicalTest( ultrasoundScan );

        ultrasoundScan.setPatient( patient );
        try
        {
            scheduler.schedule( ultrasoundScan );
        }
        catch ( Exception e )
        {
            // FIXME Zie hierboven
        }

        return ultrasoundScan;
    }

    public MedicalTest orderXRayScan( int patientID, String bodyPart, int nbOfImagesNeeded, int zoomlevel )
    {
        XRayScan xRayScan = new XRayScan( bodyPart, nbOfImagesNeeded, zoomlevel );
        Patient patient = patientRepository.getPatientByID( patientID );
        patient.getPatientFile().addMedicalTest( xRayScan );

        xRayScan.setPatient( patient );
        try
        {
            scheduler.schedule( xRayScan );
            System.out.println( "Scheduling" );
        }
        catch ( Exception e )
        {
            // FIXME Zie hierboven
        }

        return xRayScan;
    }
}
