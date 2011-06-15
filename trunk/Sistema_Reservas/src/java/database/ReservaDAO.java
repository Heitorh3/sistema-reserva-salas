package database;

import entidades.Reserva;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 0213101
 */
public class ReservaDAO implements OperacoesDAO
{
    //Hibernate h = new Hibernate();

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean inserir(Object obj)
    {
        h.beginTransaction();
        {
            Reserva re = new Reserva();
            re = (Reserva) obj;
            h.saveOnly(re);
        }
        h.endTransaction();
        return true;
    }

    /**
     *
     * @return
     */
    @Override
    public ArrayList pesquisar()
    {
        h.beginTransaction();

            List<Reserva> l = h.list(Reserva.class);

        h.endTransaction();
        ArrayList<Reserva> res = new ArrayList();
        res.addAll(l);
        return res;
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean editar(Object obj)
    {
        //recinto q vem da interface jah editado
        Reserva re = (Reserva) obj;
        //Reserva que vem do banco para ser editado
        Reserva re1 = (Reserva) h.getObject(Reserva.class, re.getIdReserva());
        //o valor de r(atualizado) vai no valor do banco
        re1 = re;
        //atualiza o r1 que recebe os valores de r(atualizado)
        h.updateOnly(re1);
        return true;
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean excluir(Object obj)
    {
        h.beginTransaction();
        {
            Reserva re = (Reserva) obj;
            Reserva re1 = (Reserva) h.getObject(Reserva.class, re.getIdReserva());
            h.delete(re1);
        }
        h.endTransaction();
        return true;
    }

}
