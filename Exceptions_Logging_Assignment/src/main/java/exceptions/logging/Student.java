package exceptions.logging;

import exceptions.logging.Exceptions.InvalidNameException;
import exceptions.logging.Exceptions.InvalidDateOfBirthException;
import exceptions.logging.Exceptions.InvalidGenderException;
import exceptions.logging.Exceptions.CNPException;

import java.time.LocalDate;
import java.time.Period;

public class Student {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String gender;
    private String CNP;
    public Student(String firstName, String lastName, LocalDate dateOfBirth, String gender, String CNP) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.CNP = CNP;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public int getAge() {
        return Period.between(this.dateOfBirth, LocalDate.now()).getYears();
    }

    public String getGender() {
        return gender;
    }

    public String getCNP() {
        return CNP;
    }

    public void setFirstName(String firstName) throws InvalidNameException {
        if(firstName == null || firstName.trim().isEmpty()){
            throw new InvalidNameException("Invalid first name");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) throws InvalidNameException{
        if(lastName == null || lastName.trim().isEmpty()){
            throw new InvalidNameException("Invalid last name");
        }
        this.lastName = lastName;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) throws InvalidDateOfBirthException {
        LocalDate today=LocalDate.now();
        if(dateOfBirth.isBefore(LocalDate.of(1900,1,1))||dateOfBirth.isAfter(today.minusYears(18)))
        {
            throw new InvalidDateOfBirthException("Invalid date of birth");
        }
        this.dateOfBirth=dateOfBirth;
    }

    public void setGender(String gender) throws InvalidGenderException {
        if(gender==null||(!gender.equalsIgnoreCase("m"))||(!gender.equalsIgnoreCase("f")))
        {
            throw new InvalidGenderException("Invalid gender");
        }
        this.gender = gender;
    }

    public void setCNP(String CNP) throws CNPException {
        if(CNP == null || CNP.trim().isEmpty()||CNP.length()!=11)
        {
            throw new CNPException("Invalid CNP");
        }
        this.CNP = CNP;
    }
    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender='" + gender + '\'' +
                ", CNP='" + CNP + '\'' +
                '}';
    }
}
