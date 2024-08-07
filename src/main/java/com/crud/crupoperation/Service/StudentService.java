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

    // Save a new student or update an existing student
    public Student saveData(Student student) {
        return studentRepo.save(student);
    }

    // Update an existing student by id
    public Student updateData(int id, Student student) {
        if (studentRepo.existsById(id)) {
            student.setId(id); // Ensure the ID is set
            return studentRepo.save(student);
        }
        return null; // Or throw an exception if needed
    }

    // Partially update student data by id
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
        return null; // Or throw an exception if needed
    }

    // Delete student by id
    public void deleteData(int id) {
        studentRepo.deleteById(id);
    }

    // Get student by id
    public Optional<Student> getData(int id) {
        return studentRepo.findById(id);
    }
}
