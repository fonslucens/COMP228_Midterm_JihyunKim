package com.jk.midterm;

public abstract class Person {
    private final String personId;
    private String name;
    private String phoneNumber;
    private static int personCount = 0;

    public Person(String personId, String name, String phoneNumber) {
        if (personId == null || personId.trim().isEmpty()) {
            throw new IllegalArgumentException("Person ID is required.");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name is required.");
        }
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Phone number is required.");
        }

        this.personId = personId;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public static int getPersonCount() {
        return personCount;
    }

    // Called only after a concrete object's validation and initialization succeed.
    protected static void incrementPersonCount() {
        personCount++;
    }

    public String getPersonId() {
        return personId;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    protected void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name is required.");
        }
        this.name = name;
    }

    public void displayBasicDetails() {
        System.out.println(toString());
    }

    public abstract String getRoleDescription();

    @Override
    public String toString() {
        return "Person ID: " + personId
                + "\nName: " + name
                + "\nPhone Number: " + phoneNumber;
    }
}
