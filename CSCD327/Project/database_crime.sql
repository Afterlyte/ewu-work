

--
-- Table structure for table `aliases`
--

CREATE TABLE IF NOT EXISTS `aliases` (
  `alias_id` int(6) NOT NULL DEFAULT '0',
  `criminal_id` int(6) DEFAULT NULL,
  `alias` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`alias_id`),
  KEY `appeals_criminalid_fk` (`criminal_id`)
);

--
-- Dumping data for table `aliases`
--

INSERT INTO `aliases` (`alias_id`, `criminal_id`, `alias`) VALUES
(100, 1020, 'Bat'),
(101, 1022, 'Cabby');

-- --------------------------------------------------------

--
-- Table structure for table `appeals`
--

CREATE TABLE IF NOT EXISTS `appeals` (
  `appeal_id` int(5) NOT NULL DEFAULT '0',
  `crime_id` int(9) NOT NULL,
  `filing_date` date DEFAULT NULL,
  `hearing_date` date DEFAULT NULL,
  `status` char(1) DEFAULT 'P',
  PRIMARY KEY (`appeal_id`),
  KEY `appeals_crimeid_fk` (`crime_id`)
);

--
-- Dumping data for table `appeals`
--

INSERT INTO `appeals` (`appeal_id`, `crime_id`, `filing_date`, `hearing_date`, `status`) VALUES
(7500, 10087, '2008-12-10', '2008-12-20', 'A'),
(7501, 10086, '2008-12-15', '2008-12-20', 'A'),
(7502, 10085, '2008-09-20', '2008-10-28', 'A');

-- --------------------------------------------------------

--
-- Table structure for table `crimes`
--

CREATE TABLE IF NOT EXISTS `crimes` (
  `crime_id` int(9) NOT NULL DEFAULT '0',
  `criminal_id` int(6) DEFAULT NULL,
  `classification` char(1) DEFAULT NULL,
  `date_charged` date DEFAULT NULL,
  `status` char(2) DEFAULT NULL,
  `hearing_date` date DEFAULT NULL,
  `appeal_cut_date` date DEFAULT NULL,
  PRIMARY KEY (`crime_id`),
  KEY `crimes_criminalid_fk` (`criminal_id`)
);

--
-- Dumping data for table `crimes`
--

INSERT INTO `crimes` (`crime_id`, `criminal_id`, `classification`, `date_charged`, `status`, `hearing_date`, `appeal_cut_date`) VALUES
(10085, 1020, 'F', '2008-09-03', 'CA', '2008-09-15', '2008-12-15'),
(10086, 1021, 'M', '2008-10-20', 'CL', '2008-12-05', NULL),
(10087, 1022, 'M', '2008-10-30', 'IA', '2008-12-05', '2009-03-15'),
(10088, 1023, 'O', '2008-11-05', 'CA', NULL, NULL),
(10089, 1025, 'M', '2008-10-22', 'CA', '2008-11-25', '2009-02-15'),
(10090, 1026, 'M', '2008-10-22', 'CA', '2008-11-25', '2009-02-15'),
(10091, 1027, 'M', '2008-10-24', 'CA', '2008-11-28', '2009-02-15'),
(10092, 1028, 'M', '2008-10-24', 'CA', '2008-11-28', '2009-02-15'),
(10093, 1024, 'M', '2008-10-22', 'CA', '2008-11-25', '2009-02-15'),
(10094, 1029, 'M', '2008-10-26', 'CA', '2008-11-26', '2009-02-17'),
(25344031, 1030, 'M', '2008-10-26', 'CA', '2008-11-26', '2009-02-17'),
(25344060, 1030, 'M', '2008-11-18', 'CL', '2008-11-26', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `crime_charges`
--

CREATE TABLE IF NOT EXISTS `crime_charges` (
  `charge_id` int(10) NOT NULL DEFAULT '0',
  `crime_id` int(9) NOT NULL,
  `crime_code` int(3) NOT NULL,
  `charge_status` char(2) DEFAULT NULL,
  `fine_amount` decimal(7,2) DEFAULT NULL,
  `court_fee` decimal(7,2) DEFAULT NULL,
  `amount_paid` decimal(7,2) DEFAULT NULL,
  `pay_due_date` date DEFAULT NULL,
  PRIMARY KEY (`charge_id`),
  KEY `crimecharges_crimeid_fk` (`crime_id`),
  KEY `crimecharges_code_fk` (`crime_code`)
);

--
-- Dumping data for table `crime_charges`
--

INSERT INTO `crime_charges` (`charge_id`, `crime_id`, `crime_code`, `charge_status`, `fine_amount`, `court_fee`, `amount_paid`, `pay_due_date`) VALUES
(5000, 10085, 301, 'GL', 3000.00, 200.00, 40.00, '2008-10-15'),
(5001, 10085, 305, 'GL', 1000.00, 100.00, NULL, '2008-10-15'),
(5002, 10086, 304, 'GL', 200.00, 100.00, 25.00, '2009-02-15'),
(5003, 10087, 305, 'GL', 100.00, 50.00, 150.00, '2009-03-15'),
(5004, 10088, 306, 'PD', NULL, NULL, NULL, NULL),
(5005, 10089, 305, 'GL', 100.00, 50.00, NULL, '2009-02-15'),
(5006, 10090, 305, 'GL', 100.00, 50.00, NULL, '2009-02-15'),
(5007, 10091, 305, 'GL', 100.00, 50.00, 20.00, '2009-02-15'),
(5008, 10092, 305, 'GL', 100.00, 50.00, 25.00, '2009-02-15'),
(5009, 10093, 305, 'GL', 100.00, 50.00, NULL, '2009-02-15'),
(5010, 10094, 305, 'GL', 50.00, 50.00, NULL, '2009-02-17'),
(5011, 25344031, 305, 'GL', 50.00, 50.00, NULL, '2009-02-17'),
(5012, 25344060, 305, 'GL', 50.00, 50.00, 100.00, '2009-02-17');

-- --------------------------------------------------------

--
-- Table structure for table `crime_codes`
--

CREATE TABLE IF NOT EXISTS `crime_codes` (
  `crime_code` int(3) NOT NULL DEFAULT '0',
  `code_description` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`crime_code`)
);

