-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 28 Jun 2025 pada 08.53
-- Versi server: 10.4.27-MariaDB
-- Versi PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hororlist`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `film horor`
--

CREATE TABLE `film horor` (
  `id` int(11) NOT NULL,
  `tittle` varchar(100) NOT NULL,
  `year` int(11) NOT NULL,
  `country` varchar(50) NOT NULL,
  `genre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `film horor`
--

INSERT INTO `film horor` (`id`, `tittle`, `year`, `country`, `genre`) VALUES
(1, 'The Conjuring', 2013, 'USA', 'Demonic Possession'),
(2, 'Annabelle', 2014, 'USA', 'Supernatural Horror'),
(3, 'Train to Busan', 2016, 'South Korea', 'Zombie'),
(4, 'Insidious', 2010, 'USA', 'Supernatural Horror');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `film horor`
--
ALTER TABLE `film horor`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
