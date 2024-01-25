-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: bhbg3ury0rbjdqvkjbmx-mysql.services.clever-cloud.com:3306
-- Generation Time: Jan 04, 2024 at 09:38 AM
-- Server version: 8.0.22-13
-- PHP Version: 8.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bhbg3ury0rbjdqvkjbmx`
--

-- --------------------------------------------------------

--
-- Table structure for table `courses`
--

CREATE TABLE `courses` (
  `c_id` int NOT NULL,
  `c_name` varchar(255) DEFAULT NULL,
  `std_level` int DEFAULT NULL,
  `status` varchar(20) NOT NULL DEFAULT 'not assigned'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `courses`
--

INSERT INTO `courses` (`c_id`, `c_name`, `std_level`, `status`) VALUES
(1, 'english', 1, 'not assigned'),
(2, 'maths', 2, 'not assigned'),
(3, 'english', 2, 'assigned'),
(4, 'maths', 1, 'assigned'),
(5, 'english', 3, 'assigned'),
(6, 'maths', 3, 'assigned');

-- --------------------------------------------------------

--
-- Table structure for table `doctor`
--

CREATE TABLE `doctor` (
  `d_id` int NOT NULL,
  `name` varchar(255) NOT NULL,
  `qualification` varchar(20) DEFAULT NULL,
  `gender` enum('male','female') NOT NULL,
  `email` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `doctor`
--

INSERT INTO `doctor` (`d_id`, `name`, `qualification`, `gender`, `email`) VALUES
(290, 'waqar', 'MBBS', 'male', 'waqar@gmail.com'),
(475, 'Shoaib', 'MBBS', 'male', 'shoaib@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `email`
--

CREATE TABLE `email` (
  `id` int NOT NULL,
  `no` int DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `sender` varchar(30) DEFAULT NULL,
  `receiver` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `games_scores`
--

CREATE TABLE `games_scores` (
  `id` int NOT NULL,
  `s_id` int DEFAULT NULL,
  `g_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `score` int DEFAULT NULL,
  `playtime` int DEFAULT NULL,
  `g_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `lecture`
--

CREATE TABLE `lecture` (
  `id` int NOT NULL,
  `c_id` int DEFAULT NULL,
  `s_id` int DEFAULT NULL,
  `watch_time` int DEFAULT '0',
  `status` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `lecture`
--

INSERT INTO `lecture` (`id`, `c_id`, `s_id`, `watch_time`, `status`) VALUES
(55, 2, 519, 0, 'incomplete'),
(56, 3, 519, 0, 'incomplete'),
(57, 2, 406, 0, 'incomplete'),
(58, 3, 406, 0, 'completed'),
(59, 2, 160, 3, 'completed'),
(60, 3, 160, 3, 'completed'),
(61, 2, 451, 0, 'incomplete'),
(62, 3, 451, 0, 'incomplete'),
(63, 2, 679, 0, 'incomplete'),
(64, 3, 679, 0, 'incomplete'),
(65, 2, 701, 0, 'incomplete'),
(66, 3, 701, 0, 'incomplete'),
(67, 2, 167, 0, 'incomplete'),
(68, 3, 167, 0, 'incomplete'),
(69, 2, 941, 0, 'incomplete'),
(70, 3, 941, 0, 'incomplete'),
(71, 2, 182, 0, 'incomplete'),
(72, 3, 182, 0, 'incomplete'),
(73, 2, 850, 0, 'incomplete'),
(74, 3, 850, 0, 'incomplete'),
(75, 2, 721, 0, 'incomplete'),
(76, 3, 721, 0, 'incomplete');

-- --------------------------------------------------------

--
-- Table structure for table `medical_report`
--

CREATE TABLE `medical_report` (
  `id` int NOT NULL,
  `s_id` int NOT NULL,
  `hyperactive` int NOT NULL,
  `inattention` int NOT NULL,
  `impulsive` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `medical_report`
--

INSERT INTO `medical_report` (`id`, `s_id`, `hyperactive`, `inattention`, `impulsive`) VALUES
(19, 519, 5, 15, 10),
(20, 406, 10, 5, 15),
(21, 160, 5, 15, 10),
(22, 451, 9, 5, 10),
(23, 679, 5, 10, 15),
(24, 701, 5, 10, 11),
(25, 167, 10, 6, 5),
(26, 941, 5, 15, 10),
(27, 182, 5, 10, 15),
(28, 850, 15, 5, 10),
(29, 721, 15, 5, 10);

-- --------------------------------------------------------

--
-- Table structure for table `notice`
--

CREATE TABLE `notice` (
  `NoticeID` int NOT NULL,
  `Title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Content` varchar(500) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Date` date DEFAULT NULL,
  `Attachment` longblob,
  `userID` varchar(10) COLLATE utf8mb4_general_ci DEFAULT 'A0001',
  `Category` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `notice`
