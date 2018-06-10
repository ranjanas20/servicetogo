-- Table: public.customer

-- DROP TABLE public.customer;

-- SEQUENCE: public.customer_customer_id_seq

-- DROP SEQUENCE public.customer_customer_id_seq;

CREATE SEQUENCE public.customer_customer_id_seq;

ALTER SEQUENCE public.customer_customer_id_seq
    OWNER TO postgres;
CREATE TABLE public.customer
(
    customer_id bigint NOT NULL DEFAULT nextval('customer_customer_id_seq'::regclass),
    customer_fname character varying(50) COLLATE pg_catalog."default",
    customer_lname character varying(50) COLLATE pg_catalog."default",
    customer_mname character varying(50) COLLATE pg_catalog."default",
    login_id character varying(150) COLLATE pg_catalog."default",
    customer_email character varying(100) COLLATE pg_catalog."default",
    customer_phone character varying(15) COLLATE pg_catalog."default",
    address_line1 character varying(100) COLLATE pg_catalog."default",
    address_line2 character varying(100) COLLATE pg_catalog."default",
    address_city character varying(100) COLLATE pg_catalog."default",
    address_state character varying(100) COLLATE pg_catalog."default",
    address_zip character varying(10) COLLATE pg_catalog."default",
    tenant_id character varying(10),
    created_on timestamp ,
    created_by character varying(20) COLLATE pg_catalog."default",
    updated_on timestamp,
    updated_by character varying(20) COLLATE pg_catalog."default",
    CONSTRAINT customer_pkey PRIMARY KEY (customer_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.customer
    OWNER to postgres;