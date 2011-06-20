/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.paineis;

import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Window;
import gui.janelas.JanelaGerenciarSalas;
import gui.janelas.JanelaGerenciarUsuarios;
import gui.janelas.JanelaPesquisas;

/**
 *
 * @author 0213101
 */
public class PainelBotoes extends Panel{

    Label lInicio;
    Button botaoLogin;
    //Button botaoSair;
    Button botaoNovaReserva;
    Button botaoConsultaSala;
    Button botaoPesquisar;
    Button gerenciarUsuarios;
    HorizontalLayout leiaute;
    Window win;
    PainelLogin pl;

    public PainelBotoes(Window win)
    {
        pl = new PainelLogin();
        this.win = win;
        lInicio = new Label("<b>Sistema de Reserva de Salas 2011</b>",Label.CONTENT_XHTML);
        botaoLogin = new Button();
        botaoLogin.setCaption("Entrar no sistema");
        botaoLogin.addListener(new EventoLogin());
        //botaoSair = new Button();
        //botaoSair.setCaption("Encerrar");
        
        botaoPesquisar = new Button("Pesquisar...");
        botaoPesquisar.addListener(new EventoPesquisar());
        /*
        botaoNovaReserva.setCaption("Nova Reserva");
        botaoNovaReserva.addListener(new EventoNovaReserva());
        *
        */
        botaoConsultaSala = new Button();
        botaoConsultaSala.setCaption("Gerenciar Salas...");
        botaoConsultaSala.addListener(new EventoNovaSala());
        
        gerenciarUsuarios = new Button("Gerenciar Usuários...");
        gerenciarUsuarios.addListener(new EventoGerUsers());
        
        
        leiaute = new HorizontalLayout();
        leiaute.setSpacing(true);
        leiaute.addComponent(pl);
        pl.setVisible(false);
        leiaute.addComponent(botaoLogin);
        //leiaute.addComponent(botaoSair);
        leiaute.addComponent(botaoConsultaSala);
        leiaute.addComponent(gerenciarUsuarios);
        leiaute.addComponent(botaoPesquisar);
        this.addComponent(lInicio);
        this.addComponent(leiaute);

        
    }

    
    //maneira de fazer eventos para os botoes
    private class EventoNovaSala implements Button.ClickListener
    {
    @Override
        public void buttonClick(Button.ClickEvent event)
        {
            JanelaGerenciarSalas FNS = new JanelaGerenciarSalas();
            win.addWindow(FNS);

        }

    }
    
    private class EventoGerUsers implements Button.ClickListener
    {
    @Override
        public void buttonClick(Button.ClickEvent event)
        {
            JanelaGerenciarUsuarios JGU = new JanelaGerenciarUsuarios();
            win.addWindow(JGU);

        }

    }

    private class EventoPesquisar implements Button.ClickListener
    {
    @Override
        public void buttonClick(Button.ClickEvent event)
        {
            JanelaPesquisas jp = new JanelaPesquisas();
            win.addWindow(jp);

        }

    }
    
    private class EventoLogin implements Button.ClickListener
    {
    @Override
        public void buttonClick(Button.ClickEvent event)
        {
            if (pl.isVisible())
                pl.setVisible(false);
            else
                pl.setVisible(true);
        }
    }

}

