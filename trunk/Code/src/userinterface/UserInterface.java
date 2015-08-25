package userinterface;

import hospital.Hospital;

import java.util.Scanner;

import medicaltestresults.Result;
import medicaltestresults.ScanMatter;
import medicaltests.MedicalTest;
import patients.Diagnosis;
import patients.Patient;
import scheduling.Appointment;
import staff.Doctor;
import staff.Nurse;
import staff.StaffMember;
import treatments.Treatment;
import controllers.AdministratorController;
import controllers.DiagnosisController;
import controllers.InitializationController;
import controllers.OrderMedicalTestController;
import controllers.PatientController;
import controllers.PatientFileController;
import controllers.PrescribeTreatmentController;
import controllers.ResultController;
import controllers.SchedulerController;
import controllers.SessionController;

// FIXME Technisch detail: stack gaat overflowen na lang gebruik
public class UserInterface
{
    private static Scanner                      scanner;
    private static InitializationController     controller;
    private static SessionController            sessionController;
    private static AdministratorController      administratorController;
    private static PatientController            patientController;
    private static PatientFileController        patientFileController;
    private static OrderMedicalTestController   orderMedicalTestController;
    private static PrescribeTreatmentController prescribeTreatmentController;
    private static DiagnosisController          diagnosisController;
    private static ResultController             resultController;
    private static SchedulerController          schedulerController;
    private static Hospital                     hospital;

    public static void main( String[] args )
    {
        scanner = new Scanner( System.in );
        controller = new InitializationController();
        sessionController = controller.getSessionController();
        administratorController = controller.getAdministratorController();
        patientController = controller.getPatientController();
        patientFileController = controller.getPatientFileController();
        orderMedicalTestController = controller.getOrderMedicalTestController();
        prescribeTreatmentController = controller.getPrescribeTreatmentController();
        diagnosisController = controller.getDiagnosisController();
        resultController = controller.getResultController();
        schedulerController = controller.getSchedulerController();
        hospital = controller.getHospital();
        mainMenu();
    }

    public static void mainMenu()
    {
        System.out.println( "Hospital time: " + hospital.getTime().getTime() );
        System.out.println( "Select one of the following:\n" );
        System.out.println( "1. Login" );
        System.out.println( "2. Exit" );

        switch ( readInt() )
        {
            case 1:
                login();
                break;
            case 2:
                exit();
                break;
            default:
                mainMenu();
        }
    }

    private static int readInt()
    {
        int menuEntry = -1;

        do
        {
            while ( !scanner.hasNextInt() )
            {
                scanner.next();
            }
            menuEntry = scanner.nextInt();
        } while ( menuEntry < 0 );

        return menuEntry;
    }

    private static void exit()
    {
        System.exit( 1 );
    }

    private static void login()
    {
        System.out.println( "Select one of the following:\n" );
        for ( StaffMember member : sessionController.getStaff() )
        {
            System.out.println( member.toString() );
        }

        int staffMemberID = readInt();
        StaffMember member = sessionController.getStaffMemberByID( staffMemberID );
        sessionController.login( member );

        // FIXME Verantwoording afleggen ('t is een instanceof hé, die mogen van mij wel gebruikt
        // worden, maar uit principe wil ik een verantwoording)
        if ( member instanceof Doctor )
        {
            doctorMenu( staffMemberID );
        }
        else if ( member instanceof Nurse )
        {
            nurseMenu( staffMemberID );
        }
        else
        {
            hospitalAdministratorMenu();
        }
    }

    public static void hospitalAdministratorMenu()
    {
        System.out.println( "Select one of the following:\n" );
        System.out.println( "1. Add Hospital Staff" );
        System.out.println( "2. Add Hospital Equipment" );
        System.out.println( "3. Log Out" );

        switch ( readInt() )
        {
            case 1:
                addHospitalStaff();
                break;
            case 2:
                addHospitalEquipment();
                break;
            case 3:
                logOut();
                break;
            default:
                hospitalAdministratorMenu();
        }
    }

    private static void logOut()
    {
        sessionController.logOut();

        mainMenu();
    }

