CREATE DATABASE `project_bykarpov`;
USE project_bykarpov;
CREATE TABLE `doctors` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `surname` varchar(50) NOT NULL,
  `address` varchar(50) NOT NULL,
  `sex` varchar(30) NOT NULL,
  `specialty` varchar(50) NOT NULL,
  `work_experience` int NOT NULL,
  PRIMARY KEY (`id`)
);
CREATE TABLE `patients` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `surname` varchar(50) NOT NULL,
  `address` varchar(50) NOT NULL,
  `sex` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
);
CREATE TABLE `insurance` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date_from` varchar(20) NOT NULL,
  `date_to` varchar(20) NOT NULL,
  `patient_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `patient_id` (`patient_id`),
  CONSTRAINT `insurance_ibfk_1` FOREIGN KEY (`patient_id`) REFERENCES `patients` (`id`)
);
CREATE TABLE `visits` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `doctor_id` int NOT NULL,
  `patient_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `patient_id` (`patient_id`),
  KEY `doctor_id` (`doctor_id`),
  CONSTRAINT `visits_ibfk_1` FOREIGN KEY (`patient_id`) REFERENCES `patients` (`id`),
  CONSTRAINT `visits_ibfk_2` FOREIGN KEY (`doctor_id`) REFERENCES `doctors` (`id`)
);

#inserts for 'patients'
INSERT INTO patients (name, surname, address, sex) VALUES ('Tom', 'Cruse', 'LA, 1 str., 1', 'MALE');
INSERT INTO patients (name, surname, address, sex) VALUES ('Tom', 'Hardy', 'LA, 1 str., 5', 'MALE');
INSERT INTO patients (name, surname, address, sex) VALUES ('Leonardo', 'Dicaprio', 'LA, 3 str., 1', 'MALE');
INSERT INTO patients (name, surname, address, sex) VALUES ('Jessica', 'Parker', 'LA, 5 str., 1', 'FEMALE');
INSERT INTO patients (name, surname, address, sex) VALUES ('Eva', 'Green', 'LA, 5 str., 7', 'FEMALE');
INSERT INTO patients (name, surname, address, sex) VALUES ('Emma', 'Watson', 'LA, 6 str., 1', 'FEMALE');
INSERT INTO patients (name, surname, address, sex) VALUES ('Keira', 'Knightley', 'LA, 6 str., 3', 'FEMALE');
INSERT INTO patients (name, surname, address, sex) VALUES ('Matthew', 'McConaughey', 'LA, 7 str., 3', 'MALE');
#inserts for 'doctors'
INSERT INTO doctors (name, surname, address, sex, specialty, work_experience) VALUES ('Perry', 'Cox', 'LA, 21 str., 55', 'MALE', 'THERAPIST', 20);
INSERT INTO doctors (name, surname, address, sex, specialty, work_experience) VALUES ('John', 'Dorian', 'LA, 33 str., 19', 'MALE', 'THERAPIST', 5);
INSERT INTO doctors (name, surname, address, sex, specialty, work_experience) VALUES ('Christopher', 'Turk', 'LA, 33 str., 19', 'MALE', 'SURGEON', 5);
INSERT INTO doctors (name, surname, address, sex, specialty, work_experience) VALUES ('Elliot', 'Reid', 'LA, 49 str., 7', 'FEMALE', 'GYNECOLOGIST', 5);
INSERT INTO doctors (name, surname, address, sex, specialty, work_experience) VALUES ('Bob', 'Kelso', 'LA, 15 str., 2', 'MALE', 'CARDIOLOGIST', 30);
INSERT INTO doctors (name, surname, address, sex, specialty, work_experience) VALUES ('Todd', 'Quinlan', 'LA, 78 str., 11', 'MALE', 'SURGEON', 6);
INSERT INTO doctors (name, surname, address, sex, specialty, work_experience) VALUES ('Doug', 'Murphy', 'LA, 66 str., 6', 'MALE', 'DERMATOVENEROLOGIST', 6);
