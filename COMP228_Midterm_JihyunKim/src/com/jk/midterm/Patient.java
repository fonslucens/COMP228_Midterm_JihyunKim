package com.jk.midterm;

// Single inheritance: Patient is a Person.
public class Patient extends Person {
    private final String patientNumber;
    private int age;
    private String medicalDepartment;
    private double consultationFee;
    private static int patientCount = 0;

    public Patient(String personId, String name, String phoneNumber,
            String patientNumber, int age, String medicalDepartment,
            double consultationFee) {
        super(personId, name, phoneNumber);

        if (patientNumber == null || patientNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Patient number is required.");
        }
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException("Age must be between 0 and 150.");
        }
        if (medicalDepartment == null || medicalDepartment.trim().isEmpty()) {
            throw new IllegalArgumentException("Department is required.");
        }
        if (consultationFee < 0) {
            throw new IllegalArgumentException("Consultation fee cannot be negative.");
        }

        this.patientNumber = patientNumber;
        this.age = age;
        this.medicalDepartment = medicalDepartment;
        this.consultationFee = consultationFee;

        // Construction with complete, valid details is the first registration.
        patientCount++;
        incrementPersonCount();
    }

    public static int getPatientCount() {
        return patientCount;
    }

    public boolean registerPatient(String name, int age) {
        return registerPatient(name, age, "General Medicine");
    }

    public boolean registerPatient(String name, int age, String department) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Registration Status: Failed - name is required.");
            return false;
        }
        if (age < 0 || age > 150) {
            System.out.println("Registration Status: Failed - age must be 0 to 150.");
            return false;
        }
        if (department == null || department.trim().isEmpty()) {
            System.out.println("Registration Status: Failed - department is required.");
            return false;
        }

        setName(name);
        this.age = age;
        this.medicalDepartment = department;
        // These methods update the same registered patient, not a new person.
        System.out.println("Registration Status: Successful");
        return true;
    }

    @Override
    public String getRoleDescription() {
        return "Patient";
    }

    public void displayPatientDetails() {
        displayBasicDetails();
        System.out.println("Patient Number: " + patientNumber);
        System.out.println("Role: " + getRoleDescription());
        System.out.println("Age: " + age);
        System.out.println("Department: " + medicalDepartment);
        System.out.printf("Consultation Fee: $%.2f%n", consultationFee);
    }

    public String getPatientNumber() {
        return patientNumber;
    }

    public int getAge() {
        return age;
    }

    public String getMedicalDepartment() {
        return medicalDepartment;
    }

    public double getConsultationFee() {
        return consultationFee;
    }
}