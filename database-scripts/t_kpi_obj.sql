-- Table: adpidmcore10_oltp.t_kpi_obj

-- DROP TABLE adpidmcore10_oltp.t_kpi_obj;

CREATE TABLE adpidmcore10_oltp.t_kpi_obj
(
    kpi_obj_ky numeric(10,0) NOT NULL,
    kpi_ovrd_nm character varying(200) COLLATE pg_catalog."default" NOT NULL,
    clnt_obj_id character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT t_kpi_obj_pkey PRIMARY KEY (kpi_obj_ky)
)

TABLESPACE pg_default;

ALTER TABLE adpidmcore10_oltp.t_kpi_obj
    OWNER to postgres;