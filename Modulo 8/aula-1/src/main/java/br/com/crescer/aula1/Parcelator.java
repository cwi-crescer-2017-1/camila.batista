/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula1;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Camila
 */
public class Parcelator implements IParcelator{

    private Map<String, BigDecimal> parcelas = new HashMap<String, BigDecimal>();
    private SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
    private Calendar calendar = Calendar.getInstance();
    
    @Override
    public Map<String, BigDecimal> calcular(BigDecimal valorParcelar, int numeroParcelas, double taxaJuros, Date dataPrimeiroVencimento) {

        calendar.setTime(dataPrimeiroVencimento);
        BigDecimal parcelaMes = new BigDecimal((valorParcelar.doubleValue() * (1 + taxaJuros) / 100) / numeroParcelas);
    
        for(int a = 1; a <= numeroParcelas; a++){
            parcelas.put(date.format(calendar.getTime()), parcelaMes);
            calendar.add(Calendar.MONTH, 1);
        }
        return parcelas;
    }    
}
