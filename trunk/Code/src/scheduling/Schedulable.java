package scheduling;
import java.util.List;

/**
 * Deze interface zorgt voor alle functionaliteit van zaken die gescheduled
 * moeten worden. Wanneer een klasse deze interface implementeert kan deze
 * gescheduled worden.
 *
 */
public interface Schedulable {
	/**
	 * 
	 * @return	De duur van de planbare actie
	 */
	public int getDuration();
	
	/**
	 * 
	 * @return	De periode waarop de actie gescheduled is
	 * 			Dit wordt ingesteld door de OScheduler
	 */
	public TimePeriod getScheduledPeriod();
	
	/**
	 * 
	 * @return	Geeft terug of de actie gescheduled is
	 */
	public boolean isScheduled();
	
	/**
	 * De nodige resources voor de planbare actie zijn letterlijk als er
	 * geen dummy instansies worden meegegeven in de list needed maar letterlijke
	 * instanties. Bijvoorbeeld als de actie door een zekere dokter moet uitgevoerd
	 * worden.O
	 * @return		Geeft terug of de actie letterlijke resources heeft
	 * 
	 * FIXME Toch wel hackerige aanpak
	 */
	public boolean hasLitteralResources();
	
	/**
	 * 
	 * @return	Een lijst met de nodige resources.
	 */
	public List<ScheduleResource> neededResources();
	
	/**
	 * Zet de periode wanneer de actie gescheduled is.
	 * @param scheduledPeriod	De nieuwe geplande periode
	 */
	public void setScheduledPeriod(TimePeriod scheduledPeriod);
}

