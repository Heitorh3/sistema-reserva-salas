/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.paineis;

import classes.Reserva;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.Panel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author 0213101
 */
public class PainelCalendario extends Panel{

    HorizontalLayout lCab;
    GridLayout leiaute;
    private ArrayList<PainelDia> paineisMes;
    private int numMes;
    Label seg = new Label("SEG");
    Label ter = new Label("TER");
    Label qua = new Label("QUA");
    Label qui = new Label("QUI");
    Label sex = new Label("SEX");
    Label sab = new Label("SAB");
    Label dom = new Label("DOM");
    NativeSelect caixaMeses;
    Button botao;
    HashMap tabelaMeses;
    HashMap tabelaDiasMes;

    public PainelCalendario(ArrayList<Reserva> reservas,int mes)
    {
        /*
         * O HashMap tabelaMeses mantem o par numero do mes -> nome do mes
         * sera usado para pegar o nome do mes no calendario e pegar o dia do
         * mes quando se obtem o nome da caixaMeses
         */
        tabelaMeses = new HashMap();
        tabelaMeses.put(new Integer(1),"Janeiro");
        tabelaMeses.put(new Integer(2),"Fevereiro");
        tabelaMeses.put(new Integer(3),"Março");
        tabelaMeses.put(new Integer(4),"Abril");
        tabelaMeses.put(new Integer(5),"Maio");
        tabelaMeses.put(new Integer(6),"Junho");
        tabelaMeses.put(new Integer(7),"Julho");
        tabelaMeses.put(new Integer(8),"Agosto");
        tabelaMeses.put(new Integer(9),"Setembro");
        tabelaMeses.put(new Integer(10),"Outubro");
        tabelaMeses.put(new Integer(11),"Novembro");
        tabelaMeses.put(new Integer(12),"Dezembro");
        System.out.println(tabelaMeses.toString());

        /*
         * O HashMap tabelaDiasMes relaciona o numero do mes com a quantidade de dias do mes
         * serve pra for de construçao dos paineis de data
         */
        tabelaDiasMes = new HashMap();
        tabelaDiasMes.put(new Integer(1), "31");
        //calcular para fevereiro...
        tabelaDiasMes.put(new Integer(2), "28");
        tabelaDiasMes.put(new Integer(3), "31");
        tabelaDiasMes.put(new Integer(4), "30");
        tabelaDiasMes.put(new Integer(5), "31");
        tabelaDiasMes.put(new Integer(6), "30");
        tabelaDiasMes.put(new Integer(7), "31");
        tabelaDiasMes.put(new Integer(8), "31");
        tabelaDiasMes.put(new Integer(9), "30");
        tabelaDiasMes.put(new Integer(10), "31");
        tabelaDiasMes.put(new Integer(11), "30");
        tabelaDiasMes.put(new Integer(12), "31");
        System.out.println(tabelaDiasMes.toString());


        //este HL serve pra alinhar a caixa de meses e o botao de mudar mes
        lCab = new HorizontalLayout();

        //string com o nome dos meses para preencher o NativeSelect
        String[] meses = {
            "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho",
            "Agosto", "Setembro", "Outubro","Novembro", "Dezembro",
        };
        //NS que permite ao usuario selecionar o mes do ano para consulta
        caixaMeses = new NativeSelect();
        for (int i = 0; i < meses.length;i++)
        {
            caixaMeses.addItem(meses[i]);
        }

        //Date data pega a data atual qndo liga o sistema
        Date data = new Date();
        //Calendar cal chama os metodos para trabalhar com calendario
        Calendar cal = new GregorianCalendar();
        //coloca a data de hoje no calendario, agora o calendario esta com o dia atual
        cal.setTime(data);
        cal.set(Calendar.DAY_OF_MONTH,1);
        Date primeiroDiaMes = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd--MM--yyyy");
        System.out.println("Today             : " + sdf.format(data));
        System.out.println("First Day of Month: " + sdf.format(primeiroDiaMes));
        int primeiroDiaSemana = cal.get(Calendar.DAY_OF_WEEK);
        String dia = "oi";
        int colunaDestino = 0;
        int linhaDestino = 1;

        caixaMeses.setNullSelectionAllowed(false);
        caixaMeses.setValue(tabelaMeses.get(cal.get(Calendar.MONTH) +1));//funciona

        switch (primeiroDiaSemana)
        {
            case 1: 
            {
                dia = "Domingo";
                colunaDestino = 6;
            }
            break;
            case 2:
            {
                dia = "Segunda";
                       colunaDestino = 0;
            }
            break;
            case 3:
            {
                dia = "Terça";
                colunaDestino = 1;
            }
            break;
            case 4:
            {
                dia = "Quarta";
                colunaDestino = 2;
            }
            break;
            case 5:
            {
                dia = "Quinta";
                colunaDestino = 3;
            }
            break;
            case 6:
            {
                dia = "Sexta";
                colunaDestino = 4;
            }
            break;
            case 7:
            {
                dia = "Sábado";
                colunaDestino = 5;
            }
            break;
        }
        System.out.println("Dia da semana: " + dia);
        //neste metodo de pegar o primeiro dia -> quarta = 4 , começa do 1-> sunday


        



        
        botao = new Button("Trocar Mes");
        botao.addListener(new EventoTrocaMes());
        caixaMeses.setNullSelectionAllowed(false); //nao funça????
        caixaMeses.setValue(new Integer(3));
        //Label labelMes = new Label(Integer.toString(cal.get(Calendar.MONTH)+1)); // aki cai num case pra ve o nº do mes, axo q vai uma variavel global
        
        //caixaMeses.


        
        


        leiaute = new GridLayout(7,7);

        //seg.setWidth("100");
        //seg.setHeight("100");
        leiaute.addComponent(seg,0,0);
        leiaute.setComponentAlignment(seg, Alignment.TOP_CENTER);
        leiaute.addComponent(ter,1,0);
        leiaute.setComponentAlignment(ter, Alignment.TOP_CENTER);
        leiaute.addComponent(qua,2,0);
        leiaute.setComponentAlignment(qua, Alignment.TOP_CENTER);
        leiaute.addComponent(qui,3,0);
        leiaute.setComponentAlignment(qui, Alignment.TOP_CENTER);
        leiaute.addComponent(sex,4,0);
        leiaute.setComponentAlignment(sex, Alignment.TOP_CENTER);
        leiaute.addComponent(sab,5,0);
        leiaute.setComponentAlignment(sab, Alignment.TOP_CENTER);
        leiaute.addComponent(dom,6,0);
        leiaute.setComponentAlignment(dom, Alignment.TOP_CENTER);


        //precisa de um case pra v q mes esta e qntos dias este mes tem
        //ou parse o dateFormat e pega o DD maximo
        //int diasMes = tabelaDiasMes.get(1);
        int diasMes = Integer.parseInt((String)(tabelaDiasMes.get(6)));
        //caixaMeses.setValue(tabelaMeses.get(cal.get(Calendar.MONTH) +1));//funciona
        for (int i = 0; i < diasMes; i++)
        {
            PainelDia pd = new PainelDia(new ArrayList(),i+1);            
            leiaute.addComponent(pd,colunaDestino,linhaDestino);
            if (colunaDestino < 6) colunaDestino++;
            else
            {
                colunaDestino = 0;
                linhaDestino++;
            }
        }

        //leiaute.removeComponent(3,2);  //para reconstruir o grid
        HorizontalLayout seletorMes = new HorizontalLayout();
        seletorMes.setSpacing(true);
        //seletorMes.s
        seletorMes.addComponent(caixaMeses);
        seletorMes.addComponent(botao);
        this.addComponent(seletorMes);

        
        this.addComponent(leiaute);
        


        for (int i = 0; i<reservas.size()-1;i++)
        {
            Reserva tempReserva = reservas.get(i);
            //reservas.remove(0); 
            String dataInicial = tempReserva.getDataInicioEvento();            
            numMes = Integer.parseInt(dataInicial.subSequence(4,5).toString());            
        }
        
        switch (numMes)
            {
                case 1:
                {
                    for (int i = 0;i<reservas.size();i++)
                    {
              
                    }
                }
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
            }
            
    }

