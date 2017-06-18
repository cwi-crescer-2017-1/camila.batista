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

    
END PCK_MEGASENA;
        
