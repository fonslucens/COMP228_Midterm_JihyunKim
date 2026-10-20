package com.jk.midterm;

public class Doctor extends MedicalStaff {
    private final double consultationFee;
    private int patientsSeen;

    public Doctor(String personId, String name, String phoneNumber,
            String staffId, String department, double monthlySalary,
            double consultationFee, int patientsSeen) {
        this(personId, name, phoneNumber, staffId, department,
                monthlySalary, consultationFee, patientsSeen, true);
    }

    protected Doctor(String personId, String name, String phoneNumber,
            String staffId, String department, double monthlySalary,
            double consultationFee, int patientsSeen, boolean countNow) {
        super(personId, name, phoneNumber, staffId, department, monthlySalary);

        if (consultationFee < 0) {
            throw new IllegalArgumentException("Consultation fee cannot be negative.");
        }
        if (patientsSeen < 0) {
            throw new IllegalArgumentException("Patients seen cannot be negative.");
        }

        this.consultationFee = consultationFee;
        this.patientsSeen = patientsSeen;

        if (countNow) {
            incrementStaffCount();
        }
    }

    @Override
    public String getRoleDescription() {
        return "Doctor";
    }

    @Override
    public double calculateMonthlyCompensation() {
        double performanceAllowance = patientsSeen * 10.0;
        return getMonthlySalary() + performanceAllowance;
    }

    public double calculateConsultationFee() {
        return consultationFee;
    }

    public double calculateConsultationFee(double discount) {
        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException("Discount must be between 0 and 100.");
        }
        return calculateConsultationFee() * (1 - discount / 100.0);
    }

    public double calculateConsultationFee(double discount, double additionalCharge) {
        if (additionalCharge < 0) {
            throw new IllegalArgumentException("Additional charge cannot be negative.");
        }
        return calculateConsultationFee(discount) + additionalCharge;
    }

    @Override
    public void displayStaffDetails() {
        super.displayStaffDetails();
        System.out.println("Patients Seen: " + patientsSeen);
        System.out.printf("Consultation Fee: $%.2f%n", calculateConsultationFee());
    }

    public double getConsultationFee() {
        return consultationFee;
    }

    public int getPatientsSeen() {
        return patientsSeen;
    }
}