package repositories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import staff.Doctor;
import staff.Nurse;
import staff.StaffMember;

public class StaffRepository
{
    private List<StaffMember> staff;
    private List<Doctor>      doctors;
    private List<Nurse>       nurses;
    private int               latestGeneratedID;

    public StaffRepository()
    {
        staff = new ArrayList<StaffMember>();
        doctors = new ArrayList<Doctor>();
        nurses = new ArrayList<Nurse>();
        latestGeneratedID = 0;

        StaffMember hospitalAdministrator = new StaffMember( "Olivier Dubois" );
        hospitalAdministrator.setId( ++latestGeneratedID );
        staff.add( hospitalAdministrator );
    }

    public List<StaffMember> getStaff()
    {
        return Collections.unmodifiableList( staff );
    }

    public List<Doctor> getDoctors()
    {
        return Collections.unmodifiableList( doctors );
    }

    public List<Nurse> getNurses()
    {
        return Collections.unmodifiableList( nurses );
    }

    private void addStaffMember( StaffMember member )
    {
        member.setId( ++latestGeneratedID );
        staff.add( member );
    }

    public void addNurse( String name )
    {
        // FIXME Er wordt niet gecheckt of er al zo'n nurse bestaat
    	// TODO VRAGEN idd vs name als identifier
        Nurse nurse = new Nurse( name );
        addStaffMember( nurse );
        nurses.add( nurse );
    }

    public void addDoctor( String name )
    {
        // FIXME Geen checks
    	// TODO VRAGEN idd vs name als identifier
        Doctor doctor = new Doctor( name );
        addStaffMember( doctor );
        doctors.add( doctor );
    }

    public void setSessionStaffMember( StaffMember member, boolean session )
    {
        member.setSession( session );
    }

    public StaffMember getStaffMemberByID( int id )
    {
        for ( StaffMember member : staff )
        {
            if ( member.getId() == id )
            {
                return member;
            }
        }

        return null;
    }
}