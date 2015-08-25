package treatmentresults;

import medicaltestresults.Result;
import treatments.Treatment;

public abstract class TreatmentResult extends Result{
	private String report;
	private Treatment treatment;
	
	public TreatmentResult(Treatment treatment,String report) {
		super(null);
		setTreatment(treatment);
		setReport(report);
	}
	
	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
	}
	
	public Treatment getTreatment() {
		return treatment;
	}

	public void setTreatment(Treatment treatment) {
		//TODO check binding
		this.treatment = treatment;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}
