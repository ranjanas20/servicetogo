
-- Table: public.user_role

-- DROP TABLE public.user_role;

-- SEQUENCE: public.user_role_user_role_id_seq

-- DROP SEQUENCE public.user_role_user_role_id_seq;



CREATE SEQUENCE public.user_role_user_role_id_seq;

ALTER SEQUENCE public.user_role_user_role_id_seq
    OWNER TO postgres;


CREATE TABLE public.user_role
(
    user_role_id integer NOT NULL DEFAULT nextval('user_role_user_role_id_seq'::regclass),
    credential_id integer NOT NULL,
    role_name character varying(20) COLLATE pg_catalog."default" NOT NULL,
    tenant_id character varying(10),
    created_on timestamp ,
    created_by character varying(20) COLLATE pg_catalog."default",
    updated_on timestamp,
    updated_by character varying(20) COLLATE pg_catalog."default",
    CONSTRAINT user_role_pkey PRIMARY KEY (user_role_id),
    CONSTRAINT fk_credential_id FOREIGN KEY (credential_id)
        REFERENCES public.user_credentials (credential_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_role_id FOREIGN KEY (role_name)
        REFERENCES public.role (role_name) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.user_role
    OWNER to postgres;
