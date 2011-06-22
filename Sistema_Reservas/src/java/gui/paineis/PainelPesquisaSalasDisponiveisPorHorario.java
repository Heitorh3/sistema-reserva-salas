/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.paineis;


import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import database.ReservaDAO;
import entidades.Reserva;
import gui.janelas.JanelaPesquisas;
import java.util.ArrayList;
import java.util.HashMap;


/**
 *
 * @author 0213101
 */
public class PainelPesquisaSalasDisponiveisPorHorario extends Panel{
    
    ReservaDAO reservaDAO = new ReservaDAO();
    Button voltar;
    Button pesquisar;
    NativeSelect dia;
    NativeSelect mes;
    NativeSelect hora;
    NativeSelect min;
    HashMap mapaMeses;
    Table resultados;

    public PainelPesquisaSalasDisponiveisPorHorario() {
        
        resultados = new Table("Resultados");
        resultados.setSelectable(true);

        resultados.addContainerProperty("Número", Integer.class, null);
        resultados.addContainerProperty("Localização", String.class, null);
        resultados.addContainerProperty("Capacidade", Integer.class, null);
        resultados.addContainerProperty("Tipo", String.class, null);
        //resultados.addContainerProperty("Recursos",NativeSelect.class, null);
        resultados.addContainerProperty("Disponível",String.class, null);
        
        mapaMeses = new HashMap();
        mapaMeses.put("Janeiro",new Integer(1));
        mapaMeses.put("Fevereiro",new Integer(2));
        mapaMeses.put("Março",new Integer(3));
        mapaMeses.put("Abril",new Integer(4));
        mapaMeses.put("Maio",new Integer(5));
        mapaMeses.put("Junho",new Integer(6));
        mapaMeses.put("Julho",new Integer(7));
        mapaMeses.put("Agosto",new Integer(8));
        mapaMeses.put("Setembro",new Integer(9));
        mapaMeses.put("Outubro",new Integer(10));
        mapaMeses.put("Novembro",new Integer(11));
        mapaMeses.put("Dezembro",new Integer(12));

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
        pesquisar.addListener(new EventoPesquisar());
        /*
        pesquisar.addListener(new Button.ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                int i = 0;
            resultados.removeAllItems();
            ArrayList<Reserva> reservas = reservaDAO.pesquisar();
            int ff = 0;
            while (!reservas.isEmpty())
            {
                Reserva r = reservas.remove(0);
                String diaUI = dia.getValue().toString() + "/" + mapaMeses.get((String)mes.getValue()) + "/2011";
                String horaUI = hora.getValue() + ":" + min.getValue();
                System.out.println(diaUI);
                System.out.println(horaUI);
                int pp = 0;
                if ((horaUI.equals(r.getHorarioInicioEvento())) && (diaUI.equals(r.getDataInicioEvento())))
                {
                    resultados.addItem(new Object[]{
                    r.getSala().getNumero(),r.getSala().getLocalizacao(),r.getSala().getTipo(),"Não Disponível"}, ++i);
                }
                else
                {
                    resultados.addItem(new Object[]{
                    r.getSala().getNumero(),r.getSala().getLocalizacao(),r.getSala().getTipo(),"Disponível"}, ++i);
                }
            }
            }
        });
        
         * 
         */
        
        
        dia = new NativeSelect("Dia");
        mes = new NativeSelect("Mês");
        hora = new NativeSelect("Hora");
        min = new NativeSelect("Minutos");
        String[] horas = {
            "00","01","02","03","04","05","06","07","08","09","10","11","12","13",
            "14","15","16","17","18","19","20","21","22","23"
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
        leiV.addComponent(voltar);
        mainLayout.addComponent(leiV);
        mainLayout.addComponent(resultados);
        this.addComponent(mainLayout);
    }
    
    private class EventoPesquisar implements Button.ClickListener
    {

        @Override
        public void buttonClick(Button.ClickEvent event) {
            int i = 0;
            resultados.removeAllItems();
            ArrayList<Reserva> reservas = reservaDAO.pesquisar();
            while (!reservas.isEmpty())
            {
                Reserva r = reservas.remove(0);
                String diaUI = dia.getValue().toString() + "/" + mapaMeses.get((String)mes.getValue()) + "/2011";
                String horaUI = hora.getValue() + ":" + min.getValue();
                String horaB = r.getHorarioInicioEvento();                
                if (horaB.length() < 5) horaB = horaB.concat("0");
                if ((horaUI.equals(horaB)) && (diaUI.equals(r.getDataInicioEvento())))
                {
                    resultados.addItem(new Object[]{
                    r.getSala().getNumero(),r.getSala().getLocalizacao(),r.getSala().getCapacidade(),r.getSala().getTipo(),"Não Disponível"}, ++i);
                }
                else
                {
                    resultados.addItem(new Object[]{
                    r.getSala().getNumero(),r.getSala().getLocalizacao(),r.getSala().getCapacidade(),r.getSala().getTipo(),"Disponível"}, ++i);
                }
            }
        }
        
    }

}

