-- Table: public.car_service_request

-- DROP TABLE public.car_service_request;

-- SEQUENCE: public.car_service_request_request_id_seq

-- DROP SEQUENCE public.car_service_request_request_id_seq;

CREATE SEQUENCE public.car_service_request_request_id_seq;

ALTER SEQUENCE public.car_service_request_request_id_seq
    OWNER TO postgres;

CREATE TABLE public.car_service_request
(
    request_id bigint NOT NULL DEFAULT nextval('car_service_request_request_id_seq'::regclass),
    tenant_id character varying(10),
    customer_id bigint,
    customer_first_name character varying(100) COLLATE pg_catalog."default",
    customer_last_name character varying(100) COLLATE pg_catalog."default",
    customer_middle_name character varying(100) COLLATE pg_catalog."default",
    customer_email character varying(200) COLLATE pg_catalog."default",
    customer_phone character varying(15) COLLATE pg_catalog."default",
    preferred_contact_method character varying(10) COLLATE pg_catalog."default",
    vehicle_make character varying(20) COLLATE pg_catalog."default",
    vehicle_model character varying(20) COLLATE pg_catalog."default",
    vehicle_year smallint,
    vehicle_vin character varying(17) COLLATE pg_catalog."default",
    address_line1 character varying(100) COLLATE pg_catalog."default",
    address_line2 character varying(100) COLLATE pg_catalog."default",
    address_city character varying(100) COLLATE pg_catalog."default",
    address_state character varying(100) COLLATE pg_catalog."default",
    address_zip character varying(10) COLLATE pg_catalog."default",
    symptoms character varying(255) COLLATE pg_catalog."default",
    user_comments character varying(255) COLLATE pg_catalog."default",
    requested_date date,
    vehicle_location character varying(10) COLLATE pg_catalog."default",
    service_status character varying(10) COLLATE pg_catalog."default",
    assigned_employee_id character varying(20) COLLATE pg_catalog."default",
    assigned_priority character varying(10) COLLATE pg_catalog."default",
    service_schedule_datetime timestamp,
    service_completion_datetime timestamp,
    service_completed_by character varying(20) COLLATE pg_catalog."default",
    created_on timestamp ,
    created_by character varying(20) COLLATE pg_catalog."default",
    updated_on timestamp,
    updated_by character varying(20) COLLATE pg_catalog."default",
    CONSTRAINT car_service_request_pkey PRIMARY KEY (request_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.car_service_request
    OWNER to postgres;