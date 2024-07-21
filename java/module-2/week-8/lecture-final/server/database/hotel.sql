--HotelDB

-- DROP TABLE public.hotel;

CREATE TABLE IF NOT EXISTS public.hotel
(
    hotel_id serial,
    address_id integer,
    name character varying(50) COLLATE pg_catalog."default" NOT NULL,
    stars integer,
    rooms_available integer,
    cover_image character varying(150) COLLATE pg_catalog."default",
    cost_per_night numeric,
    CONSTRAINT pk_hotel PRIMARY KEY (hotel_id),
    CONSTRAINT fk_hotel_address FOREIGN KEY (address_id)
        REFERENCES public.address (address_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);



-- DROP TABLE public.address;

CREATE TABLE IF NOT EXISTS address
(
    address_id serial,
    address character varying(100) COLLATE pg_catalog."default",
    address2 character varying(100) COLLATE pg_catalog."default",
    city character varying(100) COLLATE pg_catalog."default",
    state character varying(100) COLLATE pg_catalog."default",
    zip character varying(10) COLLATE pg_catalog."default",
    CONSTRAINT pk_address PRIMARY KEY (address_id)
);



-- DROP TABLE public.hotel_user;

CREATE TABLE IF NOT EXISTS hotel_user
(
    user_id serial,
    username character varying(50) COLLATE pg_catalog."default" NOT NULL,
    password_hash character varying(200) COLLATE pg_catalog."default" NOT NULL,
    role character varying(20) COLLATE pg_catalog."default",
    CONSTRAINT pk_hotel_user PRIMARY KEY (user_id),
    CONSTRAINT uq_username UNIQUE (username)
);



-- DROP TABLE public.reservation;

CREATE TABLE IF NOT EXISTS public.reservation
(
    reservation_id serial,
    hotel_id integer,
    full_name character varying(100) COLLATE pg_catalog."default",
    checkin_date character varying(100) COLLATE pg_catalog."default",
    checkout_date character varying(100) COLLATE pg_catalog."default",
    guests integer,
    CONSTRAINT pk_reservation PRIMARY KEY (reservation_id),
    CONSTRAINT fk_reservation_hotel FOREIGN KEY (hotel_id)
        REFERENCES public.hotel (hotel_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);
