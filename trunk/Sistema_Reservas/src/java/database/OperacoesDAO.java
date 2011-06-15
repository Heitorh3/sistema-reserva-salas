package database;

import entidades.Hibernate;
import java.util.ArrayList;


public interface OperacoesDAO {

    Hibernate h = new Hibernate();

    public boolean inserir(Object obj);
    
    public ArrayList pesquisar();
    
    public boolean editar(Object obj);

    public boolean excluir(Object obj);
    
}
