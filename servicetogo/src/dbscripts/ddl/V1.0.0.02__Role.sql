-- Table: public.role

-- DROP TABLE public.role;

CREATE TABLE public.role
(
    role_name character varying(20) COLLATE pg_catalog."default" NOT NULL,
    role_description character varying(100) COLLATE pg_catalog."default",
    created_on timestamp ,
    created_by character varying(20) COLLATE pg_catalog."default",
    updated_on timestamp,
    updated_by character varying(20) COLLATE pg_catalog."default",
    CONSTRAINT role_pkey PRIMARY KEY (role_name)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.role
    OWNER to postgres;

