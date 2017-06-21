/*
  
  Devido à uma falha no sistema uma aposta do DF não foi registrada no sistema.
  Em tempo, seguem os dados!
  
  Executar dentro da base da megasena!  
*/

insert into Aposta (Idaposta, Idconcurso, Idcidade, Data_Hora, Quantidade_Numeros, Valor)
  values (5000124, 1824, 171, sysdate, 6, 3.5);

insert into Numero_Aposta (idnumero_aposta, idaposta, numero) values (sqnumero_aposta.nextval, 5000124, 14); 
insert into Numero_Aposta (idnumero_aposta, idaposta, numero) values (sqnumero_aposta.nextval, 5000124, 15);
insert into Numero_Aposta (idnumero_aposta, idaposta, numero) values (sqnumero_aposta.nextval, 5000124, 23);
insert into Numero_Aposta (idnumero_aposta, idaposta, numero) values (sqnumero_aposta.nextval, 5000124, 54);
insert into Numero_Aposta (idnumero_aposta, idaposta, numero) values (sqnumero_aposta.nextval, 5000124, 27);
insert into Numero_Aposta (idnumero_aposta, idaposta, numero) values (sqnumero_aposta.nextval, 5000124, 46);

commit;



select * from cidade;

-------------------------------------------------------------------------------

CREATE TABLE LogAposta(
  idlogaposta integer not null,
  operacao char(1) not null,
  idaposta number not null,
  idconcurso number not null,
  idcidade number not null,
  dataHora date not null,
  quantidadeNumeros number not null,
  valor number not null,
  bolao number not null,
  
    constraint PK_LogAposta
      primary key (idlogaposta)
);

------------------------------- 1 ---------------------------------------------

CREATE OR REPLACE TRIGGER TR_APOSTA
  AFTER INSERT OR UPDATE OR DELETE ON APOSTA
  FOR EACH ROW
DECLARE
  v_idAposta INTEGER;
  v_idConcurso INTEGER;
  v_idCidade INTEGER;
  v_operacao CHAR(1);
  v_data_hora DATE;
  v_quantidade_numeros NUMBER;
  v_valor NUMBER;
  v_bolao NUMBER;
BEGIN

  IF INSERTING THEN
    v_operacao := 'I';
    v_idAposta := :new.idAposta;
    v_idConcurso := :new.idConcurso;
    v_idCidade := :new.idCidade;
    v_data_hora := :new.data_hora;
    v_quantidade_numeros := :new.quantidade_numeros;
    v_valor := :new.valor;
    v_bolao := :new.bolao;
  
  ELSIF UPDATING THEN
    v_operacao := 'U';
    v_idAposta := :old.idAposta;
    v_idConcurso := :old.idConcurso;
    v_idCidade := :old.idCidade;
    v_data_hora := :new.data_hora;
    v_quantidade_numeros := :new.quantidade_numeros;
    v_valor := :new.valor;
    v_bolao := :new.bolao;
    
  ELSE
    v_operacao := 'D';
    v_idAposta := :old.idAposta;
    v_idConcurso := :old.idConcurso;
    v_idCidade := :old.idCidade;
    v_data_hora := :old.data_hora;
    v_quantidade_numeros := :old.quantidade_numeros;
    v_valor := :old.valor;
    v_bolao := :old.bolao;
    
  END IF;
  
  INSERT INTO LogAposta (idlogaposta, operacao, idaposta, idconcurso, idcidade, dataHora, quantidadeNumeros, valor, bolao)
    VALUES(sqlogcliente.nextval, v_operacao, v_idAposta, v_idConcurso, v_idCidade, sysdate, v_quantidade_numeros, v_valor, v_bolao);

END TR_APOSTA;
------------------------------- 2 ---------------------------------------------

SELECT C.UF, CC.IDCONCURSO, SUM(A.IDAPOSTA) NumApostas, SUM(A.VALOR) ValorArrecadado, SUM(AP.IDAPOSTA_PREMIADA) Ganhadores, SUM(AP.VALOR) Premio
FROM APOSTA A JOIN CIDADE C ON C.IDCIDADE = A.IDCIDADE
JOIN CONCURSO CC ON CC.IDCCONCURSO = A.IDCONCURSO
LEFT JOIN APOSTA_PREMIADA AP ON AP.IDAPOSTA = A.APOSTA
GROUP BY CC.IDCONCURSO, C.UF;    
    
------------------------------- 3 ---------------------------------------------

