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
}