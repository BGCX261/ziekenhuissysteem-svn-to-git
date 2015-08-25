package machines;

import scheduling.Location;
import scheduling.ScheduleResource;
import scheduling.TimePeriod;

/**
 * 
 * Dit is de overkoepelende klasse voor alle machines. Alle machines zijn
 * resources die gebruikt kunnen worden door de scheduler. Deze implementeren
 * daarom de interface ScheduleResources
 * 
 */

public class Machine implements ScheduleResource
{
    private final int id;
    private Location  location;

    public Machine( Location location, int id )
    {
        setLocation( location );
        this.id = id;
    }

    /**
     * @return the id
     */
    public int getId()
    {
        return id;
    }

    /**
     * @return the location
     */
    public Location getLocation()
    {
        // FIXME Je geeft een mutable object terug, dus iedereen mag het
        // herbruiken en wijzigen. Dit kan leiden tot grote problemen als je niet oppast
        return location;
    }

    /**
     * @param location
     *            the location to set
     */
    public void setLocation( Location location )
    {
        this.location = location;
    }

    @Override
    public boolean equals( Object p )
    {
        if ( p instanceof Machine )
        {
            Machine m = (Machine) p;
            if ( m.id == this.id ) return true;
        }
        return false;
    }

    @Override
    public boolean isWorking( TimePeriod period )
    {
        return true;
    }

    @Override
    public TimePeriod notWorking( TimePeriod period )
    {
        return null;
    }
}
