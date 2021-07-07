package com.SchoolSystem.controller;

import com.SchoolSystem.model.ClassRoom;
import com.SchoolSystem.model.Student;
import com.SchoolSystem.model.Subject;
import com.SchoolSystem.service.ClassRoomService;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClassRoomController {

    @Autowired
    private ClassRoomService ClassService;

    @RequestMapping("/ManageClass/ClassForm")
    public ModelAndView ClassForm(ModelAndView mav, @RequestParam(required = false, defaultValue = "-1") long id) {

        ClassRoom classRoom = (id > -1) ? ClassService.findById(id) : new ClassRoom();

        mav.addObject("classroom", classRoom);

        mav.setViewName("ClassForm");
        return mav;
    }

    @PostMapping("/ManageClass/Add")
    public ModelAndView AddClass(ModelAndView mav, @ModelAttribute("classroom") ClassRoom classRoom) {

        if (classRoom.getClassName().isEmpty()) {
            mav.addObject("errormsg", "Cnnot Add ClassRoom (Must Enter ClassRoom Name)");
            mav.addObject("show", "show");
            mav.setViewName("ClassForm");
            return mav;
        }

        if (ClassService.getClaaRoomByName(classRoom.getClassName())) {
            mav.addObject("errormsg", "Cnnot Add ClassRoom (" + classRoom.getClassName() + ") Already Exsists");
            mav.addObject("show", "show");
            mav.setViewName("ClassForm");
            return mav;
        }

        ClassService.SaveClassRoom(classRoom);
        mav.setViewName("redirect:/ManageClass");
        return mav;
    }

    @GetMapping("/ManageClass/AllClasses")
    public ModelAndView AllClasses(ModelAndView mav) {
        List<ClassRoom> classRooms = ClassService.listAll();

        mav.addObject("classrooms", classRooms);

        mav.setViewName("AllClassRoom");
        return mav;
    }

    @GetMapping("/ManageClass/AllClassSubjects")
    public ModelAndView AllClassSubjects(ModelAndView mav, @RequestParam(required = false, defaultValue = "") String ClassName) {

        mav.setViewName("ClassRoomSubjects");

        if (ClassName.isEmpty()) {
            return mav;
        }

        ClassRoom classRoom = ClassService.findByClassName(ClassName);

        if (classRoom == null) {
            mav.addObject("errormsg", "No ClassRoom with this Name:" + ClassName);
            mav.addObject("show", "show");
            return mav;
        }

        Set<Subject> subjects = ClassService.AllSubjectInClass(classRoom.getId());

        classRoom.setSubjects(subjects);

        mav.addObject("ClassId", classRoom.getId());
        mav.addObject("ClassName", classRoom.getClassName());
        mav.addObject("subjects", subjects);

        return mav;
    }

    @GetMapping("/ManageClass/AssignSubjects")
    @Transactional
    public ModelAndView AssignSubjects(ModelAndView mav,
            @RequestParam(required = false, defaultValue = "") String ClassName,
            @RequestParam(required = false, defaultValue = "-1") long SubId) {

        mav.setViewName("ClassRoomAssignSubjects");

        if (ClassName.isEmpty()) {
            return mav;
        }

        ClassRoom classRoom = ClassService.findByClassName(ClassName);

        if (classRoom == null) {
            mav.addObject("errormsg", "No ClassRoom with this Name:" + ClassName);
            mav.addObject("show", "show");
            return mav;
        }

        try {
            //retrive all subject thar are not in this calss
            List<Subject> subjects = ClassService.SubjectsNotInClass(classRoom.getId());

            mav.addObject("ClassId", classRoom.getId());
            mav.addObject("ClassName", classRoom.getClassName());
            mav.addObject("subjects", subjects);

            if (SubId != -1) {
                //the Subject to be Assignd to the class
                Subject SubClass = subjects
                        .stream()
                        .filter(subject -> subject.getId() == SubId)
                        .findFirst().get();


                /* to solve this error without having to fetch = FetchType.EAGER fro better preformance
                   failed to lazily initialize a collection of role: 
                    com.SchoolSystem.model.ClassRoom.subjects, could not initialize proxy - no Session                
                 */
                Set<Subject> Classsubjects = ClassService.AllSubjectInClass(classRoom.getId());
                Classsubjects.add(SubClass);

                classRoom.setSubjects(Classsubjects);

                ClassService.SaveClassRoom(classRoom);

                mav.setViewName("redirect:/ManageClass");
                return mav;
            }
        } catch (Exception e) {
            mav.addObject("errormsg", "No ClassRoom with this Name:" + e.toString());
            mav.addObject("show", "show");

        }
        return mav;
    }

    @RequestMapping("/ManageClass/AllStudent")
    public ModelAndView AllStudentOfClass(ModelAndView mav,
            @RequestParam(required = false, defaultValue = "") String ClassName) {

        mav.setViewName("ClassRoomStudents");

        if (ClassName.isEmpty()) {
            return mav;
        }

        ClassRoom classRoom = ClassService.findByClassName(ClassName);

        if (classRoom == null) {
            mav.addObject("errormsg", "No ClassRoom with this Name:" + ClassName);
            mav.addObject("show", "show");
            return mav;
        }

        List<Student> students = ClassService.AllStudentInClass(classRoom.getId());
        mav.addObject("ClassId", classRoom.getId());
        mav.addObject("ClassName", classRoom.getClassName());
        mav.addObject("students", students);

        return mav;
    }

    @GetMapping("/ManageClass/Delete")
    public ModelAndView DeleteClass(ModelAndView mav, @RequestParam long id) {

        try {
            ClassService.deleteClass(id);
        } catch (Exception e) {
            mav.addObject("errormsg", "Connot Delete this ClassRoom with Id: " + id);
            mav.addObject("show", "show");
            mav.setViewName("AllClassRoom");
            return mav;
        }

        mav.setViewName("redirect:/ManageClass/AllClasses");
        return mav;
    }

}
