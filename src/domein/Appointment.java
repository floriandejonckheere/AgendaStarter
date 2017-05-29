package domein;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Appointment {

    private GregorianCalendar startDate;
    private GregorianCalendar endDate;
    private String description;
    private Set<Contact> attendees = new HashSet<>();
    private Location location;

    public void addAttendee(Contact attendee) {
        attendees.add(attendee);
    }

    public void removeAttendee(Contact attendee) {
        attendees.remove(attendee);
    }

    @Override
    public String toString() {
        String EOL_STRING = System.getProperty("line.separator");
        SimpleDateFormat sdf = new SimpleDateFormat();
        return String.format(
                "  Description: %s%s Start Date: %s%s End Date: %s%s Location: %s%s Attendees: %s%s",
                description, EOL_STRING,
                startDate != null ? sdf.format(startDate.getTime()) : "", EOL_STRING,
                endDate != null ? sdf.format(endDate.getTime()) : "", EOL_STRING,
                location, EOL_STRING,
                attendees, EOL_STRING);
    }

    public GregorianCalendar getStartDate() {
        return startDate;
    }

    public GregorianCalendar getEndDate() {
        return endDate;
    }

    public String getDescription() {
        return description;
    }

    public Set<Contact> getAttendees() {
        return Collections.unmodifiableSet(attendees);
    }

    public Location getLocation() {
        return location;
    }

    public void setDescription(String newDescription) {
        description = newDescription;
    }

    public void setLocation(Location newLocation) {
        location = newLocation;
    }

    public void setStartDate(GregorianCalendar newStartDate) {
        startDate = newStartDate;
    }

    public void setEndDate(GregorianCalendar newEndDate) {
        endDate = newEndDate;
    }

    public void setAttendees(List<Contact> newAttendees) {
        if (newAttendees != null) {
            for (Contact contact : newAttendees) {
                attendees.add(contact);
            }
        }
    }
    
    public static Appointment.Builder Builder() {
        return new Appointment.Builder();
    }
    
    public static Appointment.Builder MeetingBuilder() {
        return new Appointment.MeetingBuilder();
    }
    
    public static class Builder {
        protected final Appointment appointment;
        
        public Builder() {
            this.appointment = new Appointment();
        }
        
        public Builder description(String description) {
            appointment.description = description;
            return this;
        }
        
        public Builder location(Location location) {
            appointment.location = location;
            return this;
        }
        
        public Builder startDate(GregorianCalendar date) {
            appointment.startDate = date;
            return this;
        }
        
        public Builder endDate(GregorianCalendar date) {
            appointment.endDate = date;
            return this;
        }
        
        public Builder attendees(List<Contact> attendees) {
            appointment.setAttendees(attendees);
            return this;
        }
        
        public Appointment build() throws AppointmentException {
            return appointment;
        }
    }
    
    public static class MeetingBuilder extends Appointment.Builder {

        @Override
        public Appointment build() throws AppointmentException {
            if (appointment.getEndDate() == null)
                throw new AppointmentException("Dude, does it even end");
            
            return appointment;
        }
    }
}