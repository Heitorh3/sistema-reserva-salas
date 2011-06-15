/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.paineis;

import com.vaadin.event.MouseEvents.ClickEvent;
import entidades.Reserva;
import com.vaadin.event.MouseEvents.ClickListener;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import java.util.ArrayList;


/**
 *
 * @author 0213101
 */
public class PainelDia extends Panel{
    private int dia;    //??
    private int mes;    //??
    private ArrayList<Reserva> reservasDesteDia;
    Label textoDia;
    Label textoRes;
    VerticalLayout leiaute;
    ClickListener listener;
    VerticalLayout mainLeiaute;


    public PainelDia(ArrayList<Reserva> reservasDia, int dia)
    {
        listener = null;             

        mainLeiaute = new VerticalLayout();
        leiaute = new VerticalLayout();

        this.dia = dia;
        
        this.reservasDesteDia = reservasDia;

        textoDia = new Label(Integer.toString(dia));
        textoRes = new Label(Integer.toString(reservasDia.size())+" reservas");
        leiaute.addComponent(textoDia);
        //leiaute.setComponentAlignment(textoDia, Alignment.TOP_LEFT);
        leiaute.addComponent(textoRes);
        //leiaute.setComponentAlignment(textoRes, Alignment.BOTTOM_CENTER);
        mainLeiaute.addComponent(leiaute);
        mainLeiaute.setComponentAlignment(leiaute, Alignment.TOP_LEFT);
        this.addComponent(mainLeiaute);
        
    }
}
