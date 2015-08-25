package treatments;
import machines.SurgicalEquipment;




public class Surgery extends Treatment {
	private static final int DURATION=180;
	
	private String description;
	
	public Surgery(String description) {
		super(DURATION);
		
		// FIXME Werken met dummy objecten vind ik héél vies
		// Je moet dan plots de invariant van de klasse uitbreiden met ondersteuning voor "dummy toestanden"
		// Je kan dan beter werken met Class objecten zoals je elders doet (maar niet zo geweldig als design)
		// of gaan voor een propere oplossing
		needed.add(new SurgicalEquipment(null, 0));
		setDescription(description);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Description: " + description;
	}
}
