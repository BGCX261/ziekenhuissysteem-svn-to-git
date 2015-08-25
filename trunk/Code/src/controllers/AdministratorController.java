package controllers;

import repositories.EquipmentRepository;
import repositories.StaffRepository;

public class AdministratorController
{
    StaffRepository     staffRepository;
    EquipmentRepository equipmentRepository;

    /**
     * 
     * @param staffRepository
     *            De lijst met alle staff
     * @param equipmentRepository
     *            De lijst met alle equipment
     */
    public AdministratorController( StaffRepository staffRepository, EquipmentRepository equipmentRepository )
    {
        this.staffRepository = staffRepository;
        this.equipmentRepository = equipmentRepository;
    }

    /**
     * Voeg een verpleegster toe
     * 
     * @param name
     *            naam van de verpleegster
     */
    public void addNurse( String name )
    {
        staffRepository.addNurse( name );
    }

    /**
     * Voeg een dokter toe
     * 
     * @param name
     *            naam van de dokter
     */
    public void addDoctor( String name )
    {
        staffRepository.addDoctor( name );
    }

    /**
     * Voeg surgical equipment toe
     * 
     * @param floor
     *            verdieping van het chirurgisch gerief
     * @param room
     *            kamer waar het gerief staat
     */
    public void addSurgicalEquipment( int floor, int room )
    {
        equipmentRepository.addSurgicalEquipment( floor, room );
    }

    /**
     * Voeg een ultrasound scanner toe
     * 
     * @param floor
     *            verdieping van de scanner
     * @param room
     *            kamer waar de scanner staat
     */
    public void addUltrasoundMachine( int floor, int room )
    {
        equipmentRepository.addUltrasoundMachine( floor, room );
    }

    /**
     * Voeg een bloodanalyzer toe
     * 
     * @param floor
     *            verdieping van de bloodanalyzer
     * @param room
     *            kamer waar de bloodanalyzer staat
     */
    public void addBloodAnalyzer( int floor, int room )
    {
        equipmentRepository.addBloodAnalyzer( floor, room );
    }

    /**
     * Voeg een xray scanner toe
     * 
     * @param floor
     *            verdieping van de scanner
     * @param room
     *            kamer waar de scanner staat
     */
    public void addXRayScanner( int floor, int room )
    {
        equipmentRepository.addXRayScanner( floor, room );
    }
}
