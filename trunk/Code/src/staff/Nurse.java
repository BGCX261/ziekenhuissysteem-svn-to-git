package staff;

import java.util.Calendar;
import java.util.GregorianCalendar;

import scheduling.TimePeriod;

public class Nurse extends StaffMember
{
    public Nurse( String name )
    {
        super( name );
    }

    @Override
    public String toString()
    {
        return "" + super.getId() + ". " + super.getName() + " Nurse";
    }

    @Override
    public boolean isWorking( TimePeriod time )
    {
        int beginHour = time.getBegin().get( Calendar.HOUR_OF_DAY ), endHour = time.getEnd().get( Calendar.HOUR_OF_DAY );

        if ( beginHour < 8 || endHour > 17 ) return false;
        if ( endHour == 17 ) if ( time.getEnd().get( Calendar.MINUTE ) > 0 ) return false;
        return true;
    }

    public TimePeriod notWorking( TimePeriod period )
    {
        if ( isWorking( period ) ) return null;
        else
        {
            GregorianCalendar now = new GregorianCalendar();
            GregorianCalendar end = new GregorianCalendar();

            now.setTime( period.getBegin().getTime() );
            end.setTime( now.getTime() );
            end.set( now.get( Calendar.YEAR ), now.get( Calendar.MONTH ), now.get( Calendar.DAY_OF_MONTH ), 8, 0 );
            end.add( Calendar.DAY_OF_MONTH, 1 );

            return new TimePeriod( now, end );
        }
    }
}
