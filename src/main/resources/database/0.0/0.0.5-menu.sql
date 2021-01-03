--liquibase formatted sql
--changeset uncleglass:1

CREATE TABLE day_menus
(
    id   uuid NOT NULL DEFAULT uuid_generate_v4(),
    date date,
    PRIMARY KEY (id)
);

CREATE TABLE day_menu_meals
(
    day_menu_id  uuid NOT NULL,
    meal_id      uuid NOT NULL,
    meal_type_id integer,
    FOREIGN KEY (day_menu_id) REFERENCES day_menus (id),
    FOREIGN KEY (meal_id) REFERENCES meals (id)
);