--liquibase formatted sql
--changeset uncleglass:1

CREATE
EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE test_table
(
    id     uuid         NOT NULL DEFAULT uuid_generate_v4(),
    name   varchar(255) NOT NULL,
    PRIMARY KEY (id)
);
