/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.paineis;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import database.RecursoDAO;
import entidades.Recurso;
import gui.janelas.JanelaPesquisas;
import java.util.ArrayList;


/**
 *
 * @author 0213101
 */
public class PainelPesquisarRecursos extends Panel{
    Button voltar;
    RecursoDAO recursoDAO = new RecursoDAO();
    TextField sala;
    Table resultados = new Table("Resultados");

    public PainelPesquisarRecursos() {
        resultados = new Table("Resultados");
        resultados.addContainerProperty("Nome", String.class, null);
        resultados.addContainerProperty("Quantidade", Integer.class, null);
        resultados.addContainerProperty("Descrição", String.class, null);

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

        Button pesquisar = new Button("Pesquisar");
        pesquisar.addListener(new EventoPesquisaRecursos());
        sala = new TextField("Número da Sala ");
        leiaute.addComponent(sala);
        leiaute.addComponent(pesquisar);
        leiaute.addComponent(voltar);
        HorizontalLayout leiH = new HorizontalLayout();
        leiH.setSpacing(true);

        leiH.addComponent(leiaute);
        leiH.addComponent(resultados);


        this.addComponent(leiH);
    }
    
    private class EventoPesquisaRecursos implements Button.ClickListener
    {

        public void buttonClick(ClickEvent event) {
            int i = 0;
            resultados.removeAllItems();
            ArrayList<Recurso> res = new ArrayList();
            res = recursoDAO.pesquisar();
            //System.out.println(res.toString());
            while (!res.isEmpty())
            {
                Recurso rec = res.remove(0);
                System.out.println((String)sala.getValue());
                System.out.println(rec.getRecinto().getNumero());
                if (Integer.parseInt((String)sala.getValue()) == rec.getRecinto().getNumero())
                {
                    resultados.addItem( 
                            new Object[]{rec.getNome(),rec.getQuantidade(),rec.getComentarios()},++i 
                            );
                }
            }
        }
    }



}
