package medicaltestresults;

import treatmentresults.TreatmentResult;
import treatments.Medication;

public class MedicationResult extends TreatmentResult{
	private boolean abnormalReaction;
	public MedicationResult(Medication medication, String report, boolean abnormalReaction) {
		super(medication, report);
		setAbnormalReaction(abnormalReaction);
	}
	
	/**
	 * 
	 * @param abnormalReaction true als er een abnormale reactie was op de behandeling
	 */
	public void setAbnormalReaction(boolean abnormalReaction) {
		this.abnormalReaction = abnormalReaction;
	}
	
	/**
	 * 
	 * @return	true als deze behandeling een abnormale reactie kende.
	 */
	public boolean hasAbnormalReaction() {
		return abnormalReaction;
	}
	

	@Override
	public String toString() {
		return super.toString() + abnormalReaction;
	}
}
