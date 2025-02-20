-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Feb 20, 2025 at 12:56 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `rental`
--

-- --------------------------------------------------------

--
-- Table structure for table `managequipment`
--

CREATE TABLE `managequipment` (
  `equipId` varchar(50) NOT NULL,
  `category` varchar(100) NOT NULL,
  `model` varchar(100) NOT NULL,
  `fee` double NOT NULL,
  `equipCondition` varchar(50) NOT NULL,
  `status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `managequipment`
--

INSERT INTO `managequipment` (`equipId`, `category`, `model`, `fee`, `equipCondition`, `status`) VALUES
('E001', 'Camera', 'Canon EOS R5', 100, 'Damaged', 'In Repair'),
('E002', 'Camera', 'Sony FX3', 120, 'Available', 'Good'),
('E003', 'Camera', 'Nikon Z9', 130, 'Available', 'Good'),
('E004', 'Camera', 'Fujifilm X-H2S', 80, 'Good', 'Available'),
('E005', 'Lens', 'Canon RF 15-35mm f/2', 70, 'Available', 'Good'),
('E006', 'Lens', 'Sony 24-70mm f/2.8', 55, 'Available', 'Good');

-- --------------------------------------------------------

--
-- Table structure for table `register`
--

CREATE TABLE `register` (
  `clientID` varchar(50) NOT NULL,
  `name` varchar(100) NOT NULL,
  `age` int(11) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `address` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `register`
--

INSERT INTO `register` (`clientID`, `name`, `age`, `phone`, `address`) VALUES
('C001', 'Aldrie BAquiran', 18, '09067035958', 'Brgy. Papaya'),
('C002', 'Michael Villaluna', 19, '094733438', 'Brgy. Calayo'),
('C003', 'Javic Bugtonh', 18, '0937637282', 'Brgy. Papaya'),
('C004', 'Saipo Banto', 19, '03934643', 'Brgy. Looc'),
('C005', 'Ryan Paulo', 20, '097137137', 'Brgy. Papaya');

-- --------------------------------------------------------

--
-- Table structure for table `rent`
--

CREATE TABLE `rent` (
  `rentalID` varchar(50) NOT NULL,
  `equipmentID` varchar(50) NOT NULL,
  `client` varchar(50) NOT NULL,
  `rentDate` varchar(50) NOT NULL,
  `dueDate` varchar(50) NOT NULL,
  `total` double NOT NULL,
  `status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `rent`
--

INSERT INTO `rent` (`rentalID`, `equipmentID`, `client`, `rentDate`, `dueDate`, `total`, `status`) VALUES
('R001', 'E001', 'Aldrie BAquiran', '2025-01-27', '2025-01-28', 100, 'Returned'),
('R002', 'E004', 'Michael Villaluna', '2025-01-28', '2025-01-29', 80, 'Returned');

-- --------------------------------------------------------

--
-- Table structure for table `returnequip`
--

CREATE TABLE `returnequip` (
  `rentalID` varchar(50) NOT NULL,
  `equipmentID` varchar(50) NOT NULL,
  `client` varchar(50) NOT NULL,
  `rentDate` varchar(50) NOT NULL,
  `dueDate` varchar(50) NOT NULL,
  `returnDate` date NOT NULL,
  `elapsedDays` int(11) NOT NULL,
  `equipCondition` varchar(50) NOT NULL,
  `charge` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `returnequip`
--

INSERT INTO `returnequip` (`rentalID`, `equipmentID`, `client`, `rentDate`, `dueDate`, `returnDate`, `elapsedDays`, `equipCondition`, `charge`) VALUES
('R001', 'E001', 'Aldrie BAquiran', '2025-01-27', '2025-01-28', '2025-01-30', 2, 'Damaged', 150),
('R002', 'E004', 'Michael Villaluna', '2025-01-28', '2025-01-29', '2025-02-20', 22, 'Good', 1100);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `managequipment`
--
ALTER TABLE `managequipment`
  ADD PRIMARY KEY (`equipId`);

--
-- Indexes for table `register`
--
ALTER TABLE `register`
  ADD PRIMARY KEY (`clientID`);

--
-- Indexes for table `rent`
--
ALTER TABLE `rent`
  ADD PRIMARY KEY (`rentalID`);

--
-- Indexes for table `returnequip`
--
ALTER TABLE `returnequip`
  ADD PRIMARY KEY (`rentalID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