--
-- Dumping data for table `crime_codes`
--

INSERT INTO `crime_codes` (`crime_code`, `code_description`) VALUES
(301, 'Agg Assault'),
(302, 'Auto Theft'),
(303, 'Burglary-Business'),
(304, 'Criminal Mischief'),
(305, 'Drug Offense'),
(306, 'Bomb Threat');

-- --------------------------------------------------------

--
-- Table structure for table `crime_officers`
--

CREATE TABLE IF NOT EXISTS `crime_officers` (
  `crime_id` int(9) NOT NULL DEFAULT '0',
  `officer_id` int(8) NOT NULL DEFAULT '0',
  PRIMARY KEY (`crime_id`,`officer_id`),
  KEY `crimeofficers_officerid_fk` (`officer_id`)
);

--
-- Dumping data for table `crime_officers`
--

INSERT INTO `crime_officers` (`crime_id`, `officer_id`) VALUES
(10085, 111112),
(10086, 111114),
(10087, 111115),
(10088, 111115),
(10089, 111115),
(10089, 111116),
(10090, 111115),
(10091, 111115),
(10092, 111115),
(10093, 111115),
(10094, 111115),
(25344031, 111115),
(25344060, 111116);

-- --------------------------------------------------------

--
-- Table structure for table `criminals`
--

CREATE TABLE IF NOT EXISTS `criminals` (
  `criminal_id` int(6) NOT NULL DEFAULT '0',
  `last` varchar(15) DEFAULT NULL,
  `first` varchar(10) DEFAULT NULL,
  `street` varchar(30) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `state` char(2) DEFAULT NULL,
  `zip` char(5) DEFAULT NULL,
  `phone` char(10) DEFAULT NULL,
  `v_status` char(1) DEFAULT 'N',
  `p_status` char(1) DEFAULT 'N',
  PRIMARY KEY (`criminal_id`)
);

--
-- Dumping data for table `criminals`
--

INSERT INTO `criminals` (`criminal_id`, `last`, `first`, `street`, `city`, `state`, `zip`, `phone`, `v_status`, `p_status`) VALUES
(1020, 'Phelps', 'Sam', '1105 Tree Lane', 'Virginia Beach', 'VA', '23510', '7576778484', 'Y', 'N'),
(1021, 'Sums', 'Tammy', '22 E. Ave', 'Virginia Beach', 'VA', '23510', '7575453390', 'N', 'Y'),
(1022, 'Caulk', 'Dave', '8112 Chester Lane', 'Chesapeake', 'VA', '23320', '7578403690', 'N', 'Y'),
(1023, 'Dabber', 'Pat', NULL, 'Chesapeake', 'VA', '23320', NULL, 'N', 'N'),
(1024, 'Perry', 'Cart', NULL, 'Norfolk', 'VA', '26501', NULL, 'N', 'Y'),
(1025, 'Cat', 'Tommy', NULL, 'Norfolk', 'VA', '26503', NULL, 'N', 'Y'),
(1026, 'Simon', 'Tim', NULL, 'Norfolk', 'VA', '26503', NULL, 'N', 'Y'),
(1027, 'Pints', 'Reed', NULL, 'Norfolk', 'VA', '26505', NULL, 'N', 'Y'),
(1028, 'Mansville', 'Nancy', NULL, 'Norfolk', 'VA', '26505', NULL, 'N', 'Y'),
(1029, 'Statin', 'Penny', NULL, 'Norfolk', 'VA', '26505', NULL, 'N', 'Y'),
(1030, 'Panner', 'Lee', NULL, 'Norfolk', 'VA', '26505', NULL, 'N', 'Y');

