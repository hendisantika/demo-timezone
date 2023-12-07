package com.muhardin.endy.demo.timezone.controller;

import com.muhardin.endy.demo.timezone.dto.BaseResponse;
import com.muhardin.endy.demo.timezone.dto.JobLevelRequest;
import com.muhardin.endy.demo.timezone.dto.JobLevelResponse;
import com.muhardin.endy.demo.timezone.service.JobLevelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : demo-timezone2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/7/23
 * Time: 18:01
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/level")
@Tag(name = "Master Job Level", description = "REST API for Master Job Level/Level Hierarchy")
public class JobLevelController {
    private final JobLevelService jobLevelService;

    @Operation(summary = "Save Setup Job Level Hierarchy")
    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Created Success",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = BaseResponse.class))}),
            @ApiResponse(responseCode = "400",
                    description = "Bad Request",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = BaseResponse.class))}),
            @ApiResponse(responseCode = "404",
                    description = "Not Found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = BaseResponse.class))}),
            @ApiResponse(responseCode = "503",
                    description = "Service Unavailable",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = BaseResponse.class))})
    })
    public ResponseEntity<BaseResponse<JobLevelResponse>> save(@RequestBody @Valid JobLevelRequest jobLevelRequest) {
        return this.jobLevelService.save(jobLevelRequest);
    }
}
