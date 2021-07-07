package com.SchoolSystem.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.lang.Nullable;

@Entity
@Table(name = "subject")
public class Subject implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @ManyToMany(targetEntity = ClassRoom.class, mappedBy = "subjects")
    private Set<ClassRoom> rooms = new HashSet<>();

    @ManyToOne(targetEntity = Teacher.class,cascade = {CascadeType.DETACH,CascadeType.REMOVE})
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private Teacher teacher;

    public Subject() {
        teacher = new Teacher();
        rooms = new HashSet();
    }

    public Subject(String name, ClassRoom room, Teacher teacher) {
        this();
        this.name = name;
        this.rooms.add(room);
        this.teacher = teacher;
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

    public Set<ClassRoom> getRooms() {
        return rooms;
    }

    public void setRooms(Set<ClassRoom> rooms) {
        this.rooms = rooms;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teachers) {
        this.teacher = teachers;
    }

    public String getTeacherName() {
        return (teacher != null) ? teacher.getName() : "Not Assign";
    }

    public String getClassRoomsNames() {

        return rooms.stream().map(room -> room.getClassName() + " ").collect(Collectors.toList()).toString();
    }

    @Override
    public String toString() {
        return "Subject{" + "id=" + id + ", name=" + name + " " + getTeacherName() + " "+getClassRoomsNames();
    }

    public void addClassRoom(ClassRoom classRoom) {
        rooms.add(classRoom);
    }

    public String getRoomsNames() {
        return rooms.stream().map(room -> room.getClassName() + " ").collect(Collectors.toList()).toString();
    }

}
