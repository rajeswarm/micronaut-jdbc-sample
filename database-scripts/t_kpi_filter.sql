-- Table: adpidmcore10_oltp.t_kpi_filter

-- DROP TABLE adpidmcore10_oltp.t_kpi_filter;

CREATE TABLE adpidmcore10_oltp.t_kpi_filter
(
    kpi_filter_ky numeric(10,0) NOT NULL,
    kpi_obj_ky numeric(10,0) NOT NULL,
    clnt_obj_id character varying COLLATE pg_catalog."default" NOT NULL,
    filter_val character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT t_kpi_filter_pkey PRIMARY KEY (kpi_filter_ky)
)

TABLESPACE pg_default;

ALTER TABLE adpidmcore10_oltp.t_kpi_filter
    OWNER to postgres;