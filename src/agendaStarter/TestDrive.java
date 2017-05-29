package agendaStarter;

import domein.Appointment;
import domein.AppointmentBuilder;
import domein.AppointmentException;
import domein.Contact;
import domein.Location;
import domein.MeetingBuilder;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestDrive {

    private final static Contact contactData[] = {
        new Contact("Van Schoor", "Johan", "Lector", "Hogeschool Gent"),
        new Contact("Samyn", "Stefaan", "Lector", "Hogeschool Gent"),
        new Contact("Malfait", "Irina", "Lector", "Hogeschool Gent"),
        new Contact("De Donder", "Margot", "Lector", "Hogeschool Gent"),
        new Contact("Decorte", "Johan", "Lector", "Hogeschool Gent"),
        new Contact("Samyn", "Karine", "Lector", "Hogeschool Gent")
    };
    private Appointment appt;
    //TODO attribut(en) voor aanmaak van een appointment
    //

    //
    //End TODO attribut(en)
    public static void main(String[] args) {
        new TestDrive().run();
    }

    private List<Contact> createAttendees(int numberToCreate) {
        List<Contact> group = new ArrayList<>();
        for (int i = 0; i < numberToCreate; i++) {
            group.add(getContact(i));
        }
        return group;
    }

    private Contact getContact(int index) {
        return contactData[index % contactData.length];
    }

    private void run() {
        System.out.println("Creating an Appointment ");
        //TODO maak gewone afspraak zonder fout:
        //
        //Start datum = new GregorianCalendar(2017, 7, 22, 12, 30)
        //Locatie = new Location("Hogeschool Gent, D2.014")
        //Beschrijving = "Project Demo"
        //uitgenodigden = createAttendees(4)
        AppointmentBuilder ab = new AppointmentBuilder();
        ab.createAppointment();
        ab.setDescription("Project Demo");
        ab.setStartDate(new GregorianCalendar(2017, 7, 22, 12, 30));
        ab.setLocation(new Location("Hogeschool Gent, D2.014"));
        ab.setAttendees(createAttendees(4));

        try {
            appt = ab.buildAppointment();

            //Afdruk resultaat
            System.out.println("Successfully created an Appointment.");
            System.out.println("Appointment information:");
            System.out.println(appt);
            System.out.println();
            //vervolg...(als fouten)
        } catch (AppointmentException ex) {
            System.err.println("Could not create meeting: " + ex.getMessage());
            System.out.println();
        }

        System.out.println("Creating a meeting : enddate is missing");
        //TODO maak een meeting met fout:
        //
        //Start datum = new GregorianCalendar(2017, 3, 21, 12, 30)
        //Locatie = new Location("Hogeschool Gent, B3.020")
        //Beschrijving = "OOO III"
        //uitgenodigden = createAttendees(4)
        AppointmentBuilder mb = new MeetingBuilder();
        mb.createAppointment();
        mb.setDescription("OOO III");
        mb.setStartDate(new GregorianCalendar(2017, 3, 21, 12, 30));
        mb.setLocation(new Location("Hogeschool Gent, B3.020"));
        mb.setAttendees(createAttendees(4));

        try {
            appt = mb.buildAppointment();

            //Afdruk resultaat (zal falen)
            System.out.println("Successfully created an Appointment.");
            System.out.println("Appointment information:");
            System.out.println(appt);
            System.out.println();
            //vervolg... (als fouten)
        } catch (AppointmentException ex) {
            System.out.println("Could not create meeting: " + ex.getMessage());
            System.out.println();
        }

        System.out.println("Meeting : all items are provided");
        //TODO maak een meeting met fout:
        //
        //Start datum = new GregorianCalendar(2017, 4, 1, 10, 00)
        //Eind datum = new GregorianCalendar(2017, 4, 1, 11, 30),
        //Locatie = new Location("Hogeschool Gent, B1.032")
        //Beschrijving = "Project II Meeting"
        //uitgenodigden = createAttendees(2)
        mb.createAppointment();
        mb.setDescription("Project II Meeting");
        mb.setStartDate(new GregorianCalendar(2017, 4, 1, 10, 00));
        mb.setEndDate(new GregorianCalendar(2017, 4, 1, 11, 30));
        mb.setLocation(new Location("Hogeschool Gent, B1.032"));
        mb.setAttendees(createAttendees(2));

        try {
            appt = mb.buildAppointment();

            //Afdruk resultaat
            System.out.println("Successfully created an Appointment.");
            System.out.println("Appointment information:");
            System.out.println(appt);
            System.out.println();
            //vervolg...(als fouten)
        } catch (AppointmentException ex) {
            System.err.println("Could not create meeting: " + ex.getMessage());
            System.out.println();
        }
        //
    }

    //TODO een printmethode voor bij fouten : wat er voor de constructie ontbreekt
    //
    //public void print...
    //
    //END TODO printmethode wat ontbreekt
}
