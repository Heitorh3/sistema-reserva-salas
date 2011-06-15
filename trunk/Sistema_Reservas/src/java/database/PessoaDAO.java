package database;

import entidades.Pessoa;
import java.util.*;

public class PessoaDAO implements OperacoesDAO
{

    public PessoaDAO(){
    }
    
    @Override
    public boolean inserir(Object obj) 
    {
        h.beginTransaction();
        {
            Pessoa p = new Pessoa();
            p = (Pessoa) obj;
            h.saveOnly(p);
        }
        h.endTransaction();
        return true;
    }

    @Override
    // Retorna todo o conteúdo da coleção, porem a pesquisa eh feita com determinados campos
    public ArrayList pesquisar()
    {
        h.beginTransaction();

            List<Pessoa> l = h.list(Pessoa.class);

        h.endTransaction();
        ArrayList<Pessoa> ps = new ArrayList();
        ps.addAll(l);
        return ps;
    }

    @Override
    public boolean editar(Object obj)
    {
        h.beginTransaction();
        {
            //recinto q vem da interface jah editado
            Pessoa p = (Pessoa) obj;
            //Pessoa que vem do banco para ser editado
            Pessoa p1 = (Pessoa) h.getObject(Pessoa.class, p.getIdPessoa());
            //o valor de r(atualizado) vai no valor do banco
            p1 = p;
            //atualiza o r1 que recebe os valores de r(atualizado)
            h.updateOnly(p1);
        }
        h.endTransaction();
        return true;
    }

    @Override
    public boolean excluir(Object obj)
    {
        h.beginTransaction();
        {
            Pessoa p = (Pessoa) obj;
            Pessoa p1 = (Pessoa) h.getObject(Pessoa.class, p.getIdPessoa());
            h.delete(p1);
        }
        h.endTransaction();
        return true;
    }


}
