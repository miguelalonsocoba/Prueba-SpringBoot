package com.mac.management_of_employees.domain.entity;

import jakarta.persistence.*;

import java.util.Date;

/**
 * Represents an employee in a system.
 * This entity corresponds to the "employees" table in the database.
 */
@Entity
@Table(name = "employees")
public class Employee {

    /**
     * Represents the unique identifier for the Employee entity.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;


    /**
     * Represents the first name of an employee.
     */
    @Column(name = "first_name", length = 40, nullable = false)
    private String firstName;

    /**
     * Represents the second name of the employee.
     */
    @Column(name = "second_name", length = 40)
    private String secondName;

    /**
     * Represents the first surname of an employee.
     */
    @Column(name = "first_surname", length = 40, nullable = false)
    private String firstSurname;

    /**
     * Represents the second surname of an employee.
     */
    @Column(name = "second_surname", length = 40, nullable = false)
    private String secondSurname;

    /**
     * Represents the age of the Employee.
     */
    @Column(name = "age", nullable = false)
    private Integer age;

    /**
     * Represents the gender of the Employee.
     */
    @Column(name = "gender", length = 1, nullable = false)
    private String gender;

    /**
     * Represents the date of birth of the Employee.
     */
    @Column(name = "date_of_birth", nullable = false)
    private Date dateOfBirth;

    /**
     * Represents the position of the Employee.
     */
    @Column(name = "position", length = 200, nullable = false)
    private String position;

    /**
     * Default constructor for the Employee class.
     */
    public Employee() {
    }

    /**
     * Constructor for creating an Employee object with specified attributes.
     *
     * @param id The unique identifier for the employee.
     * @param firstName The first name of the employee.
     * @param secondName The second name of the employee.
     * @param firstSurname The first surname of the employee.
     * @param secondSurname The second surname of the employee.
     * @param age The age of the employee.
     * @param gender The gender of the employee.
     * @param dateOfBirth The date of birth of the employee.
     * @param position The position or role of the employee within the organization.
     */
    public Employee(Integer id, String firstName, String secondName, String firstSurname, String secondSurname, Integer age, String gender, Date dateOfBirth, String position) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.firstSurname = firstSurname;
        this.secondSurname = secondSurname;
        this.age = age;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.position = position;
    }

    /**
     * Retrieves the unique identifier of the employee.
     *
     * @return the unique identifier of the employee as an Integer.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the unique identifier for the employee.
     *
     * @param id The unique identifier to be assigned to the employee.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Retrieves the first name of the employee.
     *
     * @return the first name of the employee as a String.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the employee.
     *
     * @param firstName The first name to assign to the employee.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Retrieves the second name of the employee.
     *
     * @return the second name of the employee as a String.
     */
    public String getSecondName() {
        return secondName;
    }

    /**
     * Sets the second name of the employee.
     *
     * @param secondName The second name to assign to the employee.
     */
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    /**
     * Retrieves the first surname of the employee.
     *
     * @return the first surname of the employee as a String.
     */
    public String getFirstSurname() {
        return firstSurname;
    }

    /**
     * Sets the first surname of the employee.
     *
     * @param firstSurname The first surname to assign to the employee.
     */
    public void setFirstSurname(String firstSurname) {
        this.firstSurname = firstSurname;
    }

    /**
     * Retrieves the second surname of the employee.
     *
     * @return the second surname of the employee as a String.
     */
    public String getSecondSurname() {
        return secondSurname;
    }

    /**
     * Sets the second surname of the employee.
     *
     * @param secondSurname The second surname to assign to the employee.
     */
    public void setSecondSurname(String secondSurname) {
        this.secondSurname = secondSurname;
    }

    /**
     * Retrieves the age of the employee.
     *
     * @return the age of the employee as an Integer.
     */
    public Integer getAge() {
        return age;
    }

    /**
     * Sets the age of the employee.
     *
     * @param age The age to assign to the employee, represented as an Integer.
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * Retrieves the gender of the employee.
     *
     * @return the gender of the employee as a String.
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets the gender of the employee.
     *
     * @param gender The gender to assign to the employee, represented as a String.
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Retrieves the date of birth of the employee.
     *
     * @return the date of birth of the employee as a Date object.
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the date of birth for the employee.
     *
     * @param dateOfBirth The date of birth to assign to the employee, represented as a Date object.
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Retrieves the position or role of the employee within the organization.
     *
     * @return the position of the employee as a String.
     */
    public String getPosition() {
        return position;
    }

    /**
     * Sets the position or role of the employee within the organization.
     *
     * @param position The position to assign to the employee, represented as a String.
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * Returns a string representation of the Employee object.
     *
     * @return a string representation of the Employee object.
     */
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", firstSurname='" + firstSurname + '\'' +
                ", secondSurname='" + secondSurname + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", position='" + position + '\'' +
                '}';
    }
}
