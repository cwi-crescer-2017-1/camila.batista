/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula1;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Camila
 */
public class CalendarUtils implements ICalendarUtils{

    private Calendar calendar = Calendar.getInstance();

    
    @Override
    public DiaSemana diaSemana(Date date) {
        calendar.setTime(date);
        
        return DiaSemana.values()[calendar.get(Calendar.DAY_OF_WEEK) - 1];
    }

    @Override
    public String tempoDecorrido(Date date) {
        calendar.setTime(date);
        
        Period duracao = Period.between(LocalDate.now(), LocalDate.of(
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
        ));
        
        return String.format(Math.abs(duracao.getYears()) + " ano(s)"
                            + Math.abs(duracao.getMonths()) + " mes(es)"
                            + Math.abs(duracao.getDays()) + " dia(s)");
    }    
}
