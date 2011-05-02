/*
 * Recinto eh a classe que guarda os dados de cada sala do estabelecimento.
 * Contem um lista de recursos presente na sala. E um identificador
 * que especifica se eh sala de aula, laboratorio, auditorio, etc.
 */

package sistemareservas;

import java.util.ArrayList;

/**
 *
 * @author 0213101
 */
public class Recinto
{
    private int numero;                     //numero da sala se tiver, 0 se nao tiver num
    private String localizacao;             //??? andar?
    private int capacidade;                 //qntas pessoas a sala comporta
    private String tipo;                    //define o tipo da sala, lab, aula, auditorio,etc
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
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }



}
