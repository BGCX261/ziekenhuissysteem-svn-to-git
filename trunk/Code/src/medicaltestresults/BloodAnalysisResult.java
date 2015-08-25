package medicaltestresults;

import medicaltests.BloodAnalysis;

public class BloodAnalysisResult extends MedicalTestResult {
	private int amountOfBlood;
	private int whiteCellCount;
	private int redCellCount;
	private int plateletCount;

	/**
	 * 
	 * @param bloodAnalysis	De bloedanalyse waar het resultaat van afstamt
	 * @param amountOfBlood	De hoeveelheid aan bloed
	 * @param whiteCellCount	Het aantal witte bloedcellen
	 * @param redCellCount	Het aantal rode bloedcellen
	 * @param plateletCount	Het aantal pataletten
	 */
	public BloodAnalysisResult(BloodAnalysis bloodAnalysis, int amountOfBlood,
			int whiteCellCount, int redCellCount, int plateletCount) {
		super(bloodAnalysis);
		setAmountOfBlood(amountOfBlood);
		setWhiteCellCount(whiteCellCount);
		setRedCellCount(redCellCount);
		setPlateletCount(plateletCount);

	}
	
	@Override
	public String toString() {
		return super.toString() + amountOfBlood + " " + whiteCellCount + " " + redCellCount + " " + plateletCount;
	}

	/**
	 * 
	 * @return	De hoeveelheid bloed
	 */
	public int getAmountOfBlood() {
		return amountOfBlood;
	}

	/**
	 * 
	 * @param amountOfBlood	De nieuwe hoeveelheid bloed
	 * @throws IllegalArgumentException
	 * 			De hoeveelheid moet positief zijn of 0.
	 */
	public void setAmountOfBlood(int amountOfBlood) throws IllegalArgumentException{
		if (amountOfBlood >= 0)
			this.amountOfBlood = amountOfBlood;
		else
			throw new IllegalArgumentException();

	}

	/**
	 * 
	 * @return	Het aantal witte bloedcellen
	 */
	public int getWhiteCellCount(){
		return whiteCellCount;
	}

	/**
	 * 
	 * @param whiteCellCount	Het nieuwe aantal witte bloedcellen	
	 * @throws IllegalArgumentException
	 * 			Het aantal moet positief zijn of 0.
	 */
	public void setWhiteCellCount(int whiteCellCount) throws IllegalArgumentException{
		if (whiteCellCount >= 0)
			this.whiteCellCount = whiteCellCount;
		else
			throw new IllegalArgumentException();
	}

	/**
	 * 
	 * @return	Het aantal rode bloedcellen.
	 */
	public int getRedCellCount() {
		return redCellCount;
	}

	/**
	 * 
	 * @param redCellCount	Het nieuwe aantal rode bloedcellen
	 * @throws IllegalArgumentException
	 * 			Het aantal moet positief zijn of 0.
	 */
	public void setRedCellCount(int redCellCount) throws IllegalArgumentException{
		if (redCellCount >= 0)
			this.redCellCount = redCellCount;
		else
			throw new IllegalArgumentException();

	}

	/**
	 * 
	 * @return	Het aantal pataletten
	 */
	public int getPlateletCount() {
		return plateletCount;
	}

	/**
	 * 
	 * @param plateletCount	Het nieuwe aantal
	 * @throws IllegalArgumentException
	 * 			Het aantal moet positief zijn of 0.
	 */
	public void setPlateletCount(int plateletCount) throws IllegalArgumentException{
		if (plateletCount >= 0)
			this.plateletCount = plateletCount;
		else
			throw new IllegalArgumentException();
	}
}
