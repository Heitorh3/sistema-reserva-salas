/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.janelas;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Table;
import com.vaadin.ui.Window;
import entidades.Reserva;

/**
 *
 * @author Vinicius
 */
public class JanelaExcluirReserva extends Window{
    
    Table tabela = new Table("Sala a excluir");
    public Button deletar;
            
    public JanelaExcluirReserva(Reserva r)
    {
        center();
        setWidth("80%");
        
        
        tabela.addContainerProperty("Nome da Reserva", String.class, null);
        tabela.addContainerProperty("Finalidade", String.class, null);
        tabela.addContainerProperty("Solicitante", String.class, null);        
        tabela.addContainerProperty("Responsável", String.class, null);
        tabela.addContainerProperty("Data Inicial", String.class, null);
        tabela.addContainerProperty("Data Final", String.class, null);
        tabela.addContainerProperty("Repeticao", Character.class, null);
        tabela.addContainerProperty("Número da sala", String.class, null);
        
        tabela.addItem(new Object[] {
                r.getNomeEvento(),r.getFinalidade(),r.getSolicitante(),r.getResponsavel(),r.getDataInicioEvento(),
                r.getDataFimEvento(),r.getRepeticao(),r.getSala().getNumero()}, new Integer(1));
        
        deletar = new Button("Confirmar Exclusão");
        deletar.addListener(new Button.ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                close();
            }
        });
        
        this.addComponent(tabela);
        this.addComponent(deletar);

        
        
    }
    
    
    
}
