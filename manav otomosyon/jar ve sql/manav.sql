-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 26 May 2020, 17:36:33
-- Sunucu sürümü: 10.4.11-MariaDB
-- PHP Sürümü: 7.2.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `manav`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `satis`
--

CREATE TABLE `satis` (
  `Adi` text COLLATE utf8mb4_turkish_ci NOT NULL,
  `AlışFiyatı` text COLLATE utf8mb4_turkish_ci NOT NULL,
  `SatışFiyatı` text COLLATE utf8mb4_turkish_ci NOT NULL,
  `ToplamKar` text COLLATE utf8mb4_turkish_ci DEFAULT '\'\\\'0\\\'\''
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

--
-- Tablo döküm verisi `satis`
--

INSERT INTO `satis` (`Adi`, `AlışFiyatı`, `SatışFiyatı`, `ToplamKar`) VALUES
('akif', '12', '22', '15');

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `satis`
--
ALTER TABLE `satis`
  ADD UNIQUE KEY `Adi` (`Adi`) USING HASH;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
