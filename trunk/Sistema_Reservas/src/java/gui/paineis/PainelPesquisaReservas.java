/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.paineis;

import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;

/**
 *
 * @author 0213101
 */
public class PainelPesquisaReservas extends Panel{

    public PainelPesquisaReservas() {
        Button pesquisar = new Button("Pesquisar");
        TextField nome = new TextField("Nome da Reserva");
        TextField responsavel = new TextField("Responsável");
        TextField solicitante = new TextField("Solicitante");
        TextField dia = new TextField("Dia");
        TextField horaInicio = new TextField("Horário Inicial");
        TextField horaFim = new TextField("Horário Final");
        TextField finalidade = new TextField("Finalidade");
        TextField tipo = new TextField("Tipo");
        FormLayout leiaute = new FormLayout();
        leiaute.addComponent(nome);
        leiaute.addComponent(responsavel);
        leiaute.addComponent(solicitante);
        leiaute.addComponent(dia);
        leiaute.addComponent(horaInicio);
        leiaute.addComponent(horaFim);
        leiaute.addComponent(finalidade);
        leiaute.addComponent(tipo);
        leiaute.addComponent(pesquisar);
        this.addComponent(leiaute);

    }



}
