package scheduling;

import java.util.ArrayList;
import patients.Patient;
import staff.Doctor;

/**
 * 
 * Een appointment die gemaakt kan worden. Deze appointment geldt tussen een
 * dokter en een patient.
 * 
 */

public class Appointment implements Schedulable
{
    private static final int            DURATION = 30;
    protected static ArrayList<Integer> NEEDED   = new ArrayList<Integer>();

    private TimePeriod                  scheduledPeriod;
    private Patient                     patient;
    private Doctor                      doctor;
    private boolean                     isScheduled;

    /**
     * 
     * @param patient
     *            De patient die een afspraak wil
     * @param doctor
     *            De dokter die de afspraakt behandeld // FIXME 2 spelfouten
     */
    public Appointment( Patient patient, Doctor doctor )
    {
        setPatient( patient );
        setDoctor( doctor );
    }

    public void setScheduledPeriod( TimePeriod scheduledPeriod )
    {
        this.scheduledPeriod = scheduledPeriod;
        if ( scheduledPeriod != null )
        {
            isScheduled = true;
        }
    }

    public int getDuration()
    {
        return DURATION;
    }

    /**
     * 
     * @return De patient die een afspraak heeft
     */
    public Patient getPatient()
    {
        return patient;
    }

    /**
     * Zet de patient van deze appointment
     * 
     * @param patient
     *            De nieuwe patient
     */
    public void setPatient( Patient patient )
    {
        this.patient = patient;
    }

    @Override
    public boolean isScheduled()
    {
        return isScheduled;
    }

    @Override
    public ArrayList<ScheduleResource> neededResources()
    {
        ArrayList<ScheduleResource> needResources = new ArrayList<ScheduleResource>();
        needResources.add( doctor );
        needResources.add( patient );
        return needResources;
    }

    /**
     * Zet een nieuwe dokter voor deze appointment
     * 
     * @param doctor
     *            De nieuwe dokter
     */
    public void setDoctor( Doctor doctor )
    {
        this.doctor = doctor;
    }

    /**
     * 
     * @return Geeft de doker die deze appointment behandeld // FIXME dt
     */
    public Doctor getDoctor()
    {
        return doctor;
    }

    @Override
    public String toString()
    {
        return "Appointment with " + doctor.getName() + " at " + scheduledPeriod;
    }

    @Override
    public TimePeriod getScheduledPeriod()
    {
        return scheduledPeriod;
    }

    public boolean hasLitteralResources()
    {
        return true;
    }

}
