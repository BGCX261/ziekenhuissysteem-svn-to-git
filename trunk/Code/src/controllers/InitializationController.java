package controllers;

import hospital.Hospital;
import repositories.EquipmentRepository;
import repositories.PatientRepository;
import repositories.StaffRepository;
import scheduling.Scheduler;

public class InitializationController
{
    private StaffRepository              staffRepository;
    private EquipmentRepository          equipmentRepository;
    private PatientRepository            patientRepository;
    
    private Scheduler                    scheduler;

    // FIXME moeten alle controllers per se op voorhand aangemaakt worden?
    // Kunnen ze niet on-the-fly aangemaakt en weer weggeworpen worden?
    private SessionController            sessionController;
    private AdministratorController      administratorController;
    private PatientController            patientController;
    private PatientFileController        patientFileController;
    private OrderMedicalTestController   orderMedicalTestController;
    private PrescribeTreatmentController prescribeTreatmentController;
    private DiagnosisController          diagnosisController;
    private ResultController             resultController;
    private SchedulerController          schedulerController;
    private Hospital                     hospital;

    public InitializationController()
    {
        hospital = new Hospital();
        Thread t = new Thread( hospital );
        t.start();
        staffRepository = new StaffRepository();
        equipmentRepository = new EquipmentRepository();
        patientRepository = new PatientRepository();
        scheduler = new Scheduler( staffRepository, equipmentRepository, hospital );
        sessionController = new SessionController( staffRepository );
        administratorController = new AdministratorController( staffRepository, equipmentRepository );
        patientController = new PatientController( patientRepository );
        patientFileController = new PatientFileController( patientRepository, staffRepository );
        orderMedicalTestController = new OrderMedicalTestController( patientRepository, scheduler );
        prescribeTreatmentController = new PrescribeTreatmentController( patientRepository, scheduler );
        diagnosisController = new DiagnosisController( staffRepository, patientRepository );
        resultController = new ResultController();
        schedulerController = new SchedulerController( scheduler, staffRepository, equipmentRepository, patientRepository );

    }

    public StaffRepository getStaffRepository()
    {
        return staffRepository;
    }

    public EquipmentRepository getEquipmentRepository()
    {
        return equipmentRepository;
    }

    public PatientRepository getPatientRepository()
    {
        return patientRepository;
    }

    public Scheduler getScheduler()
    {
        return scheduler;
    }

    public SessionController getSessionController()
    {
        return sessionController;
    }

    public AdministratorController getAdministratorController()
    {
        return administratorController;
    }

    public PatientController getPatientController()
    {
        return patientController;
    }

    public PatientFileController getPatientFileController()
    {
        return patientFileController;
    }

    public OrderMedicalTestController getOrderMedicalTestController()
    {
        return orderMedicalTestController;
    }

    public PrescribeTreatmentController getPrescribeTreatmentController()
    {
        return prescribeTreatmentController;
    }

    public DiagnosisController getDiagnosisController()
    {
        return diagnosisController;
    }

    public ResultController getResultController()
    {
        return resultController;
    }

    public SchedulerController getSchedulerController()
    {
        return schedulerController;
    }

    public Hospital getHospital()
    {
        return hospital;
    }
}
