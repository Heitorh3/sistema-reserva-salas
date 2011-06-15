package database;

import java.util.ArrayList;


public interface OperacoesDAO {

    public boolean inserir(Object obj);
    
    public ArrayList pesquisar();
    
    public boolean editar(Object obj);

    public boolean excluir(Object key);
    
}
