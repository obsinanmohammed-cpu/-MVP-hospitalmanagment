package model;


public class Appointment {


    private static int appointmentCount = 0;

    private int appointmentId;
    private Patient patient;
    private Doctor doctor;
    private String date;
    private String notes;

    public Appointment(Patient patient, Doctor doctor, String date) {
        appointmentCount++;
        this.appointmentId = appointmentCount;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.notes = "No notes";
    }


    public int getAppointmentId() {
        return appointmentId;
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public String getDate() {
        return date;
    }


    public void setNotes(String notes) {
        if (notes != null && !notes.trim().isEmpty()) {
            this.notes = notes;
        }
    }


    public static int getTotalAppointments() {
        return appointmentCount;
    }

    public void displayInfo() {
        System.out.println("  Appointment ID : " + appointmentId);
        System.out.println("  Patient        : " + patient.getName());
        System.out.println("  Doctor         : " + doctor.getName()
                + " [" + doctor.getRole() + "]");
        System.out.println("  Date           : " + date);
        System.out.println("  Notes          : " + notes);
    }
}
