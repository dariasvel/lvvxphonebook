PhoneBook App 

It was developed using Java 8, Spring 4, mySQL 8 and Apache Tomcat 8.5.
It requires a mySQL DB. DB access can be configured in the "spring-context.xml"
DB Name: daphoneb
Table: contact
DB backup file: diagram/PBDB20180712.sql

 This app uses Maven for dependency management. 
 In developer mode, before running the app on server, 
 please make sure all Maven Dependencies are in the build path.
 You can check this as follows:
 - Right click on the project --> Build Path --> Configure Build Path ...
   Go to Libraries tab and make sure you see "Maven Dependencies"
   
- To add Maven Depencies, you ca do either:
  Right click on the Project --> Maven --> Update Project
  or
  Right click on the project --> Build Path --> Configure Build Path ...
  Go to Libraries tab --> Add Library --> select  Maven Managed Dependencies.
  
contact Table creation script:

CREATE TABLE `daphoneb`.`contact` (
  `c_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `phone_number` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`c_id`),
  INDEX `fnidx` (`first_name` ASC),
  INDEX `lnidx` (`last_name` ASC),
  INDEX `pnidx` (`phone_number` ASC),
  UNIQUE INDEX `unidx` (`first_name` ASC, `last_name` ASC, `phone_number` ASC))
  ENGINE=InnoDB  DEFAULT CHARSET=utf8;
 
