package treatmentresults;

import treatments.Medication;

public class MedicationResult extends TreatmentResult{
	private boolean abnormalReaction;
	public MedicationResult(Medication medication, boolean abnormalReaction, String report) {
		super(medication, report);
		setAbnormalReaction(abnormalReaction);
	}
	
	public void setAbnormalReaction(boolean abnormalReaction) {
		this.abnormalReaction = abnormalReaction;
	}
	public boolean hasAbnormalReaction() {
		return abnormalReaction;
	}
	
	@Override
	public String toString() {
		return super.toString() + abnormalReaction;
	}
}
