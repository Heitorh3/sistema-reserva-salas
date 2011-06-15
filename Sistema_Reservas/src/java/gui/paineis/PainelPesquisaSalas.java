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
public class PainelPesquisaSalas extends Panel
{
    Button voltar;

    public PainelPesquisaSalas() {
        Table resultados = new Table("Resultados");
        resultados.addContainerProperty("Número da Sala",String.class, null);
        resultados.addContainerProperty("Estado",String.class, null);

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
        TextField numero = new TextField("Número");
        TextField local  = new TextField("Localização");
        TextField cap    = new TextField("Capacidade");
        TextField tipo   = new TextField("numero");
        FormLayout leiaute = new FormLayout();
        leiaute.addComponent(numero);
        leiaute.addComponent(local);
        leiaute.addComponent(cap);
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
