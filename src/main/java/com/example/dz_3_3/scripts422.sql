CREATE table users (
    name VARCHAR,
    age INTEGER,
    user_id INTEGER PRIMARY KEY,
    has_driver_licence BOOLEAN,
    car_id INTEGER REFERENCES cars (id)
);

CREATE table cars(
    brand VARCHAR,
    model VARCHAR,
    id INTEGER PRIMARY KEY,
    cost INTEGER
);