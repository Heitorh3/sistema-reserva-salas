/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades;

import java.util.List;

/**
 *
 * @author 0213101
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Hibernate h = new Hibernate();

        
        Pessoa p;

        Recinto r = new Recinto();
        Recurso rec = new Recurso();
        rec.setRecinto(r);

        /*
        //pega todos os dados do banco e coloca numa lista
        h.beginTransaction();
            List<Pessoa> l = h.list(Pessoa.class);
            System.out.println(l.toString());
        h.endTransaction();
         *
         */


        
        //Adiciona tupla no banco.
        h.beginTransaction();
            p = new Pessoa("Vinicius","sarado_2008@zipmail.com","5197287877","mestre","master","chief",true,false);
            h.saveOnly(p);
        h.endTransaction();//
        

        /*
        //Modifica tupla.
        h.beginTransaction();
            p = (Pessoa) h.getObject(Pessoa.class, 13);
            p.setEmail("email_serio@gmail.com");
            h.updateOnly(p);
        h.endTransaction();
         *
         */
        

        /*
        //Deleta entrada do banco
        h.beginTransaction();
            p = (Pessoa) h.getObject(Pessoa.class, 13);
            h.delete(p);
        h.endTransaction();
         *
         */

    }
        
}
        
        
        /*  PROVAVEL FLUXO:
         * ArrayList<Pessoa> usuariosCadastrados -> guarda os usuario cadastrados no sistema
         * deve permitir login logoff e avisar qndo o usuario nao tem permissao para fazer determinada tarefa
         * ArrayList<Evento> eventos-> guarda os eventos gerados pelo usuario atraves do formulario
         * ArrayList<Recinto> salas -> recebe todas as salas na primeira carga
         * todas as consultas, tanto de sala qnto de eventos passa pelo ArrayList<Evento>
         * busca de salas com evento: procura em eventos e mostra as salas presentes em cada evento
         * busca de salas sem evento: procura as salas com evento e busca em salas e faz
         * um not(salas com evento marcado)
         * - todas as salas disponíveis em uma determinada data e horário:
         * procura ocorrencia em eventos e marca as salas que nao podem naquela data e horario
           e faz um not()
         * - status de uma sala, em uma determinada data e horário:
         * procura ocorrencia em eventos e mostra os dados se encontrou
         * ^^^^^^^FIKADIKA^^^^^^
           as duas buscas acima devem considerar a possibilidade de repeticao periodica,
         * sendo assim nao deve apenas procurar na data exata, deve verificar a data de inicio,
         * verificar se tem repeticao, calcular a repeticao e entao mostrar o resultado adequado
         * ^^^^^^^END FIKADIKA^^^^^^
           - o responsável (e seus dados de contato) por uma determinada sala:
         * a sala soh vai ter responsavel se tiver um evento anexado, portanto
         * procura todos os eventos que contem a sala em questao e retorna os dados pedidos
           - a relação de recursos de uma determinada sala:
         * agora procura exclusivamento no ArrayList salas e mostra os dados pedidos
         * --ArrayList ou container mais apropriado, se tiver um melhor.
   */