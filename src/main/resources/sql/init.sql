create table if not exists users
(
    id         INTEGER NOT NULL DEFAULT nextval('user_seq') PRIMARY KEY,
    firstname  varchar(20),
    secondname varchar(20),
    age        int


);


CREATE SEQUENCE user_seq
    START WITH 1
    INCREMENT BY 1;

