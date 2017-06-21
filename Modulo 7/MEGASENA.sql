-----------------------------------------------------------------
CREATE OR REPLACE PACKAGE PCK_MEGASENA AS
  FUNCTION buscaPercentual(fIdentificador VARCHAR2) RETURN NUMBER;
  PROCEDURE defineRateioPremio;
  PROCEDURE SALVAR_CONCURSO;
  PROCEDURE gerarProximoConcurso;
END;

------------------------------------------------------------------

CREATE OR REPLACE PACKAGE BODY PCK_MEGASENA AS

  ---------------------------------------------------------------------------------------------------------------------------------------
 /* Busca valores percentuais conforme regra definida na tabela 'Regra_Rateio_Premio' */
  function buscaPercentual(pIdentificador in varchar2) return number as
        -- 
        v_percentual  regra_rateio_premio.percentual%type; -- herdará as propriedades do campo percentual
      begin

        -- busca percentual conforme parametro de entrada
        select percentual
        into   v_percentual   -- atribuí valor para a variavel
        from   regra_rateio_premio
        where  identificador = lower(pIdentificador);

        return v_percentual;
      exception
        when no_data_found then
          dbms_output.put_line('Erro: '||pIdentificador);
          raise_application_error(-20002, sqlerrm);
      end buscaPercentual;
      
  ---------------------------------------------------------------------------------------------------------------------------------------
  /* Executa o rateio dos premios conforme definção das regras */
  procedure defineRateioPremio (pPremio in number) as
    begin

       gPremio_sena          := buscaPercentual('premio_sena') * pPremio;
       gPremio_quina         := buscaPercentual('premio_quina') * pPremio;
       gPremio_quadra        := buscaPercentual('premio_quadra') * pPremio;
       gAcumulado_proximo_05 := buscaPercentual('acumulado_05') * pPremio;
       gAcumulado_final_ano  := buscaPercentual('acumulado_final_ano') * pPremio;

    end defineRateioPremio;

  ---------------------------------------------------------------------------------------------------------------------------------------

    PROCEDURE SALVAR_CONCURSO 
        (
            PConcurso IN CONCURSO.IDCONSURSO%TYPE, 
            PData IN CONCURSO.DATA_SORTEIO%TYPE, 
            premio IN CONCURSO.PREMIO_SENA%TYPE
        ) AS
        BEGIN
            defineRateio(premio);
            
            INSERT INTO CONCURSO
                (Idconcurso, Data_Sorteio, Premio_Sena, Premio_Quina, Premio_Quadra, Acumulado_Proximo_05, Acumulado_Final_Ano)
            VALUES
                (pConcurso, pData, gPremio_Sena, gPremio_Quina, gPremio_Quadra, gAcumulado_proximo_05, gAcumulado_final_ano);
        END SALVAR_CONCURSO;

  -------------------------------------- A ------------------------------------------------------------------------------------------------

    PROCEDURE gerarProximoConcurso AS
        ultimo_concurso CONCURSO.IDCONCURSO%TYPE;
        valor_aposta APOSTA.VALOR%TYPE;
        acumulou CONCURSO.ACUMULOU%TYPE;
        acumulado CONSURSO.PREMIO_SENA%TYPE;
        
        BEGIN
            
            SELECT MAX(IDCONCURSO) 
            INTO ultimo_concurso
            FROM CONCURSO;
            
            SELECT SUM(VALOR)
            INTO valor_aposta
            FROM APOSTA
            WHERE IDCONCURSO = ultimo_concurso;
            
            SELECT ACUMULOU
            INTO acumulou
            FROM CONCURSO
            WHERE IDCONCURSO = ultimo_concurso;
            
            IF acumulou = 1 THEN
                SELECT PREMIO_SENA
                INTO acumulado
                FROM CONCURSO
                WHERE IDCONCURSO = ultimo_concurso;
            END IF;
            
            
            PCK_MEGASENA.SALVAR_CONCURSO
                (
                    ultimo_concurso + 1,
                    TRUNC(SYSDATE),
                    ((valor_aposta + acumulado) * .453)
                );
        END gerarProximoConcurso;

  -------------------------------------- B ------------------------------------------------------------------------------------------------

    FUNCTION premio (idConcurso IN NUMERIC, tipo IN NUMERIC, ganhadores IN NUMERIC) RETURN CONCURSO.PREMIO_QUINA$TYPE AS 
        fReturn CONCURSO.PREMIO_QUINA$TYPE;
        
        BEGIN
            IF(tipo = 1) THEN
                SELECT PREMIO_SENA INTO fReturn FROM CONCURSO WHERE IDCONCURSO = idConcurso;
            ELSIF(tipo = 2) THEN
                SELECT PREMIO_QUINA INTO fReturn FROM CONCURSO WHERE IDCONCURSO = idConcurso;
            ELSIF (tipo = 3) THEN
                SELECT PREMIO_QUADRA INTO fReturn FROM CONCURSO WHERE IDCONCURSO = idConcurso;
            END IF;
            
        fReturn := fReturn / ganhadores;
        RETURN fReturn;
    END premio;

    PROCEDURE atualizaAcertadores(pConcurso IN INTEGER) AS
        
        CURSOR ganhadores IS
            SELECT * FROM 
                (
                  SELECT A.IDAPOSTA, 
                    COUNT(CASE WHEN 
                        N.NUMERO = C.PRIMEIRA_DEZENA OR
                        N.NUMERO = C.SEGUNDA_DEZENA OR
                        N.NUMERO = C.TERCEIRA_DEZENA OR
                        N.NUMERO = C.QUARTA_DEZENA OR
                        N.NUMERO = C.QUINTA_DEZENA OR
                        N.NUMERO = C.SEXTA_DEZENA
                    THEN 1 END) AS ACERTOS
                  FROM APOSTAS A
                    INNER JOIN CONCURSO C ON C.IDCONCURSO = A.IDCONCURSO
                    INNER JOIN NUMERO_APOSTA N ON C.IDAPOSTA = N.IDAPOSTA
                    WHERE C.IDCONCURSO = pConcurso
                    GROUP BY A.IDAPOSTA  
                )
            WHERE ACERTOS > 3;
        
        vGanhadoresQuadra INTEGER := 0;
        vGanhadoresQuina INTEGER := 0;
        vGanhadoresSena INTEGER := 0;
        vPremioQuadra CONCURSO.PREMIO_QUADRA%TYPE;
        vPremioQuina CONCURSO.PREMIO_QUINA%TYPE;
        vPremioSena CONCURSO.PREMIO111_SENA%TYPE;
        vIdConcurso CONCURSO.IDCONCURSO%TYPE := pConcurso;
        vAcumulou CONCURSO.ACUMULOU%TYPE;
        vValorGanhador APOSTA_PREMIADA.VALOR%TYPE;
            
        BEGIN
        --ganhadores de cada concurso
           FOR G IN ganhador LOOP
            IF (G.ACERTOS = 4) THEN
                vGanhadoresQuadra := vGanhadoresQuadra + 1;
            ELSIF (G.ACERTOS = 5) THEN
                vGanhadoresQuina := vGanhadoresQuina + 1;
            ELSIF (G.ACERTOS = 6) THEN
                vGanhadoresSena := vGanhadoresSena + 1;
            END IF;
           END LOOP;
           
        IF(vGanhadoresQuadra > 0) THEN
            vPremioQuadra := premio(vIdConcurso, 3, vGanhadoresQuadra);
        ELSIF (vGanhadoresQuina > 0) THEN
            vPremioQuina := premio(vIdConcurso, 2, vGanhadoresQuina);
        ELSIF(vGanhadoresSena > 0) THEN
            vPremioSena := premio(vIdConcurso, 1, vGanhadoresSena);
        END IF;
        

        IF(vAcumulou = 1) THEN
            UPDATE CONCURSO SET Acumulou = 1 WHERE IDCONCURSO = vIdConcurso;
        END IF;
        
        --aposta
        FOR G IN ganhadores LOOP
            IF(G.ACERTOS = 4) THEN
                vValorGanhador := vPremioQuadra;
            ELSIF(G.ACERTOS = 5) THEN
                vValorGanhador := vPremioQuina;
            ELSIF(G.ACERTOS = 6) THEN
                vValorGanhador := vPremioSena;
            END IF;
        
            INSERT INTO APOSTA_PREMIADA (IDAPOSTA_PREMIADA, IDAPOSTA, ACERTOS, VALOR)
            VALUES(IDAPOSTA_PREMIADA.NEXTVAL, G.IDAPOSTA, G.ACERTOS, G.vValorGanhador);    
        END LOOP;
        
        END atualizaAcertadores;
        BEGIN NULL;
    
END PCK_MEGASENA; 

