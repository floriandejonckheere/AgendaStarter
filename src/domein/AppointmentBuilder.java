/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author florian
 */
public class AppointmentBuilder {

    protected Appointment appointment;
    
    public void createAppointment() {
        this.appointment = new Appointment();
    }

    public Appointment buildAppointment() throws AppointmentException {
        return appointment;
    }
    
    public void setDescription(String description) {
        appointment.setDescription(description);
    }
    
    public void setStartDate(GregorianCalendar date) {
        appointment.setStartDate(date);
    }
    
    public void setEndDate(GregorianCalendar date) {
        appointment.setEndDate(date);
    }
    
    public void setLocation(Location location) {
        appointment.setLocation(location);
    }
    
    public void setAttendees(List<Contact> attendees) {
        appointment.setAttendees(attendees);
    }
}
