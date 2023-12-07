package com.muhardin.endy.demo.timezone.entity.joblevel;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by IntelliJ IDEA.
 * Project : demo-timezone2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/7/23
 * Time: 17:30
 * To change this template use File | Settings | File Templates.
 */
@Getter
@Setter
@Entity
@Table(name = "job_level")
@EntityListeners(AuditingEntityListener.class)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@IdClass(JobLevelId.class)
public class JobLevel {

    @Id

//    @Column(columnDefinition = "serial")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "job_level_id_seq")
    @SequenceGenerator(name = "job_level_id_seq", sequenceName = "job_level_id_seq", allocationSize = 1)
    private Integer id;

    //    @EmbeddedId
//    private JobLevelId id;
    @Id
    @NotNull
    @Column(name = "jl_company_id", nullable = false)
    private Integer companyId;

    @Id
    @NotNull
    @Column(name = "jl_level_no", nullable = false)
    private Integer levelNo;

    @Id
    @Size(min = 2, max = 10)
    @NotNull
    @Column(name = "jl_job_id", nullable = false, length = 10)
    private String jobId;

    @Id
    @Size(min = 2, max = 10)
    @NotNull
    @Column(name = "jl_type", nullable = false, length = 10)
    private String type;

    @Size(max = 30)
    @Column(name = "jl_created_by", length = 30)
    @CreatedBy
    private String jlCreatedBy;

    @Column(name = "jl_created_date")
    @CreatedDate
    private LocalDateTime jlCreatedDate;

    @Size(max = 30)
    @Column(name = "jl_updated_by", length = 30)
    @LastModifiedBy
    private String jlUpdatedBy;

    @Column(name = "jl_updated_date")
    @LastModifiedDate
    private LocalDateTime jlUpdatedDate;

    @Size(max = 2)
    @Column(name = "jl_is_coll", length = 2)
    private String jlIsColl;

    @Column(name = "jl_eff_from")
    private LocalDate effFrom;

    @Column(name = "jl_eff_to")
    private LocalDate effTo;
}
