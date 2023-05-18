package com.example.demo.controller;

import com.example.demo.service.SalaryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static com.example.demo.SalaryDummy.salary;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class SalaryControllerTest {
    @InjectMocks
    private SalaryController salaryController;

    @Mock
    private SalaryService salaryService;

    private MockMvc mvc;

    @BeforeEach
    public void setUp() {
        mvc = MockMvcBuilders.standaloneSetup(salaryController).build();
    }

    @Test
    void createSalarySuccess() throws Exception {
        when(salaryService.createSalary()).thenReturn(true);
        mvc.perform(post("/salary/create")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk()).andReturn();
    }

    @Test
    void findBySalaryGreaterThanEqualSuccess() throws Exception {
        when(salaryService.findBySalaryGreaterThanEqual(anyString())).thenReturn(List.of(salary));
        mvc.perform(get("/salary/job_data/salary[gte]=10000")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk()).andReturn();
    }

    @Test
    void findByJobTitleAndGenderAndSalarySuccess() throws Exception {
        when(salaryService.findByJobTitleAndGenderAndSalary(anyString(), anyString(), anyString())).thenReturn(List.of(salary));
        mvc.perform(get("/salary/job_data/job_title=Test/gender=Test/salary=10000")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk()).andReturn();
    }

    @Test
    void findByOrderByJobTitleDesc() throws Exception {
        when(salaryService.findByOrderByJobTitleDesc(anyString())).thenReturn(List.of(salary));
        mvc.perform(get("/salary/job_data/job_title=Test")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk()).andReturn();
    }
}
