
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

INSERT INTO customer (customer_id, login, password, email, date_registered, date_last_login, customer_role)
VALUES
    (1, 'john_doe', 'password123', 'john.doe@example.com', '2023-01-15 10:00:00', '2024-10-10 12:00:00', 'User'),
    (2, 'jane_smith', 'password456', 'jane.smith@example.com', '2022-05-21 09:30:00', '2024-10-09 15:30:00', 'Admin'),
    (3, 'alice_w', 'pass789', 'alice.w@example.com', '2023-03-12 08:45:00', '2024-09-30 14:00:00', 'User'),
    (4, 'bob_j', 'secret123', 'bob.j@example.com', '2021-07-08 11:20:00', '2024-08-15 11:00:00', 'Moderator'),
    (5, 'charlie_m', 'pass987', 'charlie.m@example.com', '2020-12-01 14:10:00', '2024-10-01 16:45:00', 'User');

-- Вставка тестовых данных в таблицу customer_info
INSERT INTO customer_info (id, customer_id, customer_name, date_birth)
VALUES
    (1, 1, 'John Doe', '1990-04-25 00:00:00'),
    (2, 2, 'Jane Smith', '1985-09-14 00:00:00'),
    (3, 3, 'Alice White', '1992-06-07 00:00:00'),
    (4, 4, 'Bob Johnson', '1980-11-22 00:00:00'),
    (5, 5, 'Charlie Miller', '1995-03-30 00:00:00');

-- //todo ask ai to generate data
-- INSERT INTO customer (login, password)
-- VALUES ('kitty', 'encoded password');
-- INSERT INTO customer (login, password)
-- VALUES ('puppy', 'encoded password');
-- INSERT INTO customer (login, password)
-- VALUES ('sweety', 'encoded password');