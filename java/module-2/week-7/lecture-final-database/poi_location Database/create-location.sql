-- Table: public.location

-- DROP TABLE public.location;

CREATE TABLE IF NOT EXISTS public.location
(
    id serial,
	name character varying(250) COLLATE pg_catalog."default",
    address character varying(250) COLLATE pg_catalog."default",
    city character varying(100) COLLATE pg_catalog."default",
    state character varying(100) COLLATE pg_catalog."default",
    zip character varying(10) COLLATE pg_catalog."default"
)

TABLESPACE pg_default;

ALTER TABLE public.location
    OWNER to postgres;