package staff;

import scheduling.ScheduleResource;
import scheduling.TimePeriod;

public class StaffMember implements ScheduleResource {
	private int id;
	private String name;
	private boolean session;
	
	public StaffMember(String name) {
		this.name = name;
		this.session = false;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isSession() {
		return session;
	}

	public void setSession(boolean session) {
		this.session = session;
	}
	
	@Override
	public String toString() {
		return "" + id + ". " + name + " Hospital Administrator";
	}

	@Override
	public boolean isWorking(TimePeriod period) {
		// TODO Auto-generated method stub
		return true;
	}
	
	public TimePeriod notWorking(TimePeriod period) {
		return null;
	}
}
