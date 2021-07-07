package com.SchoolSystem.service;

import com.SchoolSystem.model.ClassRoom;
import com.SchoolSystem.model.Subject;
import com.SchoolSystem.repository.SubjectRepository;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class SubjectService {

    @Autowired
    private SubjectRepository repository;

    @Autowired
    private ClassRoomService classRoomService;

    public Set<Subject> AllSubjectInClass(long ClassID) {
        return repository.findByRoomsId(ClassID);

    }

    public Subject findSubject(long id) {

        return repository.findById(id).orElse(null);
    }

    public List<Subject> AllSubjectTeacher(long TeacherID) {
        return repository.findByTeacherId(TeacherID);

    }

    public List<Subject> AllAvailableSubject() {
        return repository.findByTeacherIdIsNull();
    }

    void SaveSubject(Subject subject) {
        repository.save(subject);
    }

    public List<Subject> AllSubjects() {
        return repository.findAll();
    }

    //to find all the subject not in this classroom   
    public List<Subject> AllSubjectsNotInClass(long ClassID) {
        return repository.findSubjectNotInClassRoom(ClassID);
    }

    public boolean exsistsByName(String name) {
        return repository.existsByNameIgnoreCase(name);
    }

    public void saveSubject(Subject subject) {
        repository.save(subject);
    }

    public List<ClassRoom> AllClassRoomOfSubject(long id) {
        return classRoomService.AllSubjectClasses(id);
    }

}
