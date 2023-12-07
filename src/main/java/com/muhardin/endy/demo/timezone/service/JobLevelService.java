package com.muhardin.endy.demo.timezone.service;

import com.muhardin.endy.demo.timezone.dao.JobLevelRepository;
import com.muhardin.endy.demo.timezone.dto.BaseResponse;
import com.muhardin.endy.demo.timezone.dto.JobLevelRequest;
import com.muhardin.endy.demo.timezone.dto.JobLevelResponse;
import com.muhardin.endy.demo.timezone.entity.joblevel.JobLevel;
import com.muhardin.endy.demo.timezone.entity.joblevel.JobLevelId;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * Project : demo-timezone2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/7/23
 * Time: 17:32
 * To change this template use File | Settings | File Templates.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class JobLevelService {
    private final JobLevelRepository jobLevelRepository;

    @Transactional(rollbackFor = EntityExistsException.class)
    public ResponseEntity<BaseResponse<JobLevelResponse>> save(JobLevelRequest jobLevelRequest) {
        JobLevelId jobLevelId = JobLevelId.builder()
                .companyId(jobLevelRequest.getCompanyId())
                .levelNo(jobLevelRequest.getLevel())
                .jobId(jobLevelRequest.getJobId())
                .type(jobLevelRequest.getType())
                .build();

        JobLevel jobLevel = JobLevel.builder()
                .companyId(jobLevelId.getCompanyId())
                .levelNo(jobLevelId.getLevelNo())
                .jobId(jobLevelId.getJobId())
                .type(jobLevelId.getType())
                .effFrom(jobLevelRequest.getEffFrom())
                .effTo(jobLevelRequest.getEffTo())
                .build();

        if (jobLevelRepository.existsByJobId(jobLevelId.getJobId())) {
            throw new EntityExistsException("Job ID already exist!");
        }

        jobLevelRepository.save(jobLevel);
        var response = BaseResponse.<JobLevelResponse>builder()
                .timestamp(new Date())
                .data(new JobLevelResponse(jobLevelRequest))
                .statusCode(HttpStatus.OK.value())
                .message("Save Success")
                .build();
        return ResponseEntity.ok(response);
    }
}


