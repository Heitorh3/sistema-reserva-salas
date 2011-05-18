/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import classes.Reserva;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Panel;
import java.util.ArrayList;

/**
 *
 * @author 0213101
 */
class PainelDia extends Panel implements Button.ClickListener {
    private int dia;    //??
    private int mes;    //??
    private ArrayList<Reserva> reservasDia;


    public PainelDia(ArrayList<Reserva> reservasDia)
    {
        this.setWidth("200");
        this.setHeight("200");
        this.reservasDia = reservasDia;
    }

    @Override
    public void buttonClick(ClickEvent event)
    {
        throw new UnsupportedOperationException("Not supported yet.");
        //abre nova janela com a nativeselect com todos os eventos do dia (this.reservasDia)
    }
}
