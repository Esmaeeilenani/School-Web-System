package com.SchoolSystem.controller;

import com.SchoolSystem.model.ClassRoom;
import com.SchoolSystem.model.Subject;
import com.SchoolSystem.model.Teacher;
import com.SchoolSystem.service.TeacherService;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping("/ManageTeachers/TeacherForm")

    public ModelAndView TeacherForm(ModelAndView mav, @RequestParam(required = false, defaultValue = "-1") long id) {

        Teacher teacher = (id > -1) ? teacherService.FindTeacherID(id)
                : new Teacher();

        mav.addObject("teacher", teacher);
        mav.setViewName("TeacherForm");
        return mav;
    }

    @PostMapping("/ManageTeachers/Add")
    public ModelAndView AddTeacher(ModelAndView mav, @ModelAttribute Teacher teacher, @RequestParam String birthDate, @RequestParam String jDate) {

        if (!teacher.ValidateAttr() || birthDate.isEmpty() || jDate.isEmpty()) {

            mav.addObject("errormsg", "Cnnot Add Teacher (Dont leave any empty values)");
            mav.addObject("show", "show");
            mav.setViewName("forward:/ManageTeachers/TeacherForm");
            return mav;
        }

        //set the dates
        teacher.setDob(LocalDate.parse(birthDate));
        teacher.setJoiningDate(LocalDate.parse(jDate));

        //save to data base
        teacherService.SaveTeacher(teacher);
        mav.setViewName("redirect:/ManageTeachers");
        return mav;
    }

    @RequestMapping("/ManageTeachers/DisplayTeachers")
    public ModelAndView DisplayTeachers(ModelAndView mav) {

        List<Teacher> teachers = teacherService.AllTeachers();

        mav.addObject("teachers", teachers);

        mav.setViewName("AllTeachers");

        return mav;
    }

    @RequestMapping("/ManageTeachers/Delete")
    public ModelAndView DeleteTeacher(ModelAndView mav, @RequestParam long id) {

        teacherService.DeleteTeacherID(id);
        return mav;
    }

    @RequestMapping("/ManageTeachers/AddSubjectTeacher")
    public ModelAndView AddSubjectTeacher(ModelAndView mav, @RequestParam(required = false, defaultValue = "-1") long TeaID, @RequestParam(required = false, defaultValue = "-1") long SubID) {

        mav.setViewName("AddSubToTeacher");

        //before Searching
        if (TeaID == -1) {
            return mav;
        }

        Teacher teacher = teacherService.FindTeacherID(TeaID);

        if (teacher == null) {
            mav.addObject("errormsg", "Teacher with Id: " + TeaID + " Not Found");
            mav.addObject("show", "show");
            return mav;
        }

        List<Subject> TeacherSubjects = teacherService.AllTeacherSubject(TeaID);
        teacher.setSubjects(TeacherSubjects);
        
        //get all Available Subject (not Assigend to any Teacher)
        List<Subject> subjects = teacherService.AllAvailableSubject();

        //set the attributs
        mav.addObject("TeaID", TeaID);
        mav.addObject("name", teacher.getName());
        mav.addObject("subjects", subjects);

        if (SubID != -1) {

            Subject TeacherSub = subjects.stream()
                    .filter(subject -> subject.getId() == SubID)
                    .findFirst().orElse(null);

            teacher.AddSubject(TeacherSub);
            teacherService.SaveTeacherSubject(TeacherSub);
            teacherService.SaveTeacher(teacher);
            mav.setViewName("redirect:/ManageTeachers");
        }

        return mav;
    }

    @RequestMapping("/ManageTeachers/TeacherSubjects")
    public ModelAndView DisplayTeacherSubjects(ModelAndView mav, @RequestParam(required = false, defaultValue = "-1") long TeaID) {

        mav.setViewName("TeacherSubjects");
        //before Searching
        if (TeaID == -1) {
            return mav;
        }

        Teacher teacher = teacherService.FindTeacherID(TeaID);

        if (teacher == null) {
            mav.addObject("errormsg", "Teacher with Id: " + TeaID + " Not Found");
            mav.addObject("show", "show");
            return mav;
        }

        //get all the Subject related to this teacher
        List<Subject> subjects = teacherService.AllTeacherSubject(TeaID);

        //Fatching all Classes foreach Subject
        subjects.forEach(subject -> {
            List<ClassRoom> classRooms = teacherService.SubjectClasses(subject.getId());
            subject.setRooms(new HashSet<>(classRooms));
        });

        teacher.setSubjects(subjects);

        //set the attributs
        mav.addObject("TeaID", TeaID);
        mav.addObject("name", teacher.getName());
        mav.addObject("subjects", subjects);

        return mav;
    }

}
