-- phpMyAdmin SQL Dump
-- version 5.2.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Tempo de geração: 27/05/2026 às 03:57
-- Versão do servidor: 10.11.16-MariaDB
-- Versão do PHP: 8.4.20

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
-- Estrutura para tabela `aluno`
--

CREATE TABLE `aluno` (
  `registroAcademico` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `sexo` varchar(255) NOT NULL,
  `codigoCurso` int(11) NOT NULL,
  `dataIngresso` date NOT NULL,
  `periodo` int(11) NOT NULL,
  `coeficiente` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

--
-- Despejando dados para a tabela `aluno`
--

INSERT INTO `aluno` (`registroAcademico`, `nome`, `sexo`, `codigoCurso`, `dataIngresso`, `periodo`, `coeficiente`) VALUES
(111, 'João da Silva', 'Masculino', 1, '2020-02-01', 3, 0.8),
(222, 'Maria de Oliveira', 'Feminino', 4, '2022-03-15', 2, 0.55),
(333, 'Ricardo Carvalho', 'Masculino', 3, '2026-02-20', 1, 0.6);

-- --------------------------------------------------------

--
-- Estrutura para tabela `curso`
--

CREATE TABLE `curso` (
  `codigo` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `periodo` varchar(255) NOT NULL,
  `duracao` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

--
-- Despejando dados para a tabela `curso`
--

INSERT INTO `curso` (`codigo`, `nome`, `periodo`, `duracao`) VALUES
(1, 'Tecnologia em Análise e Desenvolvimento de Sistemas', 'Noturno', 6),
(2, 'Bacharelado em Ciência da Computação', 'Integral', 8),
(3, 'Engenharia Mecânica', 'Integral', 10),
(4, 'Bacharelado em Ciências Biológicas', 'Integral', 8);

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `aluno`
--
ALTER TABLE `aluno`
  ADD PRIMARY KEY (`registroAcademico`),
  ADD KEY `fk_codigoCurso` (`codigoCurso`);

--
-- Índices de tabela `curso`
--
ALTER TABLE `curso`
  ADD PRIMARY KEY (`codigo`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `curso`
--
ALTER TABLE `curso`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `aluno`
--
ALTER TABLE `aluno`
  ADD CONSTRAINT `fk_codigoCurso` FOREIGN KEY (`codigoCurso`) REFERENCES `curso` (`codigo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
