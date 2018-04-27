CREATE SCHEMA `comp303project`;

USE `comp303project`;

CREATE TABLE `comp303project`.`authors` (
  `authorId` INT NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(45) NOT NULL,
  `lastName` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`authorId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;

CREATE TABLE `comp303project`.`genres` (
  `genreId` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`genreId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;

CREATE TABLE `comp303project`.`details` (
  `detailId` INT NOT NULL AUTO_INCREMENT,
  `summary` VARCHAR(1000) NOT NULL,
  PRIMARY KEY (`detailId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;

CREATE TABLE `comp303project`.`books` (
  `bookId` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `publishDate` DATE NOT NULL,
  `isbn` VARCHAR(45) NOT NULL,
  `rating` INT NULL,
  `detailId` INT,
  PRIMARY KEY (`bookId`),
  CONSTRAINT `FK_Books_Detail`
    FOREIGN KEY (`detailId`)
    REFERENCES `comp303project`.`details` (`detailId`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;

CREATE TABLE `comp303project`.`bookauthors` (
  `bookId` INT NOT NULL,
  `authorId` INT NOT NULL,
  PRIMARY KEY (`bookId`, `authorId`),
  CONSTRAINT `FK_BookAuthors_Book`
    FOREIGN KEY (`bookId`)
    REFERENCES `comp303project`.`books` (`bookId`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `FK_BookAuthors_Author`
  	FOREIGN KEY (`authorId`)
  	REFERENCES `comp303project`.`authors` (`authorId`)
  	ON DELETE RESTRICT
  	ON UPDATE RESTRICT);

CREATE TABLE `comp303project`.`bookgenres` (
  `bookId` INT NOT NULL,
  `genreId` INT NOT NULL,
  PRIMARY KEY (`bookId`, `genreId`),
  INDEX `FK_BookGenres_Genre_idx` (`genreId` ASC),
  CONSTRAINT `FK_BookGenres_Book`
    FOREIGN KEY (`bookId`)
    REFERENCES `comp303project`.`books` (`bookId`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `FK_BookGenres_Genre`
    FOREIGN KEY (`genreId`)
    REFERENCES `comp303project`.`genres` (`genreId`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT);


CREATE TABLE `comp303project`.`inventory` (
	`inventoryId` INT NOT NULL AUTO_INCREMENT,
    `quantity` INT NOT NULL,
    `price` DECIMAL(9,2) NOT NULL,
    PRIMARY KEY (`inventoryId`)  
);

CREATE TABLE transaction(
 transactionId INT NOT NULL AUTO_INCREMENT,
 bookId INT NOT NULL,
 quantity INT,
 amount FLOAT,
 user VARCHAR(20),
 date DateTime,
 PRIMARY KEY(transactionId)
);

CREATE TABLE user(
id INT NOT NULL AUTO_INCREMENT,
userName VARCHAR(20),
password VARCHAR(20),
role VARCHAR(10),
PRIMARY KEY(id)

);
/*Alter command*/
ALTER TABLE books ADD inventoryId INT NOT NULL;

CREATE TABLE `comp303project`.`history` (
  `historyId` INT NOT NULL AUTO_INCREMENT,
  `bookId` INT NOT NULL,
  `date` DATETIME NOT NULL,
  `ip` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`historyId`),
  INDEX `FK_History_Book_idx` (`bookId` ASC),
  CONSTRAINT `FK_History_Book`
    FOREIGN KEY (`bookId`)
    REFERENCES `comp303project`.`books` (`bookId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;

