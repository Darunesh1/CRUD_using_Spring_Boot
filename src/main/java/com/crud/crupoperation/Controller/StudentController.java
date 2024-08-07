package com.crud.crupoperation.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.crupoperation.Entity.Student;
import com.crud.crupoperation.Service.StudentService;

@RestController
public class StudentController {


    @Autowired
    private StudentService studentService;



    @PostMapping("/addStudent")
    public  Student postDetails(@RequestBody Student student)
    {
        return studentService.saveData(student);

    }
}
