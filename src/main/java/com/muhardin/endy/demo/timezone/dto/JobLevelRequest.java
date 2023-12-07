package com.muhardin.endy.demo.timezone.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

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
public class JobLevelRequest {
    @NotNull
    private Integer companyId;

    @NotNull
    @Positive
    private Integer level;

    @NotNull
    private String jobId;

    @NotNull
    private String type;

    @NotNull
    @FutureOrPresent
    private LocalDate effFrom;

    private LocalDate effTo;

    @AssertTrue(message = "To Date harus lebih besar atau sama dengan From Date")
    @JsonIgnore
    public boolean isJobLeveEffToValid() {
        boolean isValid = false;
        if (effFrom != null && effTo != null) {
            isValid = !effTo.isBefore(effFrom);
        } else {
            isValid = true;
        }
        return isValid;
    }
}
