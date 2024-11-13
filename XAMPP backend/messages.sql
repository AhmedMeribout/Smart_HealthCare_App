-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 23, 2023 at 06:57 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.1.12

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
-- Table structure for table `messages`
--

CREATE TABLE `messages` (
  `message_id` int(11) NOT NULL,
  `doctor_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `message` text NOT NULL,
  `time` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `messages`
--

INSERT INTO `messages` (`message_id`, `doctor_id`, `user_id`, `message`, `time`) VALUES
(1, 0, 0, 'fgfg', '2023-05-08 19:55:16'),
(2, 1, 0, 'fgdfg', '2023-05-08 20:01:42'),
(3, 1, 0, 'fgdfg', '2023-05-08 20:01:44'),
(4, 158, 0, 'dfdfsd', '2023-05-08 20:01:58'),
(5, 1, 0, 'test', '2023-05-08 23:05:00'),
(6, 0, 158, 'test', '2023-05-08 23:05:33'),
(7, 1, 0, 'test', '2023-05-08 23:06:28'),
(8, 1, 0, 'test', '2023-05-08 23:06:59'),
(9, 1, 0, 'test', '2023-05-08 23:07:01'),
(10, 1, 0, 'test', '2023-05-08 23:07:10'),
(11, 1, 0, 'test', '2023-05-08 23:10:09'),
(12, 1, 0, 'test', '2023-05-08 23:10:13'),
(13, 1, 0, 'test', '2023-05-08 23:10:37'),
(14, 1, 0, 'test', '2023-05-08 23:11:49'),
(15, 1, 158, 'test', '2023-05-08 23:13:06'),
(16, 1, 158, 'fefgfgfegdfgdf', '2023-05-10 10:46:07'),
(17, 1, 158, 'vuguy', '2023-05-10 11:35:42'),
(18, 1, 167, 'take medecin at 7 pm', '2023-05-23 10:16:00'),
(19, 1, 168, 'yu need to take your medication at 7 pm everyday', '2023-05-23 12:13:36'),
(20, 1, 167, 'bla bla bla', '2023-05-23 12:24:23');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `messages`
--
ALTER TABLE `messages`
  ADD PRIMARY KEY (`message_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `messages`
--
ALTER TABLE `messages`
  MODIFY `message_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
