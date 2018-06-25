-- Table: public.user_credentials

-- DROP TABLE public.user_credentials;

-- SEQUENCE: public.user_credentials_credential_id_seq

-- DROP SEQUENCE public.user_credentials_credential_id_seq;

CREATE SEQUENCE public.user_credentials_credential_id_seq;

ALTER SEQUENCE public.user_credentials_credential_id_seq
    OWNER TO postgres;


CREATE TABLE public.user_credentials
(
    credential_id integer NOT NULL DEFAULT nextval('user_credentials_credential_id_seq'::regclass),
    login_id character varying(150) COLLATE pg_catalog."default" NOT NULL,
    login_password character varying(20) COLLATE pg_catalog."default" NOT NULL,
    user_type character varying(10) COLLATE pg_catalog."default" NOT NULL,
    created_on timestamp ,
    tenant_id character varying(10),
    created_by character varying(20) COLLATE pg_catalog."default",
    updated_on timestamp,
    updated_by character varying(20) COLLATE pg_catalog."default",
    CONSTRAINT user_credentials_pkey PRIMARY KEY (credential_id),
    CONSTRAINT user_credentials_unique_login_id UNIQUE (login_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.user_credentials
    OWNER to postgres;