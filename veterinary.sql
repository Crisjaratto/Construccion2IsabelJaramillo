-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-03-2024 a las 06:02:53
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `veterinary`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura`
--

CREATE TABLE `factura` (
  `id` int(11) NOT NULL,
  `mascota` int(11) NOT NULL,
  `propietario` bigint(20) NOT NULL,
  `producto` varchar(30) NOT NULL,
  `valor` double NOT NULL,
  `cantidad` int(11) NOT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historia`
--

CREATE TABLE `historia` (
  `fecha` bigint(20) NOT NULL,
  `mascota` int(11) NOT NULL,
  `medico` bigint(20) NOT NULL,
  `motivo` text NOT NULL,
  `sintomatologia` text NOT NULL,
  `diagnosis` varchar(30) NOT NULL,
  `medicamento` varchar(30) NOT NULL,
  `medicationDosage` varchar(39) NOT NULL,
  `vacunacion` text NOT NULL,
  `alergia` text NOT NULL,
  `procedimiento` text NOT NULL,
  `detalles_procedimientos` text NOT NULL,
  `orden` int(11) NOT NULL,
  `ordercancelation` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `historia`
--

INSERT INTO `historia` (`fecha`, `mascota`, `medico`, `motivo`, `sintomatologia`, `diagnosis`, `medicamento`, `medicationDosage`, `vacunacion`, `alergia`, `procedimiento`, `detalles_procedimientos`, `orden`, `ordercancelation`) VALUES
(1710608723616, 2, 111, 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 5, 1),
(1710613358250, 3, 111, 'Dermatitis', 'Picazón', 'Z759', 'Dexametasona', '1', 'na', 'na', 'na', 'na', 5, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mascota`
--

CREATE TABLE `mascota` (
  `id` int(11) NOT NULL,
  `id_propietario` bigint(10) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `edad` int(11) NOT NULL,
  `peso` double NOT NULL,
  `raza` varchar(10) NOT NULL,
  `especie` varchar(10) NOT NULL,
  `caracteristicas` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `mascota`
--

INSERT INTO `mascota` (`id`, `id_propietario`, `nombre`, `edad`, `peso`, `raza`, `especie`, `caracteristicas`) VALUES
(2, 1037641710, 'Lucy', 9, 35, 'criolla', 'perro', 'ninguna'),
(3, 1017180189, 'Mailo', 2, 5, 'criollo', 'perro', 'ninguna');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `orden`
--

CREATE TABLE `orden` (
  `id` int(11) NOT NULL,
  `mascota` int(11) NOT NULL,
  `propietario` bigint(20) NOT NULL,
  `medico` bigint(20) NOT NULL,
  `medicamento` varchar(30) NOT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `orden`
--

INSERT INTO `orden` (`id`, `mascota`, `propietario`, `medico`, `medicamento`, `fecha`) VALUES
(5, 2, 1037641719, 1037641719, 'a', '2024-03-16'),
(6, 2, 1037641719, 1037641719, 'a', '2024-03-16'),
(7, 2, 1037641719, 1037641719, 'a', '2024-03-16'),
(8, 2, 1037641719, 1037641719, 'a', '2024-03-16'),
(9, 2, 1037641719, 1037641719, 'a', '2024-03-16'),
(10, 2, 1037641719, 1037641719, 'a', '2024-03-16'),
(11, 2, 1037641719, 1037641719, 'a', '2024-03-16'),
(12, 2, 1037641719, 1037641719, 'a', '2024-03-16'),
(13, 2, 1037641719, 1037641719, 'a', '2024-03-16'),
(14, 2, 1037641719, 1037641719, 'a', '2024-03-16'),
(15, 3, 1037641719, 1037641719, 'Dexametasona', '2024-03-16');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `cedula` bigint(11) NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `edad` int(3) NOT NULL,
  `role` varchar(30) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`cedula`, `nombre`, `edad`, `role`, `username`, `password`) VALUES
(12345678, 'Diana Rojas', 30, 'Administrador', 'DianaRojas', '123456'),
(1017180189, 'Juan Carlos Campillo Vargas', 35, 'Medico Veterinario', 'JuanCampillo', '123456'),
(1017270721, 'Armando Esteban Gonzalez Velasquez', 24, 'Vendedor', 'EstebanGonzalez', '123456'),
(1031741819, 'Patricia Taborda', 0, 'Dueño', 'Dueño', 'Dueño'),
(1037641710, 'cristina rojas', 0, 'Dueño', 'Dueño', 'Dueño'),
(1037641719, 'Isabel Jaramillo Rojas', 25, 'Medico Veterinario', 'isabel', '123456');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sesion`
--

CREATE TABLE `sesion` (
  `id` int(11) NOT NULL,
  `username` varchar(30) NOT NULL,
  `role` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `sesion`
--

INSERT INTO `sesion` (`id`, `username`, `role`) VALUES
(78, 'isabel', 'Medico Veterinario'),
(79, 'isabel', 'Medico Veterinario'),
(80, 'isabel', 'Medico Veterinario'),
(81, 'isabel', 'Medico Veterinario'),
(82, 'isabel', 'Medico Veterinario'),
(83, 'isabel', 'Medico Veterinario'),
(84, 'isabel', 'Medico Veterinario'),
(85, 'isabel', 'Medico Veterinario'),
(86, 'isabel', 'Medico Veterinario'),
(87, 'isabel', 'Medico Veterinario'),
(88, 'isabel', 'Medico Veterinario'),
(89, 'isabel', 'Medico Veterinario'),
(90, 'isabel', 'Medico Veterinario'),
(91, 'isabel', 'Medico Veterinario'),
(92, 'isabel', 'Medico Veterinario'),
(93, 'isabel', 'Medico Veterinario'),
(94, 'isabel', 'Medico Veterinario'),
(95, 'isabel', 'Medico Veterinario'),
(96, 'isabel', 'Medico Veterinario'),
(97, 'isabel', 'Medico Veterinario'),
(98, 'isabel', 'Medico Veterinario'),
(99, 'isabel', 'Medico Veterinario'),
(100, 'isabel', 'Medico Veterinario'),
(101, 'isabel', 'Medico Veterinario'),
(102, 'isabel', 'Medico Veterinario'),
(103, 'isabel', 'Medico Veterinario'),
(104, 'isabel', 'Medico Veterinario'),
(105, 'isabel', 'Medico Veterinario'),
(106, 'isabel', 'Medico Veterinario'),
(107, 'isabel', 'Medico Veterinario'),
(108, 'isabel', 'Medico Veterinario'),
(109, 'isabel', 'Medico Veterinario'),
(110, 'isabel', 'Medico Veterinario'),
(111, 'isabel', 'Medico Veterinario'),
(112, 'isabel', 'Medico Veterinario'),
(113, 'isabel', 'Medico Veterinario'),
(114, 'isabel', 'Medico Veterinario'),
(115, 'isabel', 'Medico Veterinario'),
(116, 'isabel', 'Medico Veterinario'),
(117, 'isabel', 'Medico Veterinario');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `factura`
--
ALTER TABLE `factura`
  ADD PRIMARY KEY (`id`),
  ADD KEY `factura_mascota` (`mascota`),
  ADD KEY `factura_propietario` (`propietario`);

--
-- Indices de la tabla `historia`
--
ALTER TABLE `historia`
  ADD PRIMARY KEY (`fecha`);

--
-- Indices de la tabla `mascota`
--
ALTER TABLE `mascota`
  ADD PRIMARY KEY (`id`),
  ADD KEY `propietario` (`id_propietario`);

--
-- Indices de la tabla `orden`
--
ALTER TABLE `orden`
  ADD PRIMARY KEY (`id`),
  ADD KEY `orden_mascota` (`mascota`),
  ADD KEY `orden_propietario` (`propietario`),
  ADD KEY `orden_veterinario` (`medico`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`cedula`);

--
-- Indices de la tabla `sesion`
--
ALTER TABLE `sesion`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `factura`
--
ALTER TABLE `factura`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `mascota`
--
ALTER TABLE `mascota`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1037641721;

--
-- AUTO_INCREMENT de la tabla `orden`
--
ALTER TABLE `orden`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `sesion`
--
ALTER TABLE `sesion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=118;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `factura`
--
ALTER TABLE `factura`
  ADD CONSTRAINT `factura_mascota` FOREIGN KEY (`mascota`) REFERENCES `mascota` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `factura_propietario` FOREIGN KEY (`propietario`) REFERENCES `persona` (`cedula`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `mascota`
--
ALTER TABLE `mascota`
  ADD CONSTRAINT `mascota_ibfk_1` FOREIGN KEY (`id_propietario`) REFERENCES `persona` (`cedula`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `orden`
--
ALTER TABLE `orden`
  ADD CONSTRAINT `orden_mascota` FOREIGN KEY (`mascota`) REFERENCES `mascota` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `orden_propietario` FOREIGN KEY (`propietario`) REFERENCES `persona` (`cedula`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `orden_veterinario` FOREIGN KEY (`medico`) REFERENCES `persona` (`cedula`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
