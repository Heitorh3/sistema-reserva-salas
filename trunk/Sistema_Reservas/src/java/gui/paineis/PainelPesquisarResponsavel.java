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
import database.PessoaDAO;
import database.ReservaDAO;
import entidades.Reserva;
import gui.janelas.JanelaPesquisas;
import java.util.ArrayList;


/**
 *
 * @author 0213101
 */
public class PainelPesquisarResponsavel extends Panel{
    Button voltar;
    Table resultados;
    Button pesquisar;
    PessoaDAO pessoaDAO = new PessoaDAO();
    ReservaDAO reservaDAO = new ReservaDAO();
    TextField sala;

    public PainelPesquisarResponsavel() {
        resultados = new Table("Resultados");
        resultados.addContainerProperty("Nome", String.class, null);
        //resultados.addContainerProperty("E-mail", String.class, null);
        //resultados.addContainerProperty("Telefone", String.class, null);
        //resultados.addContainerProperty("Cargo", String.class, null);






        FormLayout leiaute = new FormLayout();

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

        pesquisar = new Button("Pesquisar");
        pesquisar.addListener(new EventoPesquisaResponsavel());
        sala = new TextField("Sala Reservada");
        leiaute.addComponent(sala);
        leiaute.addComponent(pesquisar);
        leiaute.addComponent(voltar);
        HorizontalLayout leiH = new HorizontalLayout();
        leiH.setSpacing(true);

        leiH.addComponent(leiaute);
        leiH.addComponent(resultados);


        this.addComponent(leiH);
    }
    
    private class EventoPesquisaResponsavel implements Button.ClickListener
    {
        @Override
        public void buttonClick(Button.ClickEvent event) {
            int i = 0;
            ArrayList<Reserva> res = reservaDAO.pesquisar();
            while (!res.isEmpty())
            {
                Reserva r = res.remove(0);
                if (r.getSala().getNumero() == Integer.parseInt((String)sala.getValue()))
                {
                    resultados.addItem( new Object[] {
                                                        r.getResponsavel()},++i);
                }
            }
            
            
        }
    }



}
