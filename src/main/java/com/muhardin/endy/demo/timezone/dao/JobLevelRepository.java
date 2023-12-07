package com.muhardin.endy.demo.timezone.dao;

import com.muhardin.endy.demo.timezone.entity.joblevel.JobLevel;
import com.muhardin.endy.demo.timezone.entity.joblevel.JobLevelId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * Project : demo-timezone2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/7/23
 * Time: 17:31
 * To change this template use File | Settings | File Templates.
 */
public interface JobLevelRepository extends JpaRepository<JobLevel, JobLevelId>, JpaSpecificationExecutor<JobLevel> {
    Page<JobLevel> findAllByEffToIsNull(Pageable pageable);

    Page<JobLevel> findAllByEffToIsNull(Specification<JobLevel> spec, Pageable pageable);

    Optional<JobLevel> findById(Integer id);

    Optional<JobLevel> findByCompanyIdAndLevelNoAndJobIdAndType(Integer companyId, BigDecimal levelNo, String jobId, String type);

    boolean existsById(JobLevelId jobLevelId);

    boolean existsByJobId(String jobId);
}
