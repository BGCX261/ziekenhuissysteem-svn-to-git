package medicaltests;
import java.util.ArrayList;
import java.util.List;

import medicaltestresults.MedicalTestResult;
import patients.Patient;
import scheduling.Schedulable;
import scheduling.ScheduleResource;
import scheduling.TimePeriod;
import staff.Nurse;

/**
 * 
 * Een medicaltest is een superclasse voor alle soorten medical testen. Deze
 * implementeert de interface schedulable wat wil zeggen dat ze kan verwerkt
 * worden in de scheduler.
 *
 */

public abstract class MedicalTest implements Schedulable {
	protected ArrayList<ScheduleResource> needed =  new ArrayList<ScheduleResource>();
	
	private int duration; 
	private String textualExtraInfo; 
	private Nurse nurse;
	private MedicalTestResult result;
	private Patient patient;
	private TimePeriod scheduledPeriod;
	
	/**
	 * Wanneer medicaltest wordt ge•nitialiseerd, zal een dummy object nurse 
	 * aan needed worden toegevoegd. Dit zorgt ervoor dat de scheduler weet
	 * dat er steeds een nurse nodig is voor een medicaltest.
	 * @param 	duration de duur van de medicaltest, dit is belangrijk voor de scheduler
	 */
	public MedicalTest(int duration) {
		needed.add(new Nurse(null));
		setDuration(duration);
	}
	
	@Override
	public TimePeriod getScheduledPeriod() {
		return scheduledPeriod;
	}
	
	public void setScheduledPeriod(TimePeriod scheduledPeriod) {
		this.scheduledPeriod = scheduledPeriod;
	}
	
	/**
	 * 
	 * @return	extra informatie over de test, bijkomende complicaties enz.
	 */
	public String getTextualExtraInfo() {
		return textualExtraInfo;
	}

	/**
	 * zet de extra informatie van deze test, bijkomende complicaties enz.
	 * @param textualExtraInfo	nieuwe extra informatie
	 */
	public void setTextualExtraInfo(String textualExtraInfo) {
		this.textualExtraInfo = textualExtraInfo;
	}

	@Override
	public int getDuration() {
		return duration;
	}
	
	public void setDuration(int duration) {
		this.duration = duration;
	}

	@Override
	public boolean isScheduled() {
		return false;
	}
	
	/**
	 * 	Deze methode geeft aan scheduler mee welke resources belangrijk zijn
	 * voor deze medicaltest
	 */
	@Override
	public List<ScheduleResource> neededResources() {
		return needed;
	}

	public void setNurse(Nurse nurse) {
		this.nurse = nurse;
	}

	public Nurse getNurse() {
		return nurse;
	}

	public void setResult(MedicalTestResult result) {
		this.result = result;
	}
	/**
	 * 
	 * @return	Medicalestresult, een resultaat van een medicaltest.
	 */
	public MedicalTestResult getResult() {
		return result;
	}
	
	public boolean hasLitteralResources() {
		return false;
	}
	
	/**
	 * Medicaltest wordt gedaan op een zeker patient, deze wordt toegevoegd
	 * aan de needed resources. Een patient is immers ook een resource en mag niet 
	 * dubbel geboekt worden.
	 * @param patient
	 */
	public void setPatient(Patient patient) {
		needed.add(patient);
		this.patient = patient;
	}
	
	public Patient getPatient() {
		return this.patient;
	}
	
}
