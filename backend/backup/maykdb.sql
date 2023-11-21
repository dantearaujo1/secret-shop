--
-- PostgreSQL database dump
--

-- Dumped from database version 15.4
-- Dumped by pg_dump version 15.4

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

--
-- Name: public; Type: SCHEMA; Schema: -; Owner: dante
--

-- *not* creating schema, since initdb creates it


ALTER SCHEMA public OWNER TO dante;

--
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: dante
--

COMMENT ON SCHEMA public IS '';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: branch; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.branch (
    id_branch uuid NOT NULL,
    cep character varying(255),
    city character varying(255),
    name character varying(255),
    number integer,
    state character varying(255),
    street character varying(255)
);


ALTER TABLE public.branch OWNER TO postgres;

--
-- Name: client; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.client (
    id_client uuid NOT NULL,
    name character varying(60) NOT NULL
);


ALTER TABLE public.client OWNER TO postgres;

--
-- Name: client_contact; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.client_contact (
    phone_number character varying(255) NOT NULL,
    ddd character varying(255) NOT NULL,
    id_client uuid NOT NULL
);


ALTER TABLE public.client_contact OWNER TO postgres;

--
-- Name: product; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.product (
    id_product uuid NOT NULL,
    brand character varying(50) NOT NULL,
    description character varying(255),
    name character varying(100) NOT NULL,
    price numeric(16,4),
    id_product_cat uuid
);


ALTER TABLE public.product OWNER TO postgres;

--
-- Name: product_cat; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.product_cat (
    id_product_cat uuid NOT NULL,
    description character varying(255),
    name character varying(30) NOT NULL
);


ALTER TABLE public.product_cat OWNER TO postgres;

--
-- Name: sale; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.sale (
    id_sale uuid NOT NULL,
    id_branch uuid,
    id_client uuid,
    id_seller uuid
);


ALTER TABLE public.sale OWNER TO postgres;

--
-- Name: sale_product; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.sale_product (
    id_product uuid NOT NULL,
    id_sale uuid NOT NULL,
    quantity integer NOT NULL
);


ALTER TABLE public.sale_product OWNER TO postgres;

--
-- Name: seller; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.seller (
    id_seller uuid NOT NULL,
    name character varying(60) NOT NULL
);


ALTER TABLE public.seller OWNER TO postgres;

--
-- Name: stock; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.stock (
    id_branch uuid NOT NULL,
    id_product uuid NOT NULL,
    quantity integer NOT NULL
);


ALTER TABLE public.stock OWNER TO postgres;

--
-- Data for Name: branch; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.branch (id_branch, cep, city, name, number, state, street) FROM stdin;
\.


--
-- Data for Name: client; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.client (id_client, name) FROM stdin;
\.


--
-- Data for Name: client_contact; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.client_contact (phone_number, ddd, id_client) FROM stdin;
\.


--
-- Data for Name: product; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.product (id_product, brand, description, name, price, id_product_cat) FROM stdin;
aef24f5c-6bd3-42bc-bdd8-96ca244220f8	SEPHORA	Batom de primeira qualidade não testado em animais!	Batom roxo	10.2000	\N
e610b198-2605-4a58-b93e-bbb593d64532	SEPHORA	Batom barato não testado em animais!	Batom rosa	2.2000	\N
e28943ed-6998-4136-93aa-a2adca59e8aa	SEPHORA	Batom mais ou menos não testado em animais!	Batom verde	2.2000	\N
df6cd4d1-e842-4a16-b154-941258ca189e	SEPHORA	Batom raridade no mercado não testado em animais!	Batom vermelho	50.2000	4e618e3a-23d3-496e-b9c4-206f536cc603
\.


--
-- Data for Name: product_cat; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.product_cat (id_product_cat, description, name) FROM stdin;
4e618e3a-23d3-496e-b9c4-206f536cc603		Maquiagem
b83d84d8-5365-4d21-b6f1-b8b1f0f41bf6		Skincare
232eab2d-e360-4fd2-b80b-65f42432726b		Cabelo
af064d9d-a81d-48bc-8f6f-989ccaf8a5cf		Perfume
1dec4099-e1cf-4e91-92ee-523d688b78bc		Pinceis e Ferramentas
4bc73d33-db7a-4280-ac54-12b9295013c5		Corpo e Banho
\.