    private static void addHospitalEquipment()
    {
        System.out.println( "Select one of the following:\n" );
        System.out.println( "1. X-Ray Scanner" );
        System.out.println( "2. Blood Analyzer" );
        System.out.println( "3. Ultrasound Machine" );
        System.out.println( "4. Surgical Equipment" );
        System.out.println( "5. Back" );

        switch ( readInt() )
        {
            case 1:
                addXRayScanner();
                break;
            case 2:
                addBloodAnalyzer();
                break;
            case 3:
                addUltrasoundMachine();
                break;
            case 4:
                addSurgicalEquipment();
                break;
            case 5:
                hospitalAdministratorMenu();
                break;
            default:
                addHospitalEquipment();
        }

        System.out.println( "Success" );
        hospitalAdministratorMenu();
    }

    private static void addSurgicalEquipment()
    {
        System.out.println( "Floor:\n" );
        int floor = readInt();

        System.out.println( "Room:\n" );
        int room = readInt();

        administratorController.addSurgicalEquipment( floor, room );
    }

    private static void addUltrasoundMachine()
    {
        System.out.println( "Floor:\n" );
        int floor = readInt();

        System.out.println( "Room:\n" );
        int room = readInt();

        administratorController.addUltrasoundMachine( floor, room );
    }

    private static void addBloodAnalyzer()
    {
        System.out.println( "Floor:\n" );
        int floor = readInt();

        System.out.println( "Room:\n" );
        int room = readInt();

        administratorController.addBloodAnalyzer( floor, room );
    }

    private static void addXRayScanner()
    {
        System.out.println( "Floor:\n" );
        int floor = readInt();

        System.out.println( "Room:\n" );
        int room = readInt();

        administratorController.addXRayScanner( floor, room );
    }

    private static void addHospitalStaff()
    {
        System.out.println( "Select one of the following:\n" );
        System.out.println( "1. Doctor" );
        System.out.println( "2. Nurse" );
        System.out.println( "3. Back" );

        switch ( readInt() )
        {
            case 1:
                addDoctor();
                break;
            case 2:
                addNurse();
                break;
            case 3:
                hospitalAdministratorMenu();
                break;
            default:
                addHospitalStaff();
        }

        System.out.println( "Success" );
        hospitalAdministratorMenu();
    }

    private static void addNurse()
    {
        System.out.println( "Name:\n" );
        String name = scanner.next();

        administratorController.addNurse( name );
    }

    private static void addDoctor()
    {
        System.out.println( "Name:\n" );
        String name = scanner.next();

        administratorController.addDoctor( name );
    }

    public static void nurseMenu( int nurseID )
    {
        System.out.println( "Select one of the following:\n" );
        System.out.println( "1. Register Patient" );
        System.out.println( "2. Enter Medical Test Result" );
        System.out.println( "3. Enter Treatment Result" );
        System.out.println( "4. Log Out" );

        switch ( readInt() )
        {
            case 1:
                registerPatient( nurseID );
                break;
            case 2:
                enterMedicalTestResult( nurseID );
                break;
            case 3:
                enterTreatmentResult( nurseID );
                break;
            case 4:
                logOut();
                break;
            default:
                nurseMenu( nurseID );
        }
    }

    private static void enterTreatmentResult( int nurseID )
    {
        System.out.println( "Select one of the following:\n" );
        System.out.println( "1. Medication" );
        System.out.println( "2. Cast" );
        System.out.println( "3. Surgery" );
        System.out.println( "4. Back" );

        switch ( readInt() )
        {
            case 1:
                requestDetailsMedicationResult();
                break;
            case 2:
                requestDetailsCastResult();
                break;
            case 3:
                requestDetailsSurgeryResult();
                break;
            case 4:
                nurseMenu( nurseID );
                break;
            default:
                enterTreatmentResult( nurseID );
        }
    }

    private static void requestDetailsMedicationResult()
    {
        System.out.println( "Abnormal reaction? (type true or false):\n" );
        boolean abnormalReaction = scanner.nextBoolean();
        String report = "";
        while ( report.length() <= 0 )
        {
            System.out.println( "Enter report:\n" );
            report = scanner.next();
        }
        resultController.registerMedicationResult( null, abnormalReaction, report );
    }

    private static void requestDetailsCastResult()
    {
        String report = "";
        while ( report.length() <= 0 )
        {
            System.out.println( "Enter report:\n" );
            report = scanner.next();
        }
        resultController.registerCastResult( null, report );
    }

    private static void requestDetailsSurgeryResult()
    {
        String report = "";
        while ( report.length() <= 0 )
        {
            System.out.println( "Enter report:\n" );
            report = scanner.nextLine();
        }
        String specialAftercare = "";
        while ( specialAftercare.length() <= 0 )
        {
            System.out.println( "Enter special aftercare:\n" );
            specialAftercare = scanner.nextLine();
        }
        resultController.registerSurgeryResult( null, report, specialAftercare );
    }

