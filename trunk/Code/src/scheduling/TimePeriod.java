package scheduling;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * 
 * Alle periodes die gescheduled worden, worden bijgehouden als TimePeriod. Deze
 * klasse bestaat eigenlijk uit 2 tijdsmomenten. Het begin en het einde.
 * 
 */

public class TimePeriod implements Comparable<TimePeriod>
{
    private Calendar begin, end;

    public TimePeriod( GregorianCalendar begin, GregorianCalendar end )
    {
        this.begin = begin;
        this.end = end;
    }

    /**
     * @return the begin
     */
    public Calendar getBegin()
    {
        // FIXME Opgelet, mutable object
        return begin;
    }

    /**
     * @param begin
     *            the begin to set
     */
    public void setBegin( Calendar begin )
    {
        // FIXME Mutable object
        this.begin = begin;
    }

    /**
     * @return the end
     */
    public Calendar getEnd()
    {
        // FIXME Mutable object
        return end;
    }

    /**
     * @param end
     *            the end to set
     */
    public void setEnd( Calendar end )
    {
        // FIXME Mutable object
        this.end = end;
    }

    // FIXME Docs! Moet dit een soort unieke id voorstellen voor een time period?
    public long identify()
    {
        return this.begin.getTimeInMillis() + this.end.getTimeInMillis();
    }

    /**
     * 
     * @param otherTime
     *            De mogelijks overlappende tijdsperiode
     * @return true als de tijdsperiode overlapt met deze
     */
    public boolean interferres( TimePeriod otherTime )
    {
        if ( otherTime.getBegin().compareTo( this.getBegin() ) <= 0 && otherTime.getEnd().compareTo( this.getBegin() ) > 0 ) return true;
        if ( otherTime.getBegin().compareTo( this.getBegin() ) >= 0 && otherTime.getBegin().compareTo( this.getEnd() ) < 0 ) return true;
        return false;
    }

    /**
     * 
     * @param otherTime
     *            De mogelijks omhullende tijdsperiode
     * @return true als deze tijdsperiode de gegeven omhult
     */
    public boolean incapsulates( TimePeriod otherTime )
    {
        if ( otherTime.getBegin().compareTo( this.getBegin() ) >= 0 && otherTime.getEnd().compareTo( this.getEnd() ) <= 0 ) return true;
        return false;
    }

    @Override
    public String toString()
    {
        return begin.getTime().toString() + " - " + end.getTime().toString();
    }

    @Override
    public int compareTo( TimePeriod time )
    {
        return this.getBegin().compareTo( time.getBegin() );
    }

}
