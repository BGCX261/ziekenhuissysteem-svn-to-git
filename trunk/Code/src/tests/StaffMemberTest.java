package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import staff.StaffMember;


public class StaffMemberTest {

	@Test
	public void testCreateStaffMember() {
		StaffMember staffMember = new StaffMember("John Doe");
		staffMember.setId(5);
		staffMember.setSession(true);
		assertEquals("Name", "John Doe", staffMember.getName());
		assertEquals("Id", 5, staffMember.getId());
		assertEquals("Session", true, staffMember.isSession());
	}

}
