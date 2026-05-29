package model;


public abstract class Person {

    private int id;
    private String name;
    private int age;

public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
    }


    public abstract String getRole();


    public void displayInfo() {
        System.out.println("  ID   : " + id);
        System.out.println("  Name : " + name);
        System.out.println("  Age  : " + age);
        System.out.println("  Role : " + getRole());
    }
}
