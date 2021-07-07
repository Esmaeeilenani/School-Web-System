package com.SchoolSystem.service;

import com.SchoolSystem.model.ClassRoom;
import com.SchoolSystem.model.Student;
import com.SchoolSystem.model.Subject;
import com.SchoolSystem.repository.ClassRoomRepository;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClassRoomService {

    @Autowired
    private ClassRoomRepository roomRepository;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private StudentService studentService;

    public List<ClassRoom> listAll() {
        return roomRepository.findAll();
    }

    public ClassRoom findById(long id) {
        return roomRepository.findById(id).orElse(null);
    }

    public ClassRoom findByClassName(String name) {
        return roomRepository.findByClassName(name);
    }

    public Set<Subject> AllSubjectInClass(long ClassID) {
        return subjectService.AllSubjectInClass(ClassID);
    }

    public List<Student> AllStudentInClass(long ClassID) {
        return studentService.AllStudentInClass(ClassID);
    }

    public List<Subject> SubjectsNotInClass(long ClassID) {
        return subjectService.AllSubjectsNotInClass(ClassID);
    }

    //all the classes that teach this subject
    public List<ClassRoom> AllSubjectClasses(long SubjectID) {
        return roomRepository.findBySubjectsId(SubjectID);
    }

    public void SaveClassRoom(ClassRoom classRoom) {
        roomRepository.save(classRoom);
    }

    public boolean getClaaRoomByName(String className) {

        return roomRepository.existsByClassName(className);

    }

    public void deleteClass(long id) {
        roomRepository.deleteById(id);
    }

}
