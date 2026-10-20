package com.jk.midterm;

public class Nurse extends MedicalStaff {
    private final String shiftType;
    private final double shiftAllowance;

    public Nurse(String personId, String name, String phoneNumber,
            String staffId, String department, double monthlySalary,
            String shiftType, double shiftAllowance) {
        super(personId, name, phoneNumber, staffId, department, monthlySalary);

        if (shiftType == null || shiftType.trim().isEmpty()) {
            throw new IllegalArgumentException("Shift type is required.");
        }
        if (shiftAllowance < 0) {
            throw new IllegalArgumentException("Shift allowance cannot be negative.");
        }

        this.shiftType = shiftType;
        this.shiftAllowance = shiftAllowance;
        incrementStaffCount();
    }

    @Override
    public String getRoleDescription() {
        return "Nurse";
    }

    @Override
    public double calculateMonthlyCompensation() {
        return getMonthlySalary() + shiftAllowance;
    }

    @Override
    public void displayStaffDetails() {
        super.displayStaffDetails();
        System.out.println("Shift: " + shiftType);
        System.out.printf("Shift Allowance: $%.2f%n", shiftAllowance);
    }

    public String getShiftType() {
        return shiftType;
    }

    public double getShiftAllowance() {
        return shiftAllowance;
    }
}