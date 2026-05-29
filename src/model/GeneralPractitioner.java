package model;

public class GeneralPractitioner extends Doctor {

    private String clinic;

    public GeneralPractitioner(int id, String name, int age,
            int yearsExperience, String clinic) {
        super(id, name, age, "General Practice", yearsExperience);
        this.clinic = clinic;
    }

    public String getClinic() {
        return clinic;
    }


    @Override
    public String getRole() {
        return "General Practitioner";
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("  Clinic         : " + clinic);
    }
}
