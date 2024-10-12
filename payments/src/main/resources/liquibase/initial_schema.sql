
create table if not exists payment
(
    transaction_id  bigserial NOT NULL  PRIMARY KEY,
    customer_id     bigserial NOT NULL,
    created_at      timestamp,
    amount          numeric,
    currency        varchar(10),
    status          varchar(20)
);

INSERT INTO payment (customer_id, created_at, amount, currency, status)
VALUES
    (1, '2024-10-01 14:30:00', 49.99, 'USD', 'Completed'),
    (2, '2024-09-25 09:15:00', 19.99, 'EUR', 'Completed'),
    (3, '2024-10-05 18:45:00', 99.99, 'USD', 'Pending'),
    (4, '2024-10-08 11:00:00', 29.99, 'GBP', 'Completed'),
    (5, '2024-09-30 20:00:00', 14.99, 'USD', 'Failed'),
    (1, '2024-10-10 13:25:00', 59.99, 'USD', 'Completed'),
    (3, '2024-10-02 16:00:00', 39.99, 'USD', 'Completed'),
    (5, '2024-10-07 09:40:00', 24.99, 'EUR', 'Pending'),
    (4, '2024-10-11 08:15:00', 79.99, 'GBP', 'Failed'),
    (2, '2024-10-09 15:30:00', 49.99, 'EUR', 'Completed');