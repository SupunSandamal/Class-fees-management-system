-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 04, 2023 at 02:30 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `studen_information`
--
CREATE DATABASE IF NOT EXISTS `studen_information` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `studen_information`;

-- --------------------------------------------------------

--
-- Table structure for table `student_info`
--

CREATE TABLE `student_info` (
  `StudentNumber` int(12) NOT NULL,
  `StudentName` varchar(50) NOT NULL,
  `Address` varchar(100) NOT NULL,
  `ContactNumber` int(10) NOT NULL,
  `Year` varchar(10) NOT NULL,
  `Subject` varchar(50) NOT NULL,
  `DateOfRegistation` date NOT NULL,
  `PaymentDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student_info`
--

INSERT INTO `student_info` (`StudentNumber`, `StudentName`, `Address`, `ContactNumber`, `Year`, `Subject`, `DateOfRegistation`, `PaymentDate`) VALUES
(1, 'Supun Sandamal', 'yakkalamulla', 77554466, '2022', 'Enginearing Technology', '2022-08-02', '2023-01-03'),
(2, 'Pasindu', 'Udugama', 77558899, '2022', 'Science For Technology', '2022-08-01', '2022-09-01'),
(3, 'Zuko', 'Baddegama', 71442288, '2022', 'Information & Communication Technology', '2022-08-01', '2022-12-22'),
(4, 'Nipun', 'Baddegama', 77556633, '2022', 'Information & Communication Technology', '2022-08-01', '2022-08-01'),
(7, 'Nipundf', 'Baddegama', 77556633, '2023', 'Information & Communication Technology', '2022-08-01', '2023-03-15');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `student_info`
--
ALTER TABLE `student_info`
  ADD PRIMARY KEY (`StudentNumber`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