    private static void enterMedicalTestResult( int nurseID )
    {
        System.out.println( "Select one of the following:\n" );
        System.out.println( "1. X-Ray Scan" );
        System.out.println( "2. Ultrasound Scan" );
        System.out.println( "3. Blood Analysis" );
        System.out.println( "4. Back" );

        switch ( readInt() )
        {
            case 1:
                requestDetailsXRayScanResult();
                break;
            case 2:
                requestDetailsUltrasoundScanResult();
                break;
            case 3:
                requestDetailsBloodAnalysisResult();
                break;
            case 4:
                nurseMenu( nurseID );
                break;
            default:
                enterMedicalTestResult( nurseID );
        }
    }

    private static void requestDetailsBloodAnalysisResult()
    {
        System.out.println( "Enter amount of blood withdrawn (higher than zero):\n" );
        int amountOfBloodWithdrawn = readInt();

        System.out.println( "Enter red cell count (higher than zero):\n" );
        int redCellCount = readInt();

        System.out.println( "Enter white cell count (higher than zero):\n" );
        int whiteCellCount = readInt();

        System.out.println( "Enter platelet count (higher than zero):\n" );
        int plateletCount = readInt();

        resultController.registerBloodAnalysisResult( null, amountOfBloodWithdrawn, redCellCount, whiteCellCount, plateletCount );

    }

    private static void requestDetailsUltrasoundScanResult()
    {
        String scanInformation = "";
        while ( scanInformation.length() <= 0 )
        {
            System.out.println( "Enter scan information:\n" );
            scanInformation = scanner.next();
        }
        System.out.println( "Choose nature of scanned mass:\n" );
        System.out.println( "1. Benign" );
        System.out.println( "2. Unknown" );
        System.out.println( "3. Malignant" );

        ScanMatter scanMatter = null;
        int natureOfScannedMass = readInt();

        switch ( natureOfScannedMass )
        {
            case 1:
                scanMatter = ScanMatter.BENIGN;
                break;
            case 2:
                scanMatter = ScanMatter.UNKNOWN;
                break;
            case 3:
                scanMatter = ScanMatter.MALIGNANT;
                break;
            default:
                scanMatter = ScanMatter.BENIGN;
                break;
        }

        resultController.registerUltrasoundScanResult( null, scanInformation, scanMatter );
    }

    private static void requestDetailsXRayScanResult()
    {
        String abnormalities = "";
        while ( abnormalities.length() <= 0 )
        {
            System.out.println( "Enter abnormalities:\n" );
            abnormalities = scanner.next();
        }

        System.out.println( "Enter number of images taken (higher than zero):\n" );
        int nbImagesTaken = readInt();

        resultController.registerXRayScanResult( null, abnormalities, nbImagesTaken );
    }

    private static void registerPatient( int nurseID )
    {
        int i = 1;
        System.out.println( "Select one of the following:\n" );
        for ( Patient patient : patientController.getPreviouslyRegisteredPatients() )
        {
            System.out.println( patient.toString() );
            i++;
        }
        System.out.println( "" + i + ". Add Patient" );

        int patientID = readInt();
        if ( patientID == i )
        {
            System.out.println( "Name:\n" );
            String name = scanner.next();

            patientController.addPatient( name );
        }
        else
        {
            patientController.registerPatient( patientID );
        }

        System.out.println( "Select one of the following:\n" );
        for ( Doctor doctor : sessionController.getDoctors() )
        {
            System.out.println( doctor.toString() );
        }

        int doctorID = scanner.nextInt();

        Appointment appointment = schedulerController.scheduleAppointment( doctorID, patientID );
        System.out.println( appointment.toString() );

        nurseMenu( nurseID );
    }

    public static void doctorMenu( int doctorID )
    {
        System.out.println( "Select one of the following:\n" );
        System.out.println( "1. Consult Patient File" );
        System.out.println( "2. Approve Diagnosis" );
        System.out.println( "3. Log Out" );

        switch ( readInt() )
        {
            case 1:
                consultPatientFile( doctorID );
                break;
            case 2:
                approveDiagnosis( doctorID );
                break;
            case 3:
                logOut();
                break;
            default:
                doctorMenu( doctorID );
        }
    }

