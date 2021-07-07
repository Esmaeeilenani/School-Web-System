package com.SchoolSystem.service;

import com.SchoolSystem.model.ClassRoom;
import com.SchoolSystem.model.Student;
import com.SchoolSystem.repository.StudentRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public List<Student> AllStudent() {
        return repository.findAll();
    }

    public void SaveStudent(Student student) {

        repository.save(student);

    }

    public Student getById(long id) {
        return repository.findById(id).orElse(null);
    }

    public void DeleteById(long id) {
        repository.deleteById(id);
    }

    List<Student> AllStudentInClass(long ClassID) {
        return repository.findByRoomId(ClassID);
    }

}
