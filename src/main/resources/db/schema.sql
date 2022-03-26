DROP TABLE IF EXISTS public.employee;

DROP SEQUENCE IF EXISTS public.employee_id_seq;

CREATE SEQUENCE public.employee_id_seq;

CREATE TABLE public.employee
(
    id bigint NOT NULL DEFAULT nextval('employee_id_seq'::regclass),
    age integer NOT NULL,
    name character varying(255) COLLATE pg_catalog."default",
    salary integer NOT NULL,
    CONSTRAINT employee_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.employee
    OWNER to postgres;

ALTER SEQUENCE public.employee_id_seq
OWNED BY public.employee.id;

