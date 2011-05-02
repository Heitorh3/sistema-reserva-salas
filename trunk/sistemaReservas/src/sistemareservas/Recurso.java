/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemareservas;

/**
 *
 * @author 0213101
 */
public class Recurso
{
    private String nome;            //nome q identifica o recurso
    private int quantidade;         //quantidade deste recurso
    private String comentarios;
    /* em 'comentarios' fica qquer informacao extra sobre o recurso da sala em particular
    ex:
    nome: computador
    quantidade: 30
    comentarios: -intel core i7 4ghz OC, 12gb memoria, 1500gb de hd
    */

    public Recurso() {
    }

    public Recurso(String nome, int quantidade, String comentarios) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.comentarios = comentarios;
    }


    public String getComentarios()
    {
        return comentarios;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "Recurso{" + "nome=" + nome + "quantidade=" + quantidade + "comentarios=" + comentarios + '}';
    }



}
