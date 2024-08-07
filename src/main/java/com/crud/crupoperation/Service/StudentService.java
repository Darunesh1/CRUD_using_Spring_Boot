package com.crud.crupoperation.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.crupoperation.Entity.Student;
import com.crud.crupoperation.Repository.StudentRepo;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

  
    public Student saveData(Student student) {
        return studentRepo.save(student);
    }

    public Student updateData(int id, Student student) {
        if (studentRepo.existsById(id)) {
            student.setId(id); 
            return studentRepo.save(student);
        }
        return null; 
    }

    public Student partiallyUpdateData(int id, Student student) {
        Optional<Student> existingStudentOpt = studentRepo.findById(id);
        if (existingStudentOpt.isPresent()) {
            Student existingStudent = existingStudentOpt.get();
            
            if (student.getName() != null) {
                existingStudent.setName(student.getName());
            }
            if (student.getMark() != 0) {
                existingStudent.setMark(student.getMark());
            }
            if (student.getEmail() != null) {
                existingStudent.setEmail(student.getEmail());
            }

            return studentRepo.save(existingStudent);
        }
        return null;
    }

    public void deleteData(int id) {
        studentRepo.deleteById(id);
    }

    public Optional<Student> getData(int id) {
        return studentRepo.findById(id);
    }
}
