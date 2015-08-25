package controllers;

import java.util.List;

import medicaltestresults.*;
import medicaltests.*;
import treatmentresults.*;
import treatments.*;

public class ResultController
{

    private List<MedicalTest> unfinishedMedicalTests;
    private List<Treatment>   unfinishedTreatments;
    private MedicalTest       selectedMedicalTest;
    private Treatment         selectedTreatment;

    public ResultController()
    {

    }

    public void registerBloodAnalysisResult( BloodAnalysis bloodAnalysis, int amountOfBloodWithdrawn, int redCellCount, int whiteCellCount, int plateletCount )
    {
        BloodAnalysisResult bloodAnalysisResult = new BloodAnalysisResult( bloodAnalysis, amountOfBloodWithdrawn, redCellCount, whiteCellCount, plateletCount );
        // TODO Register
    }

    public void registerUltrasoundScanResult( UltrasoundScan ultrasoundScan, String scanInformation, ScanMatter scanMatter )
    {
        UltrasoundScanResult ultrasoundScanResult = new UltrasoundScanResult( ultrasoundScan, scanInformation, scanMatter );
        // TODO Register
    }

    public void registerXRayScanResult( XRayScan xRayScan, String abnormalities, int nbImagesTaken )
    {
        // XRayScanResult xRayScanResult = new XRayScanResult(xRayScan,
        // abnormalities, nbImagesTaken);
        // TODO Register
    }

    public void registerMedicationResult( Medication medication, boolean abnormalReaction, String report )
    {
        // MedicationResult medicationResult = new MedicationResult(medication,
        // abnormalReaction, report);
    }

    public void registerCastResult( Cast cast, String report )
    {
        CastResult castResult = new CastResult( cast, report );
    }

    public void registerSurgeryResult( Surgery surgery, String report, String specialAftercare )
    {
        SurgeryResult surgeryResult = new SurgeryResult( surgery, report, specialAftercare );
    }
    //
    // // 1. A nurse indicates s/he wants to report on a scheduled medical test
    // that has been completed
    // public void reportScheduledMedicalTest() {
    // getCompletedMedicalTests();
    // }
    //
    // public void getCompletedMedicalTests() {
    // // TODO
    // }
    // // 2. The system displays a list of un nished6 medical tests assigned to
    // the current nurse
    // public String listUnfinishedMedicalTests() {
    // String tmp = "";
    // for (MedicalTest unfinishedMedicalTest: getUnfinishedMedicalTests()) {
    // tmp += unfinishedMedicalTest.toString() + "\n";
    // }
    // return tmp;
    // }
    //
    // // 3. The nurse selects the appropriate medical test
    // public void selectMedicalTest(MedicalTest medicalTest) {
    // setSelectedMedicalTest(medicalTest);
    // }
    //
    // // 4. The system requests the necessary test information
    // public void requestTestInformation() {
    // // TODO ?
    // }
    //
    // // 5. The nurse enters the information
    // public void enterTestInformation() {
    // // TODO ?
    // }
    //
    // // 6. The system registers the results
    // public void registerResults() {
    // // TODO ?
    // }
    //
    // public void reportScheduledTreatment() {
    // getCompletedTreatments();
    // }
    //
    // public void getCompletedTreatments() {
    // // TODO
    // }
    //
    // public String listUnfinishedTreatments() {
    // String tmp = "";
    // for (Treatment unfinishedTreatment: getUnfinishedTreatments()) {
    // tmp += unfinishedTreatment.toString() + "\n";
    // }
    // return tmp;
    // }
}
