--CREATE DATABASE IF NOT EXISTS local;

ALTER DATABASE local OWNER TO postgres;

CREATE SCHEMA IF NOT EXISTS ecommerce AUTHORIZATION postgres;

\c local
\c
SET search_path TO ecommerce;