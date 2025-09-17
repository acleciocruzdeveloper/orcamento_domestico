CREATE SCHEMA IF NOT EXISTS budget_service;

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

--- ITEM TABLE
CREATE TABLE budget_service.item (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    item_name VARCHAR(100) NOT NULL,
    price NUMERIC(5,2) NOT NULL DEFAULT 0.00,
    mark VARCHAR(3) NOT NULL,
    amount NUMERIC(5,2) NOT NULL DEFAULT 0.00
);