package com.SchoolSystem.service;

import com.SchoolSystem.model.ClassRoom;
import com.SchoolSystem.model.Subject;
import com.SchoolSystem.model.Teacher;
import com.SchoolSystem.repository.TeacherRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class TeacherService {

    @Autowired
    private TeacherRepository repository;

    @Autowired
    private SubjectService subjectService;
    
    @Autowired
    private ClassRoomService classRoomService;

    public void SaveTeacher(Teacher teacher) {
        repository.save(teacher);
    }

    public List<Teacher> AllTeachers() {
        return repository.findAll();

    }

    public Teacher FindTeacherID(long id) {
        return repository.findById(id).orElse(null);

    }

    public void DeleteTeacherID(long id) {
        repository.deleteById(id);
    }

    public List<Subject> AllTeacherSubject(long TeacherID) {
        return subjectService.AllSubjectTeacher(TeacherID);
    }

    public List<Subject> AllAvailableSubject() {
        return subjectService.AllAvailableSubject();
    }

    public void SaveTeacherSubject(Subject TeacherSub) {
        subjectService.SaveSubject(TeacherSub);
    }
    
    public List<ClassRoom> SubjectClasses(long SubjID){
                   
       return classRoomService.AllSubjectClasses(SubjID);
        
    }
    
}
