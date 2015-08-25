package treatmentresults;

import treatments.Surgery;

public class SurgeryResult extends TreatmentResult {
	private String specialAftercare;
	

	public SurgeryResult(Surgery surgery, String report, String specialAftercare) {
		super(surgery, report);
		setSpecialAftercare(specialAftercare);
	}

	public String getSpecialAftercare() {
		return specialAftercare;
	}

	public void setSpecialAftercare(String specialAftercare) {
		this.specialAftercare = specialAftercare;
	}
	
	@Override
	public String toString() {
		return super.toString() + specialAftercare;
	}
}
