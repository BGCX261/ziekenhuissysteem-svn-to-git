package treatments;
import java.util.ArrayList;

import patients.*;
import scheduling.*;
import staff.Nurse;

/**
 * 
 * De treatment klasse is een superclasse voor alle treatments. Omdat deze
 * Schedulable implementeert kan ze met de Scheduler gescheduled worden.
 *
 */

public abstract class Treatment implements Schedulable {
	protected ArrayList<ScheduleResource> needed = new ArrayList<ScheduleResource>();
	
	private TimePeriod scheduledPeriod ;
	protected int duration;
	private Diagnosis diagnosis;
	private Nurse nurse;
	private Patient patient;
	
	/**
	 * Wanneer een treatment gemaakt wordt, wordt er een dummy instansie van nurse
	 * meegegven aan de needed arraylist. Deze vertelt de Scheduler dat er steeds
	 * een nurse nodig is voor een treatment.
	 * @param duration
	 */
	public Treatment(int duration) {
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
	
	@Override
	public int getDuration() {
		return duration;
	}
	
	/**
	 * Zet de duur van deze treatment naar duration
	 * @param duration
	 */ 
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	@Override
	public boolean isScheduled() {
		return false;
	}

	@Override
	public ArrayList<ScheduleResource> neededResources() {
		return this.needed;
	}

	/**
	 * 
	 * @param nurse	De nurse die de treatment uitvoert
	 */
	public void setNurse(Nurse nurse) {
		this.nurse = nurse;
	}

	public boolean hasLitteralResources() {
		return false;
	}
	
	/**
	 * 
	 * @return	de nurse die de treatment uitvoert
	 */
	public Nurse getNurse() {
		return nurse;
	}
	
	/**
	 * @return the patient
	 */
	public Patient getPatient() {
		return patient;
	}

	/**
	 * @param patient the patient to set
	 */
	public void setPatient(Patient patient) {
		needed.add(patient);
		this.patient = patient;
	}

	/**
	 * 
	 * @return	De diagnose van de patient op wie de treatment wordt uitgevoert
	 */
	public Diagnosis getDiagnosis() {
		return diagnosis;
	}

	/**
	 * 	Zet de diagnose van de patient op wie de treatment wordt uitgevoerd
	 * @param diagnosis	de nieuwe diagnosis
	 */
	public void setDiagnosis(Diagnosis diagnosis) {
		this.diagnosis = diagnosis;
	}
}
