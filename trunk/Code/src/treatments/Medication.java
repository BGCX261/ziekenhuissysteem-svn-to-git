package treatments;



public class Medication extends Treatment {
	private String description;
	private boolean sensitive;
	public Medication(String description, boolean sensitive)  {
		super(10);
		setDescription(description);
		setSensitive(sensitive);
		if (sensitive) duration=20;
	}
	
	public boolean isSensitive(){
		return sensitive;
	}
	
	public void setSensitive(boolean sensitive) {
		this.sensitive = sensitive;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Description: " + description + " Sensitive: " + sensitive;
	}
}
