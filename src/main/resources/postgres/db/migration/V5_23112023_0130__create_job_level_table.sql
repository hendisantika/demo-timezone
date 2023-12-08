CREATE SEQUENCE job_level_seq AS integer START 101;

CREATE TABLE job_level
(
    id serial4 NOT NULL UNIQUE,
    jl_company_id   int4        NOT NULL,
    jl_level_no     int         NOT NULL,
    jl_job_id       varchar(10) NOT NULL,
    jl_created_by   varchar(30) NULL,
    jl_created_date timestamptz NULL,
    jl_updated_by   varchar(30) NULL,
    jl_updated_date timestamptz NULL,
    jl_type         varchar(10) NOT NULL,
    jl_is_coll      varchar(2) NULL,
    jl_eff_from     date NULL,
    jl_eff_to       date NULL,
    CONSTRAINT job_level_pk PRIMARY KEY (id, jl_level_no, jl_job_id, jl_type, jl_company_id)
);



