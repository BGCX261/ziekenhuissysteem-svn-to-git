package medicaltests;

import machines.UltrasoundMachine;

public class UltrasoundScan extends MedicalTest
{
    private static final int DURATION = 30; // FIXME Duration als int
    String                   focus;
    boolean                  recordVideo;
    boolean                  recordImages;

    /**
     * 
     * @param focus
     *            De focus van de scan
     * @param recordVideo
     * @param recordImages
     */
    public UltrasoundScan( String focus, boolean recordVideo, boolean recordImages )
    {
        super( DURATION );
        needed.add( new UltrasoundMachine( null, 0 ) ); // FIXME Yuck, dummy
                                                        // objecten zijn vies
        this.focus = focus;
        this.recordVideo = recordVideo;
        this.recordImages = recordImages;
    }

    @Override
    public String toString()
    {
        return "Focus: " + focus + " Record Video: " + recordVideo + " Record Images: " + recordImages;
    }
}