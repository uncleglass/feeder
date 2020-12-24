--liquibase formatted sql
--changeset uncleglass:1

CREATE TABLE meals
(
    id          uuid NOT NULL DEFAULT uuid_generate_v4(),
    name        varchar(255),
    description text,
    notes       text,
    calories    integer,
    PRIMARY KEY (id)
);

CREATE TABLE meal_type
(
    meal_id     uuid NOT NULL,
    meal_type_id    integer,
    FOREIGN KEY (meal_id) REFERENCES meals(id)
);