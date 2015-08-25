package machines;

// FIXME Deze klasse lijkt dubbel te bestaan, ook in scheduling package
public class Location {
	private int floor;
	private int room;
	
	/**
	 * 
	 * @param floor	De verdieping van de locatie
	 * @param room	de kamer van de locatie
	 */
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