    private static void approveDiagnosis( int doctorID )
    {
        System.out.println( "Select one of the following:\n" );
        for ( Diagnosis diagnosis : diagnosisController.getSecondOpinionDiagnosis( doctorID ) )
        {
            System.out.println( diagnosis.toString() );
        }

        int diagnosisID = readInt();
        Diagnosis diagnosis = diagnosisController.getDiagnosisByID( doctorID, diagnosisID );

        continueApproveDiagnosis( diagnosis );
    }

    private static void continueApproveDiagnosis( Diagnosis diagnosis )
    {
        System.out.println( "Doctor: " + diagnosis.getDoctor().getName() );
        System.out.println( "Patient: " + diagnosis.getPatient().getName() );
        System.out.println( "Description " + diagnosis.getDecision() );

        System.out.println( "Select one of the following:\n" );
        System.out.println( "1. Review Previous Results" );
        System.out.println( "2. Approve Diagnosis" );
        System.out.println( "3. Do NOT Approve Diagnosis" );

        switch ( readInt() )
        {
            case 1:
                reviewPreviousResults( diagnosis );
                break;
            case 2:
                approveDiagnosis();
                break;
            case 3:
                doNotApproveDiagnosis();
                break;
        }
    }

    private static void doNotApproveDiagnosis()
    {
        // TODO Auto-generated method stub

    }

    private static void approveDiagnosis()
    {
        // TODO Auto-generated method stub

    }

    private static void reviewPreviousResults( Diagnosis diagnosis )
    {
        for ( Result result : patientFileController.getResults( diagnosis.getPatient().getId() ) )
        {
            System.out.println( result.toString() );
        }

        System.out.println( "Select one of the following:\n" );
        System.out.println( "1. Back" );

        switch ( readInt() )
        {
            case 1:
                continueApproveDiagnosis( diagnosis );
                break;
        }
    }

    private static void consultPatientFile( int doctorID )
    {
        System.out.println( "Select one of the following:\n" );
        for ( Patient patient : patientFileController.getNonDischargedPatients() )
        {
            System.out.println( patient.toString() );
        }

        int patientID = readInt();

        int i = 1;
        System.out.println( "Select one of the following:\n" );
        for ( Result result : patientFileController.consultPatientFile( doctorID, patientID ) )
        {
            System.out.println( result.toString() );
            i++;
        }
        System.out.println( "" + i + ". Go to Patientfile Menu" );
        System.out.println( "" + (i + 1) + ". Back" );

        int resultID = readInt();
        if ( resultID == (i + 1) )
        {
            doctorMenu( doctorID );
        }
        else if ( resultID == i )
        {
            patientFileMenu( doctorID, patientID );
        }
        else
        {
            Result result = patientFileController.getResult( resultID );
            System.out.println( result.getDetails() + "\n" );
        }
    }

    public static void patientFileMenu( int doctorID, int patientID )
    {
        System.out.println( "Select one of the following:\n" );
        System.out.println( "1. Enter Diagnosis" );
        System.out.println( "2. Order Medical Test" );
        System.out.println( "3. Prescribe Treatment" );
        System.out.println( "4. Close Patient File" );
        System.out.println( "5. Discharge Patient" );
        System.out.println( "6. Back" );

        switch ( readInt() )
        {
            case 1:
                enterDiagnosis( doctorID, patientID );
                break;
            case 2:
                orderMedicalTest( doctorID, patientID );
                break;
            case 3:
                prescribeTreatment( doctorID, patientID );
                break;
            case 4:
                closePatientFile( doctorID );
                break;
            case 5:
                dischargePatient();
                break;
            case 6:
                doctorMenu( doctorID );
                break;
            default:
                patientFileMenu( doctorID, patientID );
        }
    }

    private static void closePatientFile( int doctorID )
    {
        patientFileController.closePatientFile();
        doctorMenu( doctorID );
    }

    private static void dischargePatient()
    {
        if ( !patientFileController.dischargePatient() ) // TODO
        System.out.println( "Patient can't be discharged. There are still diagnosises without treatments." );
    }

