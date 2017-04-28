USE exercicios;
Create table Cidade
(
  IDCidade  int         not null,
  Nome      varchar(30) not null,
  UF        varchar(2)  not null,
    constraint PK_Cidade primary key (IDCidade)
);

insert into Cidade (IDCidade, Nome, UF)
   values (1, 'Sao Leopoldo', 'RS');
insert into Cidade (IDCidade, Nome, UF)
   values (2, 'Porto Alegre', 'RS');
insert into Cidade (IDCidade, Nome, UF)
   values (3, 'Parobe', 'RS');
insert into Cidade (IDCidade, Nome, UF)
   values (4, 'Taquara', 'RS');
insert into Cidade (IDCidade, Nome, UF)
   values (105, 'São Paulo', 'SP');
insert into Cidade (IDCidade, Nome, UF)
   values (106, 'Guarulhos', 'SP');
insert into Cidade (IDCidade, Nome, UF)
   values (27, 'Rio de Janeiro', 'RJ');
insert into Cidade (IDCidade, Nome, UF)
   values (108, 'Brasilia', 'DF');
insert into Cidade (IDCidade, Nome, UF)
   values (109, 'Belo Horizonte', 'MG');
insert into Cidade (IDCidade, Nome, UF)
   values (110, 'Uberlândia', 'MG');
insert into Cidade (IDCidade, Nome, UF)
   values (5, 'Cidade de Alagoas', 'AL');
insert into Cidade (IDCidade, Nome, UF)
   values (6, 'Maceio', 'AL');
insert into Cidade (IDCidade, Nome, UF)
   values (7, 'Itu', 'SP');
insert into Cidade (IDCidade, Nome, UF)
   values (8, 'Campinas', 'SP');
insert into Cidade (IDCidade, Nome, UF)
   values (9, 'Guaratingueta', 'SP');
insert into Cidade (IDCidade, Nome, UF)
   values (10, 'Santa Barbara', 'MG');
insert into Cidade (IDCidade, Nome, UF)
   values (11, 'Campos dos Goitacases', 'RJ');
insert into Cidade (IDCidade, Nome, UF)
   values (12, 'Sao Gabriel', 'RS');
insert into Cidade (IDCidade, Nome, UF)
   values (13, 'Brasopolis', 'MG');
insert into Cidade (IDCidade, Nome, UF)
   values (14, 'Cristina', 'MG');
insert into Cidade (IDCidade, Nome, UF)
   values (15, 'Umbuzeiro', 'PB');
insert into Cidade (IDCidade, Nome, UF)
   values (16, 'Vicosa', 'MG');
insert into Cidade (IDCidade, Nome, UF)
   values (17, 'Macae', 'RJ');
insert into Cidade (IDCidade, Nome, UF)
   values (18, 'Sao Luis', 'MA');
insert into Cidade (IDCidade, Nome, UF)
   values (19, 'Cuiaba', 'MT');
insert into Cidade (IDCidade, Nome, UF)
   values (20, 'Sao Borja', 'RS');
insert into Cidade (IDCidade, Nome, UF)
   values (21, 'Natal', 'RN');
insert into Cidade (IDCidade, Nome, UF)
   values (22, 'Diamantina', 'MG');
insert into Cidade (IDCidade, Nome, UF)
   values (23, 'Campo Grande', 'MS');
insert into Cidade (IDCidade, Nome, UF)
   values (24, 'Fortaleza', 'CE');
insert into Cidade (IDCidade, Nome, UF)
   values (25, 'Bage', 'RS');
insert into Cidade (IDCidade, Nome, UF)
   values (26, 'Bento Goncalves', 'RS');
insert into Cidade (IDCidade, Nome, UF)
   values (28, 'Pinheiro', 'MA');
insert into Cidade (IDCidade, Nome, UF)
   values (29, 'Salvador', 'BA');
insert into Cidade (IDCidade, Nome, UF)
   values (30, 'Garanhuns', 'PE');
Insert into Cidade (IDCidade, Nome, UF)
   values (31, 'São Paulo', 'SP');    
Insert into Cidade (IDCidade, Nome, UF)
   values (32, 'Guarulhos', 'SP');    
Insert into Cidade (IDCidade, Nome, UF)
   values (33, 'Rio de Janeiro', 'RJ');    
Insert into Cidade (IDCidade, Nome, UF)
   values (34, 'Brasilia', 'DF');    
Insert into Cidade (IDCidade, Nome, UF)
   values (35, 'Belo Horizonte', 'MG');        
Insert into Cidade (IDCidade, Nome, UF)
   values  (36, 'Uberlândia', 'MG');      
Insert into Cidade (IDCidade, Nome, UF)
   values  (37, 'Santana do Livramento', 'RS');
Insert into Cidade (IDCidade, Nome, UF)
   values  (38, 'Santa Maria', 'RS');
Insert into Cidade (IDCidade, Nome, UF)
   values  (39, 'Santa Rosa', 'RS');
Insert into Cidade (IDCidade, Nome, UF)
   values  (40, 'São Francisco de Paula', 'RS'); 




--Exercício 1
select into CidadeAux from cidade;

-- Exercício 2
truncate table CidadeAux;
insert into CidadeAux (IDCidade, Nome, UF) select IDCidade, Nome, UF from cidade where UF like 'RS';

--Exercício 3
create table produtos 
(
	IDProdutos int IDENTITY not null,
	Nome varchar(10) not null,
	Descricao varchar(50),
	DataCriacao DATETIME,
	LocalEstoque varchar(30),
	Quantidade int,
	Preco decimal,
		constraint PK_Produto primary key (IDProdutos)		
); 

--Exercício 4
insert into produtos (Nome, Descricao, DataCriacao, LocalEstoque, Quantidade, Preco) values 
('Produto 1', 'Alguma coisa', 2004-05-23, 'em algum lugar', 23, 10.8);
insert into produtos values ('Produto 2', 'pudim', 2018-09-22, 'por ai', 43, 0.98);


select * from produtos;