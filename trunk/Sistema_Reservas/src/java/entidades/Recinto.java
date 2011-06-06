/*
 * Recinto eh a classe que guarda os dados de cada sala do estabelecimento.
 * Contem um lista de recursos presente na sala. E um identificador
 * que especifica se eh sala de aula, laboratorio, auditorio, etc.
 */

package entidades;

import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author 0213101
 */
@Entity
@Table
public class Recinto
{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column
    private int IdRecinto;                  //chave primaria no Hibernate
    @Column
    private int numero;                     //numero da sala se tiver, 0 se nao tiver num
    @Column
    private String localizacao;             //??? andar?
    @Column
    private int capacidade;                 //qntas pessoas a sala comporta
    @Column
    private String tipo;                    //define o tipo da sala, lab, aula, auditorio,etc
    @Column
    @OneToMany(mappedBy = "recinto")
    private ArrayList<Recurso> recursos;    //lista de recursos da sala

    public Recinto() {
    }

    public Recinto(int numero, String localizacao, int capacidade, String tipo,
                   ArrayList<Recurso> recursos) {
        this.numero = numero;
        this.localizacao = localizacao;
        this.capacidade = capacidade;
        this.tipo = tipo;
        this.recursos = recursos;
    }

    public int getIdRecinto() {
        return IdRecinto;
    }


    public int getCapacidade() {
        return capacidade;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public int getNumero() {
        return numero;
    }

    public ArrayList<Recurso> getRecursos() {
        return recursos;
    }

    public String getTipo() {
        return tipo;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setRecursos(ArrayList<Recurso> recursos) {
        this.recursos = recursos;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Recinto{" + "numero=" + numero + "localizacao=" + localizacao +
               "capacidade=" + capacidade + "tipo=" + tipo +
               "recursos=" + recursos + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Recinto other = (Recinto) obj;
        if (this.numero != other.numero) {
            return false;
        }
        if ((this.localizacao == null) ? (other.localizacao != null) : !this.localizacao.equals(other.localizacao)) {
            return false;
        }
        if (this.capacidade != other.capacidade) {
            return false;
        }
        if ((this.tipo == null) ? (other.tipo != null) : !this.tipo.equals(other.tipo)) {
            return false;
        }
        if (this.recursos != other.recursos && (this.recursos == null || !this.recursos.equals(other.recursos))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.numero;
        hash = 37 * hash + (this.localizacao != null ? this.localizacao.hashCode() : 0);
        hash = 37 * hash + this.capacidade;
        hash = 37 * hash + (this.tipo != null ? this.tipo.hashCode() : 0);
        hash = 37 * hash + (this.recursos != null ? this.recursos.hashCode() : 0);
        return hash;
    }

    public void adicionaRecursos(Recurso rec)
    {
        this.recursos.add(rec);
    }



}
