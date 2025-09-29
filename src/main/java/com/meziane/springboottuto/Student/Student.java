package com.meziane.springboottuto.Student;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
@Entity
@Table
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1

    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
            )
    private int id;
    private String name;
    private String email;
    private LocalDate DOB;
    @Transient
    private int age ;


    public Student(int id, String name, String email, LocalDate DOB) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.DOB = DOB;

    }
    public Student(String name, String email, LocalDate DOB) {

        this.name = name;
        this.email = email;
        this.DOB = DOB;
        this.age=calculateAge(this.DOB);
    }
    public Student() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    public int getAge() {
        return calculateAge(this.DOB);
    }

    public void setAge(int age) {
        this.age = age;
    }

    private int calculateAge(LocalDate dob) {
        if (dob == null) {
            throw new IllegalArgumentException("Date of birth cannot be null");
        }

        LocalDate today = LocalDate.now();

        // Calculate age in years
        return (int) ChronoUnit.YEARS.between(dob, today);
    }

}
