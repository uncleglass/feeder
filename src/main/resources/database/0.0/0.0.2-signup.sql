--liquibase formatted sql
--changeset uncleglass:1

CREATE TABLE users
(
    id     uuid         NOT NULL DEFAULT uuid_generate_v4(),
    username   varchar(255) NOT NULL,
    salt   varchar(255) NOT NULL,
    password   varchar(255) NOT NULL,
    PRIMARY KEY (id)
);
