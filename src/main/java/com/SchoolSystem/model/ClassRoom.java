package com.SchoolSystem.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.transaction.annotation.Transactional;

@Entity
@Table(name = "classroom")
public class ClassRoom implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String className;

    @OneToMany(mappedBy = "room")
    private List<Student> students;

    @ManyToMany(targetEntity = Subject.class)
    @JoinTable(name = "course_subject",
            joinColumns = @JoinColumn(name = "class_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private Set<Subject> subjects = new HashSet();

    public ClassRoom() {
        subjects = new HashSet();
        students = new ArrayList<>();
    }

    public ClassRoom(String ClassName, Student... students) {
        this();
        this.className = ClassName;
        this.students.addAll(Arrays.asList(students));
    }

    public ClassRoom(String ClassName) {
        this();
        this.className = ClassName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String ClassName) {

        this.className = ClassName;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "ClassRoom{" + "id=" + id + ", ClassName=" + className + '}';
    }

    
    public void addSubject(Subject SubClass) {
        subjects.add(SubClass);
        
    }

}
