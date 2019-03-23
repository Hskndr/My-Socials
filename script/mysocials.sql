-- Database: mysocials

-- DROP DATABASE mysocials;

CREATE DATABASE mysocials
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'Spanish_Argentina.1252'
       LC_CTYPE = 'Spanish_Argentina.1252'
       CONNECTION LIMIT = -1;


 -- Sequence: public.country_id_country_seq

-- DROP SEQUENCE public.country_id_country_seq;

CREATE SEQUENCE public.country_id_country_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE public.country_id_country_seq
  OWNER TO postgres;


-- Table: public.country

-- DROP TABLE public.country;

CREATE TABLE public.country
(
  id_country integer NOT NULL DEFAULT nextval('country_id_country_seq'::regclass),
  name character varying(24),
  CONSTRAINT pk_country_id PRIMARY KEY (id_country)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.country
  OWNER TO postgres;


-- Table: public.users

-- DROP TABLE public.users;

CREATE TABLE public.users
(
  user_name character varying(24) NOT NULL,
  first_name character varying(24),
  last_name character varying(24),
  email character varying(48),
  address character varying(128),
  phone character varying(20),
  id_country integer,
  CONSTRAINT pk_users_username PRIMARY KEY (user_name),
  CONSTRAINT fk_users_id_country FOREIGN KEY (id_country)
      REFERENCES public.country (id_country) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT ux_users_email UNIQUE (email)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.users
  OWNER TO postgres;