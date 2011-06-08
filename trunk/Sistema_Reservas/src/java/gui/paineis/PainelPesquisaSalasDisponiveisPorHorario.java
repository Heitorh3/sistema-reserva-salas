/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.paineis;


import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;

/**
 *
 * @author 0213101
 */
public class PainelPesquisaSalasDisponiveisPorHorario extends Panel{

    public PainelPesquisaSalasDisponiveisPorHorario() {
        Button pesquisar = new Button("Pesquisar");
        Table resultados = new Table("Resultados");
        NativeSelect dia = new NativeSelect("Dia");
        NativeSelect mes = new NativeSelect("Mes");
        String[] meses = {
            "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho",
            "Agosto", "Setembro", "Outubro","Novembro", "Dezembro",
        };
        for (int i = 0; i < 32;i++)
        {
            dia.addItem(i);
        }
        for (int i = 0; i < meses.length;i++)
        {
            mes.addItem(meses[i]);
        }
        FormLayout leiaute = new FormLayout();
        leiaute.addComponent(dia);
        leiaute.addComponent(mes);
        leiaute.addComponent(pesquisar);
        this.addComponent(leiaute);
        this.addComponent(resultados);


    }


}

