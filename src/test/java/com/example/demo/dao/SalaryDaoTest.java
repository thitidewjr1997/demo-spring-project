package com.example.demo.dao;

import com.example.demo.repository.SalaryRepository;
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
public class SalaryDaoTest {
    @InjectMocks
    private SalaryDaoImpl salaryDao;

    @Mock
    private SalaryRepository salaryRepository;

    @Test
    void findBySalaryGreaterThanEqualSuccess() {
        when(salaryDao.findBySalaryGreaterThanEqual(anyString())).thenReturn(List.of(salary));
        var results = salaryDao.findBySalaryGreaterThanEqual("10000");
        Assertions.assertFalse(results.isEmpty());
        verify(salaryRepository).findBySalaryGreaterThanEqual(anyString());
    }

    @Test
    void findByJobTitleAndGenderAndSalarySuccess() {
        when(salaryDao.findByJobTitleAndGenderAndSalary(anyString(), anyString(), anyString())).thenReturn(List.of(salary));
        var results = salaryDao.findByJobTitleAndGenderAndSalary("Test", "Test", "10000");
        Assertions.assertFalse(results.isEmpty());
        verify(salaryRepository).findByJobTitleAndGenderAndSalary(anyString(), anyString(), anyString());
    }

    @Test
    void findByOrderByJobTitleDesc() {
        when(salaryDao.findByOrderByJobTitleDesc(anyString())).thenReturn(List.of(salary));
        var results = salaryDao.findByOrderByJobTitleDesc("Test");
        Assertions.assertFalse(results.isEmpty());
        verify(salaryRepository).findByOrderByJobTitleDesc(anyString());
    }
}
