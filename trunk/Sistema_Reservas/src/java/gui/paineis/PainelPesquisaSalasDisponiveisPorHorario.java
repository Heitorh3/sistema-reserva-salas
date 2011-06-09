/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.paineis;


import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author 0213101
 */
public class PainelPesquisaSalasDisponiveisPorHorario extends Panel{

    public PainelPesquisaSalasDisponiveisPorHorario() {
        
        Table resultados = new Table("Resultados");
        resultados.setSelectable(true);

        resultados.addContainerProperty("Número", Integer.class, null);
        resultados.addContainerProperty("Localização", String.class, null);
        resultados.addContainerProperty("Capacidade", Integer.class, null);
        resultados.addContainerProperty("Tipo", String.class, null);
        resultados.addContainerProperty("Recursos",NativeSelect.class, null);
        resultados.addContainerProperty("Disponível?",String.class, null);

        /*
        resultados.addItem(new Object[] {
        new Integer(303), "Centro", new Integer(43), "banheiro",new NativeSelect(),"Sim"},new Integer(6));
        *
        */

        Button pesquisar = new Button("Pesquisar");
        NativeSelect dia = new NativeSelect("Dia");
        NativeSelect mes = new NativeSelect("Mes");
        NativeSelect hora = new NativeSelect("Hora");
        NativeSelect min = new NativeSelect("Minutos");
        String[] horas = {
            "01","02","03","04","05","06","07","08","09","10","11","12","13",
            "14","15","16","17","18","19","20","21","22","23","00"
        };
        for (int i = 0; i < horas.length;i++)
        {
            hora.addItem(horas[i]);
        }
        min.addItem("00");
        min.addItem("30");
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
        HorizontalLayout leiauteDia = new HorizontalLayout();
        leiauteDia.setSpacing(true);
        HorizontalLayout leiauteHora = new HorizontalLayout();
        leiauteHora.setSpacing(true);
        VerticalLayout leiV = new VerticalLayout();
        leiV.setSpacing(true);
        HorizontalLayout mainLayout = new HorizontalLayout();
        mainLayout.setSpacing(true);

        leiauteDia.addComponent(dia);
        leiauteDia.addComponent(mes);
        leiV.addComponent(leiauteDia);
        leiauteHora.addComponent(hora);
        leiauteHora.addComponent(min);
        leiV.addComponent(leiauteHora);
        leiV.addComponent(pesquisar);
        mainLayout.addComponent(leiV);
        mainLayout.addComponent(resultados);
        this.addComponent(mainLayout);
    }

}

