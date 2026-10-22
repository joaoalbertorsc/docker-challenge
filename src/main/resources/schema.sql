-- Runs on every startup against the in-memory H2 database, before data.sql
CREATE TABLE shows (
    id             VARCHAR(100)             PRIMARY KEY,
    title          VARCHAR(200)             NOT NULL,
    performer      VARCHAR(200)             NOT NULL,
    category       VARCHAR(50)              NOT NULL,
    venue          VARCHAR(200)             NOT NULL,
    city           VARCHAR(100)             NOT NULL,
    starts_at      TIMESTAMP WITH TIME ZONE NOT NULL,
    starting_price DECIMAL(10, 2)           NOT NULL,
    currency       VARCHAR(3)               NOT NULL
);
