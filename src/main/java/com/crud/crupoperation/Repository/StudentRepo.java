package com.crud.crupoperation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.crupoperation.Entity.Student;

public interface StudentRepo extends JpaRepository <Student,Integer> {


}