--

INSERT INTO `notice` (`NoticeID`, `Title`, `Content`, `Date`, `Attachment`, `userID`, `Category`) VALUES
(3, 'New Prescription Added For Sharjeel', 'A new prescription has been added for the student.', '2024-01-03', NULL, '952', 'Doctor\'s Prescription'),
(4, 'New Prescription Added For afridi', 'A new prescription has been added for the student.', '2024-01-03', NULL, '803', 'Doctor\'s Prescription'),
(5, 'New Prescription Added For shah', 'A new prescription has been added for the student.', '2024-01-03', NULL, '122', 'Doctor\'s Prescription'),
(6, 'New Prescription Added For sohail', 'A new prescription has been added for the student.', '2024-01-03', NULL, '505', 'Doctor\'s Prescription'),
(7, 'New Prescription Added For asif', 'A new prescription has been added for the student.', '2024-01-04', NULL, '673', 'Doctor\'s Prescription');

-- --------------------------------------------------------

--
-- Table structure for table `parent`
--

CREATE TABLE `parent` (
  `p_id` int NOT NULL,
  `name` varchar(255) NOT NULL,
  `relation` varchar(255) DEFAULT NULL,
  `email` varchar(30) NOT NULL,
  `contact` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `parent`
--

INSERT INTO `parent` (`p_id`, `name`, `relation`, `email`, `contact`) VALUES
(122, 'naseem', 'Father', 'naseem@gmail.com', 45345353),
(250, 'babar', 'Father', 'babar@gmail.com', 433535534),
(311, 'Umer', 'Father', 'umer@gmail.com', 21312312),
(505, 'haris', 'Father', 'haris@gmail.com', 34234243),
(559, 'imad', 'Father', 'imad@gmail.com', 234242342),
(601, 'asad', 'Father', 'asad@gmail.com', 423455435),
(634, 'salman', 'Father', 'salman@gmail.com', 1233243),
(673, 'umaid', 'Father', 'umaid@gmail.com', 43243442),
(803, 'shaheen', 'Father', 'shaheen@', 45354535),
(966, 'iftikhar', 'Father', 'iftikhar@gmail.com', 32343242);

-- --------------------------------------------------------

--
-- Table structure for table `quiz_marks`
--

CREATE TABLE `quiz_marks` (
  `id` int NOT NULL,
  `c_id` int DEFAULT NULL,
  `s_id` int DEFAULT NULL,
  `marks` int DEFAULT NULL,
  `feedback` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `quiz_marks`
--

INSERT INTO `quiz_marks` (`id`, `c_id`, `s_id`, `marks`, `feedback`) VALUES
(780, 4, 376, 3, 'Well done! You scored a good grade.');

-- --------------------------------------------------------

--
-- Table structure for table `stdcourse`
--

CREATE TABLE `stdcourse` (
  `s_id` int NOT NULL,
  `c_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `stdcourse`
--

INSERT INTO `stdcourse` (`s_id`, `c_id`) VALUES
(160, 2),
(167, 2),
(182, 2),
(406, 2),
(451, 2),
(519, 2),
(679, 2),
(701, 2),
(721, 2),
(850, 2),
(941, 2),
(160, 3),
(167, 3),
(182, 3),
(406, 3),
(451, 3),
(519, 3),
(679, 3),
(701, 3),
(721, 3),
(850, 3),
(941, 3);

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `s_id` int NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `DOB` date DEFAULT NULL,
  `p_id` int DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `s_level` int DEFAULT '0',
  `adhd_type` enum('inattention','impulsive','hyperactive','null','') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`s_id`, `name`, `email`, `DOB`, `p_id`, `gender`, `s_level`, `adhd_type`) VALUES
(160, 'afridi', 'afridi@gmail.com', '2024-01-03', 803, 'Male ', 2, 'inattention'),
(167, 'asif', 'asif@gmail.com', '2024-01-03', 673, 'Male ', 1, 'hyperactive'),
(182, 'shah', 'shah@gmail.com', '2024-01-03', 122, 'Male ', 3, 'impulsive'),
(406, 'Sharjeel', 'sharjeel@gmail.com', '2024-01-03', 311, 'Male ', 2, 'impulsive'),
(451, 'shafiq', 'shafiq@gmail.com', '2024-01-03', 601, 'Male ', 2, 'impulsive'),
(679, 'sohail', 'sohail@gmail.com', '2024-01-03', 505, 'Male ', 3, 'impulsive'),
(701, 'wasim', 'wasim@gmail.com', '2024-01-03', 559, 'Male ', 2, 'impulsive'),
(721, 'agha', 'agha@gmail.com', '2024-01-03', 634, 'Male ', 1, 'hyperactive'),
(850, 'ahmad', 'ahmad@gmail.com', '2024-01-03', 966, 'Male ', 2, 'hyperactive'),
(941, 'azam', 'azam@gmail.com', '2024-01-03', 250, 'Male ', 1, 'inattention');

-- --------------------------------------------------------

--
-- Table structure for table `student_prescription`
--

CREATE TABLE `student_prescription` (
  `id` int NOT NULL,
  `s_id` int NOT NULL,
  `adhd_type` enum('inattention','impulsive','hyperactive','') NOT NULL,
  `medicine` varchar(255) NOT NULL,
  `prescription_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `student_prescription`
--

INSERT INTO `student_prescription` (`id`, `s_id`, `adhd_type`, `medicine`, `prescription_date`) VALUES
(6, 376, 'impulsive', 'Medicine5', '2024-01-03'),
(7, 160, 'inattention', 'Medicine2', '2024-01-03'),
(8, 182, 'impulsive', 'Medicine5', '2024-01-03'),
(9, 679, 'impulsive', 'Medicine4', '2024-01-03'),
(10, 167, 'hyperactive', 'Medicine8', '2024-01-04');

-- --------------------------------------------------------

--
-- Table structure for table `teacher`
--

CREATE TABLE `teacher` (
  `t_id` int NOT NULL,
  `name` varchar(255) NOT NULL,
  `gender` varchar(4) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `c_id` int DEFAULT NULL,
  `t_status` varchar(255) DEFAULT 'not approve',
  `qualification` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `teacher`
--

INSERT INTO `teacher` (`t_id`, `name`, `gender`, `email`, `c_id`, `t_status`, `qualification`) VALUES
(118, 'Shadab', 'Male', 'shadab@gmail.com', 5, 'approved', 'MSCS'),
(396, 'Amir', 'Male', 'amir@gmail.com', 4, 'approved', 'MSCS'),
(400, 'Saud', 'Male', 'saud@gmail.com', 6, 'approved', 'MBA'),
(420, 'virat', 'Male', 'virat@gmail.com', 3, 'approved', 'MSCS');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int UNSIGNED NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `Password` varchar(255) DEFAULT NULL,
  `role` enum('Parent','Doctor','Teacher','Student','Admin') NOT NULL,
  `registered_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `name`, `Email`, `Password`, `role`, `registered_date`) VALUES
(1, 'Sharjeel', 'sharjeel00@gmail.com', '123', 'Admin', '2018-01-10'),
(118, 'Shadab', 'shadab@gmail.com', '123', 'Teacher', '2024-01-03'),
(122, 'naseem', 'naseem@gmail.com', '123', 'Parent', '2024-01-03'),
(160, 'afridi', 'afridi@gmail.com', '123', 'Student', '2024-01-06'),
(167, 'asif', 'asif@gmail.com', '123', 'Student', '2004-11-03'),
(182, 'shah', 'shah@gmail.com', '123', 'Student', '2003-07-29'),
(250, 'babar', 'babar@gmail.com', '123', 'Parent', '2024-01-03'),
(290, 'waqar', 'waqar@gmail.com', '123', 'Doctor', '2024-01-03'),
(311, 'Umer', 'umer@gmail.com', '123', 'Parent', '2024-01-03'),
(396, 'Amir', 'amir@gmail.com', '123', 'Teacher', '2024-01-03'),
(400, 'Saud', 'saud@gmail.com', '123', 'Teacher', '2024-01-03'),
(406, 'Sharjeel', 'sharjeel@gmail.com', '123', 'Student', '2024-01-18'),
(420, 'virat', 'virat@gmail.com', '123', 'Teacher', '2024-01-04'),
(451, 'shafiq', 'shafiq@gmail.com', '123', 'Student', '2003-11-07'),
(475, 'Shoaib', 'shoaib@gmail.com', '123', 'Doctor', '2024-01-03'),
(505, 'haris', 'haris@gmail.com', '123', 'Parent', '2024-01-03'),
(559, 'imad', 'imad@gmail.com', '123', 'Parent', '2024-01-03'),
(601, 'asad', 'asad@gmail.com', '123', 'Parent', '2024-01-03'),
(634, 'salman', 'salman@gmail.com', '123', 'Parent', '2024-01-03'),
(673, 'umaid', 'umaid@gmail.com', '123', 'Parent', '2024-01-03'),
(679, 'sohail', 'sohail@gmail.com', '123', 'Student', '2004-01-28'),
(701, 'wasim', 'wasim@gmail.com', '123', 'Student', '2002-12-12'),
(721, 'agha', 'agha@gmail.com', '123', 'Student', '2004-05-09'),
(803, 'shaheen', 'shaheen@', '123', 'Parent', '2024-01-03'),
(850, 'ahmad', 'ahmad@gmail.com', '123', 'Student', '2004-03-04'),
(941, 'azam', 'azam@gmail.com', '123', 'Student', '2006-06-29'),
(966, 'iftikhar', 'iftikhar@gmail.com', '123', 'Parent', '2024-01-03');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `courses`
--
ALTER TABLE `courses`
  ADD PRIMARY KEY (`c_id`);

--
-- Indexes for table `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`d_id`);

--
-- Indexes for table `email`
--
ALTER TABLE `email`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `games_scores`
--
ALTER TABLE `games_scores`
  ADD PRIMARY KEY (`id`),
  ADD KEY `s_id` (`s_id`);

--
-- Indexes for table `lecture`
--
ALTER TABLE `lecture`
  ADD PRIMARY KEY (`id`),
  ADD KEY `c_id` (`c_id`),
  ADD KEY `s_id` (`s_id`);

--
-- Indexes for table `medical_report`
--
ALTER TABLE `medical_report`
  ADD PRIMARY KEY (`id`),
  ADD KEY `s_id` (`s_id`);

--
-- Indexes for table `notice`
--
ALTER TABLE `notice`
  ADD PRIMARY KEY (`NoticeID`),
  ADD KEY `AdminID` (`userID`);

--
-- Indexes for table `parent`
--
ALTER TABLE `parent`
  ADD PRIMARY KEY (`p_id`);

--
-- Indexes for table `quiz_marks`
--
ALTER TABLE `quiz_marks`
  ADD PRIMARY KEY (`id`),
  ADD KEY `c_id` (`c_id`),
  ADD KEY `s_id` (`s_id`);

--
-- Indexes for table `stdcourse`
--
ALTER TABLE `stdcourse`
  ADD PRIMARY KEY (`s_id`,`c_id`),
  ADD KEY `crsid` (`c_id`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`s_id`),
  ADD KEY `cons_fk` (`p_id`);

--
-- Indexes for table `student_prescription`
--
ALTER TABLE `student_prescription`
  ADD PRIMARY KEY (`id`),
  ADD KEY `cons_fks` (`s_id`);

--
-- Indexes for table `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`t_id`),
  ADD KEY `fk_teacou` (`c_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `email`
--
ALTER TABLE `email`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `games_scores`
--
ALTER TABLE `games_scores`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `lecture`
--
ALTER TABLE `lecture`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=77;

--
-- AUTO_INCREMENT for table `medical_report`
--
ALTER TABLE `medical_report`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT for table `notice`
--
ALTER TABLE `notice`
  MODIFY `NoticeID` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `quiz_marks`
--
ALTER TABLE `quiz_marks`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=781;

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `s_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=993;

--
-- AUTO_INCREMENT for table `student_prescription`
--
ALTER TABLE `student_prescription`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=995;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `games_scores`
--
ALTER TABLE `games_scores`
  ADD CONSTRAINT `games_scores_ibfk_1` FOREIGN KEY (`s_id`) REFERENCES `student` (`s_id`);

--
-- Constraints for table `lecture`
--
ALTER TABLE `lecture`
  ADD CONSTRAINT `lecture_ibfk_1` FOREIGN KEY (`c_id`) REFERENCES `courses` (`c_id`),
  ADD CONSTRAINT `lecture_ibfk_2` FOREIGN KEY (`s_id`) REFERENCES `student` (`s_id`);

--
-- Constraints for table `medical_report`
--
ALTER TABLE `medical_report`
  ADD CONSTRAINT `medical_report_ibfk_1` FOREIGN KEY (`s_id`) REFERENCES `student` (`s_id`);

--
-- Constraints for table `quiz_marks`
--
ALTER TABLE `quiz_marks`
  ADD CONSTRAINT `quiz_marks_ibfk_2` FOREIGN KEY (`c_id`) REFERENCES `courses` (`c_id`),
  ADD CONSTRAINT `quiz_marks_ibfk_3` FOREIGN KEY (`s_id`) REFERENCES `student` (`s_id`);

--
-- Constraints for table `stdcourse`
--
ALTER TABLE `stdcourse`
  ADD CONSTRAINT `stdcourse_ibfk_1` FOREIGN KEY (`s_id`) REFERENCES `student` (`s_id`),
  ADD CONSTRAINT `stdcourse_ibfk_2` FOREIGN KEY (`c_id`) REFERENCES `courses` (`c_id`);

--
-- Constraints for table `student`
--
ALTER TABLE `student`
  ADD CONSTRAINT `cons_fk` FOREIGN KEY (`p_id`) REFERENCES `parent` (`p_id`);

--
-- Constraints for table `student_prescription`
--
ALTER TABLE `student_prescription`
  ADD CONSTRAINT `cons_fks` FOREIGN KEY (`s_id`) REFERENCES `student` (`s_id`);

--
-- Constraints for table `teacher`
--
ALTER TABLE `teacher`
  ADD CONSTRAINT `fk_teacou` FOREIGN KEY (`c_id`) REFERENCES `courses` (`c_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
