package com.example.demo.controller;

import com.example.demo.constant.Constant;
import com.example.demo.model.dto.SalaryResponseDto;
import com.example.demo.response.Response;
import com.example.demo.service.SalaryService;
import com.example.demo.utils.ResponseUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Log4j2
@RequestMapping(value = "salary")
public class SalaryController {
    @Autowired
    private ResponseUtil responseUtil;
    @Autowired
    private SalaryService salaryService;

    @PostMapping("/create")
    public ResponseEntity<Response> createSalary() {
        log.info("Start Create Salary");
        var status = Boolean.TRUE.equals(salaryService.createSalary()) ? Constant.SUCCESS : Constant.FAILED;
        return ResponseEntity.ok(responseUtil.getSuccessResponse(Constant.STATUS, status));
    }

    @GetMapping("/job_data/salary[gte]={salary}")
    public ResponseEntity<Response> findBySalaryGte(@PathVariable(value = "salary") String salary) {
        log.info("Get salary details");
        var salaryList = salaryService.findBySalaryGreaterThanEqual(salary);
        var responseDto = salaryList.stream()
                .map(s -> new SalaryResponseDto(s.getSalary(), null, null))
                .toList();
        return ResponseEntity.ok(responseUtil.getSuccessResponse(Constant.RESPONSE, responseDto));
    }

    @GetMapping("/job_data/job_title={job_title}/gender={gender}/salary={salary}")
    public ResponseEntity<Response> findByJobTitleAndGenderAndSalary(
            @PathVariable(value = "job_title") String jobTitle,
            @PathVariable(value = "gender") String gender,
            @PathVariable(value = "salary") String salary) {
        log.info("Get salary details");
        var salaryList = salaryService.findByJobTitleAndGenderAndSalary(jobTitle, gender, salary);
        var responseDto = salaryList.stream()
                .map(s -> new SalaryResponseDto(s.getSalary(), s.getJobTitle(), s.getGender()))
                .toList();
        return ResponseEntity.ok(responseUtil.getSuccessResponse(Constant.RESPONSE, responseDto));
    }

    @GetMapping("/job_data/job_title={job_title}")
    public ResponseEntity<Response> findByOrderByJobTitleDesc(
            @PathVariable(value = "job_title") String jobTitle) {
        log.info("Get salary details");
        var salaryList = salaryService.findByOrderByJobTitleDesc(jobTitle);
        List<SalaryResponseDto> responseDto = salaryList.stream()
                .map(s -> new SalaryResponseDto(null, s.getJobTitle(), null))
                .toList();
        return ResponseEntity.ok(responseUtil.getSuccessResponse(Constant.RESPONSE, responseDto));
    }
}
