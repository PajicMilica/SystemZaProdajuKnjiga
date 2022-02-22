/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 10.4.18-MariaDB : Database - database
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bookmark` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `bookmark`;



DROP TABLE IF EXISTS `Administrator`;

CREATE TABLE `Administrator` (
  `AdministratorID` BIGINT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `Ime` VARCHAR(20) NOT NULL,
  `Prezime` VARCHAR(30) NOT NULL,
  `Username` VARCHAR(20) NOT NULL,
  `Password` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`AdministratorID`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;



INSERT  INTO `Administrator`(`AdministratorID`,`Ime`,`Prezime`,`Username`,`Password`) VALUES 
(1,'Milica','Pajic','milica','milica123'),
(2,'Aleksandra','Pajic','aleks','aleks123');


DROP TABLE IF EXISTS `Kupac`;

CREATE TABLE `Kupac` (
  `KupacID` BIGINT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `ImeKupca` VARCHAR(20) NOT NULL,
  `PrezimeKupca` VARCHAR(30) NOT NULL,
  `Email` VARCHAR(50) NOT NULL,
  `TipKupca` VARCHAR(30),
  PRIMARY KEY (`KupacID`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;


INSERT  INTO `Kupac`(`KupacID`,`ImeKupca`,`PrezimeKupca`,`Email`, `TipKupca`) VALUES 
(1,'Aleksandra', 'Mitic', 'aleksandra@gmail.com', 'PREMIUM'),
(2,'Sofija', 'Milovanovic', 'sofija@gmail.com', 'PREMIUM PLUS'),
(3,'Nevena', 'Mitrovic', 'nevena@gmail.com', 'FREE');

DROP TABLE IF EXISTS `Zanr`;


CREATE TABLE `Zanr` (
  `ZanrID` BIGINT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `NazivZanra` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`ZanrID`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;


INSERT  INTO `Zanr`(`ZanrID`,`NazivZanra`) VALUES 
(1,'Religija i mitologija'),
(2,'Popularna psihologija'),
(3,'Licne finansije, preduzetnistvo, biznis, investiranje, ekonomija');


DROP TABLE IF EXISTS `Knjiga`;

CREATE TABLE `Knjiga` (
  `KnjigaID` BIGINT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `NazivKnjige` VARCHAR(70) NOT NULL,
  `Pisac` VARCHAR(70) NOT NULL,
  `Opis` VARCHAR(300) NOT NULL,
  `CenaKnjige` INT(7) NOT NULL,
  `Izdanje` INT(7) NOT NULL,
  `ZanrID` BIGINT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`KnjigaID`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;


INSERT  INTO `Knjiga`(`KnjigaID`,`NazivKnjige`,`Pisac`,`Opis`,`CenaKnjige`, `Izdanje`,`ZanrID`) VALUES 
(1,'Cetiri sporazuma', 'Don Miguel Ruis', 'Ovo je knjiga s kakvom se čovek zapadne civilizacije ne sreće često.', 700, 2005,1),
(2,'Budni u 5', 'Robin S. Sharma', 'Knjiga o povecanju produktivnosti, poboljsavanju zdravstevnog stanja i cuvanja smirenosti.', 900, 2010,2),
(3,'Bogati otac, siromasni otac', 'Robert Kiosaki i Seron Lehter', 'Knjiga o tome kako postati bogati preduzetnik.', 1000, 2013,3),
(4,'Kaludjer koji je prodao svog ferarija', 'Robin Sharma','Uh, mnogo dobra.', 1200, 2018, 3);


DROP TABLE IF EXISTS `Porudzbina`;

CREATE TABLE `Porudzbina` (
  `PorudzbinaID` BIGINT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `DatumVreme` DATETIME NOT NULL,
  `DatumIsporuke` DATE NOT NULL,
  `Grad` VARCHAR(30) NOT NULL,
  `Adresa` VARCHAR(70) NOT NULL,
  `Cena` DECIMAL(10,2) NOT NULL,
  `Popust` DECIMAL(10,2) NOT NULL,
  `KonacnaCena` DECIMAL(10,2) NOT NULL,
  `KupacID` BIGINT(10) UNSIGNED NOT NULL,
  `AdministratorID` BIGINT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`PorudzbinaID`),
  CONSTRAINT `fk_kupac_id` FOREIGN KEY (`KupacID`) REFERENCES `Kupac` (`KupacID`),
  CONSTRAINT `fk_administrator_id` FOREIGN KEY (`AdministratorID`) REFERENCES `Administrator` (`AdministratorID`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


INSERT  INTO `Porudzbina`(`PorudzbinaID`,`DatumVreme`,`DatumIsporuke`,`Grad`,`Adresa`,`Cena`,`Popust`,`KonacnaCena`,`KupacID`,`AdministratorID`) VALUES 
(1,'2021-12-20 14:33:44','2021-12-25','Beograd','Bulevar oslobodjenja 153',2600,0,2600,1,1);


DROP TABLE IF EXISTS `StavkaPorudzbine`;

CREATE TABLE `StavkaPorudzbine` (
  `PorudzbinaID` BIGINT(10) UNSIGNED NOT NULL,
  `RbStavke` INT(7) NOT NULL,
  `Kolicina` INT(7) NOT NULL,
  `CenaStavke` DECIMAL(10,2) NOT NULL,
  `KnjigaID` BIGINT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`PorudzbinaID`,`RbStavke`),
  CONSTRAINT `fk_porudzbina_id` FOREIGN KEY (`PorudzbinaID`) REFERENCES `Porudzbina` (`PorudzbinaID`) ON DELETE CASCADE,
  CONSTRAINT `fk_knjiga_id` FOREIGN KEY (`KnjigaID`) REFERENCES `Knjiga` (`KnjigaID`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;



INSERT  INTO `StavkaPorudzbine`(`PorudzbinaID`,`RbStavke`,`Kolicina`,`CenaStavke`,`KnjigaID`) VALUES 
(1,1,1,700,1),
(1,2,1,900,2),
(1,3,1,1000,3);



/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
