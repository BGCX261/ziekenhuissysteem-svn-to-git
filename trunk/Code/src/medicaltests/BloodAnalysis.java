package medicaltests;
import machines.BloodAnalyser;


public class BloodAnalysis extends MedicalTest {
	private static final int DURATION = 45; // FIXME Duration als int
	private String focus;
	private int numberOfAnalyses;
	
	/**
	 * 
	 * @param focus	De focus van de bloedanalyse
	 * @param numberOfAnalyses	Het aantal analyses
	 */
	public BloodAnalysis(String focus, int numberOfAnalyses) {
		super(DURATION);
		needed.add(new BloodAnalyser(null, 0)); // FIXME Dummy object alert
		this.focus = focus;
		this.numberOfAnalyses = numberOfAnalyses;
		}

	/**
	 * 
	 * @return	het aantal analyses
	 */
	public int getNumberOfAnalyses() {
		return numberOfAnalyses;
	}
	
	/**
	 * Zet het aantal analyses
	 * @param numberOfAnalyses	het nieuwe aantal analyses
	 * @throws IllegalArgumentException
	 * 	Het aantal analyses moet groter zijn als of gelijk aan nul
	 */
	public void setNumberOfAnalyses(int numberOfAnalyses) throws IllegalArgumentException{
		if(numberOfAnalyses>=0) this.numberOfAnalyses = numberOfAnalyses;
		else throw new IllegalArgumentException();
	}
	
	@Override
	public String toString() {
		return "Focus: " + focus + " Number of Analyses: " + numberOfAnalyses;
	}
}
