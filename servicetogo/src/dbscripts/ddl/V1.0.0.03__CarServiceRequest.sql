-- Table: public.car_service_request

--DROP TABLE public.car_service_request;

-- SEQUENCE: public.car_service_request_request_id_seq

DROP SEQUENCE public.car_service_request_request_id_seq;

CREATE SEQUENCE public.car_service_request_request_id_seq;

ALTER SEQUENCE public.car_service_request_request_id_seq
    OWNER TO postgres;

CREATE TABLE public.car_service_request
(
    request_id bigint NOT NULL DEFAULT nextval('car_service_request_request_id_seq'::regclass),
    tenant_id character varying(10),
    customer_id bigint,
    customer_first_name character varying(100) ,
    customer_last_name character varying(100) ,
    customer_middle_name character varying(100) ,
    customer_email character varying(200) ,
    customer_phone character varying(15) ,
    preferred_contact_method character varying(10) ,
    vehicle_make character varying(20) ,
    vehicle_model character varying(20) ,
    vehicle_year smallint,
    vehicle_vin character varying(17) ,
    address_line1 character varying(100) ,
    address_line2 character varying(100) ,
    address_city character varying(100) ,
    address_state character varying(100) ,
    address_zip character varying(10) ,
    symptoms character varying(255) ,
    user_comments character varying(255) ,
    requested_date date,
    vehicle_location character varying(10) ,
    service_status character varying(10) ,
    assigned_employee_id int4 ,
    assigned_priority character varying(10) ,
    service_schedule_datetime timestamp,
    service_completion_datetime timestamp,
    service_completed_by int4  ,
    created_on timestamp ,
    created_by character varying(20) ,
    updated_on timestamp,
    updated_by character varying(20) ,
    CONSTRAINT car_service_request_pkey PRIMARY KEY (request_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.car_service_request
    OWNER to postgres;