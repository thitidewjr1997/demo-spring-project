package com.example.demo.service;

import com.example.demo.dao.SalaryDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.example.demo.SalaryDummy.salary;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SalaryServiceTest {
    @InjectMocks
    private SalaryService salaryService;

    @Mock
    private SalaryDao salaryDao;

    @Test
    void findBySalaryGreaterThanEqualSuccess() {
        when(salaryDao.findBySalaryGreaterThanEqual(anyString())).thenReturn(List.of(salary));
        var results = salaryService.findBySalaryGreaterThanEqual("10000");
        Assertions.assertFalse(results.isEmpty());
        verify(salaryDao).findBySalaryGreaterThanEqual(anyString());
    }

    @Test
    void findByJobTitleAndGenderAndSalarySuccess() {
        when(salaryDao.findByJobTitleAndGenderAndSalary(anyString(), anyString(), anyString())).thenReturn(List.of(salary));
        var results = salaryService.findByJobTitleAndGenderAndSalary("Test", "Test", "10000");
        Assertions.assertFalse(results.isEmpty());
        verify(salaryDao).findByJobTitleAndGenderAndSalary(anyString(), anyString(), anyString());
    }

    @Test
    void findByOrderByJobTitleDesc() {
        when(salaryDao.findByOrderByJobTitleDesc(anyString())).thenReturn(List.of(salary));
        var results = salaryService.findByOrderByJobTitleDesc("Test");
        Assertions.assertFalse(results.isEmpty());
        verify(salaryDao).findByOrderByJobTitleDesc(anyString());
    }
}
