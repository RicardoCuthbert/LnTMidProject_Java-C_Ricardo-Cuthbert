package model;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Employee {
    private String id;
    private String name;
    private String gender;
    private String position;
    private double salary;
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int NUM_DIGITS = 4;
    private static final int NUM_LETTERS = 2;
    private static final Set<String> usedIds = new HashSet<>();
    public Employee(String name, String gender, String position) {
        super();
        this.id = generateId();
        this.name = name;
        this.gender = gender;
        this.position = position;
        setSalaryBasedOnPosition(position);
    }
    
    private String generateId() {
        String newId;
        do {
            newId = generateRandomId();
        } while (usedIds.contains(newId));
        usedIds.add(newId);
        return newId;
    }

    private String generateRandomId() {
        StringBuilder idBuilder = new StringBuilder();
        for (int i = 0; i < NUM_LETTERS; i++) {
            char randomLetter = ALPHABET.charAt(new Random().nextInt(ALPHABET.length()));
            idBuilder.append(randomLetter);
        }
        for (int i = 0; i < NUM_DIGITS; i++) {
            int randomNumber = new Random().nextInt(10);
            idBuilder.append(randomNumber);
        }

        return idBuilder.toString();
    }

    private void setSalaryBasedOnPosition(String position) {
        switch (position.toLowerCase()) {
            case "manager":
                this.salary = 8000000;
                break;
            case "supervisor":
                this.salary = 6000000;
                break;
            case "admin":
                this.salary = 4000000;
                break;
            default:
                System.out.println("Invalid position specified.");
                break;
        }
    }

       public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
        setSalaryBasedOnPosition(position);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
