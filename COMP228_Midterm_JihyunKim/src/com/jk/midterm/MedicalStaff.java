package com.jk.midterm;

public abstract class MedicalStaff extends Person {
    private final String staffId;
    private String department;
    private double monthlySalary;
    private static int staffCount = 0;

    public MedicalStaff(String personId, String name, String phoneNumber,
            String staffId, String department, double monthlySalary) {
        super(personId, name, phoneNumber);

        if (staffId == null || staffId.trim().isEmpty()) {
            throw new IllegalArgumentException("Staff ID is required.");
        }
        if (department == null || department.trim().isEmpty()) {
            throw new IllegalArgumentException("Department is required.");
        }
        if (monthlySalary < 0) {
            throw new IllegalArgumentException("Monthly salary cannot be negative.");
        }

        this.staffId = staffId;
        this.department = department;
        this.monthlySalary = monthlySalary;
    }

    public static int getStaffCount() {
        return staffCount;
    }

    protected static void incrementStaffCount() {
        staffCount++;
        incrementPersonCount();
    }

    public abstract double calculateMonthlyCompensation();

    public void displayStaffDetails() {
        displayBasicDetails();
        System.out.println("Staff ID: " + staffId);
        System.out.println("Role: " + getRoleDescription());
        System.out.println("Department: " + department);
        System.out.printf("Monthly Salary: $%.2f%n", monthlySalary);
    }

    @Override
    public String getRoleDescription() {
        return "Medical Staff";
    }

    public String getStaffId() {
        return staffId;
    }

    public String getDepartment() {
        return department;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }
}