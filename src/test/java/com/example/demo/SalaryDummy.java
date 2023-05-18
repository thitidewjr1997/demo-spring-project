package com.example.demo;

import com.example.demo.model.pojo.Salary;
import org.springframework.stereotype.Component;

@Component
public class SalaryDummy {
    public static final Salary salary = Salary.builder()
            .salary("10000")
            .jobTitle("Test")
            .gender("Test")
            .build();
}
