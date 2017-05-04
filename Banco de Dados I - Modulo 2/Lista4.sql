-- LISTA 4

--Exercício 1
SELECT *, DATEDIFF(MONTH, Data_Inicio_Prev, Data_Fim_Prev) AS TempoPrevisto, DATEDIFF(MONTH, Data_Fim_Prev, Data_Fim_Real) AS TempoReal FROM Licitacao WHERE DATEDIFF(MONTH, Data_Inicio_Prev, Data_Fim_Prev) NOT LIKE DATEDIFF(MONTH, Data_Fim_Prev, Data_Fim_Real);

--Exercício 2
SELECT TOP 10 Empresa_Licitante, SUM(Valor_Realizado) AS TotalFaturamento, (SUM(Valor_Realizado) / SUM(Profissionais)) AS ValorMédioProfissional FROM Licitacao GROUP BY Empresa_Licitante ORDER BY SUM(Valor_Realizado) DESC;

--Exercício 3
SELECT TOP 10 Municipio, Estado, SUM(Imposto_Municipal) AS ArrecadaçãoImpostos FROM Licitacao GROUP BY Municipio, Estado ORDER BY SUM(Imposto_Municipal) DESC;

-- Exercício 4
SELECT * FROM Licitacao WHERE DATEPART(WEEKDAY, Data_Inicio_Real) LIKE 1 OR DATEPART(WEEKDAY, Data_Inicio_Real) LIKE 7;

--Exercício 5
SELECT Empresa_Licitante, SUM(Valor_Realizado) AS Faturamento, Faturamento_1Ano_Anterior FROM Licitacao GROUP BY Empresa_Licitante, Faturamento_1Ano_Anterior HAVING SUM(Valor_Realizado) >= (0.5 * Faturamento_1Ano_Anterior); 

--Exercício 6
SELECT CASE
	WHEN Esfera LIKE 'Federal' THEN Valor_Realizado - Imposto_Federal
	WHEN Esfera LIKE 'Municipal' THEN Valor_Realizado - Imposto_Municipal
	WHEN Esfera LIKE 'Estadual' THEN Valor_Realizado - Imposto_Estadual
END AS 'CustoReal', * FROM Licitacao;

--Exercício 7
SELECT * FROM Licitacao WHERE Identificador LIKE 17255;
SELECT * FROM Licitacao WHERE Projeto LIKE 'Escola Técnica Bento Gonçalves';
 -- Foi constatado que este projeto já estava sendo realizado por outra empresa, empresa esta que concorreu com outras 13 empresas e ganhou a disputa, realizando o projeto por 1360000

