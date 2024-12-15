-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 14, 2024 at 01:24 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `usage`
--
CREATE DATABASE IF NOT EXISTS `usage` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `usage`;

-- --------------------------------------------------------

--
-- Table structure for table `usern`
--

CREATE TABLE `usern` (
  `username` varchar(127) NOT NULL,
  `emailadd` varchar(127) NOT NULL,
  `passwa` varchar(127) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `usern`
--

INSERT INTO `usern` (`username`, `emailadd`, `passwa`) VALUES
('Tusk', '@', '111'),
('Tusk1', '@gmail.com', '12345'),
('Tusk2', '@gmail', '12345'),
('Floro', '@gmail', '111'),
('belle', '@belle', 'bella');
--
-- Database: `user_belle`
--
CREATE DATABASE IF NOT EXISTS `user_belle` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `user_belle`;

-- --------------------------------------------------------

--
-- Table structure for table `usage_data`
--

CREATE TABLE `usage_data` (
  `ID` int(11) NOT NULL,
  `Month` varchar(20) DEFAULT NULL,
  `Year` int(11) DEFAULT NULL,
  `Useyg` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `usage_data`
--
ALTER TABLE `usage_data`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `usage_data`
--
ALTER TABLE `usage_data`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Database: `user_floro`
--
CREATE DATABASE IF NOT EXISTS `user_floro` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `user_floro`;

-- --------------------------------------------------------

--
-- Table structure for table `usage_data`
--

CREATE TABLE `usage_data` (
  `ID` int(11) NOT NULL,
  `Month` varchar(20) DEFAULT NULL,
  `Year` int(11) DEFAULT NULL,
  `Useyg` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `usage_data`
--
ALTER TABLE `usage_data`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `usage_data`
--
ALTER TABLE `usage_data`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- Database: `user_tusk`
--
CREATE DATABASE IF NOT EXISTS `user_tusk` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `user_tusk`;

-- --------------------------------------------------------

--
-- Table structure for table `usage_data`
--

CREATE TABLE `usage_data` (
  `ID` int(11) NOT NULL,
  `Month` varchar(20) DEFAULT NULL,
  `Year` int(11) DEFAULT NULL,
  `Useyg` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `usage_data`
--

INSERT INTO `usage_data` (`ID`, `Month`, `Year`, `Useyg`) VALUES
(1, 'January', 2024, 18),
(2, 'February', 2024, 18),
(3, 'March', 2024, 17),
(4, 'December', 2024, 17),
(5, 'September', 2024, 18),
(6, 'July', 2024, 16),
(7, 'August', 2024, 18),
(8, 'April', 2024, 19),
(9, 'May', 2024, 17),
(10, 'June', 2024, 16),
(11, 'October', 2024, 19),
(12, 'November', 2024, 17),
(13, 'January', 2023, 19),
(14, 'February', 2023, 19),
(15, 'March', 2023, 20),
(16, 'April', 2023, 22),
(17, 'May', 2023, 23),
(18, 'June', 2023, 24),
(19, 'July', 2023, 22),
(20, 'August', 2023, 23),
(21, 'September', 2023, 24),
(22, 'October', 2023, 25),
(23, 'November', 2023, 21),
(24, 'December', 2023, 19),
(25, 'January', 2022, 33),
(26, 'February', 2022, 29),
(27, 'March', 2022, 27),
(28, 'April', 2022, 30),
(29, 'May', 2022, 33),
(30, 'June', 2022, 32),
(31, 'July', 2022, 29),
(32, 'August', 2022, 30),
(33, 'September', 2022, 31),
(34, 'October', 2022, 32),
(35, 'November', 2022, 28),
(36, 'December', 2022, 30);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `usage_data`
--
ALTER TABLE `usage_data`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `usage_data`
--
ALTER TABLE `usage_data`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;
--
-- Database: `user_tusk1`
--
CREATE DATABASE IF NOT EXISTS `user_tusk1` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `user_tusk1`;

-- --------------------------------------------------------

--
-- Table structure for table `usage_data`
--

CREATE TABLE `usage_data` (
  `ID` int(11) NOT NULL,
  `Month` varchar(20) DEFAULT NULL,
  `Year` int(11) DEFAULT NULL,
  `Useyg` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `usage_data`
--
ALTER TABLE `usage_data`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `usage_data`
--
ALTER TABLE `usage_data`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- Database: `user_tusk2`
--
CREATE DATABASE IF NOT EXISTS `user_tusk2` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `user_tusk2`;

-- --------------------------------------------------------

--
-- Table structure for table `usage_data`
--

CREATE TABLE `usage_data` (
  `ID` int(11) NOT NULL,
  `Month` varchar(20) DEFAULT NULL,
  `Year` int(11) DEFAULT NULL,
  `Useyg` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `usage_data`
--
ALTER TABLE `usage_data`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `usage_data`
--
ALTER TABLE `usage_data`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
