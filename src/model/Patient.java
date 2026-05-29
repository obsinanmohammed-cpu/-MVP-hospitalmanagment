package model;


public class Patient extends Person {


    private String illness;
    private String doctorAssigned;


    public Patient(int id, String name, int age, String illness) {
        super(id, name, age);  // V3 - super() call
        this.illness = illness;
        this.doctorAssigned = "Not assigned";
    }


    public String getIllness() {
        return illness;
    }

    public String getDoctorAssigned() {
        return doctorAssigned;
    }

    public void setDoctorAssigned(String doctorName) {
        this.doctorAssigned = doctorName;
    }


    @Override
    public String getRole() {
        return "Patient";
    }


    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("  Illness : " + illness);
        System.out.println("  Doctor  : " + doctorAssigned);
    }
}