    private static void prescribeTreatment( int doctorID, int patientID )
    {
        if ( !patientController.getPatientByPatientID( patientID ).isDischarged() )
        {
            System.out.println( "Select one of the following:\n" );
            System.out.println( "1. Medication" );
            System.out.println( "2. Cast" );
            System.out.println( "3. Surgery" );
            System.out.println( "4. Back" );

            switch ( readInt() )
            {
                case 1:
                    requestDetailsMedication( doctorID, patientID );
                    break;
                case 2:
                    requestDetailsCast( doctorID, patientID );
                    break;
                case 3:
                    requestDetailsSurgery( doctorID, patientID );
                    break;
                case 4:
                    patientFileMenu( doctorID, patientID );
                    break;
                default:
                    prescribeTreatment( doctorID, patientID );
            }
        }
        else
        {
            System.out.println( "Patient is already discharged." );
            patientFileMenu( doctorID, patientID );
        }
    }

    private static void requestDetailsMedication( int doctorID, int patientID )
    {
        String description = "";
        while ( description.length() <= 0 )
        {
            System.out.println( "Enter description:\n" );
            description = scanner.next();
        }
        System.out.println( "Sensitive? (type true or false):\n" );
        boolean sensitive = scanner.nextBoolean();

        Treatment treatment = prescribeTreatmentController.prescribeMedication( patientID, description, sensitive );
        if ( treatment == null )
        {
            System.out.println( "Treatment is stored, but can't be scheduled yet. The treatment's diagnose needs a second opinion." );
        }
        else
        {
            System.out.println( treatment.toString() );
            System.out.println( "Treatment scheduled at " + treatment.getScheduledPeriod() );
        }

        System.out.println( "Select one of the following:\n" );
        System.out.println( "1. Back" );

        switch ( readInt() )
        {
            case 1:
                patientFileMenu( doctorID, patientID );
                break;
            default:
                requestDetailsMedication( doctorID, patientID );
        }
    }

    private static void requestDetailsCast( int doctorID, int patientID )
    {
        String bodyPart = "";
        while ( bodyPart.length() <= 0 )
        {
            System.out.println( "Enter body part:\n" );
            bodyPart = scanner.next();
        }

        System.out.println( "Enter duration in days (higher than zero):\n" );
        int durationInDays = readInt();

        Treatment treatment = prescribeTreatmentController.prescribeCast( patientID, bodyPart, durationInDays );
        if ( treatment == null )
        {
            System.out.println( "Treatment is stored, but can't be scheduled yet. The treatment's diagnose needs a second opinion." );
        }
        else
        {
            System.out.println( treatment.toString() );
            System.out.println( "Treatment scheduled at " + treatment.getScheduledPeriod() );
        }

        System.out.println( "Select one of the following:\n" );
        System.out.println( "1. Back" );

        switch ( readInt() )
        {
            case 1:
                patientFileMenu( doctorID, patientID );
                break;
            default:
                requestDetailsCast( doctorID, patientID );
        }
    }

    private static void requestDetailsSurgery( int doctorID, int patientID )
    {
        String description = "";
        while ( description.length() <= 0 )
        {
            System.out.println( "Enter description:\n" );
            description = scanner.next();
        }

        Treatment treatment = prescribeTreatmentController.prescribeSurgery( patientID, description );
        if ( treatment == null )
        {
            System.out.println( "Treatment is stored, but can't be scheduled yet. The treatment's diagnose needs a second opinion." );
        }
        else
        {
            System.out.println( treatment.toString() );
            System.out.println( "Treatment scheduled at " + treatment.getScheduledPeriod() );
        }

        System.out.println( "Select one of the following:\n" );
        System.out.println( "1. Back" );

        switch ( readInt() )
        {
            case 1:
                patientFileMenu( doctorID, patientID );
                break;
            default:
                requestDetailsSurgery( doctorID, patientID );
        }
    }

    private static void enterDiagnosis( int doctorID, int patientID )
    {
        if ( !patientController.getPatientByPatientID( patientID ).isDischarged() )
        {
            System.out.println( "Second opinion required?\n" );
            System.out.println( "1. Yes" );
            System.out.println( "2. No" );

            switch ( readInt() )
            {
                case 1:
                    requestSecondOpinion( doctorID, patientID );
                    break;
                case 2:
                    registerDiagnosis( doctorID, patientID, 0 );
                    break;
                default:
                    enterDiagnosis( doctorID, patientID );
            }
        }
        else
        {
            System.out.println( "Patient is already discharged." );
            patientFileMenu( doctorID, patientID );
        }
    }

    private static void registerDiagnosis( int doctorID, int patientID, int secondDoctorID )
    {
        System.out.println( "Description:\n" );
        String description = scanner.next();

        diagnosisController.enterDiagnosis( doctorID, patientID, description, secondDoctorID );
        patientFileMenu( doctorID, patientID );
    }

