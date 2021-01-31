CREATE TABLE meals
(
    id          integer identity,
    name        varchar(255),
    description text,
    notes       text,
    calories    integer,
    PRIMARY KEY (id)
);

CREATE TABLE meal_type
(
    meal_id     integer NOT NULL,
    meal_type_id    integer NOT NULL,
    PRIMARY KEY (meal_id, meal_type_id), FOREIGN KEY (meal_id) REFERENCES meals(id)
);