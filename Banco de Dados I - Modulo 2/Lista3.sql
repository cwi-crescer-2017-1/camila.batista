-- LISTA 3

--Exercício 1
SELECT IDEmpregado, NomeEmpregado, DATEDIFF(year, DataNascimento, DataAdmissao) AS Idade FROM Empregado WHERE YEAR(DataAdmissao) LIKE 1980;

--Exercício 2
SELECT NomeDepartamento, COUNT(IDEmpregado) AS QuantidadeEmpregados FROM Departamento, Empregado WHERE Departamento.IDDepartamento = Empregado.IDDepartamento GROUP BY NomeDepartamento, Departamento.IDDepartamento;

--Exercício 3
SELECT UF, COUNT(IDCidade) AS QuantidadeCidade FROM Cidade GROUP BY UF;

--Exercício 4
INSERT INTO Departamento VALUES (70, 'Inovação', 'São Leopoldo');

UPDATE Empregado SET IDDepartamento = 70 WHERE MONTH(DataAdmissao) LIKE 12 AND Cargo NOT LIKE 'Atendente';
