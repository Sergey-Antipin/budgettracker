DELETE
FROM user_expense_limits;
DELETE
FROM user_roles;
DELETE
FROM operations;
DELETE
FROM accounts;
DELETE
FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (email, password, registration_date)
VALUES ('admin@mail.ru', 'adminpassword', '2024-01-01'), /*id = 100000*/
       ('user1@mail.ru', 'user1password', '2024-01-02'),/*id = 100001*/
       ('user2@mail.ru', 'user2password', '2024-01-03'); /*id = 100002*/

INSERT INTO accounts (amount, currency, description, user_id)
VALUES (10000.00, 'RUB', 'admin account', 100000), /*id = 100003*/
       (20000.00, 'RUB', 'user1 account', 100001),/*id = 100004*/
       (50000.00, 'RUB', 'user2 bank account', 100002), /*id = 100005*/
       (30000.00, 'RUB', 'user2 cash account', 100002); /*id = 100006*/

INSERT INTO operations (date, amount, currency, description, type, category, account_id)
VALUES ('2024-02-02', -10000.00, 'RUB', 'всё пропил', 'expense', 'LEISURE', 100003), /*100007*/
       ('2024-02-02', -5000.00, 'RUB', '', 'expense', 'GROCERIES', 100004), /*100008*/
       ('2024-02-05', -2000.00, 'RUB', '', 'expense', 'CAR', 100004), /*100009*/
       ('2024-02-15', -3500.00, 'RUB', '', 'expense', 'CAR', 100004), /*100010*/
       ('2024-02-20', 100000.00, 'RUB', '', 'income', 'SALARY', 100004), /*100011*/
       ('2024-02-18', -30000.00, 'RUB', 'снятие наличных', 'expense', 'FINANCIAL_OPERATIONS', 100005), /*100012*/
       ('2024-02-18', 30000.00, 'RUB', 'снятие наличных', 'income', 'FINANCIAL_OPERATIONS', 100006), /*100013*/
       ('2024-03-08', -9000.00, 'RUB', 'подарки', 'expense', 'GIFTS', 100006), /*100014*/
       ('2024-03-09', -2000.00, 'RUB', 'еще подарки', 'expense', 'GIFTS', 100005); /*100015*/

INSERT INTO user_roles (user_id, role)
VALUES (100000, 'ADMIN'),
       (100001, 'USER'),
       (100002, 'USER');

INSERT INTO user_expense_limits (user_id, expense_category, amount, currency)
VALUES (100001, 'CAR', -5000.00, 'RUB'),
       (100002, 'GIFTS', -10000.00, 'RUB');

