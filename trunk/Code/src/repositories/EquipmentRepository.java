package repositories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import scheduling.Location;

import machines.BloodAnalyser;
import machines.Machine;
import machines.SurgicalEquipment;
import machines.UltrasoundMachine;
import machines.XRayScanner;

public class EquipmentRepository
{
    private List<Machine>           machines;
    private List<SurgicalEquipment> surgicalEquipments;
    private List<UltrasoundMachine> ultrasoundMachines;
    private List<BloodAnalyser>     bloodAnalysers;
    private List<XRayScanner>       xRayScanners;

    private int                     latestGeneratedID;

    public EquipmentRepository()
    {
        machines = new ArrayList<Machine>();
        surgicalEquipments = new ArrayList<SurgicalEquipment>();
        ultrasoundMachines = new ArrayList<UltrasoundMachine>();
        bloodAnalysers = new ArrayList<BloodAnalyser>();
        xRayScanners = new ArrayList<XRayScanner>();
        latestGeneratedID = 0;
    }

    public List<Machine> getMachines()
    {
        return Collections.unmodifiableList( machines );
    }

    public List<SurgicalEquipment> getSurgicalEquipments()
    {
        return Collections.unmodifiableList( surgicalEquipments );
    }

    public List<UltrasoundMachine> getUltrasoundMachines()
    {
        return Collections.unmodifiableList( ultrasoundMachines );
    }

    public List<BloodAnalyser> getBloodAnalysers()
    {
        return Collections.unmodifiableList( bloodAnalysers );
    }

    public List<XRayScanner> getxRayScanners()
    {
        return Collections.unmodifiableList( xRayScanners );
    }

    public int getLatestGeneratedID()
    {
        return latestGeneratedID;
    }

    public void addSurgicalEquipment( int floor, int room )
    {
        Location location = new Location( floor, room );
        SurgicalEquipment equipment = new SurgicalEquipment( location, ++latestGeneratedID );
        machines.add( equipment );
        surgicalEquipments.add( equipment );
    }

    public void addUltrasoundMachine( int floor, int room )
    {
        Location location = new Location( floor, room );
        UltrasoundMachine machine = new UltrasoundMachine( location, ++latestGeneratedID );
        machines.add( machine );
        ultrasoundMachines.add( machine );
    }

    public void addBloodAnalyzer( int floor, int room )
    {
        Location location = new Location( floor, room );
        BloodAnalyser analyser = new BloodAnalyser( location, ++latestGeneratedID );
        machines.add( analyser );
        bloodAnalysers.add( analyser );
    }

    public void addXRayScanner( int floor, int room )
    {
        Location location = new Location( floor, room );
        XRayScanner scanner = new XRayScanner( location, ++latestGeneratedID );
        machines.add( scanner );
        xRayScanners.add( scanner );
    }
}
