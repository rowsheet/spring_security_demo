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
-- Name: comments; Type: TABLE; Schema: public; Owner: qfecqiiyybbzql
--

CREATE TABLE public.comments (
    id integer NOT NULL,
    author character varying,
    content character varying
);


ALTER TABLE public.comments OWNER TO qfecqiiyybbzql;

--
-- Name: comments_id_seq; Type: SEQUENCE; Schema: public; Owner: qfecqiiyybbzql
--

CREATE SEQUENCE public.comments_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.comments_id_seq OWNER TO qfecqiiyybbzql;

--
-- Name: comments_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: qfecqiiyybbzql
--

ALTER SEQUENCE public.comments_id_seq OWNED BY public.comments.id;


--
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: qfecqiiyybbzql
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 10
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO qfecqiiyybbzql;

--
-- Name: posts; Type: TABLE; Schema: public; Owner: qfecqiiyybbzql
--

CREATE TABLE public.posts (
    id integer NOT NULL,
    title character varying,
    content character varying
);


ALTER TABLE public.posts OWNER TO qfecqiiyybbzql;

--
-- Name: posts_id_seq; Type: SEQUENCE; Schema: public; Owner: qfecqiiyybbzql
--

CREATE SEQUENCE public.posts_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.posts_id_seq OWNER TO qfecqiiyybbzql;

--
-- Name: posts_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: qfecqiiyybbzql
--

ALTER SEQUENCE public.posts_id_seq OWNED BY public.posts.id;


--
-- Name: users; Type: TABLE; Schema: public; Owner: qfecqiiyybbzql
--

CREATE TABLE public.users (
    id integer NOT NULL,
    active boolean DEFAULT false,
    password character varying,
    roles character varying,
    username character varying
);


ALTER TABLE public.users OWNER TO qfecqiiyybbzql;

--
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: qfecqiiyybbzql
--

CREATE SEQUENCE public.users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_id_seq OWNER TO qfecqiiyybbzql;

--
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: qfecqiiyybbzql
--

ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;


--
-- Name: comments id; Type: DEFAULT; Schema: public; Owner: qfecqiiyybbzql
--

ALTER TABLE ONLY public.comments ALTER COLUMN id SET DEFAULT nextval('public.comments_id_seq'::regclass);


--
-- Name: posts id; Type: DEFAULT; Schema: public; Owner: qfecqiiyybbzql
--

ALTER TABLE ONLY public.posts ALTER COLUMN id SET DEFAULT nextval('public.posts_id_seq'::regclass);


--
-- Name: users id; Type: DEFAULT; Schema: public; Owner: qfecqiiyybbzql
--

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);


--
-- Data for Name: comments; Type: TABLE DATA; Schema: public; Owner: qfecqiiyybbzql
--

COPY public.comments (id, author, content) FROM stdin;
1	foo	foo
7	unit test AUTHOR 1	unit test CONTENT 1
9	unit test AUTHOR 1	unit test CONTENT 1
\.


--
-- Data for Name: posts; Type: TABLE DATA; Schema: public; Owner: qfecqiiyybbzql
--

COPY public.posts (id, title, content) FROM stdin;
1	foo	this is foo
2	bar	this is bar
3	baz	this is baz
7	unit test TITLE	unit test CONTENT
9	unit test TITLE	unit test CONTENT
\.


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: qfecqiiyybbzql
--

COPY public.users (id, active, password, roles, username) FROM stdin;
2	t	$2y$10$gfAGRsdY5PksXUEeqrhuKOQE2GKs8UI9JrWEOm8w0z4MPIpHQimLC	ROLE_ADMIN	admin
1	t	$2y$10$gfAGRsdY5PksXUEeqrhuKOQE2GKs8UI9JrWEOm8w0z4MPIpHQimLC	ROLE_USER	user
\.


--
-- Name: comments_id_seq; Type: SEQUENCE SET; Schema: public; Owner: qfecqiiyybbzql
--

SELECT pg_catalog.setval('public.comments_id_seq', 7, true);


--
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: qfecqiiyybbzql
--

SELECT pg_catalog.setval('public.hibernate_sequence', 33, true);


--
-- Name: posts_id_seq; Type: SEQUENCE SET; Schema: public; Owner: qfecqiiyybbzql
--

SELECT pg_catalog.setval('public.posts_id_seq', 16, true);


--
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: qfecqiiyybbzql
--

SELECT pg_catalog.setval('public.users_id_seq', 5, true);


--
-- Name: comments comments_pkey; Type: CONSTRAINT; Schema: public; Owner: qfecqiiyybbzql
--

ALTER TABLE ONLY public.comments
    ADD CONSTRAINT comments_pkey PRIMARY KEY (id);


--
-- Name: posts posts_pkey; Type: CONSTRAINT; Schema: public; Owner: qfecqiiyybbzql
--

ALTER TABLE ONLY public.posts
    ADD CONSTRAINT posts_pkey PRIMARY KEY (id);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: qfecqiiyybbzql
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

