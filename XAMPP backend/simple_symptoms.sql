-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 04, 2023 at 01:32 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `si`
--

-- --------------------------------------------------------

--
-- Table structure for table `simple_symptoms`
--

CREATE TABLE `simple_symptoms` (
  `symptom_id` int(11) NOT NULL,
  `photo` text NOT NULL,
  `symptomen` varchar(255) NOT NULL,
  `symptomar` varchar(255) NOT NULL,
  `symptomfr` varchar(255) NOT NULL,
  `treatmenten` text NOT NULL,
  `treatmentar` text NOT NULL,
  `treatmentfr` text NOT NULL,
  `headache` tinyint(1) NOT NULL DEFAULT 0,
  `runny_nose` tinyint(1) NOT NULL DEFAULT 0,
  `itching` tinyint(1) NOT NULL DEFAULT 0,
  `red_eyes` tinyint(1) NOT NULL DEFAULT 0,
  `sneezing` tinyint(1) NOT NULL DEFAULT 0,
  `throat` tinyint(1) NOT NULL DEFAULT 0,
  `fever` tinyint(1) NOT NULL DEFAULT 0,
  `tired` tinyint(1) NOT NULL DEFAULT 0,
  `taste` tinyint(1) NOT NULL DEFAULT 0,
  `vomitting` tinyint(1) NOT NULL DEFAULT 0,
  `dizziness` tinyint(1) NOT NULL DEFAULT 0,
  `diarrhea` tinyint(1) NOT NULL DEFAULT 0,
  `stomach` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `simple_symptoms`
--

INSERT INTO `simple_symptoms` (`symptom_id`, `photo`, `symptomen`, `symptomar`, `symptomfr`, `treatmenten`, `treatmentar`, `treatmentfr`, `headache`, `runny_nose`, `itching`, `red_eyes`, `sneezing`, `throat`, `fever`, `tired`, `taste`, `vomitting`, `dizziness`, `diarrhea`, `stomach`) VALUES
(1, 'headache.png', 'headache', 'صداع', 'mal de tête', 'Rest in a quiet, dark room.\r\nHot or cold compresses to your head or neck.\r\nMassage and small amounts of caffeine.\r\n\r\nPotential illnesses: Stroke,Dental problemsm,Covid,Concussion.', 'استرح في غرفة هادئة ومظلمة.\r\nكمادات ساخنة أو باردة على رأسك أو رقبتك.\r\nالتدليك بكميات قليلة من الكافيين.\r\nالأمراض المحتملة: السكتة الدماغية ، مشاكل الأسنان ، كوفيد ، ارتجاج.', 'Reposez-vous dans une pièce calme et sombre.\r\nCompresses chaudes ou froides sur la tête ou le cou.\r\nMassage et petites quantités de caféine.\r\nMaladies potentielles : AVC, problèmes dentaires, Covid, commotion cérébrale.', 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `simple_symptoms`
--
ALTER TABLE `simple_symptoms`
  ADD PRIMARY KEY (`symptom_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `simple_symptoms`
--
ALTER TABLE `simple_symptoms`
  MODIFY `symptom_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
