package com.muhardin.endy.demo.timezone.entity.joblevel;

import lombok.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by IntelliJ IDEA.
 * Project : demo-timezone2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/7/23
 * Time: 17:29
 * To change this template use File | Settings | File Templates.
 */
@Getter
@Setter
//@Embeddable
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JobLevelId implements Serializable {
    private static final long serialVersionUID = 6773049698124950737L;

    //    @Column(name = "id")
//    @GeneratedValue(strategy = GenerationType.UUID)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "job_level_seq")
//    @SequenceGenerator(name = "job_level_seq", sequenceName = "job_level_seq", initialValue = 100)
    private Integer id;

    //    @NotNull
//    @Column(name = "jl_company_id", nullable = false)
    private Integer companyId;

    //    @NotNull
//    @Column(name = "jl_level_no", nullable = false)
    private Integer levelNo;

    //    @Size(max = 10)
//    @NotNull
//    @Column(name = "jl_job_id", nullable = false, length = 10)
    private String jobId;

    //    @Size(max = 10)
//    @NotNull
//    @Column(name = "jl_type", nullable = false, length = 10)
    private String type;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobLevelId that = (JobLevelId) o;
        return Objects.equals(id, that.id) && Objects.equals(companyId, that.companyId) && Objects.equals(levelNo, that.levelNo) && Objects.equals(jobId, that.jobId) && Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, companyId, levelNo, jobId, type);
    }

}
