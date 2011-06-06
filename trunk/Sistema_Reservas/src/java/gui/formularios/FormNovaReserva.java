/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.formularios;

import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;

/**
 *
 * @author 0213101
 */
public class FormNovaReserva extends Window{
    Panel principal;
    Panel sala;
    Panel labelResponsavel;
    TextField nomeReserva;
    TextField solicitante;
    NativeSelect NSresponsavel;
    NativeSelect NSdia;
    NativeSelect NSmes;
    NativeSelect NSano;
    NativeSelect NSsala;
    Label numeroSala;
    Label localizacaoSala;
    Label tipoSala;
    ComboBox recsSala;

    /*
     * A fábrica não tem trabalho megafoda, a gente que torna o trabalho
     * megafoda pra valorizar.
     * - Cabeceia
     */
    public FormNovaReserva()
    {

        this.setModal(true);
        this.setWidth("50%");
        this.setHeight("50%");
        this.center();

        principal = new Panel();
        HorizontalLayout leiaute = new HorizontalLayout();
        nomeReserva = new TextField("Nome do Evento");
        solicitante = new TextField("Solicitante");
        //neste setValue vai o nome do solicitante logado no sistema
        solicitante.setValue("Manolo");
        NSresponsavel = new NativeSelect("Responsável");
        NSdia = new NativeSelect("Dia");
        for (int i = 1; i < 32;i++)
        {
            NSdia.addItem(i);
        }
        NSdia.setValue(1);  //NAO PODE SER HARDCODED, tem q vir do dia clicado

        String[] meses = {
            "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho",
            "Agosto", "Setembro", "Outubro","Novembro", "Dezembro",
        };
        NSmes = new NativeSelect("Mês");
        NSmes.setNullSelectionAllowed(false);        
        for (int i = 0; i < meses.length;i++)
        {
            NSmes.addItem(meses[i]);
        }
        NSmes.setValue("Janeiro");  //NAO PODE SER HARDCODED, tem q vir do dia clicado
        NSano = new NativeSelect("Ano");
        NSano.setNullSelectionAllowed(false);
        for (int i = 2011;i < 2016;i++)
        {
            NSano.addItem(i);
        }
        NSano.setValue(2011); //NAO PODE SER HARDCODED, tem q vir do dia clicado
        NSano.setNullSelectionAllowed(false);
        
        this.addComponent(nomeReserva);
        this.addComponent(solicitante);
        this.addComponent(NSresponsavel);
        leiaute.addComponent(NSdia);
        leiaute.addComponent(NSmes);
        leiaute.addComponent(NSano);
        //leiaute.setSizeFull();
        this.addComponent(leiaute);

    }


}
