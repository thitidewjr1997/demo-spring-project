package com.example.demo.repository;

import com.example.demo.model.pojo.Salary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalaryRepository extends MongoRepository<Salary, String>, CrudRepository<Salary, String> {
    Salary save(Salary salary);

    List<Salary> findBySalaryGreaterThanEqual(String salary);

    List<Salary> findByJobTitleAndGenderAndSalary(String jobTitle, String gender, String salary);

    List<Salary> findByOrderByJobTitleDesc(String jobTitle);
}
