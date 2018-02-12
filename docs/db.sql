CREATE SCHEMA `soatest` ;

CREATE TABLE `soatest`.`users` (
  `id` INT NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

ALTER TABLE `soatest`.`users` 
CHANGE COLUMN `id` `id` INT(11) NOT NULL AUTO_INCREMENT ;
