CREATE DATABASE IF NOT EXISTS `inventory_logistics` DEFAULT CHARACTER SET utf8;
USE `inventory_logistics`;

DROP TABLE IF EXISTS `customers`;
CREATE TABLE `customers`
(
    `customer_id`  int(11) NOT NULL AUTO_INCREMENT,
    `last_name`    varchar(45) DEFAULT NULL,
    `first_name`   varchar(45) DEFAULT NULL,
    `trn`          varchar(45) DEFAULT NULL,
    `phone_number` varchar(45) DEFAULT NULL,
    PRIMARY KEY (`customer_id`),
    UNIQUE KEY ` idCustomer_UNIQUE` (`customer_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `inventory`;
CREATE TABLE `inventory`
(
    `inventory_id` int(11) NOT NULL AUTO_INCREMENT,
    `category`     varchar(45) DEFAULT NULL,
    `description`  varchar(45) DEFAULT NULL,
    `price`        int(11)     DEFAULT NULL,
    `quantity`     int(11)     DEFAULT NULL,
    PRIMARY KEY (`inventory_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`
(
    `order_id`     int(11) NOT NULL AUTO_INCREMENT,
    `customer_id`  int(11) NOT NULL,
    `inventory_id` int(11) NOT NULL,
    `quantity`     int(11) NOT NULL,
    `price`        int(11) NOT NULL,
    PRIMARY KEY (`order_id`),
    UNIQUE KEY `purchase_id_UNIQUE` (`order_id`),
    KEY `fk_customer_idx` (`customer_id`),
    KEY `fk_inventory_idx` (`inventory_id`),
    CONSTRAINT `fk_customer` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`customer_id`),
    CONSTRAINT `fk_inventory` FOREIGN KEY (`inventory_id`) REFERENCES `inventory` (`inventory_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;

SET FOREIGN_KEY_CHECKS = 0;
INSERT INTO customers (last_name, first_name, trn, phone_number)
VALUES ('Meyas', 'Alex', '000000000', '00000000000'),
       ('Dodos', 'Totos', '123123123', '1234512345'),
       ('Norris', 'Chuck', '999999999', '9999999999'),
       ('Zamayias', 'Mike', '321321321', '5432154321');
INSERT INTO inventory (category, description, price, quantity)
VALUES ('CPU', 'Ryzen 9', 600, 2),
       ('Supercomputer', 'DGX A100', 300000, 1),
       ('GPU', '3060 Ti', 700, 3),
       ('SoC', 'M1', 400, 10);
INSERT INTO orders (customer_id, inventory_id, quantity, price)
VALUES (2, 2, 1, 300000),
       (1, 1, 1, 0),
       (1, 3, 1, 0),
       (3, 2, 99, 300000),
       (4, 4, 1, 400);
SET FOREIGN_KEY_CHECKS = 1;

SELECT *
FROM customers;
SELECT *
FROM inventory;
SELECT *
FROM orders;
