/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.paineis;

import com.vaadin.event.MouseEvents.ClickEvent;
import com.vaadin.event.MouseEvents.ClickListener;
import entidades.Reserva;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import gui.janelas.JanelaNovaReserva;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;

/**
 *
 * @author 0213101
 */
public class PainelCalendario extends Panel{

    HorizontalLayout mainLeiaute;
    HorizontalLayout topoLeiaute;
    VerticalLayout listaLeiaute;
    GridLayout diasLeiaute;
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
    Button botaoMudarMes;
    HashMap tabelaMeses;
    HashMap tabelaDiasMes;
    Window win;
    ListSelect listaReservas;
    Button botaoEditar;
    Button botaoExcluir;
    Button botaoNovaReserva;
    int diaS;
    String mesS;



    public PainelCalendario(ArrayList<Reserva> reservas, Window win)
    {
        /*
         * O HashMap tabelaMeses mantem o par numero do mes -> nome do mes
         * sera usado para pegar o nome do mes no calendario e pegar o dia do
         * mes quando se obtem o nome da caixaMeses
         */
        listaReservas = new ListSelect("Lista de Reservas");
        botaoEditar = new Button("Editar Reserva");
        botaoEditar.addListener(new EventoEditarReserva());
        botaoExcluir = new Button("Excluir Reserva");
        botaoNovaReserva = new Button("Nova Reserva");
        botaoNovaReserva.addListener(new EventoNovaReserva());





        this.win = win;
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


        //este HL serve pra alinhar a caixa de meses e o botaoMudarMes de mudar mes
        mainLeiaute = new HorizontalLayout();
        topoLeiaute = new HorizontalLayout();

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
        //cal.set(Calendar.MONTH,2);
        int primeiroDiaSemana = cal.get(Calendar.DAY_OF_WEEK);
        String dia = "oi";
        int colunaDestino = 0;
        int linhaDestino = 1;

        caixaMeses.setNullSelectionAllowed(false);
        caixaMeses.setValue(tabelaMeses.get(cal.get(Calendar.MONTH) +1));//funciona
        mesS = (String) tabelaMeses.get(cal.get(Calendar.MONTH) +1);

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


        



        
        botaoMudarMes = new Button("Trocar Mes");
        botaoMudarMes.addListener(new EventoTrocaMes());
        caixaMeses.setNullSelectionAllowed(false); //nao funça????
        caixaMeses.setValue(new Integer(3));
        //Label labelMes = new Label(Integer.toString(cal.get(Calendar.MONTH)+1)); // aki cai num case pra ve o nº do mes, axo q vai uma variavel global
        
        //caixaMeses.


        
        


        diasLeiaute = new GridLayout(7,7);

        //seg.setWidth("100");
        //seg.setHeight("100");
        diasLeiaute.addComponent(seg,0,0);
        diasLeiaute.setComponentAlignment(seg, Alignment.TOP_CENTER);
        diasLeiaute.addComponent(ter,1,0);
        diasLeiaute.setComponentAlignment(ter, Alignment.TOP_CENTER);
        diasLeiaute.addComponent(qua,2,0);
        diasLeiaute.setComponentAlignment(qua, Alignment.TOP_CENTER);
        diasLeiaute.addComponent(qui,3,0);
        diasLeiaute.setComponentAlignment(qui, Alignment.TOP_CENTER);
        diasLeiaute.addComponent(sex,4,0);
        diasLeiaute.setComponentAlignment(sex, Alignment.TOP_CENTER);
        diasLeiaute.addComponent(sab,5,0);
        diasLeiaute.setComponentAlignment(sab, Alignment.TOP_CENTER);
        diasLeiaute.addComponent(dom,6,0);
        diasLeiaute.setComponentAlignment(dom, Alignment.TOP_CENTER);


        //precisa de um case pra v q mes esta e qntos dias este mes tem
        //ou parse o dateFormat e pega o DD maximo
        //int diasMes = tabelaDiasMes.get(1);
        int diasMes = Integer.parseInt((String)(tabelaDiasMes.get(cal.get(Calendar.MONTH)+1)));
        //caixaMeses.setValue(tabelaMeses.get(cal.get(Calendar.MONTH) +1));//funciona
        for (int i = 0; i < diasMes; i++)
        {
            PainelDia pd = new PainelDia(new ArrayList(),i+1);
            pd.listener = new EventoPassaReservas();
            pd.addListener(pd.listener);
            diasLeiaute.addComponent(pd,colunaDestino,linhaDestino);
            if (colunaDestino < 6)
                colunaDestino++;
            else
            {
                colunaDestino = 0;
                linhaDestino++;
            }
        }

        //diasLeiaute.removeComponent(3,2);  //para reconstruir o grid
        
        //seletorMes.s

        listaLeiaute = new VerticalLayout();
        listaLeiaute.setSpacing(true);
        topoLeiaute.setSpacing(true);
        mainLeiaute.setSpacing(true);

        topoLeiaute.addComponent(caixaMeses);
        topoLeiaute.addComponent(botaoMudarMes);

        mainLeiaute.addComponent(topoLeiaute);

        mainLeiaute.addComponent(diasLeiaute);

        listaLeiaute.addComponent(listaReservas);
        listaLeiaute.addComponent(botaoNovaReserva);
        listaLeiaute.addComponent(botaoEditar);
        listaLeiaute.addComponent(botaoExcluir);



        mainLeiaute.addComponent(listaLeiaute);
        
        this.addComponent(mainLeiaute);

    }