    private static void requestSecondOpinion( int doctorID, int patientID )
    {
        System.out.println( "Select one of the following:\n" );
        for ( Doctor doctor : sessionController.getDoctors() )
        {
            if ( doctor.getId() != doctorID )
            {
                System.out.println( doctor.toString() );
            }
        }
        System.out.println( "0. Back" );

        int secondDoctorID = readInt();
        if ( secondDoctorID == 0 )
        {
            patientFileMenu( doctorID, patientID );
        }
        else
        {
            registerDiagnosis( doctorID, patientID, secondDoctorID );
        }
    }

    private static void orderMedicalTest( int doctorID, int patientID )
    {
        if ( !patientController.getPatientByPatientID( patientID ).isDischarged() )
        {
            System.out.println( "Select one of the following:\n" );
            System.out.println( "1. X-Ray Scan" );
            System.out.println( "2. Ultrasound Scan" );
            System.out.println( "3. Blood Analysis" );
            System.out.println( "4. Back" );

            switch ( readInt() )
            {
                case 1:
                    requestDetailsXRayScan( doctorID, patientID );
                    break;
                case 2:
                    requestDetailsUltrasoundScan( doctorID, patientID );
                    break;
                case 3:
                    requestDetailsBloodAnalysis( doctorID, patientID );
                    break;
                case 4:
                    patientFileMenu( doctorID, patientID );
                    break;
                default:
                    orderMedicalTest( doctorID, patientID );
            }
        }
        else
        {
            System.out.println( "Patient is already discharged." );
            patientFileMenu( doctorID, patientID );
        }
    }

    private static void requestDetailsBloodAnalysis( int doctorID, int patientID )
    {
        String focus = "";
        while ( focus.length() <= 0 )
        {
            System.out.println( "Enter focus:\n" );
            focus = scanner.next();
        }

        System.out.println( "Enter number of analyses (higher than zero):\n" );
        int numberOfAnalyses = readInt();

        MedicalTest medicalTest = orderMedicalTestController.orderBloodAnalysis( patientID, focus, numberOfAnalyses );
        System.out.println( medicalTest.toString() );
        System.out.println( "Select one of the following:\n" );
        System.out.println( "1. Back" );

        switch ( readInt() )
        {
            case 1:
                patientFileMenu( doctorID, patientID );
                break;
            default:
                patientFileMenu( doctorID, patientID );
        }
    }

    private static void requestDetailsUltrasoundScan( int doctorID, int patientID )
    {
        String focus = "";
        while ( focus.length() <= 0 )
        {
            System.out.println( "Enter focus:\n" );
            focus = scanner.next();
        }
        System.out.println( "Record video? (type true or false):\n" );
        boolean recordVideo = scanner.nextBoolean();
        System.out.println( "Record Images? (type true or false):\n" );
        boolean recordImages = scanner.nextBoolean();

        MedicalTest medicalTest = orderMedicalTestController.orderUltrasoundScan( patientID, focus, recordVideo, recordImages );
        System.out.println( medicalTest.toString() );
        System.out.println( "Select one of the following:\n" );
        System.out.println( "1. Back" );

        switch ( readInt() )
        {
            case 1:
                patientFileMenu( doctorID, patientID );
                break;
            default:
                patientFileMenu( doctorID, patientID );
        }
    }

    private static void requestDetailsXRayScan( int doctorID, int patientID )
    {
        String bodyPart = "";
        while ( bodyPart.length() <= 0 )
        {
            System.out.println( "Enter bodyPart:\n" );
            bodyPart = scanner.next();
        }

        System.out.println( "Enter number of needed images (higher than zero):\n" );
        int nbOfNeededImages = readInt();

        System.out.println( "Enter level of zoom (1-3):\n" );
        int levelOfZoom = readInt();
        while ( levelOfZoom != 1 || levelOfZoom != 2 || levelOfZoom != 3 )
        {
            levelOfZoom = readInt();
        }
        MedicalTest medicalTest = orderMedicalTestController.orderXRayScan( patientID, bodyPart, nbOfNeededImages, levelOfZoom );
        System.out.println( medicalTest.toString() );
        System.out.println( "Select one of the following:\n" );
        System.out.println( "1. Back" );

        switch ( readInt() )
        {
            case 1:
                patientFileMenu( doctorID, patientID );
                break;
            default:
                patientFileMenu( doctorID, patientID );
        }
    }
}
