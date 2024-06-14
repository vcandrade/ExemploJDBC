-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 14-Jun-2024 às 20:56
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
  `data_ingresso` date NOT NULL,
  `periodo` int(11) NOT NULL,
  `coeficiente` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `aluno`
--

INSERT INTO `aluno` (`registro_academico`, `nome`, `sexo`, `codigo_curso`, `data_ingresso`, `periodo`, `coeficiente`) VALUES
(111111, 'João da Silva', 'Masculino', 5, '2018-08-01', 2, 0.69),
(222222, 'Marcela de Almeida', 'Feminino', 4, '2015-05-10', 2, 0.88),
(333333, 'Daniel Souza', 'Masculino', 3, '2020-03-15', 5, 0),
(444444, 'Ana Vieira', 'Feminino', 2, '2019-02-19', 6, 0.61),
(555555, 'Bruna Camargo', 'Feminino', 4, '2005-05-05', 4, 0.68),
(666666, 'Amanda Oliveira', 'Feminino', 2, '2005-02-18', 6, 0.59);

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
(1, 'Tecnologia em Automação Industrial', 'Noturno', 6),
(2, 'Tecnologia em Alimentos', 'Noturno', 6),
(3, 'Bacharelado em Ciência da Computação', 'Integral', 8),
(4, 'Bacharelado em Ciências Biológicas', 'Integral', 8),
(5, 'Tecnologia em Análise e Desenvolvimento de Sistema', 'Noturno', 6),
(6, 'Engenharia Mecânica', 'Noturno', 12);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `aluno`
--
ALTER TABLE `aluno`
  ADD PRIMARY KEY (`registro_academico`),
  ADD KEY `fk_cod_curso` (`codigo_curso`);

--
-- Índices para tabela `curso`
--
ALTER TABLE `curso`
  ADD PRIMARY KEY (`codigo`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `curso`
--
ALTER TABLE `curso`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `aluno`
--
ALTER TABLE `aluno`
  ADD CONSTRAINT `fk_cod_curso` FOREIGN KEY (`codigo_curso`) REFERENCES `curso` (`codigo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
