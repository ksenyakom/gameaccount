
create table if not exists payment
(
    transaction_id  bigserial NOT NULL  PRIMARY KEY,
    customer_id     bigserial NOT NULL,
    created_at      timestamp,
    amount          numeric,
    currency        varchar(10),
    status          varchar(20)
);

-- //todo ask ai to generate data
-- INSERT INTO customer (login, password)
-- VALUES ('kitty', 'encoded password');
-- INSERT INTO customer (login, password)
-- VALUES ('puppy', 'encoded password');
-- INSERT INTO customer (login, password)
-- VALUES ('sweety', 'encoded password');