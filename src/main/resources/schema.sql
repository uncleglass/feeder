CREATE TABLE meals
(
--     change below column to serial in Postgres
    id          integer AUTO_INCREMENT,
    name        varchar(255),
    description varchar,
    notes       varchar,
    calories    integer,
    PRIMARY KEY (id)
);

CREATE TABLE meal_type
(
    meal_id     integer NOT NULL,
    meal_type_id    integer NOT NULL,
    PRIMARY KEY (meal_id, meal_type_id), FOREIGN KEY (meal_id) REFERENCES meals(id)
);