package com.jk.midterm;

public class Main {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("       CAREPOINT HOSPITAL");
        System.out.println("       MANAGEMENT SYSTEM");
        System.out.println("========================================");

        System.out.println("\nPATIENT REGISTRATION");
        Patient patient1 = new Patient("PER101", "Priya Sharma", "416-555-0101",
                "P1001", 35, "Cardiology", 150.00);
        if (patient1.registerPatient("Priya Sharma", 35, "Cardiology")) {
            patient1.displayPatientDetails();
        }

        System.out.println();
        Patient patient2 = new Patient("PER102", "Daniel Brown", "416-555-0102",
                "P1002", 42, "General Medicine", 150.00);
        if (patient2.registerPatient("Daniel Brown", 42)) {
            patient2.displayPatientDetails();
        }

        MedicalStaff staff1 = new Doctor("PER201", "Dr. Amit Kumar", "416-555-0201",
                "D2001", "Cardiology", 9000.00, 150.00, 100);
        MedicalStaff staff2 = new SpecialistDoctor(
                "PER202", "Dr. Neha Patel", "416-555-0202",
                "D2002", "Neurology", 11000.00, 150.00, 80,
                "Neurology", 50.00);
        MedicalStaff staff3 = new Nurse("PER301", "Sarah Wilson", "416-555-0301",
                "N3001", "Emergency", 5000.00, "Night", 500.00);

        MedicalStaff[] staffList = {staff1, staff2, staff3};
        System.out.println("\nMEDICAL STAFF DETAILS (RUNTIME POLYMORPHISM)");
        for (MedicalStaff staff : staffList) {
            System.out.println();
            staff.displayStaffDetails();
            System.out.printf("Monthly Compensation: $%.2f%n",
                    staff.calculateMonthlyCompensation());
        }

        Doctor generalDoc = (Doctor) staff1;
        SpecialistDoctor specialistDoc = (SpecialistDoctor) staff2;

        System.out.println("\nCONSULTATION FEE CALCULATIONS");
        System.out.printf("Standard Consultation Fee: $%.2f%n",
                generalDoc.calculateConsultationFee());
        System.out.printf("Consultation Fee After 10%% Discount: $%.2f%n",
                generalDoc.calculateConsultationFee(10.00));
        System.out.printf("10%% Discount plus $40.00 Additional Charge: $%.2f%n",
                generalDoc.calculateConsultationFee(10.00, 40.00));
        System.out.printf("Specialist Consultation Fee: $%.2f%n",
                specialistDoc.calculateConsultationFee());
        System.out.printf("Specialist Fee After 10%% Discount: $%.2f%n",
                specialistDoc.calculateConsultationFee(10.00));

        System.out.println("\nINTERFACE DEMONSTRATION");
        Reportable reportableStaff = specialistDoc;
        Schedulable schedulableStaff = specialistDoc;
        reportableStaff.generateReport();
        schedulableStaff.scheduleAppointment("2026-10-25 10:30 AM");
        schedulableStaff.scheduleAppointment("");

        System.out.println("\nVALIDATION TESTS");
        System.out.println("Invalid updates to the existing patient:");
        patient1.registerPatient("Priya Sharma", -5, "Cardiology");
        patient1.registerPatient("", 30, "Cardiology");
        System.out.println("Patient kept: " + patient1.getName()
                + ", age " + patient1.getAge()
                + ", " + patient1.getMedicalDepartment());

        System.out.println("Counts before failed creations: "
                + Person.getPersonCount() + " people, "
                + Patient.getPatientCount() + " patients, "
                + MedicalStaff.getStaffCount() + " staff");

        try {
            new Patient("PER103", "Test Patient", "416-555-0103",
                    "P1003", 151, "Cardiology", 150.00);
        } catch (IllegalArgumentException e) {
            System.out.println("Patient Creation Failed: " + e.getMessage());
        }

        try {
            new Patient("PER104", "Test Patient", "   ",
                    "P1004", 30, "Cardiology", 150.00);
        } catch (IllegalArgumentException e) {
            System.out.println("Patient Creation Failed: " + e.getMessage());
        }

        try {
            new Doctor("PER203", "Test Doctor", "416-555-0203",
                    "D2003", "Cardiology", 9000.00, -1.00, 100);
        } catch (IllegalArgumentException e) {
            System.out.println("Doctor Creation Failed: " + e.getMessage());
        }

        try {
            new SpecialistDoctor("PER204", "Test Specialist", "416-555-0204",
                    "D2004", "Neurology", 11000.00, 150.00, 80,
                    "Neurology", -50.00);
        } catch (IllegalArgumentException e) {
            System.out.println("Specialist Creation Failed: " + e.getMessage());
        }

        try {
            new Nurse("PER302", "Test Nurse", "416-555-0302",
                    "N3002", "Emergency", 5000.00, "Night", -100.00);
        } catch (IllegalArgumentException e) {
            System.out.println("Nurse Creation Failed: " + e.getMessage());
        }

        try {
            generalDoc.calculateConsultationFee(110.00);
        } catch (IllegalArgumentException e) {
            System.out.println("Fee Calculation Failed: " + e.getMessage());
        }

        try {
            generalDoc.calculateConsultationFee(10.00, -5.00);
        } catch (IllegalArgumentException e) {
            System.out.println("Fee Calculation Failed: " + e.getMessage());
        }

        System.out.println("\nREGISTRATION SUMMARY");
        System.out.println("Total People: " + Person.getPersonCount());
        System.out.println("Total Patients: " + Patient.getPatientCount());
        System.out.println("Total Medical Staff: " + MedicalStaff.getStaffCount());
        System.out.println("========================================");
        System.out.println("            END OF REPORT");
        System.out.println("========================================");
    }
}
