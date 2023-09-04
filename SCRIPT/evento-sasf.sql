BEGIN;


CREATE TABLE IF NOT EXISTS public.evento
(
    id bigint NOT NULL DEFAULT nextval('evento_id_seq'::regclass),
    created_date timestamp without time zone,
    modified_date date,
    nombre character varying(255) COLLATE pg_catalog."default",
    precio numeric(19, 2),
    CONSTRAINT evento_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.solicitud_cotizacion
(
    id bigint NOT NULL DEFAULT nextval('solicitud_cotizacion_id_seq'::regclass),
    created_date timestamp without time zone,
    modified_date date,
    fecha_creacion timestamp without time zone,
    motivo_rechazo character varying(255) COLLATE pg_catalog."default",
    precio_calculado numeric(19, 2),
    cliente_id bigint,
    evento_id bigint,
    CONSTRAINT solicitud_cotizacion_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.users
(
    id bigint NOT NULL DEFAULT nextval('users_id_seq'::regclass),
    created_date timestamp without time zone,
    modified_date date,
    apellido_de_usuario character varying(255) COLLATE pg_catalog."default",
    clave character varying(255) COLLATE pg_catalog."default",
    email_usuarios character varying(30) COLLATE pg_catalog."default",
    nombre_de_usuario character varying(255) COLLATE pg_catalog."default",
    usuarios character varying(20) COLLATE pg_catalog."default",
    CONSTRAINT users_pkey PRIMARY KEY (id),
    CONSTRAINT uk_4vi15h8jdlok9ql72pcbsfcdx UNIQUE (usuarios),
    CONSTRAINT uk_ea6digttbcrpoedycm92hayi2 UNIQUE (email_usuarios)
);

CREATE TABLE IF NOT EXISTS public.users_rol
(
    rol character varying(20) COLLATE pg_catalog."default" NOT NULL,
    usuario character varying(20) COLLATE pg_catalog."default" NOT NULL,
    granted_date timestamp without time zone NOT NULL,
    CONSTRAINT users_rol_pkey PRIMARY KEY (rol, usuario)
);

CREATE TABLE IF NOT EXISTS public.usuarios_roles
(
    usuarios character varying(20) COLLATE pg_catalog."default" NOT NULL,
    created_date timestamp without time zone,
    modified_date date,
    apellido_de_usuario character varying(255) COLLATE pg_catalog."default",
    clave character varying(255) COLLATE pg_catalog."default",
    email_usuarios character varying(30) COLLATE pg_catalog."default",
    nombre_de_usuario character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT usuarios_roles_pkey PRIMARY KEY (usuarios),
    CONSTRAINT uk_fu0r3nel6oh0a3fp47v0ftifw UNIQUE (email_usuarios)
);

ALTER TABLE IF EXISTS public.solicitud_cotizacion
    ADD CONSTRAINT fks00u8x9eqllxbrhgclhmh80ur FOREIGN KEY (evento_id)
    REFERENCES public.evento (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.solicitud_cotizacion
    ADD CONSTRAINT fkt7gq9bwugxsyq0wv8k7n8mwfq FOREIGN KEY (cliente_id)
    REFERENCES public.users (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.users_rol
    ADD CONSTRAINT fklkty7lbpfffvc4c2986aijh8c FOREIGN KEY (usuario)
    REFERENCES public.usuarios_roles (usuarios) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;

END;