CREATE DATABASE `it_incubator`

CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `surname` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `accounts` (
  `id` int NOT NULL AUTO_INCREMENT,
  `account` int NOT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*inserts for 'users'*/

INSERT INTO users (name, surname) VALUES ('Josephine', 'Huffman');
INSERT INTO users (name, surname) VALUES ('Maurice', 'Martz');
INSERT INTO users (name, surname) VALUES ('Royal', 'Cipriani');
INSERT INTO users (name, surname) VALUES ('Pasquale', 'Benavides');
INSERT INTO users (name, surname) VALUES ('Gidget', 'Hosch');
INSERT INTO users (name, surname) VALUES ('Lanell', 'Wenzel');
INSERT INTO users (name, surname) VALUES ('Fabian', 'Ooten');
INSERT INTO users (name, surname) VALUES ('Alexandria', 'Toothman');
INSERT INTO users (name, surname) VALUES ('Alena', 'Klar');
INSERT INTO users (name, surname) VALUES ('Laverne', 'Isler');

/*inserts for 'accounts'*/

INSERT INTO accounts (account, user_id) VALUES ('1111', '1');
INSERT INTO accounts (account, user_id) VALUES ('2222', '2');
INSERT INTO accounts (account, user_id) VALUES ('3333', '3');
INSERT INTO accounts (account, user_id) VALUES ('4444', '4');
INSERT INTO accounts (account, user_id) VALUES ('5555', '5');
INSERT INTO accounts (account, user_id) VALUES ('6666', '6');
INSERT INTO accounts (account, user_id) VALUES ('7777', '7');
INSERT INTO accounts (account, user_id) VALUES ('8888', '8');
INSERT INTO accounts (account, user_id) VALUES ('9999', '9');
INSERT INTO accounts (account, user_id) VALUES ('1010', '10');
