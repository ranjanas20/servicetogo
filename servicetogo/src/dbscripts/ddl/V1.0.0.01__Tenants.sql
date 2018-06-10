-- Table: public.tenant

-- DROP TABLE public.tenant;

CREATE TABLE public.tenant
(
    tenant_id character varying(10) COLLATE pg_catalog."default" NOT NULL,
    tenant_name character varying(20) COLLATE pg_catalog."default" NOT NULL,
    tenant_status character varying(10) COLLATE pg_catalog."default" NOT NULL,
    created_on timestamp ,
    created_by character varying(20) COLLATE pg_catalog."default",
    updated_on timestamp,
    updated_by character varying(20) COLLATE pg_catalog."default",
    CONSTRAINT "Tenant_pkey" PRIMARY KEY (tenant_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.tenant
    OWNER to postgres;