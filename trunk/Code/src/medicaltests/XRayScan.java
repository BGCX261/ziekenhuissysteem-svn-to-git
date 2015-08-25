package medicaltests;

import machines.XRayScanner;



public class XRayScan extends MedicalTest{
	private static final int DURATION=15; // FIXME Duration als int, is dat wel veilig? Wat als er ergens plots in seconden moet gemeten worden?
	
	private String bodyPart;
	private int numberOfImagesNeeded;
	private int zoomlevel;

	/**
	 * 
	 * @param bodyPart	De body part die gescanned moet worden, een string
	 * @param numberOfImagesNeeded	De nodige afbeeldingen
	 * @param zoomlevel	Hoeveel er gezoomed moet worden
	 */
	public XRayScan(String bodyPart, int numberOfImagesNeeded, int zoomlevel) {
		super(DURATION);
		needed.add(new XRayScanner(null, 0)); // FIXME Dummy object
		this.bodyPart = bodyPart;
		this.numberOfImagesNeeded = numberOfImagesNeeded;
		this.zoomlevel = zoomlevel;
	}
	
	/**
	 * 
	 * @return Nodige afbeeldingen
	 */
	public int getNumberOfImagesNeeded() {
		return numberOfImagesNeeded;
	}
	

	/**
	 * Zet de nodige afbeeldingen
	 * @param numberOfImagesNeeded	Zet naar numberOfImagesNeeded
	 * @throws IllegalArgumentException
	 */
	public void setNumberOfImagesNeeded(int numberOfImagesNeeded) throws IllegalArgumentException{
		if(numberOfImagesNeeded>=0) this.numberOfImagesNeeded = numberOfImagesNeeded;
		else throw new IllegalArgumentException();
	}
	
	/**
	 * 
	 * @return	Het zoomlevel van de scan
	 */
	public int getZoomlevel() {
		return zoomlevel;
	}
	
	/**
	 * Herzet het zoomlevel van de scan
	 * @param zoomlevel
	 * @throws IllegalArgumentException
	 */
	public void setZoomlevel(int zoomlevel) throws IllegalArgumentException{
		if(zoomlevel<1||zoomlevel>3) this.zoomlevel = zoomlevel;
		else throw new IllegalArgumentException(); 
	}
	
	@Override
	public String toString() {
		return "Body Part:" + bodyPart + " Number of Images needed: " + numberOfImagesNeeded + " Zoom Level: " + zoomlevel;
	}
}