-- --------------------------------------------------------

--
-- Table structure for table `criminals_dw`
--

CREATE TABLE IF NOT EXISTS `criminals_dw` (
  `criminal_id` int(6) DEFAULT NULL,
  `last` varchar(15) DEFAULT NULL,
  `first` varchar(10) DEFAULT NULL,
  `street` varchar(30) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `state` char(2) DEFAULT NULL,
  `zip` char(5) DEFAULT NULL,
  `phone` char(10) DEFAULT NULL,
  `v_status` char(1) DEFAULT NULL,
  `p_status` char(1) DEFAULT NULL
);

--
-- Dumping data for table `criminals_dw`
--

INSERT INTO `criminals_dw` (`criminal_id`, `last`, `first`, `street`, `city`, `state`, `zip`, `phone`, `v_status`, `p_status`) VALUES
(1020, 'Phelps', 'Sam', '1105 Tree Lane', 'Virginia Beach', 'VA', '23510', '7576778484', 'Y', 'N'),
(1021, 'Sums', 'Tammy', '22 E. Ave', 'Virginia Beach', 'VA', '23510', '7575453390', 'N', 'Y'),
(1022, 'Caulk', 'Dave', '8112 Chester Lane', 'Chesapeake', 'VA', '23320', '7578403690', 'N', 'Y'),
(1023, 'Dabber', 'Pat', NULL, 'Chesapeake', 'VA', '23320', NULL, 'N', 'N'),
(1024, 'Perry', 'Cart', '11 New St.', 'Surry', 'VA', '54501', NULL, 'N', 'Y'),
(1025, 'Cat', 'Tommy', NULL, 'Norfolk', 'VA', '26503', '7578889393', 'N', 'Y');

-- --------------------------------------------------------

--
-- Table structure for table `officers`
--

CREATE TABLE IF NOT EXISTS `officers` (
  `officer_id` int(8) NOT NULL DEFAULT '0',
  `last` varchar(15) DEFAULT NULL,
  `first` varchar(10) DEFAULT NULL,
  `precinct` char(4) DEFAULT NULL,
  `badge` varchar(14) DEFAULT NULL,
  `phone` char(10) DEFAULT NULL,
  `status` char(1) DEFAULT 'A',
  PRIMARY KEY (`officer_id`)
);

--
-- Dumping data for table `officers`
--

INSERT INTO `officers` (`officer_id`, `last`, `first`, `precinct`, `badge`, `phone`, `status`) VALUES
(111112, 'Shocks', 'Pam', 'OCVW', 'E5546A33', '7574446767', 'A'),
(111113, 'Busey', 'Gerry', 'GHNT', 'E5577D48', '7574446767', 'A'),
(111114, 'Gants', 'Dale', 'SBCH', 'E5536N02', '7574446767', 'A'),
(111115, 'Hart', 'Leigh', 'WAVE', 'E5511J40', '7574446767', 'A'),
(111116, 'Sands', 'Ben', 'OCVW', 'E5588R00', '7574446767', 'I');

-- --------------------------------------------------------

--
-- Table structure for table `prob_contact`
--

CREATE TABLE IF NOT EXISTS `prob_contact` (
  `prob_cat` int(2) DEFAULT NULL,
  `low_amt` int(5) DEFAULT NULL,
  `high_amt` int(5) DEFAULT NULL,
  `con_freq` varchar(20) DEFAULT NULL
);

--
-- Dumping data for table `prob_contact`
--

INSERT INTO `prob_contact` (`prob_cat`, `low_amt`, `high_amt`, `con_freq`) VALUES
(10, 1, 80, 'Weekly'),
(20, 81, 160, 'Every 2 weeks'),
(30, 161, 500, 'Monthly');

-- --------------------------------------------------------

--
-- Table structure for table `prob_officers`
--

