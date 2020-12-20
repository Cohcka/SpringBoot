BEGIN;

DROP TABLE IF EXISTS `HiberLesson`.`Product`;
CREATE TABLE `HiberLesson`.`Product` (
  `ID` BIGINT(20) NOT NULL,
  `title` VARCHAR(250) NULL,
  `price` INT NULL,
  PRIMARY KEY (`ID`));

COMMIT;