package com.example.demo.dao;

import com.example.demo.model.pojo.Salary;
import com.example.demo.repository.SalaryRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Log4j2
@Component
public class SalaryDaoImpl implements SalaryDao {
    private final SalaryRepository salaryRepository;

    @Autowired
    public SalaryDaoImpl(SalaryRepository salaryRepository) {
        this.salaryRepository = salaryRepository;
    }

    @Override
    public void saveAll(List<Salary> salaryList) {
        salaryRepository.saveAll(salaryList);
    }

    @Override
    public List<Salary> findBySalaryGreaterThanEqual(String salary) {
        return salaryRepository.findBySalaryGreaterThanEqual(salary);
    }

    @Override
    public List<Salary> findByJobTitleAndGenderAndSalary(String jobTitle, String gender, String salary) {
        return salaryRepository.findByJobTitleAndGenderAndSalary(jobTitle, gender, salary);
    }

    @Override
    public List<Salary> findByOrderByJobTitleDesc(String jobTitle) {
        return salaryRepository.findByOrderByJobTitleDesc(jobTitle);
    }
}
