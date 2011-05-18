/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import classes.Reserva;
import java.util.ArrayList;

/**
 *
 * @author 0213101
 */
class Calendario {
    final int DIAS_JAN = 31;
    final int DIAS_FEV = 28;    //deve ser calculado no construtor
    final int DIAS_MAR = 31;
    final int DIAS_ABR = 30;
    final int DIAS_MAI = 31;
    final int DIAS_JUN = 30;
    final int DIAS_JUL = 31;
    final int DIAS_AGO = 31;
    final int DIAS_SET = 30;
    final int DIAS_OUT = 31;
    final int DIAS_NOV = 30;
    final int DIAS_DEZ = 31;

    private ArrayList<PainelDia> paineisMes;
    private int numMes;

    public Calendario(ArrayList<Reserva> reservas, int mes)
    {
        //percorre a arraylist, procura se o mes ativo no calendario eh o mesmo mes do evento e coloca
        //o evento no dia tal
        this.numMes = mes;
        for (int i = 0; i<reservas.size()-1;i++)
        {
            Reserva tempReserva = reservas.get(i);
            //reservas.remove(0); 
            String dataInicial = tempReserva.getDataInicioEvento();            
            numMes = Integer.parseInt(dataInicial.subSequence(4,5).toString());            
        }
        
        switch (numMes)
            {
                case 1:
                {
                    for (int i = 0;i<reservas.size();i++)
                    {
              
                    }
                }
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
            }
            
    }

    private void setNumMes(int numMes)
    {
        this.numMes = numMes;
    }


}
