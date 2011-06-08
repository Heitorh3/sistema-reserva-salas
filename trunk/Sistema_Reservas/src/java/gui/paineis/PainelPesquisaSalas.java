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
public class PainelPesquisaSalas extends Panel
{

    public PainelPesquisaSalas() {
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
        this.addComponent(leiaute);

    }


}
