package com.crud.crupoperation.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.crud.crupoperation.Entity.Student;
import com.crud.crupoperation.Service.StudentService;

import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/addStudent")
    public Student postDetails(@RequestBody Student student) {
        return studentService.saveData(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
        return studentService.updateData(id, student);
    }

    @PatchMapping("/{id}")
    public Student partiallyUpdateStudent(@PathVariable int id, @RequestBody Student student) {
        return studentService.partiallyUpdateData(id, student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id) {
        studentService.deleteData(id);
    }

    @GetMapping("/{id}")
    public Optional<Student> getStudent(@PathVariable int id) {
        return studentService.getData(id);
    }
}
