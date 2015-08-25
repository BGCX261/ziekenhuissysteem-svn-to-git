package medicaltestresults;

import medicaltests.UltrasoundScan;

public class UltrasoundScanResult extends MedicalTestResult {
	private String scanInfo;
	private ScanMatter scanMatter;

	/**
	 * 
	 * @param ultrasoundScan	De medicaltest ultrasoundScan
	 * @param scanInfo	Informatie over de scan
	 * @param scanMatter	Informatie over de massa van het te scannen object
	 * 						zie ook enumeratie ScanMatter
	 */
	public UltrasoundScanResult(UltrasoundScan ultrasoundScan, String scanInfo,
			ScanMatter scanMatter) {
		super(ultrasoundScan);
		setScanInfo(scanInfo);
		setScanMatter(scanMatter);
	}
	
	@Override
	public String toString() {
		return super.toString() + scanInfo;
	}

	public String getScanInfo() {
		return scanInfo;
	}

	public void setScanInfo(String scanInfo) {
		this.scanInfo = scanInfo;
	}

	public ScanMatter getScanMatter() {
		return scanMatter;
	}

	public void setScanMatter(ScanMatter scanMatter) {
		this.scanMatter = scanMatter;
	}
}