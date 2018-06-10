-- Table: public.employee

-- DROP TABLE public.employee;

-- SEQUENCE: public.employee_employee_id_seq

-- DROP SEQUENCE public.employee_employee_id_seq;

CREATE SEQUENCE public.employee_employee_id_seq;

ALTER SEQUENCE public.employee_employee_id_seq
    OWNER TO postgres;

CREATE TABLE public.employee
(
    employee_id integer NOT NULL DEFAULT nextval('employee_employee_id_seq'::regclass),
    employee_fname character varying(50) COLLATE pg_catalog."default",
    employee_lname character varying(50) COLLATE pg_catalog."default",
    employee_mname character varying(50) COLLATE pg_catalog."default",
    login_id character varying(150) COLLATE pg_catalog."default",
    tenant_id character varying(10),
    CONSTRAINT employee_pkey PRIMARY KEY (employee_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.employee
    OWNER to postgres;