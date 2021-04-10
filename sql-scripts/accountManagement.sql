CREATE DATABASE account

USE account

CREATE TABLE user (
  id BIGINT NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(20),
  last_name VARCHAR(20),
  email VARCHAR(50),
  password VARCHAR(50), 
  PRIMARY KEY (id),
  UNIQUE KEY (email)
)

CREATE TABLE account (
  id BIGINT NOT NULL AUTO_INCREMENT,
  currency VARCHAR(10),
  balance FLOAT(14, 2),
  holder_id BIGINT,
  PRIMARY KEY (id),
  FOREIGN KEY (holder_id) REFERENCES user(id)
)

CREATE TABLE deposit (
  id BIGINT NOT NULL AUTO_INCREMENT,
  amount DECIMAL,
  account_id BIGINT,
  PRIMARY KEY (id),
  FOREIGN KEY (account_id) REFERENCES account(id)
)

CREATE TABLE transaction (
  id BIGINT NOT NULL AUTO_INCREMENT,
  amount DECIMAL,
  currency VARCHAR(10),
  PRIMARY KEY (id),
  sender_id BIGINT,
  receiver_id BIGINT,
  FOREIGN KEY (sender_id) REFERENCES account(id),
  FOREIGN KEY (receiver_id) REFERENCES account(id)
)

SELECT * FROM user
SELECT * FROM account
SELECT * FROM deposit
SELECT * FROM transaction

DROP TABLE user
DROP TABLE account
DROP TABLE deposit
DROP TABLE transaction

DROP DATABASE account
