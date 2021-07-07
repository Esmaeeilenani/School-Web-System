package com.SchoolSystem.model;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student implements Serializable {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private LocalDate dob;
    private String email;

    @ManyToOne()
    @JoinColumn(name = "class_id" , referencedColumnName = "id")
    private ClassRoom room;

    public Student() {
        this.name = null;
        this.dob = null;
        this.email = null;
        this.room = null;
    }

    public Student(String name, LocalDate dob, String email, ClassRoom room) {
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.room = room;
    }

    public Student(String name, LocalDate dob, String email) {
        this.name = name;
        this.dob = dob;
        this.email = email;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ClassRoom getRoom() {
        return room;
    }

    public void setRoom(ClassRoom room) {
        this.room = room;
    }

    public boolean ValidateAttr() {

        return (!name.trim().isEmpty() && !email.trim().isEmpty() && room != null && !room.getClassName().isEmpty());

    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", dob=" + dob + ", email=" + email + " Class Room " + room.getClassName() + '}';
    }

}
