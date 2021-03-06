--
-- PostgreSQL database dump
--

-- Dumped from database version 11.5
-- Dumped by pg_dump version 11.5

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: users; Type: TABLE; Schema: public; Owner: xijinping
--

CREATE TABLE public.users (
    id integer NOT NULL,
    active boolean DEFAULT false,
    password character varying,
    roles character varying,
    username character varying
);


ALTER TABLE public.users OWNER TO xijinping;

--
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: xijinping
--

CREATE SEQUENCE public.users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_id_seq OWNER TO xijinping;

--
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: xijinping
--

ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;


--
-- Name: users id; Type: DEFAULT; Schema: public; Owner: xijinping
--

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: xijinping
--

COPY public.users (id, active, password, roles, username) FROM stdin;
1	t	pass	ROLE_USER	user
\.


--
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: xijinping
--

SELECT pg_catalog.setval('public.users_id_seq', 1, true);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: xijinping
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

