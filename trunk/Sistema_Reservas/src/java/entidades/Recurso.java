/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author 0213101
 */
@Entity
@Table
public class Recurso implements Serializable
{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column
    private int IdRecurso;          //chave primaria no Hibernate
    @Column
    private String nomeRecurso;            //nomeRecurso q identifica o recurso
    @Column
    private int quantidade;         //quantidade deste recurso
    @Column
    private String comentarios;
    @ManyToOne(targetEntity=Recinto.class)
    @JoinColumn(name="idRecinto")
    private Recinto recinto;

    /* em 'comentarios' fica qquer informacao extra sobre o recurso da sala em particular
    ex:
    nomeRecurso: computador
    quantidade: 30
    comentarios: -intel core i7 4ghz OC, 12gb memoria, 1500gb de hd
     */

    public Recurso() {
    }

    public Recurso(String nome, int quantidade, String comentarios) {
        this.nomeRecurso = nome;
        this.quantidade = quantidade;
        this.comentarios = comentarios;
    }

    public String getNomeRecurso() {
        return nomeRecurso;
    }

    public void setNomeRecurso(String nomeRecurso) {
        this.nomeRecurso = nomeRecurso;
    }

    public int getIdRecurso() {
        return IdRecurso;
    }

    public String getComentarios() {
        return comentarios;
    }

    public String getNome() {
        return nomeRecurso;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public void setNome(String nome) {
        this.nomeRecurso = nome;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Recinto getRecinto() {
        return recinto;
    }

    public void setRecinto(Recinto recinto) {
        this.recinto = recinto;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Recurso other = (Recurso) obj;
        if ((this.nomeRecurso == null) ? (other.nomeRecurso != null) : !this.nomeRecurso.equals(other.nomeRecurso)) {
            return false;
        }
        if (this.quantidade != other.quantidade) {
            return false;
        }
        if ((this.comentarios == null) ? (other.comentarios != null) : !this.comentarios.equals(other.comentarios)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.IdRecurso;
        hash = 71 * hash + (this.nomeRecurso != null ? this.nomeRecurso.hashCode() : 0);
        hash = 71 * hash + this.quantidade;
        hash = 71 * hash + (this.comentarios != null ? this.comentarios.hashCode() : 0);
        return hash;
    }

    
    @Override
    public String toString() {
        return nomeRecurso + "  " +quantidade + "  " +  comentarios;
    }
}
