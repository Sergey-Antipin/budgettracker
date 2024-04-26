DROP TABLE IF EXISTS user_expense_limits;
DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS operations;
DROP TABLE IF EXISTS accounts;
DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS global_seq CASCADE;

CREATE SEQUENCE global_seq START WITH 100000;

CREATE TABLE users
(
    id                INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    email             VARCHAR(255) UNIQUE               NOT NULL,
    password          VARCHAR(255)                      NOT NULL,
    registration_date DATE                DEFAULT now() NOT NULL
);
CREATE INDEX users_email_idx on users (email);

CREATE TABLE accounts
(
    id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    amount      NUMERIC(16, 4) NOT NULL,
    currency    CHAR(3)        NOT NULL,
    description VARCHAR(255),
    user_id     INTEGER        NOT NULL REFERENCES users (id) ON DELETE CASCADE
);
CREATE INDEX accounts_user_idx on accounts (user_id);

CREATE TABLE operations
(
    id          INTEGER PRIMARY KEY     DEFAULT nextval('global_seq'),
    date        DATE           NOT NULL,
    amount      NUMERIC(16, 4) NOT NULL,
    currency    VARCHAR(3)     NOT NULL,
    description VARCHAR(255),
    type        VARCHAR(7)     NOT NULL,
    category    VARCHAR(255)   NOT NULL DEFAULT 'OTHER',
    account_id  INTEGER        NOT NULL REFERENCES accounts (id) ON DELETE CASCADE
);
CREATE INDEX operations_account_date_idx on operations (account_id, date);

CREATE TABLE user_roles
(
    user_id INTEGER      NOT NULL REFERENCES users (id) ON DELETE CASCADE,
    role    VARCHAR(255) NOT NULL
);

CREATE TABLE user_expense_limits
(
    user_id          INTEGER        NOT NULL REFERENCES users (id) ON DELETE CASCADE,
    expense_category VARCHAR(255)   NOT NULL,
    limit_amount     NUMERIC(16, 4) NOT NULL,
    limit_currency   VARCHAR(3)     NOT NULL,
    PRIMARY KEY (user_id, expense_category)
);