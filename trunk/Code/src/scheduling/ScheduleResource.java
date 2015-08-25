package scheduling;

/** 
 * Deze interface zorgt voor alle functionaliteit van resources die nodig
 * is voor de scheduler. Wanneer een klasse deze interface implementeert
 * kan deze gebruikt worden als resource door de scheduler.
 *
 */

public interface ScheduleResource {
	/**
	 * 
	 * @param period
	 * @return	Is de resource aan het werken tijdens de gegeven periode
	 */
	public boolean isWorking(TimePeriod period);
	/**
	 * Wanneer de resource niet werkt is op de periode, dan geeft deze methode
	 * de volledige tijdspanne wanneer de resource niet werkt, welke overlapt
	 * met de gegeven periode.
	 * @param period	Een periode
	 * @return	De volledige tijdspanne wanneer de resource niet werkt, overlappend
	 * met de gegeven periode
	 */
	public TimePeriod notWorking(TimePeriod period);
}
