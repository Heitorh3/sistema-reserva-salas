/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.paineis;


import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import gui.janelas.JanelaPesquisas;


/**
 *
 * @author 0213101
 */
public class PainelPesquisaReservas extends Panel{
    Button voltar;

    public PainelPesquisaReservas() {
        Table resultados = new Table("Resultados");
        resultados.addContainerProperty("Nome da Reserva", String.class, null);
        resultados.addContainerProperty("Nome do Responsável", String.class, null);
        resultados.addContainerProperty("Nome do Solicitante", String.class, null);
        resultados.addContainerProperty("Dia", String.class, null);
        resultados.addContainerProperty("Início",String.class, null);
        resultados.addContainerProperty("Fim",String.class, null);
        resultados.addContainerProperty("Finalidade",String.class, null);
        resultados.addContainerProperty("Tipo",String.class, null);



        voltar = new Button("Voltar");
        voltar.addListener(new Button.ClickListener() {

            public void buttonClick(Button.ClickEvent event) {
                setVisible(false);
                VerticalLayout o = (VerticalLayout) getParent();                
                JanelaPesquisas o2 = (JanelaPesquisas) o.getParent();
                Panel p = o2.getPainelBotoes();
                p.setEnabled(true);
            }
        });
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
        leiaute.addComponent(voltar);
        HorizontalLayout leiH = new HorizontalLayout();
        leiH.setSpacing(true);
        leiH.addComponent(leiaute);
        leiH.addComponent(resultados);
        this.addComponent(leiH);

    }


}
