package com.crud.crupoperation.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.crupoperation.Entity.Student;
import com.crud.crupoperation.Repository.StudentRepo;

@Service
public class StudentService {


    @Autowired
    private StudentRepo studentRepo;

    public Student saveData(Student student)
    {
        return studentRepo.save(student);
    } 

    public List<Student> getData()
    {
        return studentRepo.findAll();
    }

}
