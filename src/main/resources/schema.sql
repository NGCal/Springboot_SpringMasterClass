DROP TABLE IF EXISTS PERSON;

CREATE TABLE person
(
    id         integer      not null,
    name       varchar(255) not null,
    location   varchar(255) not null,
    birth_date timestamp,
    PRIMARY KEY (id)
)