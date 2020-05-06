-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 06, 2020 at 07:47 PM
-- Server version: 5.5.27
-- PHP Version: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `helthcare_management`
--

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `u_id` int(20) NOT NULL AUTO_INCREMENT,
  `u_fname` varchar(30) NOT NULL,
  `u_lname` varchar(30) NOT NULL,
  `u_age` varchar(10) NOT NULL,
  `u_address` varchar(50) NOT NULL,
  `u_sex` varchar(15) NOT NULL,
  `u_email` varchar(50) NOT NULL,
  `u_username` varchar(25) NOT NULL,
  `u_password` varchar(30) NOT NULL,
  `u_type` varchar(15) NOT NULL,
  `u_contact` varchar(15) NOT NULL,
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=11 ;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`u_id`, `u_fname`, `u_lname`, `u_age`, `u_address`, `u_sex`, `u_email`, `u_username`, `u_password`, `u_type`, `u_contact`) VALUES
(2, 'Kasun', 'Thilina', '26', 'Horana', 'Male', 'kasun@gmail.com', 'Kasun', '123456', 'Patient', '0756745151'),
(3, 'Sahan', 'Malassri', '24', 'Malabe', 'Male', 'sahan96@gmail.com', 'Sahan', '123654', 'Patient', '0713562148'),
(5, 'Imasha', 'Perera', '34', 'Athrugiriya', 'Female', 'iperera@gmail.com', 'Imasha', 'i12345', 'Patient', '0789565324'),
(6, 'Mallika', 'Fernando', '45', 'Dehiwala', 'Female', 'mallika@gmail.com', 'Mallika', '987654', 'Patient', '0342255818'),
(10, 'Madhawa', 'Amarsinghe', '25', 'Alaluwa', 'Male', 'madhawa.amarasinghe96@gmail.com', 'Madhawa', '123456', 'Admin', '0719145562');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
