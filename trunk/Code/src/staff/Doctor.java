package staff;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import patients.PatientFile;
import scheduling.TimePeriod;
import patients.Diagnosis;

;

/**
 * 
 * Elke dokter is een subclasse van staffmember. Deze klasse zorgt voor alle
 * functionaliteit van een dokter.
 * 
 */

public class Doctor extends StaffMember
{
    private PatientFile     lastOpenedPatientFile;
    private List<Diagnosis> needSecondOpinion;

    /**
     * Maakt een dokter aan
     * 
     * @param name
     *            naam van de dokter
     */
    public Doctor( String name )
    {
        super( name );
        lastOpenedPatientFile = null;
        needSecondOpinion = new ArrayList<Diagnosis>();
    }

    /**
     * 
     * @return de laatste patient file die de dokter las
     */
    public PatientFile getLastOpenedPatientFile()
    {
        return lastOpenedPatientFile;
    }

    /**
     * 
     * @param lastOpenedPatientFile
     *            De nieuwe laatst geopende patient file
     */
    public void setLastOpenedPatientFile( PatientFile lastOpenedPatientFile )
    {
        this.lastOpenedPatientFile = lastOpenedPatientFile;
    }

    @Override
    public String toString()
    {
        return "" + super.getId() + ". " + super.getName() + " Doctor";
    }

    public List<Diagnosis> getSecondOpinionDiagnosis()
    {
        return Collections.unmodifiableList( needSecondOpinion );
    }

    public void addNeedSecondOpinion( Diagnosis diagnosis )
    {
        needSecondOpinion.add( diagnosis );
    }

    public void removeNeedSecondOpinion( Diagnosis diagnosis )
    {
        needSecondOpinion.remove( diagnosis );
    }

    /**
     * Geeft terug wanneer de dokter niet werkt. Er wordt aangenomen dat een
     * dokter altijd werkt. Meer informatie werd niet gegeven.
     */
    public TimePeriod notWorking( TimePeriod period )
    {
        return null;
    }
}
