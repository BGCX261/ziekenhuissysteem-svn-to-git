package controllers;

import java.util.*;

import medicaltests.MedicalTest;
import patients.Patient;
import repositories.*;
import scheduling.*;
import staff.Doctor;
import treatments.Treatment;

public class SchedulerController
{
    private Scheduler           scheduler;
    private StaffRepository     staffRepository;
    private EquipmentRepository equipmentRepository;
    private PatientRepository   patientRepository;

    public SchedulerController( Scheduler scheduler, StaffRepository staffRepository, EquipmentRepository equipmentRepository, PatientRepository patientRepository )
    {
        this.scheduler = scheduler;
        this.staffRepository = staffRepository;
        this.equipmentRepository = equipmentRepository;
        this.patientRepository = patientRepository;
    }

    public Appointment scheduleAppointment( int doctorID, int patientID )
    {
        Doctor doctor = (Doctor) staffRepository.getStaffMemberByID( doctorID );
        Patient patient = patientRepository.getPatientByID( patientID );

        Appointment appointment = new Appointment( patient, doctor );
        try
        {
            scheduler.schedule( appointment );
        }
        catch ( Exception e )
        {
            // TODO
        }

        return appointment;
    }

    public List<MedicalTest> getCompletedMedicalTests()
    {
        List<MedicalTest> medicalTests = new ArrayList<MedicalTest>();
        /*
         * medicalTests.addAll(scheduler.getSchedule().getFinishedByClass(XRayScan
         * .class, ));
         * medicalTests.addAll(scheduler.getSchedule().getFinishedByClass
         * (MedicalTest.class, ));
         * medicalTests.addAll(scheduler.getSchedule().getFinishedByClass
         * (BloodAnalysis.class, ));
         */
        return medicalTests;
    }

    public List<Treatment> getCompletedTreatments()
    {
        List<Treatment> treatments = new ArrayList<Treatment>();
        /*
         * treatments.addAll(scheduler.getSchedule().getFinishedByClass(Medication
         * .class, ));
         * treatments.addAll(scheduler.getSchedule().getFinishedByClass
         * (Cast.class, ));
         * treatments.addAll(scheduler.getSchedule().getFinishedByClass
         * (Surgery.class, ));
         */
        return treatments;
    }
}
