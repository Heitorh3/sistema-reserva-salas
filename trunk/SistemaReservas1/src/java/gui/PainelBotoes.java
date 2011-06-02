/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;

/**
 *
 * @author 0213101
 */
public class PainelBotoes extends Panel{

    Label lInicio;
    Button botaoLogin;
    Button botaoSair;
    Button botaoNovaReserva;
    Button botaoConsulta;
    HorizontalLayout leiaute;

    public PainelBotoes()
    {
        lInicio = new Label("<b>Sistema de Reserva de Salas 2011</b>",Label.CONTENT_XHTML);
        botaoLogin = new Button();
        botaoLogin.setCaption("Entrar no sistema");
        botaoSair = new Button();
        botaoSair.setCaption("Encerrar");
        botaoNovaReserva = new Button();
        botaoNovaReserva.setCaption("Nova Reserva");
        botaoNovaReserva.addListener(new EventoNovaJanela());
        botaoConsulta = new Button();
        botaoConsulta.setCaption("Consultar / Modificar Salas");        
        botaoSair.addListener(new EventoSair());
        
        leiaute = new HorizontalLayout();
        leiaute.addComponent(botaoLogin);
        leiaute.addComponent(botaoSair);        
        leiaute.addComponent(botaoNovaReserva);
        leiaute.addComponent(botaoConsulta);
        
        this.addComponent(leiaute);

        
    }
    
    //maneira de fazer eventos para os botoes
    private class EventoSair implements Button.ClickListener
    {
    @Override
        public void buttonClick(Button.ClickEvent event)
        {
            System.out.println("Encerra Programa");
        }

    }

    private class EventoNovaJanela implements Button.ClickListener
    {
    @Override
        public void buttonClick(Button.ClickEvent event)
        {
            //JanelaLogin nw = new JanelaLogin();
            //mainWindow.addComponent(nw);

        }

    }
}
