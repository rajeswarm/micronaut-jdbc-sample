-- Table: adpidmcore10_oltp.t_kpi_cmnt

-- DROP TABLE adpidmcore10_oltp.t_kpi_cmnt;

CREATE TABLE adpidmcore10_oltp.t_kpi_cmnt
(
    kpi_cmnt_ky numeric(10,0) NOT NULL,
    kpi_obj_ky numeric(10,0) NOT NULL,
    clnt_obj_id character varying COLLATE pg_catalog."default" NOT NULL,
    comnt_txt character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT t_kpi_cmnt_pkey PRIMARY KEY (kpi_cmnt_ky)
)

TABLESPACE pg_default;

ALTER TABLE adpidmcore10_oltp.t_kpi_cmnt
    OWNER to postgres;