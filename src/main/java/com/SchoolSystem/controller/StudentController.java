package com.SchoolSystem.controller;

import com.SchoolSystem.model.ClassRoom;
import com.SchoolSystem.model.Student;
import com.SchoolSystem.model.Subject;
import com.SchoolSystem.service.ClassRoomService;
import com.SchoolSystem.service.StudentService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private ClassRoomService roomService;

    @Autowired
    private HttpServletRequest request;

    

    @RequestMapping("/ManageStudents/StudentForm")
    public ModelAndView StudentForm(ModelAndView mav, @RequestParam(required = false, defaultValue = "-1") long id) {

        List<ClassRoom> rooms = roomService.listAll();

        //if no classes the student cannot be added
        if (rooms.isEmpty()) {
            mav.addObject("errormsg", "Cnnot Add Student (no Class Room Available)");
            mav.addObject("show", "show");
            mav.setViewName("/ManageStudents");
            return mav;
        }

        Student student = (id > -1) ? studentService.getById(id) : new Student();

        mav.addObject("student", student);
        mav.addObject("rooms", rooms);
        mav.setViewName("StudentForm");

        return mav;
    }

    @PostMapping("/ManageStudents/Add")
    public ModelAndView AddStudent(@ModelAttribute("student") Student student, ModelAndView mav, @RequestParam String birthDate) {

        //all the form should be validated
        if (!student.ValidateAttr() || birthDate.isEmpty()) {

            mav.addObject("errormsg", "Cnnot Add Student (Dont leave any empty values)");
            mav.addObject("show", "show");

            mav.setViewName("forward:/ManageStudents/StudentForm");
            return mav;
        }

        student.setDob(LocalDate.parse(birthDate));

        //becuse the calssRoom object in student only have a name
        ClassRoom classRoom = roomService.findByClassName(student.getRoom().getClassName());

        student.setRoom(classRoom);

        studentService.SaveStudent(student);

        mav.setViewName("redirect:/ManageStudents");
        return mav;
    }

    @GetMapping("/ManageStudents/displaystudent")
    public ModelAndView DisplayAllStudent(ModelAndView mav) {

        List<Student> Students = studentService.AllStudent();

        mav.addObject("students", Students);

        mav.setViewName("AllStudent");
        return mav;
    }

    @GetMapping("/ManageStudents/Delete")
    public ModelAndView DeleteStudent(ModelAndView mav, @RequestParam long id) {

        studentService.DeleteById(id);

        mav.setViewName("redirect:/ManageStudents/displaystudent");
        return mav;
    }

    @GetMapping("/ManageStudents/StudentSubjects")
    public ModelAndView DisplayStudentSubjects(ModelAndView mav, @RequestParam(required = false, defaultValue = "-1") long StdID) {

        mav.setViewName("StudentSubjects");

        if (StdID == -1) {
            return mav;
        }

        Student student = studentService.getById(StdID);

        if (student == null) {
            mav.addObject("errormsg", "Student with Id: " + StdID + " Not Found");
            mav.addObject("show", "show");
            return mav;
        }

        Set<Subject> subjects = roomService.AllSubjectInClass(student.getRoom().getId());

        mav.addObject("StdID", StdID);
        mav.addObject("name", student.getName());
        mav.addObject("ClassRoom", student.getRoom().getClassName());
        mav.addObject("subjects", subjects);
        

        return mav;
    }

}