    private void setNumMes(int numMes)
    {
        this.numMes = numMes;
    }

    /**
     * Nota sobre os eventos EventoPassaReservas e EventoEditarReserva:
     * O EventoPassaReservas pega as reservas que estao no arraylist do painel e passa 1 a 1
     * (num for) e passará talvez dois campos de identificacao (nome do evento e sala e mais algum).
     * -> O TIPO PASSADO PARA A LISTA DE EVENTOS (LISTSELECT) SERA O TIPO QUE DEVERA OBRIGATORIAMENTE
     * SER RETIRADO DO LISTSELECT. Se passa uma reserva, o toString da reserva aparecera no listSelect.
     * é necessario identificar qual a posicao selecionada e pegar da posicao correspondente. tb eh
     * necessario filtrar selecao nula /:)
     * lista de reservas
     * | x0  | xx1  | xxx2  | ->
     * se no listSelect for selecionado o indice 2, entao tem q pegar o indice 2 do arraylist de reservas
     * do painel selecionado
     * -> O listSelect ignora duplicatas, mesmo fazendo um for com addItem do objeto!
     * 
     */
    private class EventoPassaReservas implements ClickListener
    {

        public void click(ClickEvent event)
        {            
            PainelDia pd = (PainelDia) event.getComponent();            

            diaS = Integer.parseInt((String)pd.textoDia.getValue());           
            mesS = (String) caixaMeses.getValue();

            listaReservas.setCaption("Reservas para o dia " + diaS + " de " + mesS );

            System.out.println(""+pd.textoDia);
            Reserva r = new Reserva();
            listaReservas.addItem(r.getDadosReservaParaListSelect());
        }

    }

    private class EventoNovaReserva implements Button.ClickListener
    {
    @Override
        public void buttonClick(Button.ClickEvent event)
        {
            if (diaS != 0)
            {
                JanelaNovaReserva NR = new JanelaNovaReserva(diaS,mesS);
                win.addWindow(NR);
            }
        }

    }

    private class EventoEditarReserva implements Button.ClickListener
    {
    @Override
        public void buttonClick(Button.ClickEvent event)
        {
            Reserva valor = (Reserva) listaReservas.getValue();
            if (valor != null)
                System.out.println(valor.toString());
        }

    }

    private class EventoTrocaMes implements Button.ClickListener
    {

        @Override
        public void buttonClick(Button.ClickEvent event)
        {
            listaReservas.removeAllItems();
            listaReservas.setCaption("Lista de Reservas");
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
            cal.set(Calendar.DAY_OF_MONTH,1);            
            int primeiroDiaSemana = cal.get(Calendar.DAY_OF_WEEK);
            System.out.println("primeiroDiaSemana: " + primeiroDiaSemana);

            switch (primeiroDiaSemana)
            {
                case 1:
                {
                    colunaDestino = 6;
                }
                break;
                case 2:
                {
                     colunaDestino = 0;
                }
                break;
                case 3:
                {
                    colunaDestino = 1;
                }
                break;
                case 4:
                {
                    colunaDestino = 2;
                }
                break;
                case 5:
                {
                    colunaDestino = 3;
                }
                break;
                case 6:
                {
                    colunaDestino = 4;
                }
                break;
                case 7:
                {
                    colunaDestino = 5;
                }
                break;
            }
            System.out.println("" + colunaDestino);


            int diasMes = Integer.parseInt((String)(tabelaDiasMes.get(cal.get(Calendar.MONTH)+1)));
            System.out.println(diasMes);

            diasLeiaute.removeAllComponents();
            diasLeiaute.addComponent(seg,0,0);
            diasLeiaute.setComponentAlignment(seg, Alignment.TOP_CENTER);
            diasLeiaute.addComponent(ter,1,0);
            diasLeiaute.setComponentAlignment(ter, Alignment.TOP_CENTER);
            diasLeiaute.addComponent(qua,2,0);
            diasLeiaute.setComponentAlignment(qua, Alignment.TOP_CENTER);
            diasLeiaute.addComponent(qui,3,0);
            diasLeiaute.setComponentAlignment(qui, Alignment.TOP_CENTER);
            diasLeiaute.addComponent(sex,4,0);
            diasLeiaute.setComponentAlignment(sex, Alignment.TOP_CENTER);
            diasLeiaute.addComponent(sab,5,0);
            diasLeiaute.setComponentAlignment(sab, Alignment.TOP_CENTER);
            diasLeiaute.addComponent(dom,6,0);
            diasLeiaute.setComponentAlignment(dom, Alignment.TOP_CENTER);

            for (int i = 0; i < diasMes; i++)
            {
                PainelDia pd = new PainelDia(new ArrayList(),i+1);
                pd.listener = new EventoPassaReservas();
                pd.addListener(pd.listener);
                diasLeiaute.addComponent(pd,colunaDestino,linhaDestino);
                diasLeiaute.requestRepaint();
                if (colunaDestino < 6)
                    colunaDestino++;
                else
                {
                    colunaDestino = 0;
                    linhaDestino++;
                }
            }
           
        }
    }
}
