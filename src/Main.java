
import model.*;
import service.Hospital;
import util.InputHelper;
public class Main {
public static void main(String[] args) {
Hospital hospital = new Hospital("BITS General Hospital");
seedData(hospital);

System.out.println("\n========== Welcome to ===========--");
System.out.println("   " + hospital.getHospitalName() + "   ");
System.out.println("\n==================================");

boolean running = true;
    while (running) {
    printMenu();
        int choice = InputHelper.readInt("  Enter choice: ");

    switch (choice) {
        case 1 ->
            registerPatient(hospital);
                case 2 ->
                    addDoctor(hospital);
        case 3 ->
            bookAppointment(hospital);
                case 4 ->
                    hospital.showAllPatients();
        case 5 ->
            hospital.showAllStaff();
                case 6 ->
                    hospital.showAllAppointments();
        case 7 ->
            searchPatient(hospital);
                case 0 -> {
                    System.out.println("\n  Goodbye!\n");
                    running = false;
                }
                default ->
                    System.out.println("  Invalid option.");
            }
        }

        InputHelper.close();
    }


    static void printMenu() {
        System.out.println("\n┌──────────────----------------------");
        System.out.println("|           MAIN MENU                 │");
        System.out.println("├─────────────────────────────────────┤");
        System.out.println("│  1. Register patient                │");
        System.out.println("│  2. Add doctor / surgeon / GP       │");
        System.out.println("│  3. Book appointment                │");
        System.out.println("│  4. Show all patients               │");
        System.out.println("│  5. Show all staff                  │");
        System.out.println("│  6. Show all appointments           │");
        System.out.println("│  7. Search patient                  │");
        System.out.println("│  0. Exit                            │");
        System.out.println("└─────────────────────────────────────┘");
    }


    static void registerPatient(Hospital h) {
        System.out.println("\n  -- Register Patient --");
        int id = InputHelper.readInt("  Enter ID     : ");
        String name = InputHelper.readString("  Enter Name   : ");
        int age = InputHelper.readInt("  Enter Age    : ");
        String illness = InputHelper.readString("  Enter Illness: ");
        h.addPatient(new Patient(id, name, age, illness));
    }

    static void addDoctor(Hospital h) {
        System.out.println("\n  -- Add Doctor --");
        System.out.println("  Type: 1=General Doctor  2=Surgeon  3=GP");
        int type = InputHelper.readInt("  Choose type: ");

        int id = InputHelper.readInt("  Enter ID          : ");
        String name = InputHelper.readString("  Enter Name        : ");
        int age = InputHelper.readInt("  Enter Age         : ");
        int exp = InputHelper.readInt("  Years Experience  : ");

        switch (type) {
            case 1 -> {
                String spec = InputHelper.readString("  Specialization: ");
                h.addDoctor(new Doctor(id, name, age, spec, exp));
            }
            case 2 -> {
                String stype = InputHelper.readString("  Surgery type  : ");
                h.addDoctor(new Surgeon(id, name, age, exp, stype));
            }
            case 3 -> {
                String clinic = InputHelper.readString("  Clinic name   : ");
                h.addDoctor(new GeneralPractitioner(id, name, age, exp, clinic));
            }
            default ->
                System.out.println("  Invalid type.");
        }
    }

    static void bookAppointment(Hospital h) {
        System.out.println("\n  -- Book Appointment --");
        int pid = InputHelper.readInt("  Patient ID : ");
        int did = InputHelper.readInt("  Doctor  ID : ");
        String date = InputHelper.readString("  Date (e.g. 2025-06-15): ");
        h.bookAppointment(pid, did, date);
    }

    static void searchPatient(Hospital h) {
        System.out.println("\n  Search by: 1=Name  2=ID");
        int opt = InputHelper.readInt("  Choose: ");
        if (opt == 1) {
            String name = InputHelper.readString("  Enter name: ");
            Patient p = h.findPatient(name);
            if (p != null) {
                System.out.println();
                p.displayInfo();
            } else {
                System.out.println("  Not found.");
            }
        } else {
            int id = InputHelper.readInt("  Enter ID: ");
            Patient p = h.findPatient(id);
            if (p != null) {
                System.out.println();
                p.displayInfo();
            } else {
                System.out.println("  Not found.");
            }
        }
    }

    
    static void seedData(Hospital h) {
        h.addPatient(new Patient(1, "umar", 23, "Malaria"));
        h.addPatient(new Patient(2, "Roba", 25, "Diabetes"));

        h.addDoctor(new Surgeon(10, "Dr.Obsinan", 20, 2, "hair transplant"));
        h.addDoctor(new GeneralPractitioner(11, "Dr.yani", 28, 1, "Ajora Clinic"));

        h.bookAppointment(1, 10, "2025-06-10");
        h.bookAppointment(2, 11, "2025-06-11");
    }
}
