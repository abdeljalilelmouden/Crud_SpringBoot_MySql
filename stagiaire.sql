-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : lun. 27 avr. 2020 à 05:29
-- Version du serveur :  10.4.11-MariaDB
-- Version de PHP : 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `stagiaire`
--

-- --------------------------------------------------------

--
-- Structure de la table `role`
--

CREATE TABLE `role` (
  `role` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `role`
--

INSERT INTO `role` (`role`, `description`) VALUES
('ADMIN', 'administrateur'),
('USER', 'utilisateur');

-- --------------------------------------------------------

--
-- Structure de la table `stagiaire`
--

CREATE TABLE `stagiaire` (
  `id` bigint(20) NOT NULL,
  `date_naissance` date DEFAULT NULL,
  `nom` varchar(15) NOT NULL,
  `prenom` varchar(15) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `stagiaire`
--

INSERT INTO `stagiaire` (`id`, `date_naissance`, `nom`, `prenom`) VALUES
(1, '2020-04-27', 'khadija', 'ABDELJALIL'),
(2, '2020-04-27', 'ali ali', 'alami'),
(3, '2020-04-27', 'naima', 'jamali'),
(4, '2020-04-27', 'khadija', 'ABDELJALIL'),
(5, '2020-04-27', 'ali ali', 'alami'),
(6, '2020-04-27', 'naima', 'jamali'),
(7, '2020-04-27', 'khadija', 'ABDELJALIL'),
(8, '2020-04-27', 'ali ali', 'alami'),
(9, '2020-04-27', 'naima', 'jamali'),
(10, '2020-04-27', 'khadija', 'ABDELJALIL'),
(11, '2020-04-27', 'ali ali', 'alami'),
(12, '2020-04-27', 'naima', 'jamali'),
(13, '2020-04-27', 'khadija', 'ABDELJALIL'),
(14, '2020-04-27', 'ali ali', 'alami'),
(15, '2020-04-27', 'naima', 'jamali'),
(16, '2020-04-27', 'khadija', 'ABDELJALIL'),
(17, '2020-04-27', 'ali ali', 'alami'),
(18, '2020-04-27', 'naima', 'jamali');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `username` varchar(255) NOT NULL,
  `actived` bit(1) NOT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`username`, `actived`, `password`) VALUES
('admin', b'1', 'admin'),
('user', b'1', 'user');

-- --------------------------------------------------------

--
-- Structure de la table `user_role`
--

CREATE TABLE `user_role` (
  `user_username` varchar(255) NOT NULL,
  `roles_role` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `user_role`
--

INSERT INTO `user_role` (`user_username`, `roles_role`) VALUES
('admin', 'ADMIN'),
('user', 'USER'),
('admin', 'USER');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`role`);

--
-- Index pour la table `stagiaire`
--
ALTER TABLE `stagiaire`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`username`);

--
-- Index pour la table `user_role`
--
ALTER TABLE `user_role`
  ADD KEY `FKgvlamif7qhr5hwaphc28rxh0s` (`roles_role`),
  ADD KEY `FKdeg30urqytlwess957r1ugy7m` (`user_username`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `stagiaire`
--
ALTER TABLE `stagiaire`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
