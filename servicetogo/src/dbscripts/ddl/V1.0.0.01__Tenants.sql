-- Table: public.tenants

-- DROP TABLE public.tenants;

CREATE TABLE public.tenants
(
    tenant_id character varying(10) COLLATE pg_catalog."default" NOT NULL,
    tenant_name character varying(20) COLLATE pg_catalog."default" NOT NULL,
    tenant_status character varying(10) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT "Tenants_pkey" PRIMARY KEY (tenant_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.tenants
    OWNER to postgres;