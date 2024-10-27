DROP DATABASE IF EXISTS homework;
CREATE DATABASE homework;
use homework;

CREATE TABLE cats (
  id INT AUTO_INCREMENT PRIMARY KEY,
  type VARCHAR(20) NOT NULL,
  name VARCHAR(20) NOT NULL,
  birthDate DATE NOT NULL,
  commands TEXT
);
CREATE TABLE dogs (
  id INT AUTO_INCREMENT PRIMARY KEY,
  type VARCHAR(20) NOT NULL,
  name VARCHAR(20) NOT NULL,
  birthDate DATE NOT NULL,
  commands TEXT
);
CREATE TABLE humsters (
  id INT AUTO_INCREMENT PRIMARY KEY,
  type VARCHAR(20) NOT NULL,
  name VARCHAR(20) NOT NULL,
  birthDate DATE NOT NULL,
  commands TEXT
);
CREATE TABLE horses (
  id INT AUTO_INCREMENT PRIMARY KEY,
  type VARCHAR(20) NOT NULL,
  name VARCHAR(20) NOT NULL,
  birthDate DATE NOT NULL,
  commands TEXT
);
CREATE TABLE camels (
  id INT AUTO_INCREMENT PRIMARY KEY,
  type VARCHAR(20) NOT NULL,
  name VARCHAR(20) NOT NULL,
  birthDate DATE NOT NULL,
  commands TEXT
);
CREATE TABLE donkeys (
  id INT AUTO_INCREMENT PRIMARY KEY,
  type VARCHAR(20) NOT NULL,
  name VARCHAR(20) NOT NULL,
  birthDate DATE NOT NULL,
  commands TEXT
);

INSERT INTO cats(type,name,birthDate,commands) 
VALUES
('кот','Мурзик','2023-10-10','кис-кис'),
('кот','Мурка','2022-08-12','кис-кисб прыг'),
('кот','Франт','2024-05-29','играть');
INSERT INTO dogs(type,name,birthDate,commands) 
VALUES
('собака','Лорд','2018-03-14','ко мне, лапу, лежать'),
('собака','Гек','2018-03-27','ко мне, лапу, лежать'),
('собака','Зума','2010-11-30','ко мне, лапу, лежатьб служить, голос');
INSERT INTO humsters(type,name,birthDate,commands) 
VALUES
('хомяк','Рыжик','2024-02-7',''),
('хомяк','Пухлик','2024-03-26',''),
('хомяк','Топ','2023-12-31','');
INSERT INTO horses(type,name,birthDate,commands) 
VALUES
('лошадь','Плотва','2018-5-2','Но, Пошла, Ко мне'),
('лошадь','Сизый','2017-03-19','Но, Пошла, Ко мне'),
('лошадь','Молния','2018-07-13','Но, Пошла, Ко мне');
INSERT INTO camels(type,name,birthDate,commands) 
VALUES
('верблюд','Упрямец','2022-03-14','ко мне, лежать, стоять'),
('верблюд','Сластена','2013-06-27','ко мне, лежать, стоять'),
('верблюд','Топотун','2020-01-30','ко мне, лежать, стоять');
INSERT INTO donkeys(type,name,birthDate,commands) 
VALUES
('осел','Иа','2021-02-7','вперед, назад, стой'),
('осел','Ресничка','2020-03-26','вперед, назад, стой'),
('осел','Соня','2018-12-31','вперед, назад, стой');

-- Создаем таблицу домашних животных
DROP TEMPORARY TABLE IF EXISTS pets;
CREATE TEMPORARY TABLE pets
SELECT * FROM cats
UNION ALL
SELECT * FROM dogs
UNION ALL
SELECT * FROM humsters;

-- Создаем таблицу въючных животных
DROP TEMPORARY TABLE IF EXISTS pack_animals;
CREATE TEMPORARY TABLE pack_animals
SELECT * FROM horses
UNION ALL
SELECT * FROM camels
UNION ALL
SELECT * FROM donkeys;

#select * FROM pack_animals;

-- верблюд уехал
DELETE FROM pack_animals
WHERE type='верблюд';

#select * FROM pack_animals;

-- общая таблица животных
DROP TEMPORARY TABLE IF EXISTS animals;
CREATE TEMPORARY TABLE animals
SELECT * FROM cats
UNION ALL
SELECT * FROM dogs
UNION ALL
SELECT * FROM humsters
UNION ALL
SELECT * FROM horses
UNION ALL
SELECT * FROM camels
UNION ALL
SELECT * FROM donkeys;

#SELECT * FROM animals;

-- создание таблицы животных с возрастом от 1 до 3 лет
DROP TEMPORARY TABLE IF EXISTS animals3year;
CREATE TEMPORARY TABLE animals3year
	SELECT * 
	FROM animals
		WHERE TIMESTAMPDIFF(MONTH, birthDate, curdate()) BETWEEN 1*12 AND 3*12;
-- вычисление точного возраста животных
SELECT  
    *,
	concat(TIMESTAMPDIFF(YEAR, birthDate, curdate()),' г. ', TIMESTAMPDIFF(MONTH, birthDate, curdate()) MOD 12, ' мес.') AS age
FROM animals3year;

--- все животные + доп. возраст. таблица создана ранее

SELECT
	*,
	concat(TIMESTAMPDIFF(YEAR, birthDate, curdate()),' г. ', TIMESTAMPDIFF(MONTH, birthDate, curdate()) MOD 12, ' мес.') AS age
FROM animals;
