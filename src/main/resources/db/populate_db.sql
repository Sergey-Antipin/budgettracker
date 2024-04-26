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
VALUES ('2024-02-02', -10000.00, 'RUB', 'всё пропил', 'expense', 'LEISURE', 100003),
       ('2024-02-02', -5000.00, 'RUB', '', 'expense', 'GROCERIES', 100004),
       ('2024-02-05', -2000.00, 'RUB', '', 'expense', 'CAR', 100004),
       ('2024-02-15', -3500.00, 'RUB', '', 'expense', 'CAR', 100004),
       ('2024-02-20', 100000.00, 'RUB', '', 'income', 'SALARY', 100004),
       ('2024-02-18', -30000.00, 'RUB', 'снятие наличных', 'expense', 'FINANCIAL_OPERATIONS', 100005),
       ('2024-02-18', 30000.00, 'RUB', 'снятие наличных', 'income', 'FINANCIAL_OPERATIONS', 100006),
       ('2024-03-08', -10000.00, 'RUB', 'подарки', 'expense', 'GIFTS', 100006);

INSERT INTO user_roles (user_id, role)
VALUES (100000, 'ROLE_ADMIN'),
       (100001, 'ROLE_USER'),
       (100002, 'ROLE_USER');

INSERT INTO user_expense_limits (user_id, expense_category, limit_amount, limit_currency)
VALUES (100001, 'CAR', -5000.00, 'RUB'),
       (100002, 'GIFTS', -10000.00, 'RUB');

