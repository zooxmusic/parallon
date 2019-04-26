insert into customer(id, name) values (1, 'Jim Smith');
insert into customer(id, name) values (2, 'Joe Doe');
insert into customer(id, name) values (3, 'Tara Sold');

insert into account(id, name, balance) values (100, 'Jims Checking', 1000);
insert into account(id, name, balance) values (101, 'Jims Savings', 500);
insert into account(id, name, balance) values (200, 'Joes Savings', 2000);
insert into account(id, name, balance) values (300, 'Taras Checking', 3000);

insert into customer_accounts(id, customer_id, accounts_id) values (1000, 1, 100);
insert into customer_accounts(id, customer_id, accounts_id) values (1001, 1, 101);
insert into customer_accounts(id, customer_id, accounts_id) values (2000, 2, 200);
insert into customer_accounts(id, customer_id, accounts_id) values (3000, 3, 300);