    private void setNumMes(int numMes)
    {
        this.numMes = numMes;
    }

    private class EventoTrocaMes implements Button.ClickListener
    {

        @Override
        public void buttonClick(Button.ClickEvent event)
        {
            //repete o for de criar os objetos e coloca o mes padrao para o novo mes retirado do NativeSelect
            int colunaDestino = 0;
            int linhaDestino = 1;
            System.out.println("Mes na caixa de meses: " + caixaMeses.getValue());
            Iterator valueIterator = tabelaMeses.values().iterator();
            int numMes = 0;
            while (valueIterator.hasNext())
            {
                String mesSelecionado = (String) valueIterator.next();
                //System.out.println(teste);
                if (mesSelecionado == caixaMeses.getValue())
                {                    
                    //System.out.println(i);
                    break;
                }
                else numMes++;
            }
            System.out.println(numMes);

            Calendar cal = new GregorianCalendar();
            cal.set(Calendar.MONTH, numMes);
            System.out.println(cal.get(Calendar.MONTH));




            //SimpleDateFormat sdf = new SimpleDateFormat("dd--MM--yyyy");
            /*
            int primeiroDiaSemana = cal.get(Calendar.DAY_OF_WEEK);
            switch (primeiroDiaSemana)
        {
            case 1:
            {
                dia = "Domingo";
                colunaDestino = 6;
            }
            break;
            case 2:
            {
                dia = "Segunda";
                       colunaDestino = 0;
            }
            break;
            case 3:
            {
                dia = "Terça";
                colunaDestino = 1;
            }
            break;
            case 4:
            {
                dia = "Quarta";
                colunaDestino = 2;
            }
            break;
            case 5:
            {
                dia = "Quinta";
                colunaDestino = 3;
            }
            break;
            case 6:
            {
                dia = "Sexta";
                colunaDestino = 4;
            }
            break;
            case 7:
            {
                dia = "Sábado";
                colunaDestino = 5;
            }
            break;
        }
            */

            /*
            for (int i = 0; i < diasMes; i++)
            {
                PainelDia pd = new PainelDia(new ArrayList(),i+1);
                leiaute.addComponent(pd,colunaDestino,linhaDestino);
                if (colunaDestino < 6) colunaDestino++;
            else
            {
                colunaDestino = 0;
                linhaDestino++;
            }

            }
           */
        }
    }
}
