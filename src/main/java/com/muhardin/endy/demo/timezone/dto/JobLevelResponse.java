package com.muhardin.endy.demo.timezone.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by IntelliJ IDEA.
 * Project : demo-timezone2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/7/23
 * Time: 17:36
 * To change this template use File | Settings | File Templates.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JobLevelResponse {
    private Integer id;
    private Integer companyId;

    private BigDecimal level;
    private String jobId;
    private String type;
    private String description;

    private LocalDate effFrom;

    private LocalDate effTo;

    public JobLevelResponse(JobLevelRequest jobLevelRequest) {
        BeanUtils.copyProperties(jobLevelRequest, this);
    }
}
