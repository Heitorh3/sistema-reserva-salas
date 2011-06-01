/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import classes.Reserva;
import com.vaadin.event.MouseEvents;
import com.vaadin.event.MouseEvents.ClickListener;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import java.util.ArrayList;

/**
 *
 * @author 0213101
 */
class PainelDia extends Panel {
    private int dia;    //??
    private int mes;    //??
    private ArrayList<Reserva> reservasDia;
    Label textoDia;
    Label textoRes;
    VerticalLayout leiaute;


    public PainelDia(ArrayList<Reserva> reservasDia, int dia)
    {
        //this.setHeight("50");
        //this.setWidth("50");
        leiaute = new VerticalLayout();

        this.dia = dia;
        //this.setWidth("100");
        //this.setHeight("100");
        this.reservasDia = reservasDia;
        textoDia = new Label(""+dia);
        textoRes = new Label(""+reservasDia.size()+" reservas");
        leiaute.addComponent(textoDia);
        leiaute.setComponentAlignment(textoDia, Alignment.TOP_LEFT);
        leiaute.addComponent(textoRes);
        leiaute.setComponentAlignment(textoRes, Alignment.BOTTOM_CENTER);
        this.addComponent(leiaute);
        this.addListener(new ClickListener() {

            @Override
            public void click(MouseEvents.ClickEvent event) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        } );

    }

    private class EventoPassaReservas implements Button.ClickListener
    {
    @Override
        public void buttonClick(Button.ClickEvent event)
        {
            System.out.println("oioioioi");

        }
    }
}
