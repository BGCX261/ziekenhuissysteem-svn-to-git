package scheduling;

import hospital.Hospital;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * 
 * Deze klasse bevat een lijst met alle geplande schedulables en een hashmap van
 * de regeling van alle resources.
 * 
 */

public class Schedule
{    
    private HashMap<ScheduleResource, ArrayList<TimePeriod>> resourceMap; // FIXME Waarom is dit geen veld in ScheduleResource-objecten?
    private List<Schedulable>                                schedulables;
    private Hospital                                         hospital; // FIXME Moet deze dependency er echt zijn? Kan men aan die ene methode die dit veld nodig heeft 't niet doorgeven als argument?

    /**
     * Maakt een nieuw schedule
     * 
     * @param hospital
     *            Het hospital waarvoor dit schedule geldt
     */
    public Schedule( Hospital hospital )
    {
        resourceMap = new HashMap<ScheduleResource, ArrayList<TimePeriod>>();
        schedulables = new ArrayList<Schedulable>();
        this.hospital = hospital;
    }

    public Hospital getHospital()
    {
        return this.hospital;
    }

    /**
     * 
     * @param needResource
     *            De resource voor welke de methode moet checken of hij
     *            beschijkbaar is
     * @param needTime
     *            De tijdsperiode die nodig is
     * @return True als de resource voor de gegeven tijd toegankelijk is
     */
    public boolean resourceAvailable( ScheduleResource needResource, TimePeriod needTime )
    {
        ArrayList<TimePeriod> times = resourceMap.get( needResource );
        if ( times == null ) return true;
        if ( !needResource.isWorking( needTime ) ) return false;
        for ( TimePeriod time : times )
        {
            if ( time.interferres( needTime ) ) return false;
        }
        return true;
    }

    /**
     * 
     * Doet hetzelfde als resourceAvailable maar geeft ook de timeperiod terug
     * die in conflict is met de gegeven timeperiod.
     */
    public TimePeriod getInterferringTimePeriod( ScheduleResource needResource, TimePeriod needTime )
    {
        ArrayList<TimePeriod> times = resourceMap.get( needResource );
        if ( times == null ) return null;
        if ( !needResource.isWorking( needTime ) )
        {
            return needResource.notWorking( needTime );
        }
        for ( TimePeriod time : times )
        {
            if ( time.interferres( needTime ) ) return time;
        }

        return null;
    }

    public ArrayList<TimePeriod> getTimeTable( ScheduleResource resource )
    {
        return resourceMap.get( resource );
    }

    /**
     * 
     * reserveer een resource
     * 
     */
    public void reserveResource( ScheduleResource resource, TimePeriod time ) throws Exception
    {
        if ( resourceAvailable( resource, time ) )
        {
            if ( !resourceMap.containsKey( resource ) ) resourceMap.put( resource, new ArrayList<TimePeriod>() );
            resourceMap.get( resource ).add( time );
        }
        else
            throw new Exception();
    }

    public void scheduleSchedulable( Schedulable schedulable )
    {
        schedulables.add( schedulable );
    }

    public List<Schedulable> getAllByClass( Class<?> classType )
    {
        List<Schedulable> listPerClass = new ArrayList<Schedulable>();

        for ( Schedulable schedulable : schedulables )
            if ( schedulable.getClass() == classType ) listPerClass.add( schedulable );

        return Collections.unmodifiableList( listPerClass );
    }

    /**
     * 
     * Geeft alle schedulables terug van de classe classType die al gedaan zijn.
     */
    public List<Schedulable> getFinishedByClass( Class<?> classType )
    {
        List<Schedulable> listFinishedPerClass = new ArrayList<Schedulable>();
        GregorianCalendar now = hospital.getTime();

        for ( Schedulable schedulable : schedulables )
            if ( schedulable.getClass() == classType ) if ( schedulable.getScheduledPeriod().getEnd().before( now ) ) listFinishedPerClass.add( schedulable );

        return Collections.unmodifiableList( listFinishedPerClass );
    }
}
