package model;


public class Doctor extends Person {


    protected String specialization;
    private int yearsExperience;


    public Doctor(int id, String name, int age,
            String specialization, int yearsExperience) {
        super(id, name, age);
        this.specialization = specialization;
        this.yearsExperience = yearsExperience;
    }

    // V2 - Getters
    public String getSpecialization() {
        return specialization;
    }

    public int getYearsExperience() {
        return yearsExperience;
    }


    @Override
    public String getRole() {
        return "Doctor";
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("  Specialization : " + specialization);
        System.out.println("  Experience     : " + yearsExperience + " years");
    }
}
