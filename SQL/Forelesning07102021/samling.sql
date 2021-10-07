--Tutorial 15
DROP TABLE IF EXISTS accounts;
CREATE TABLE accounts (
    id PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    balance DEC(15,2) NOT NULL
);

--insert values
INSERT INTO accounts (name,balance)
VALUES('Bob',10000);


--begin transaction
BEGIN;
INSERT INTO accounts (name,balance)
VALUES('Alice',10000);

-- see values from current transaction
SELECT * FROM accounts;

-- commit transaction 
COMMIT; 

SELECT * FROM accounts;

-- Transfer example. 

BEGIN; 
UPDATE accounts
SET balance = balance - 1000
WHERE id=1;

-- Second session now, check balance on both accounts
SELECT * FROM accounts;

-- Add the $1000 to alice's acc
UPDATE accounts
SET balance = balance + 1000
WHERE id=2; 
COMMIT; 

-- now from any session we can see the changes.
SELECT * FROM accounts;

-- add a third person
INSERT INTO accounts (name,balance)
VALUES('Jack',0);
SELECT * FROM accounts;

-- Transfer from bob to jack 
BEGIN;

UPDATE accounts
SET balance = balance - 1500
WHERE id=1;

UPDATE accounts
SET balance = balance + 1500
WHERE id=3;

-- See our changes:
SELECT * FROM accounts;


-- discard the changes. 
ROLLBACK;

SELECT * FROM accounts;