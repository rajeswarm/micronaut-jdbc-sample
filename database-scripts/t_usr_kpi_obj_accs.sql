-- Table: adpidmcore10_oltp.t_usr_kpi_obj_accs

-- DROP TABLE adpidmcore10_oltp.t_usr_kpi_obj_accs;

CREATE TABLE adpidmcore10_oltp.t_usr_kpi_obj_accs
(
    kpi_obj_ky numeric(10,0) NOT NULL,
    usr_ao_id character varying COLLATE pg_catalog."default" NOT NULL,
    clnt_obj_id character varying COLLATE pg_catalog."default" NOT NULL,
    accs_type_cd character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT t_usr_kpi_obj_accs_pkey PRIMARY KEY (kpi_obj_ky, usr_ao_id)
)

TABLESPACE pg_default;

ALTER TABLE adpidmcore10_oltp.t_usr_kpi_obj_accs
    OWNER to postgres;