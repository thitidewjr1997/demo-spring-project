package com.example.demo.dao;

import com.example.demo.model.pojo.Salary;

import java.util.List;

public interface SalaryDao {
    void saveAll(List<Salary> salaryList);

    List<Salary> findBySalaryGreaterThanEqual(String salary);

    List<Salary> findByJobTitleAndGenderAndSalary(String jobTitle, String gender, String salary);

    List<Salary> findByOrderByJobTitleDesc(String jobTitle);
}