CREATE TABLE IF NOT EXISTS `prob_officers` (
  `prob_id` int(5) NOT NULL DEFAULT '0',
  `last` varchar(15) DEFAULT NULL,
  `first` varchar(10) DEFAULT NULL,
  `street` varchar(30) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `state` char(2) DEFAULT NULL,
  `zip` char(5) DEFAULT NULL,
  `phone` char(10) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `status` char(1) DEFAULT 'A',
  `mgr_id` int(5) DEFAULT NULL,
  PRIMARY KEY (`prob_id`)
);

--
-- Dumping data for table `prob_officers`
--

INSERT INTO `prob_officers` (`prob_id`, `last`, `first`, `street`, `city`, `state`, `zip`, `phone`, `email`, `status`, `mgr_id`) VALUES
(100, 'Peek', 'Susan', NULL, 'Virginia Beach', NULL, NULL, NULL, NULL, 'A', NULL),
(102, 'Speckle', 'Jeff', NULL, 'Virginia Beach', NULL, NULL, NULL, NULL, 'A', 100),
(104, 'Boyle', 'Chris', NULL, 'Virginia Beach', NULL, NULL, NULL, NULL, 'A', 100),
(106, 'Taps', 'George', NULL, 'Chesapeake', NULL, NULL, NULL, NULL, 'A', NULL),
(108, 'Ponds', 'Terry', NULL, 'Chesapeake', NULL, NULL, NULL, NULL, 'A', 106),
(110, 'Hawk', 'Fred', NULL, 'Chesapeake', NULL, NULL, NULL, NULL, 'I', 106);

-- --------------------------------------------------------

--
-- Table structure for table `sentences`
--

CREATE TABLE IF NOT EXISTS `sentences` (
  `sentence_id` int(6) NOT NULL DEFAULT '0',
  `criminal_id` int(9) DEFAULT NULL,
  `type` char(1) DEFAULT NULL,
  `prob_id` int(5) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `violations` int(3) DEFAULT NULL,
  PRIMARY KEY (`sentence_id`),
  KEY `sentences_crimeid_fk` (`criminal_id`),
  KEY `sentences_probid_fk` (`prob_id`)
);

--
-- Dumping data for table `sentences`
--

INSERT INTO `sentences` (`sentence_id`, `criminal_id`, `type`, `prob_id`, `start_date`, `end_date`, `violations`) VALUES
(1000, 1020, 'J', NULL, '2008-09-15', '2010-09-15', 0),
(1001, 1021, 'P', 102, '2008-12-05', '2009-06-05', 0),
(1002, 1022, 'P', 108, '2009-03-20', '2009-08-20', 0),
(1003, 1024, 'P', 106, '2008-12-20', '2009-03-20', 1),
(1004, 1025, 'P', 106, '2008-12-20', '2009-03-20', 0),
(1005, 1026, 'P', 106, '2008-12-20', '2009-03-20', 0),
(1006, 1027, 'P', 106, '2008-12-20', '2009-03-20', 0),
(1007, 1028, 'P', 106, '2008-12-20', '2009-03-20', 0),
(1008, 1029, 'P', 106, '2008-12-20', '2009-02-05', 1),
(1009, 1030, 'P', 106, '2008-12-20', '2009-02-05', 1),
(1010, 1030, 'P', 106, '2009-02-06', '2009-07-06', 0);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `aliases`
--
ALTER TABLE `aliases`
  ADD CONSTRAINT `appeals_criminalid_fk` FOREIGN KEY (`criminal_id`) REFERENCES `criminals` (`criminal_id`);

--
-- Constraints for table `crimes`
--
ALTER TABLE `crimes`
  ADD CONSTRAINT `crimes_criminalid_fk` FOREIGN KEY (`criminal_id`) REFERENCES `criminals` (`criminal_id`);

--
-- Constraints for table `crime_charges`
--
ALTER TABLE `crime_charges`
  ADD CONSTRAINT `crimecharges_code_fk` FOREIGN KEY (`crime_code`) REFERENCES `crime_codes` (`crime_code`),
  ADD CONSTRAINT `crimecharges_crimeid_fk` FOREIGN KEY (`crime_id`) REFERENCES `crimes` (`crime_id`);

--
-- Constraints for table `sentences`
--
ALTER TABLE `sentences`
  ADD CONSTRAINT `sentences_crimeid_fk` FOREIGN KEY (`criminal_id`) REFERENCES `criminals` (`criminal_id`),
  ADD CONSTRAINT `sentences_probid_fk` FOREIGN KEY (`prob_id`) REFERENCES `prob_officers` (`prob_id`);
