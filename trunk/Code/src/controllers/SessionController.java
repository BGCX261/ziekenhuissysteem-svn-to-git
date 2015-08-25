package controllers;

import java.util.List;

import repositories.*;
import staff.Doctor;
import staff.StaffMember;

public class SessionController
{
    private StaffRepository staffRepository;
    private StaffMember     currentUser;

    public SessionController( StaffRepository staffRepository )
    {
        this.staffRepository = staffRepository;
    }

    public void login( StaffMember member )
    {
        currentUser = member;
        staffRepository.setSessionStaffMember( currentUser, true );
    }

    public void logOut()
    {
        staffRepository.setSessionStaffMember( currentUser, false );
    }

    public List<StaffMember> getStaff()
    {
        return staffRepository.getStaff();
    }

    public List<Doctor> getDoctors()
    {
        return staffRepository.getDoctors();
    }

    public StaffMember getStaffMemberByID( int id )
    {
        return staffRepository.getStaffMemberByID( id );
    }
}
