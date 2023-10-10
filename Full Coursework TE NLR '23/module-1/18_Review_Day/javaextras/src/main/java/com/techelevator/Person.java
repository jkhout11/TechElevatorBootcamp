package com.techelevator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Person {

    public static final String BIRTHDATE_FORMAT = "MM/dd/yyyy";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(BIRTHDATE_FORMAT);

    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String ssn;

    public Person(String firstName, String lastName, LocalDate birthDate, String ssn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.ssn = ssn;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }


//
//    @Override
//    public boolean equals(Object o) {
//        // if the memory locations are the same return true
//        if (this == o) {
//            return true;
//        }
//
//        // if the object being compared is null or is a different class type, return false
//        if (o == null || getClass() != o.getClass()) {
//            return false;
//        }
//
//        // cast the Object to a Person
//        Person person = (Person) o;
//
//        // compare the values that you want to take into account for equality
//        return Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName)
//                && Objects.equals(birthDate, person.birthDate) && Objects.equals(ssn, person.ssn);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(firstName, lastName, birthDate, ssn);
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(birthDate, person.birthDate) && Objects.equals(ssn, person.ssn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, birthDate, ssn);
    }



    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", ssn='" + ssn + '\'' +
                '}';
    }

    //    @Override
//    public String toString() {
//        return "Person{" +
//                "firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", birthDate=" + DateAndTimeUtils.getLocalDateAsString(birthDate, DateAndTimeUtils.BIRTHDATE_FORMAT) +
//                ", ssn='" + ssn + '\'' +
//                '}';
//    }
}
