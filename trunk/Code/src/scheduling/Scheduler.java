package scheduling;

import hospital.Hospital;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import machines.Machine;
import patients.Patient;
import repositories.EquipmentRepository;
import repositories.StaffRepository;
import staff.StaffMember;

/**
 * 
 * Deze klasse behandeld alle scheduling problemen. De planning zelf wordt hier
 * niet in bijgehouden, voor dit verwijst de Scheduler naar een Schedule.
 * 
 */

public class Scheduler
{
    private Schedule            schedule;
    private StaffRepository     staffRepository;
    private EquipmentRepository equipmentRepository;

    /**
     * Maak een nieuwe scheduler.
     * 
     * @param staffRepository
     *            Lijst met alle staff
     * @param equipmentRepository
     *            Lijst met alle equipment
     * @param hospital
     *            Het ziekenhuis waarin moet gescheduled worden
     */
    
    public Scheduler( StaffRepository staffRepository, EquipmentRepository equipmentRepository, Hospital hospital )
    {
        this.schedule = new Schedule( hospital );
        this.equipmentRepository = equipmentRepository;
        this.staffRepository = staffRepository;
    }

    public Schedule getSchedule()
    {
        return this.schedule;
    }

    /**
     * 
     * @param resources
     *            De lijst van resources
     * @param period
     *            De periode die in eerste instantie gescheduled moet worden.
     *            Deze periode wordt aangepast wanneer er geen toegankelijke
     *            resource is in de lijst voor de eerst gegeven periode.
     * @param duration
     *            De duur van de timeperiod
     * 
     * @return De eerst toegankelijke resource in de lijst resources.
     */

    private ScheduleResource firstAvailable( List<ScheduleResource> resources, TimePeriod period, int duration )
    {
        TimePeriod time = null;
        int i = 0;
        ScheduleResource resource;

        do
        {
            resource = resources.get( i++ );
            time = schedule.getInterferringTimePeriod( resource, period );
            if ( i == resources.size() && time != null )
            {
                i = 0;

                period.getBegin().setTime( time.getEnd().getTime() );
                period.getEnd().setTime( time.getEnd().getTime() );
                period.getEnd().add( Calendar.MINUTE, duration );
            }
        } while ( time != null );

        return resource;
    }

    /**
     * Deze methode behandeld het schedulen. FIXME dt
     * Ze werkt met de interfaces
     * ScheduleResource en Schedulable om correcte informatie te verzamelen rond
     * het schedulen.
     * 
     * @param appointment
     *            De Schedulable die moet gescheduled worden
     * @throws Exception
     *             Alls er een foute schedulable wordt getracht te schedulen.
     */
    public void schedule( Schedulable appointment ) throws Exception
    {
        // FIXME Lijkt me opsplitsbaar in meerdere submethodes
        List<ScheduleResource> needResources;
        if ( appointment.hasLitteralResources() ) needResources = appointment.neededResources();
        else
            needResources = this.getAll( appointment.neededResources() );

        ArrayList<ScheduleResource> scheduled = new ArrayList<ScheduleResource>();

        int duration = appointment.getDuration();

        boolean check = false;
        Map<Class<?>, List<ScheduleResource>> resourceMap = new HashMap<Class<?>, List<ScheduleResource>>();

        for ( ScheduleResource needResource : needResources )
        {
            if ( resourceMap.get( needResource.getClass() ) == null ) resourceMap.put( needResource.getClass(), new ArrayList<ScheduleResource>() );

            resourceMap.get( needResource.getClass() ).add( needResource );
        }

        TimePeriod buffer1;

        // FIXME Misschien vergis ik me, maar waar zit de "minstens één uur later" constraint?
        GregorianCalendar now = new GregorianCalendar(), end = new GregorianCalendar();
        now.setTime( schedule.getHospital().getTime().getTime() );
        end.setTime( schedule.getHospital().getTime().getTime() );
        end.add( Calendar.MINUTE, duration );
        buffer1 = new TimePeriod( now, end );

        while ( !check )
        {
            check = true;
            long identify = 0;
            scheduled = new ArrayList<ScheduleResource>();

            for ( Class<?> key : resourceMap.keySet() )
            {
                // FIXME Waarom casten naar ArrayList? Waarom dan niet meteen het juiste type toekennen hierboven, of hier wrken met Lists
                ArrayList<ScheduleResource> value = (ArrayList<ScheduleResource>) resourceMap.get( key );

                identify = buffer1.identify();
                ScheduleResource addResource = firstAvailable( value, buffer1, duration );
                if ( !(identify == 0 || identify == buffer1.identify()) ) check = false;
                else
                    scheduled.add( addResource );
            }
        }
        for ( ScheduleResource scheduleResource : scheduled )
            schedule.reserveResource( scheduleResource, buffer1 );

        schedule.scheduleSchedulable( appointment );

        appointment.setScheduledPeriod( buffer1 );
    }

    /**
     * 
     * @param getFrom
     *            Een lijst met dummie objecten die de klassen van resources
     *            voorstellen.
     * @return Geeft een lijst van alle instancies van de gegeven klassen.
     */
    private ArrayList<ScheduleResource> getAll( List<ScheduleResource> getFrom )
    {
        // FIXME: waarom niet meteen met een lijst van Class-objecten werken?
        // Vind ik nog steeds geen propere oplossing, maar toch stukken beter dan dummy-objecten
        
        ArrayList<ScheduleResource> allResources = new ArrayList<ScheduleResource>();
        ArrayList<ScheduleResource> result = new ArrayList<ScheduleResource>();

        for ( StaffMember staff : staffRepository.getStaff() )
        {
            allResources.add( staff );
        }
        for ( Machine machine : equipmentRepository.getMachines() )
        {
            allResources.add( machine );
        }
        for ( ScheduleResource resource : allResources )
        {
            boolean check = false;
            Class<?> resourceClass = resource.getClass();

            for ( ScheduleResource thisResource : getFrom )
            {
                if ( resourceClass == thisResource.getClass() ) check = true;
            }

            // FIXME new Patient( null ).getClass() --> Patient.class
            if ( check || resource.getClass() == new Patient( null ).getClass() ) result.add( resource );
        }

        return result;
    }
}
