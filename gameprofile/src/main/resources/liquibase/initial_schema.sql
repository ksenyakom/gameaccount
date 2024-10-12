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
    inventory_id   bigserial   NOT NULL PRIMARY KEY,
    inventory_name varchar(50) NOT NULL,
    inventory_type varchar(50),
    rarity    varchar(50)
);

create table if not exists customer_inventory
(
    id          bigserial NOT NULL PRIMARY KEY,
    inventory_id     bigserial NOT NULL,
    customer_id bigserial NOT NULL,
    inventory_count  int       NOT NULL default 0,
    consumable  boolean            default false
);

INSERT INTO inventory (inventory_name, inventory_type, rarity)
VALUES
    ('Steel Sword', 'Weapon', 'Common'),
    ('Iron Shield', 'Armor', 'Uncommon'),
    ('Health Potion', 'Consumable', 'Rare'),
    ('Magic Wand', 'Weapon', 'Epic'),
    ('Leather Boots', 'Armor', 'Common'),
    ('Elixir of Strength', 'Consumable', 'Rare'),
    ('Golden Helmet', 'Armor', 'Legendary'),
    ('Bow of the Phoenix', 'Weapon', 'Legendary'),
    ('Mana Potion', 'Consumable', 'Common'),
    ('Dwarven Axe', 'Weapon', 'Uncommon');


INSERT INTO customer_inventory (inventory_id, customer_id, inventory_count, consumable)
VALUES
    (1, 1, 5, true),  -- John Doe имеет 5 Health Potions
    (2, 1, 1, false), -- John Doe имеет 1 Steel Sword
    (3, 2, 3, true),  -- Jane Smith имеет 3 Mana Potions
    (4, 2, 2, false), -- Jane Smith имеет 2 Magic Wands
    (5, 3, 1, false), -- Alice White имеет 1 Iron Shield
    (6, 3, 2, true),  -- Alice White имеет 2 Elixirs of Strength
    (7, 4, 1, false), -- Bob Johnson имеет 1 Golden Helmet
    (8, 4, 1, false), -- Bob Johnson имеет 1 Dwarven Axe
    (9, 5, 10, true), -- Charlie Miller имеет 10 Health Potions
    (10, 5, 1, false);-- Charlie Miller имеет 1 Bow of the Phoenix


INSERT INTO customer_game_profile (customer_id, game_level, experience, game_currency_balance)
VALUES
    (1, 15, 1200, 500),  -- John Doe имеет 15 уровень, 1200 опыта и 500 игровой валюты
    (2, 20, 2500, 1500), -- Jane Smith имеет 20 уровень, 2500 опыта и 1500 игровой валюты
    (3, 10, 800, 200),   -- Alice White имеет 10 уровень, 800 опыта и 200 игровой валюты
    (4, 25, 3200, 2000), -- Bob Johnson имеет 25 уровень, 3200 опыта и 2000 игровой валюты
    (5, 12, 1100, 750);  -- Charlie Miller имеет 12 уровень, 1100 опыта и 750 игровой валюты