--
-- Data for Name: sale; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.sale (id_sale, id_branch, id_client, id_seller) FROM stdin;
\.


--
-- Data for Name: sale_product; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.sale_product (id_product, id_sale, quantity) FROM stdin;
\.


--
-- Data for Name: seller; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.seller (id_seller, name) FROM stdin;
\.


--
-- Data for Name: stock; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.stock (id_branch, id_product, quantity) FROM stdin;
\.


--
-- Name: branch branch_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.branch
    ADD CONSTRAINT branch_pkey PRIMARY KEY (id_branch);


--
-- Name: client_contact client_contact_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.client_contact
    ADD CONSTRAINT client_contact_pkey PRIMARY KEY (id_client, ddd, phone_number);


--
-- Name: client client_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.client
    ADD CONSTRAINT client_pkey PRIMARY KEY (id_client);


--
-- Name: product_cat product_cat_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product_cat
    ADD CONSTRAINT product_cat_pkey PRIMARY KEY (id_product_cat);


--
-- Name: product product_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product
    ADD CONSTRAINT product_pkey PRIMARY KEY (id_product);


--
-- Name: sale sale_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sale
    ADD CONSTRAINT sale_pkey PRIMARY KEY (id_sale);


--
-- Name: sale_product sale_product_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sale_product
    ADD CONSTRAINT sale_product_pkey PRIMARY KEY (id_product, id_sale);


--
-- Name: seller seller_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.seller
    ADD CONSTRAINT seller_pkey PRIMARY KEY (id_seller);


--
-- Name: stock stock_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.stock
    ADD CONSTRAINT stock_pkey PRIMARY KEY (id_branch, id_product);


--
-- Name: sale_product fk6lbr0ga8i5rqojsxjrirg1ji; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sale_product
    ADD CONSTRAINT fk6lbr0ga8i5rqojsxjrirg1ji FOREIGN KEY (id_product) REFERENCES public.product(id_product);


--
-- Name: client_contact fk6regq01mxvvqpbccj28wr28vc; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.client_contact
    ADD CONSTRAINT fk6regq01mxvvqpbccj28wr28vc FOREIGN KEY (id_client) REFERENCES public.client(id_client);


--
-- Name: sale fka3snnn1kxdye45qhqb6pfv0jg; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sale
    ADD CONSTRAINT fka3snnn1kxdye45qhqb6pfv0jg FOREIGN KEY (id_client) REFERENCES public.client(id_client);


--
-- Name: sale fkbkfcbr32i74mp2hf53g5cvd6y; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sale
    ADD CONSTRAINT fkbkfcbr32i74mp2hf53g5cvd6y FOREIGN KEY (id_seller) REFERENCES public.seller(id_seller);


--
-- Name: stock fkcxv2cobg6lwqav3aidjq54uge; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.stock
    ADD CONSTRAINT fkcxv2cobg6lwqav3aidjq54uge FOREIGN KEY (id_product) REFERENCES public.product(id_product);


--
-- Name: sale_product fkkqfmbm2nlf70uwxibcd4jai63; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sale_product
    ADD CONSTRAINT fkkqfmbm2nlf70uwxibcd4jai63 FOREIGN KEY (id_sale) REFERENCES public.sale(id_sale);


--
-- Name: product fkn0el11eac3ssxo6sk9tshh9yk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product
    ADD CONSTRAINT fkn0el11eac3ssxo6sk9tshh9yk FOREIGN KEY (id_product_cat) REFERENCES public.product_cat(id_product_cat);


--
-- Name: sale fkn234epx03d8yi1fk5n86nflly; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sale
    ADD CONSTRAINT fkn234epx03d8yi1fk5n86nflly FOREIGN KEY (id_branch) REFERENCES public.branch(id_branch);


--
-- Name: stock fkoxhggudhw6j81hk3clr2smi74; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.stock
    ADD CONSTRAINT fkoxhggudhw6j81hk3clr2smi74 FOREIGN KEY (id_branch) REFERENCES public.branch(id_branch);


--
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: dante
--

REVOKE USAGE ON SCHEMA public FROM PUBLIC;


--
-- PostgreSQL database dump complete
--

