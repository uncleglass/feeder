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

--changeset uncleglass:2

ALTER TABLE day_menu_meals
    RENAME TO day_menus_meals;

--changeset uncleglass:3

DROP TABLE day_menus_meals;

CREATE TABLE day_menus_meals
(
    day_menu_id  uuid NOT NULL,
    meals_id      uuid NOT NULL,
    meals_key integer,
    FOREIGN KEY (day_menu_id) REFERENCES day_menus (id),
    FOREIGN KEY (meals_id) REFERENCES meals (id)
);