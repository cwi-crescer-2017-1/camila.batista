-- LISTA 3

--Exercício 1
SELECT IDEmpregado, NomeEmpregado FROM Empregado WHERE YEAR(DataAdmissao) LIKE 1980;

--Exercício 2
SELECT NomeDepartamento, COUNT(IDEmpregado) AS QuantidadeEmpregados FROM Departamento, Empregado WHERE Departamento.IDDepartamento = Empregado.IDDepartamento GROUP BY NomeDepartamento, Departamento.IDDepartamento;
