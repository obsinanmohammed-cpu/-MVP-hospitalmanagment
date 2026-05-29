package model;


public class Surgeon extends Doctor {

    private String surgeryType;


    public Surgeon(int id, String name, int age,
            int yearsExperience, String surgeryType) {
        super(id, name, age, "Surgery", yearsExperience);
        this.surgeryType = surgeryType;
    }

    public String getSurgeryType() {
        return surgeryType;
    }

    
    @Override
    public String getRole() {
        return "Surgeon (" + surgeryType + ")";
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("  Surgery Type   : " + surgeryType);
    }
}
