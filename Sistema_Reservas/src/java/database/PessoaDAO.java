package database;

import java.sql.*;
import java.util.*;

public class PessoaDAO implements OperacoesDAO
{

    public PessoaDAO(){
    }
    
    @Override
    public boolean inserir(Object obj) 
    {
        return true;
    }

    @Override
    // Retorna todo o conteúdo da coleção
    public ArrayList pesquisar()
    {
        return new ArrayList();
    }

    @Override
    public boolean editar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean excluir(Object key) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}
