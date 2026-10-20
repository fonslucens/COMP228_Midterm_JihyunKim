package com.jk.midterm;

public class SpecialistDoctor extends Doctor implements Reportable, Schedulable {
    private final String specialization;
    private final double specialistSurcharge;
    private String appointmentDate;

    public SpecialistDoctor(String personId, String name, String phoneNumber,
            String staffId, String department, double monthlySalary,
            double consultationFee, int patientsSeen,
            String specialization, double specialistSurcharge) {
        super(personId, name, phoneNumber, staffId, department,
                monthlySalary, consultationFee, patientsSeen, false);

        if (specialization == null || specialization.trim().isEmpty()) {
            throw new IllegalArgumentException("Specialization is required.");
        }
        if (specialistSurcharge < 0) {
            throw new IllegalArgumentException("Specialist surcharge cannot be negative.");
        }

        this.specialization = specialization;
        this.specialistSurcharge = specialistSurcharge;
        incrementStaffCount();
    }

    @Override
    public String getRoleDescription() {
        return "Specialist Doctor";
    }

    @Override
    public double calculateConsultationFee() {
        return super.calculateConsultationFee() + specialistSurcharge;
    }

    @Override
    public void displayStaffDetails() {
        super.displayStaffDetails();
        System.out.println("Specialization: " + specialization);
        System.out.printf("Specialist Surcharge: $%.2f%n", specialistSurcharge);
    }

    @Override
    public void generateReport() {
        System.out.println("[SPECIALIST REPORT]");
        displayStaffDetails();
        System.out.printf("Monthly Compensation: $%.2f%n",
                calculateMonthlyCompensation());
    }

    @Override
    public void scheduleAppointment(String appointmentDate) {
        if (appointmentDate == null || appointmentDate.trim().isEmpty()) {
            System.out.println("Appointment Status: Failed - date is required.");
            return;
        }

        this.appointmentDate = appointmentDate;
        System.out.println("Appointment Status: Confirmed with " + getName()
                + " on " + this.appointmentDate);
    }

    public String getSpecialization() {
        return specialization;
    }

    public double getSpecialistSurcharge() {
        return specialistSurcharge;
    }
}
