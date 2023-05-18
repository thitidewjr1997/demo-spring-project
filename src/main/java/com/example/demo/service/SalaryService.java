package com.example.demo.service;

import com.example.demo.dao.SalaryDao;
import com.example.demo.model.pojo.Salary;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Arrays;
import java.util.List;

@Service
@Log4j2
public class SalaryService {
    @Autowired
    private SalaryDao salaryDao;

    public Boolean createSalary() {
        try {
            String filePath = "src/main/resources/salary_survey-3.json";
            File file = new File(filePath);
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            var salaryList = Arrays.asList(mapper.readValue(file, Salary[].class));
            salaryDao.saveAll(salaryList);
        } catch (Exception ex) {
            log.error("Exception Message: {}", ex.getMessage());
            return false;
        }
        log.info("End Create Salary");
        return true;
    }

    public List<Salary> findBySalaryGreaterThanEqual(String salary) {
        return salaryDao.findBySalaryGreaterThanEqual(salary);
    }

    public List<Salary> findByJobTitleAndGenderAndSalary(String jobTitle, String gender, String salary) {
        return salaryDao.findByJobTitleAndGenderAndSalary(jobTitle, gender, salary);
    }

    public List<Salary> findByOrderByJobTitleDesc(String jobTitle) {
        return salaryDao.findByOrderByJobTitleDesc(jobTitle);
    }
}
