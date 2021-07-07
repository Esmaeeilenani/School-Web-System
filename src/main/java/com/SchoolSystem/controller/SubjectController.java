package com.SchoolSystem.controller;

import com.SchoolSystem.model.ClassRoom;
import com.SchoolSystem.model.Subject;
import com.SchoolSystem.service.SubjectService;
import java.util.HashSet;
import java.util.List;
import javax.ws.rs.POST;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @RequestMapping("/ManageSubjects/SubjectForm")
    public ModelAndView SubjectForm(ModelAndView mav, @RequestParam(required = false, defaultValue = "-1") long id) {

        Subject subject = (id > -1) ? subjectService.findSubject(id) : new Subject();

        mav.setViewName("SubjectForm");

        mav.addObject("subject", new Subject());

        return mav;
    }

    @PostMapping("/ManageSubjects/Add")
    public ModelAndView AddSubject(ModelAndView mav, @ModelAttribute Subject subject) {

        if (subject.getName().isEmpty()) {
            mav.addObject("errormsg", "Cnnot Add Subject (Must Enter Subject Name)");
            mav.addObject("show", "show");
            mav.setViewName("SubjectForm");
            return mav;
        }

        if (subjectService.exsistsByName(subject.getName())) {
            mav.addObject("errormsg", "Cnnot Add Subject with name: " + subject.getName() + " Already Exsists");
            mav.addObject("show", "show");
            mav.setViewName("SubjectForm");
            return mav;
        }

        try {
            subject.setTeacher(null);
            subjectService.saveSubject(subject);
        } catch (Exception e) {
            mav.addObject("errormsg", e.toString());
            mav.addObject("show", "show");
            mav.setViewName("SubjectForm");
            return mav;
        }

        mav.setViewName("redirect:/ManageSubjects");

        return mav;
    }

    @RequestMapping("/ManageSubjects/AllSubjects")
    public ModelAndView AllSubject(ModelAndView mav) {

        List<Subject> subjects = subjectService.AllSubjects();

        subjects.forEach(subject -> {
            List<ClassRoom> classRooms = subjectService.AllClassRoomOfSubject(subject.getId());
            subject.setRooms(new HashSet<>(classRooms));

        });
        mav.addObject("subjects", subjects);

        mav.setViewName("AllSubject");
        return mav;
    }

}
