create table if not exists customer_game_profile
(
    profile_id            bigserial NOT NULL PRIMARY KEY,
    customer_id           bigserial NOT NULL,
    game_level            int       NOT NULL default 0,
    experience            int       NOT NULL default 0,
    game_currency_balance int       NOT NULL default 0
);

create table if not exists inventory
(
    item_id   bigserial   NOT NULL PRIMARY KEY,
    item_name varchar(50) NOT NULL,
    item_type varchar(50),
    rarity    varchar(50)
);

create table if not exists customer_inventory
(
    id          bigserial NOT NULL PRIMARY KEY,
    item_id     bigserial NOT NULL,
    customer_id bigserial NOT NULL,
    item_count  int       NOT NULL default 0,
    consumable  boolean            default false
);


-- //todo ask ai to generate data
-- INSERT INTO customer (login, password)
-- VALUES ('kitty', 'encoded password');
-- INSERT INTO customer (login, password)
-- VALUES ('puppy', 'encoded password');
-- INSERT INTO customer (login, password)
-- VALUES ('sweety', 'encoded password');