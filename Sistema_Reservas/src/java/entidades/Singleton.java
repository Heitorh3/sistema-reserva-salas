
package entidades;

public class Singleton {
     // Instancia privada que será acessada
     private static Singleton logado;
     Pessoa pessoa = new Pessoa();


     // Construtor privado. Suprime o construtor público padrao.
     private Singleton() {
          // Operações de inicialização da classe
     }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa p) {
        this.pessoa = p;
    }



     // Método público de acesso único ao objeto!
     public synchronized static Singleton getInstance(){
           if(logado == null) {
                logado = new Singleton();
           }
           return logado;
     }
 }