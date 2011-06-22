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

        reservasDesteDia = new ArrayList();
        this.reservasDesteDia = reservasDia;


        textoDia = new Label(Integer.toString(dia));
        textoRes = new Label();
        textoRes.setCaption(Integer.toString(reservasDesteDia.size()) + " reservas");
        leiaute.addComponent(textoDia);
        //leiaute.setComponentAlignment(textoDia, Alignment.TOP_LEFT);
        leiaute.addComponent(textoRes);
        //leiaute.setComponentAlignment(textoRes, Alignment.BOTTOM_CENTER);
        mainLeiaute.addComponent(leiaute);
        mainLeiaute.setComponentAlignment(leiaute, Alignment.TOP_LEFT);
        this.addComponent(mainLeiaute);

        
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public VerticalLayout getLeiaute() {
        return leiaute;
    }

    public void setLeiaute(VerticalLayout leiaute) {
        this.leiaute = leiaute;
    }

    public ClickListener getListener() {
        return listener;
    }

    public void setListener(ClickListener listener) {
        this.listener = listener;
    }

    public VerticalLayout getMainLeiaute() {
        return mainLeiaute;
    }

    public void setMainLeiaute(VerticalLayout mainLeiaute) {
        this.mainLeiaute = mainLeiaute;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public ArrayList<Reserva> getReservasDesteDia() {
        return reservasDesteDia;
    }

    public void setReservasDesteDia(ArrayList<Reserva> reservasDesteDia) {
        this.reservasDesteDia = reservasDesteDia;
    }

    public Label getTextoDia() {
        return textoDia;
    }

    public void setTextoDia(Label textoDia) {
        this.textoDia = textoDia;
    }

    public Label getTextoRes() {
        return textoRes;
    }

    public void setTextoRes(Label textoRes) {
        this.textoRes = textoRes;
    }


}


