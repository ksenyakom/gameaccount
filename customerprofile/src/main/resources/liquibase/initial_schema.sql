
create table if not exists customer
(
    customer_id     int NOT NULL PRIMARY KEY,
    login           varchar(50),
    password        varchar(50),
    email           varchar(50),
    date_registered timestamp,
    date_last_login timestamp,
    customer_role            varchar(50)
);

create table if not exists customer_info
(
    id          int NOT NULL PRIMARY KEY,
    customer_id int NOT NULL,
    customer_name        varchar(50),
    date_birth  timestamp,
    CONSTRAINT uc_customer UNIQUE (customer_id)
);

-- //todo ask ai to generate data
-- INSERT INTO customer (login, password)
-- VALUES ('kitty', 'encoded password');
-- INSERT INTO customer (login, password)
-- VALUES ('puppy', 'encoded password');
-- INSERT INTO customer (login, password)
-- VALUES ('sweety', 'encoded password');