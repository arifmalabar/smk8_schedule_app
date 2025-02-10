-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 10 Feb 2025 pada 16.32
-- Versi server: 10.4.22-MariaDB
-- Versi PHP: 8.0.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `k8_jadwal`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `days`
--

CREATE TABLE `days` (
  `day_name` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `days`
--

INSERT INTO `days` (`day_name`) VALUES
('jumat'),
('kamis'),
('rabu'),
('sabtu'),
('selasa'),
('senin');

-- --------------------------------------------------------

--
-- Struktur dari tabel `hours`
--

CREATE TABLE `hours` (
  `hour` int(200) NOT NULL,
  `begin_times` time NOT NULL,
  `end_times` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `hours`
--

INSERT INTO `hours` (`hour`, `begin_times`, `end_times`) VALUES
(1, '06:00:00', '07:45:00'),
(2, '07:45:00', '08:45:00');

-- --------------------------------------------------------

--
-- Struktur dari tabel `rooms`
--

CREATE TABLE `rooms` (
  `room_id` varchar(200) NOT NULL,
  `number` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `rooms`
--

INSERT INTO `rooms` (`room_id`, `number`) VALUES
('R221', 221);

-- --------------------------------------------------------

--
-- Struktur dari tabel `schedule`
--

CREATE TABLE `schedule` (
  `schedule_id` varchar(100) NOT NULL,
  `hour` int(11) NOT NULL,
  `day_name` varchar(200) NOT NULL,
  `room_id` varchar(200) NOT NULL,
  `year` year(4) NOT NULL,
  `NIP` int(200) NOT NULL,
  `study_id` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktur dari tabel `study`
--

CREATE TABLE `study` (
  `study_id` varchar(200) NOT NULL,
  `study_name` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `study`
--

INSERT INTO `study` (`study_id`, `study_name`) VALUES
('BD', 'Basis Data'),
('PBO', 'Pemrograman Berorientasi Objek');

-- --------------------------------------------------------

--
-- Struktur dari tabel `study_period`
--

CREATE TABLE `study_period` (
  `year` year(4) NOT NULL,
  `stud_period` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `study_period`
--

INSERT INTO `study_period` (`year`, `stud_period`) VALUES
(2024, '2024-2025');

-- --------------------------------------------------------

--
-- Struktur dari tabel `teachers`
--

CREATE TABLE `teachers` (
  `NIP` int(200) NOT NULL,
  `name` varchar(100) NOT NULL,
  `phone` varchar(100) NOT NULL,
  `gender` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `teachers`
--

INSERT INTO `teachers` (`NIP`, `name`, `phone`, `gender`) VALUES
(1997121, 'Ridho', '0812121212', 0);

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `user_id` varchar(200) NOT NULL,
  `name` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`user_id`, `name`, `email`, `password`) VALUES
('U001', 'admin', 'admin@gmail.com', 'admin');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `days`
--
ALTER TABLE `days`
  ADD PRIMARY KEY (`day_name`);

--
-- Indeks untuk tabel `hours`
--
ALTER TABLE `hours`
  ADD PRIMARY KEY (`hour`);

--
-- Indeks untuk tabel `rooms`
--
ALTER TABLE `rooms`
  ADD PRIMARY KEY (`room_id`);

--
-- Indeks untuk tabel `schedule`
--
ALTER TABLE `schedule`
  ADD PRIMARY KEY (`schedule_id`);

--
-- Indeks untuk tabel `study`
--
ALTER TABLE `study`
  ADD PRIMARY KEY (`study_id`);

--
-- Indeks untuk tabel `study_period`
--
ALTER TABLE `study_period`
  ADD PRIMARY KEY (`year`);

--
-- Indeks untuk tabel `teachers`
--
ALTER TABLE `teachers`
  ADD PRIMARY KEY (`NIP`);

--
-- Indeks untuk tabel `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
