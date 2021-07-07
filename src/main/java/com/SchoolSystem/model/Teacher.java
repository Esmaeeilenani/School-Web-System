package com.SchoolSystem.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import javax.persistence.Table;

@Entity
@Table(name = "teacher")
public class Teacher implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private LocalDate dob;
    private LocalDate joiningDate;

    @OneToMany(mappedBy = "teacher")
    private List<Subject> subjects;

    public Teacher() {
        subjects = new ArrayList<>();
    }

    public Teacher(String name, LocalDate dob, LocalDate JoiningDate, Subject... subjects) {
        this();
        this.name = name;
        this.dob = dob;
        this.joiningDate = JoiningDate;
        this.subjects.addAll(Arrays.asList(subjects));
    }

    public Teacher(String name, LocalDate dob, LocalDate JoiningDate) {
        this();
        this.name = name;
        this.dob = dob;
        this.joiningDate = JoiningDate;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public void AddSubject(Subject subject) {
        subjects.add(subject);
        subject.setTeacher(this);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean ValidateAttr() {

        return (!name.trim().isEmpty() && !email.trim().isEmpty());

    }

    @Override
    public String toString() {
        return "Teacher{" + "id=" + id + ", name=" + name + ", email=" + email + ", dob=" + dob + ", joiningDate=" + joiningDate + '}';
    }

}
