package service;

import java.util.ArrayList;
import model.*;


public class Hospital {

    private String hospitalName;
    private ArrayList<Patient> patients;
    private ArrayList<Doctor> doctors;
    private ArrayList<Appointment> appointments;

    public Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
        this.patients = new ArrayList<>();
        this.doctors = new ArrayList<>();
        this.appointments = new ArrayList<>();
    }


    public void addPatient(Patient p) {
        patients.add(p);
        System.out.println("  ✔ Patient registered: " + p.getName());
    }

    public void addDoctor(Doctor d) {
        doctors.add(d);
        System.out.println("  ✔ Doctor added: " + d.getName()
                + " [" + d.getRole() + "]");
    }


    public Patient findPatient(String name) {
        for (Patient p : patients) {
            if (p.getName().equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }


    public Patient findPatient(int id) {
        for (Patient p : patients) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }


    public Doctor findDoctor(String name) {
        for (Doctor d : doctors) {
            if (d.getName().equalsIgnoreCase(name)) {
                return d;
            }
        }
        return null;
    }


    public Doctor findDoctor(int id) {
        for (Doctor d : doctors) {
            if (d.getId() == id) {
                return d;
            }
        }
        return null;
    }

    
    public void bookAppointment(int patientId, int doctorId, String date) {
        Patient p = findPatient(patientId);
        Doctor d = findDoctor(doctorId);

        if (p == null) {
            System.out.println("  ✘ Patient ID " + patientId + " not found.");
            return;
        }
        if (d == null) {
            System.out.println("  ✘ Doctor ID " + doctorId + " not found.");
            return;
        }

        p.setDoctorAssigned(d.getName());
        Appointment a = new Appointment(p, d, date);
        appointments.add(a);
        System.out.println("  ✔ Appointment booked! ID: "
                + a.getAppointmentId());
    }


    public void showAllPatients() {
        if (patients.isEmpty()) {
            System.out.println("  No patients registered yet.");
            return;
        }
        System.out.println("\n  ── Registered Patients ──");
        for (Patient p : patients) {
            System.out.println();
            p.displayInfo();
        }
    }

    
    public void showAllStaff() {
        if (doctors.isEmpty()) {
            System.out.println("  No doctors added yet.");
            return;
        }
        System.out.println("\n  ── Medical Staff ──");
        for (Doctor d : doctors) {
            Person staff = d;
            System.out.println();
            staff.displayInfo();
        }
    }

    public void showAllAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("  No appointments booked yet.");
            return;
        }
        System.out.println("\n  ── Appointments ──");
        System.out.println("  Total booked: "
                + Appointment.getTotalAppointments());
        for (Appointment a : appointments) {
            System.out.println();
            a.displayInfo();
        }
    }

    public String getHospitalName() {
        return hospitalName;
    }
}
