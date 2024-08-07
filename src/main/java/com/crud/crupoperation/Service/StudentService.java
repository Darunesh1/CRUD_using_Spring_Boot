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
        } else {
            throw new RuntimeException("Student not found with id: " + id);
        }
    }

    public Student partiallyUpdateData(int id, Student student) {
        Optional<Student> existingStudent = studentRepo.findById(id);
        if (existingStudent.isPresent()) {
            Student updatedStudent = existingStudent.get();
            if (student.getMark() != 0) updatedStudent.setMark(student.getMark());
            if (student.getName() != null) updatedStudent.setName(student.getName());
            return studentRepo.save(updatedStudent);
        } else {
            throw new RuntimeException("Student not found with id: " + id);
        }
    }

    public void deleteData(int id) {
        if (studentRepo.existsById(id)) {
            studentRepo.deleteById(id);
        } else {
            throw new RuntimeException("Student not found with id: " + id);
        }
    }

    public Optional<Student> getData(int id) {
        return studentRepo.findById(id);
    }
}
