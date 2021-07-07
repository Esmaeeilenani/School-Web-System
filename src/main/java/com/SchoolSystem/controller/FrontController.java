package com.SchoolSystem.controller;

import com.SchoolSystem.model.Subject;
import com.SchoolSystem.service.SubjectService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrontController {

    @RequestMapping({"/","index"})
    public String HomePage() {
        return "/index";
    }

    @RequestMapping("/ManageStudents")
    public String ManageStudentsPage() {
        return "ManageStudents";
    }

    @RequestMapping("/ManageTeachers")
    public String ManageTeacherPage() {
        return "ManageTeachers";
    }
    
    @RequestMapping("/ManageClass")
    public String ManageClassPage() {
        return "ManageClasses";
    }
    
    @RequestMapping("/ManageSubjects")
    public String ManageSubjectsPage() {
        return "ManageSubjects";
    }

    @RequestMapping("/About")
    public String AboutPage() {
        return "About";
    }

}
