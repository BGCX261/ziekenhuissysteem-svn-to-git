package controllers;

import patients.Patient;
import repositories.PatientRepository;
import scheduling.Scheduler;
import treatments.Cast;
import treatments.Medication;
import treatments.Surgery;
import treatments.Treatment;

public class PrescribeTreatmentController
{
    private PatientRepository patientRepository;
    private Scheduler         scheduler;

    public PrescribeTreatmentController( PatientRepository patientRepository, Scheduler scheduler )
    {
        this.patientRepository = patientRepository;
        this.scheduler = scheduler;
    }

    public Treatment prescribeMedication( int patientID, String description, boolean sensitive )
    {
        Medication medication = new Medication( description, sensitive );
        Patient patient = patientRepository.getPatientByID( patientID );
        medication.setDiagnosis( patient.getPatientFile().getDiagnosis() );
        patient.getPatientFile().addTreatment( medication );

        if ( medication.getDiagnosis().requiresSecondOpinion() ) return null;
        else
        {
            medication.setPatient( patient );
            try
            {
                scheduler.schedule( medication );
            }
            catch ( Exception e )
            {
            }
            return medication;
        }
    }

    public Treatment prescribeCast( int patientID, String bodyPart, int durationInDays )
    {
        Cast cast = new Cast( bodyPart, durationInDays );
        Patient patient = patientRepository.getPatientByID( patientID );
        cast.setDiagnosis( patient.getPatientFile().getDiagnosis() );
        patient.getPatientFile().addTreatment( cast );

        if ( cast.getDiagnosis().requiresSecondOpinion() ) return null;
        else
        {
            cast.setPatient( patient );
            try
            {
                scheduler.schedule( cast );
            }
            catch ( Exception e )
            {
            }
            return cast;
        }
    }

    public Treatment prescribeSurgery( int patientID, String description )
    {
        Surgery surgery = new Surgery( description );
        Patient patient = patientRepository.getPatientByID( patientID );
        surgery.setDiagnosis( patient.getPatientFile().getDiagnosis() );
        patient.getPatientFile().addTreatment( surgery );

        if ( surgery.getDiagnosis().requiresSecondOpinion() ) return null;
        else
        {
            surgery.setPatient( patient );
            try
            {
                scheduler.schedule( surgery );
            }
            catch ( Exception e )
            {
            }
            return surgery;
        }
    }
}
