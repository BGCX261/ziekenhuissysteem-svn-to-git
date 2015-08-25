package scheduling;
/**
 * 
 * Een locatie bestaande uit een verdieping en een kamernummer
 *
 * FIXME Waarom is deze klasse mutable? (maw waarom zijn er setters)
 * Je hebt al een aparte setLocation, dus je laat wijziging op 2 niveaus terug,
 * waarvan één nogal dubieus is als Location-objecten zouden geshared worden,
 * iets waar je zelf geen controle over hebt, omdat je die Location-objecten
 * zomaar rondgeeft.
 */
public class Location {
	private int floor;
	private int room;
	
	public Location(int floor, int room) {
		this.floor = floor;
		this.room = room;
	}
	/**
	 * @return the floor
	 */
	public int getFloor() {
		return floor;
	}
	/**
	 * @param floor the floor to set
	 */
	public void setFloor(int floor) {
		this.floor = floor;
	}
	/**
	 * @return the room
	 */
	public int getRoom() {
		return room;
	}
	/**
	 * @param room the room to set
	 */
	public void setRoom(int room) {
		this.room = room;
	}
}
