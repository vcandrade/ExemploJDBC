-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 08-Maio-2023 às 16:21
-- Versão do servidor: 10.4.17-MariaDB
-- versão do PHP: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `utfprdb`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `aluno`
--

CREATE TABLE `aluno` (
  `registro_academico` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `sexo` varchar(15) NOT NULL,
  `codigo_curso` int(11) NOT NULL,
  `data_ingresso` varchar(12) NOT NULL,
  `periodo` int(11) NOT NULL,
  `coeficiente` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `aluno`
--

INSERT INTO `aluno` (`registro_academico`, `nome`, `sexo`, `codigo_curso`, `data_ingresso`, `periodo`, `coeficiente`) VALUES
(1, 'João da Silva', 'Masculino', 2, '01/02/2020', 3, 0.71),
(2, 'Maria de Oliveira', 'Feminino', 5, '01/08/2022', 5, 0.88),
(3, 'Ricardo Carvalho', 'Masculino', 3, '01/08/2020', 4, 0.55),
(4, 'Marcela', 'Feminino', 5, '15/05/2015', 2, 0.88),
(5, 'Carlos', 'Masculino', 9, '01/01/2010', 5, 0.45);

-- --------------------------------------------------------

--
-- Estrutura da tabela `curso`
--

CREATE TABLE `curso` (
  `codigo` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `periodo` varchar(50) NOT NULL,
  `duracao` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `curso`
--

INSERT INTO `curso` (`codigo`, `nome`, `periodo`, `duracao`) VALUES
(1, 'Engenharia Mecânica', 'Integral', 10),
(2, 'Engenharia de Produção', 'Integral', 10),
(3, 'Bacharelado em Ciência da Computação', 'Integral', 8),
(4, 'Tecnol em Análise e Desenvolvimento de Sistemas', 'Noturno', 6),
(5, 'Bacharelado em Ciências Biológicas', 'Diurno', 8),
(9, 'Tecnologia em Automação Industrial', 'Noturno', 5);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `aluno`
--
ALTER TABLE `aluno`
  ADD PRIMARY KEY (`registro_academico`),
  ADD KEY `fk_codigo_curso` (`codigo_curso`);

--
-- Índices para tabela `curso`
--
ALTER TABLE `curso`
  ADD PRIMARY KEY (`codigo`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `aluno`
--
ALTER TABLE `aluno`
  MODIFY `registro_academico` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de tabela `curso`
--
ALTER TABLE `curso`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `aluno`
--
ALTER TABLE `aluno`
  ADD CONSTRAINT `fk_codigo_curso` FOREIGN KEY (`codigo_curso`) REFERENCES `curso` (`codigo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
