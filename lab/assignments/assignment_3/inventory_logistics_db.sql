CREATE DATABASE IF NOT EXISTS `inventory_logistics` DEFAULT CHARACTER SET utf8;
USE `inventory_logistics`;

DROP TABLE IF EXISTS `customers`;

CREATE TABLE `customers`
(
    `customer_id` int(11) NOT NULL AUTO_INCREMENT,
    `last_name`   varchar(45) DEFAULT NULL,
    `first_name`  varchar(45) DEFAULT NULL,
    `afm`         varchar(45) DEFAULT NULL,
    `telephone`   varchar(45) DEFAULT NULL,
    PRIMARY KEY (`customer_id`),
    UNIQUE KEY ` idCustomer_UNIQUE` (`customer_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 7
  DEFAULT CHARSET = utf8;

INSERT INTO `customers` (`customer_id`, `last_name`, `first_name`, `afm`, `telephone`)
VALUES (1, 'Powlowski', 'Jordi', '4', '+13(7)5601732875');
INSERT INTO `customers` (`customer_id`, `last_name`, `first_name`, `afm`, `telephone`)
VALUES (2, 'Wiegand', 'Adolphus', '6', '(150)732-6419x43922');
INSERT INTO `customers` (`customer_id`, `last_name`, `first_name`, `afm`, `telephone`)
VALUES (3, 'Koelpin', 'Nicolas', '9', '639-131-9929');
INSERT INTO `customers` (`customer_id`, `last_name`, `first_name`, `afm`, `telephone`)
VALUES (4, 'Windler', 'Morgan', '7', '(656)947-1894x619');
INSERT INTO `customers` (`customer_id`, `last_name`, `first_name`, `afm`, `telephone`)
VALUES (5, 'Kuvalis', 'Fay', '1', '(515)350-6121');
INSERT INTO `customers` (`customer_id`, `last_name`, `first_name`, `afm`, `telephone`)
VALUES (6, 'Konopelski', 'Tito', '2', '152.716.2056');

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
  AUTO_INCREMENT = 7
  DEFAULT CHARSET = utf8;

INSERT INTO `inventory` (`inventory_id`, `category`, `description`, `price`, `quantity`)
VALUES (1, 'Molestiae consequuntur consequatur voluptas a', 'Labore necessitatibus est praesentium ratione', 1, 4588);
INSERT INTO `inventory` (`inventory_id`, `category`, `description`, `price`, `quantity`)
VALUES (2, 'Aperiam et dicta ab.', 'Magnam laboriosam ipsa ex neque. Ut sunt nemo', 835, 149);
INSERT INTO `inventory` (`inventory_id`, `category`, `description`, `price`, `quantity`)
VALUES (3, 'Laborum nihil sapiente iusto odio est laborum', 'Harum nihil facilis minima commodi. Rerum iur', 92, 459);
INSERT INTO `inventory` (`inventory_id`, `category`, `description`, `price`, `quantity`)
VALUES (4, 'Consectetur ipsam sed dolorum voluptate minim', 'Dicta omnis corrupti officia libero. Minima h', 6612546,
        58913050);
INSERT INTO `inventory` (`inventory_id`, `category`, `description`, `price`, `quantity`)
VALUES (5, 'Enim dolorum pariatur dolorem beatae fuga dol', 'Fugit ipsa nihil consequatur eligendi. Numqua', 9526,
        6290112);
INSERT INTO `inventory` (`inventory_id`, `category`, `description`, `price`, `quantity`)
VALUES (6, 'Ab illum ut optio repellat.', 'Provident et aliquam ut. Magnam itaque enim v', 8854, 33364);

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders`
(
    `order_id`  int(11) NOT NULL AUTO_INCREMENT,
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
  AUTO_INCREMENT = 19
  DEFAULT CHARSET = utf8;

INSERT INTO `orders` (`order_id`, `customer_id`, `inventory_id`, `quantity`, `price`)
VALUES (13, 1, 1, 6, 0);
INSERT INTO `orders` (`order_id`, `customer_id`, `inventory_id`, `quantity`, `price`)
VALUES (14, 2, 2, 2, 1541258);
INSERT INTO `orders` (`order_id`, `customer_id`, `inventory_id`, `quantity`, `price`)
VALUES (15, 3, 3, 4330, 311);
INSERT INTO `orders` (`order_id`, `customer_id`, `inventory_id`, `quantity`, `price`)
VALUES (16, 4, 4, 38797311, 436581);
INSERT INTO `orders` (`order_id`, `customer_id`, `inventory_id`, `quantity`, `price`)
VALUES (17, 5, 5, 3624759, 486751);
INSERT INTO `orders` (`order_id`, `customer_id`, `inventory_id`, `quantity`, `price`)
VALUES (18, 6, 6, 6059453, 0);
