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


    public PainelDia(ArrayList<Reserva> reservasDia, int dia)
    {
        listener = null;     
        //this.setHeight("50");
        //this.setWidth("50");
        leiaute = new VerticalLayout();

        this.dia = dia;
        //this.setWidth("100");
        //this.setHeight("100");
        this.reservasDesteDia = reservasDia;
        textoDia = new Label(""+dia);
        textoRes = new Label(""+reservasDia.size()+" reservas");
        leiaute.addComponent(textoDia);
        leiaute.setComponentAlignment(textoDia, Alignment.TOP_LEFT);
        leiaute.addComponent(textoRes);
        leiaute.setComponentAlignment(textoRes, Alignment.BOTTOM_CENTER);
        this.addComponent(leiaute);        
    }
}
