/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.paineis;

import com.vaadin.ui.Button;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import gui.formularios.FormNovaReserva;
import java.util.ArrayList;

/**
 *
 * @author 0213101
 */
public class PainelDisplayReservas extends Panel {
    ListSelect listaReservas;
    VerticalLayout leiaute;
    
    Window win;

    public PainelDisplayReservas(Window win)
    {
        this.win = win;
        

        //Label l = new Label("Reservas");
        
        leiaute = new VerticalLayout();
        ArrayList c = new ArrayList();
        c.add(new Integer(7));
        c.add(new Integer(3));
        listaReservas = new ListSelect("Lista de Reservas",c);
        listaReservas.setMultiSelect(false);
        listaReservas.setNullSelectionAllowed(false);
        leiaute.addComponent(listaReservas);
        
        
        this.addComponent(leiaute);
    }

    

}
