/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

/**
 *
 * @author florian
 */
public class MeetingBuilder extends AppointmentBuilder {

    @Override
    public Appointment buildAppointment() throws AppointmentException {
        if (appointment.getEndDate() == null)
            throw new AppointmentException("Dude, does it even end");
        
        return appointment;
    }
    
}
