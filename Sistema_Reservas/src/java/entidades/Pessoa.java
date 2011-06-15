/*
 * A classe Pessoa guarda todas as pessoas ||cadastradas no sistema de reservas||.
 * Inclusive login e senha. Verifica se a Pessoa existe no sistema, verifica
 * login e senha. Enrao entra no sistema.
 */

package entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author 0213101
 */

@Entity
@Table
public class Pessoa implements Serializable
{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column
    private int IdPessoa;           //chave primaria no Hibernate
    @Column
    private String nomePessoa;
    @Column
    private String email;
    @Column
    private String telefone;
    @Column
    private String cargo;
    @Column
    private String login;
    @Column
    private String senha;
    @Column
    private boolean adm;            //adm marca 'false' se a pessoa eh um usuario comum
    @Column                         //ou 'true' se eh admistrador.
    private boolean bloqueado;      //marca se o usuario esta bloqueado pelo adm
                                    //apenas admins podem mudar esta variavel
                                    //adm nao pode se bloquear
            
    public Pessoa() {
    }

    public Pessoa(String nomePessoa, String email, String telefone, String cargo, String login, String senha, boolean admin, boolean bloqueado) {
        this.nomePessoa = nomePessoa;
        this.email = email;
        this.telefone = telefone;
        this.cargo = cargo;
        this.login = login;
        this.senha = senha;
        this.adm = admin;
        this.bloqueado = bloqueado;
    }

    public int getIdPessoa() {
        return IdPessoa;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    public boolean isBloqueado() {
        return bloqueado;
    }


    public void setAdmin(boolean admin) {
        this.adm = admin;
    }

    public boolean isAdmin() {
        return adm;
    }

    public String getCargo() {
        return cargo;
    }

    public String getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public String getSenha() {
        return senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return nomePessoa + "   |   " + email + "   |   " + telefone
                + "   |   " + cargo + "   |   " + login + "   |   " + senha;
    }

    public String toStringReal()
    {
        return "Pessoa{" + "nomePessoa=" + nomePessoa + "email=" + email +
               "telefone=" + telefone + "cargo=" + cargo + "login=" + login +
               "senha=" + senha + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        if (this.IdPessoa != other.IdPessoa) {
            return false;
        }
        if ((this.nomePessoa == null) ? (other.nomePessoa != null) : !this.nomePessoa.equals(other.nomePessoa)) {
            return false;
        }
        if ((this.email == null) ? (other.email != null) : !this.email.equals(other.email)) {
            return false;
        }
        if ((this.telefone == null) ? (other.telefone != null) : !this.telefone.equals(other.telefone)) {
            return false;
        }
        if ((this.cargo == null) ? (other.cargo != null) : !this.cargo.equals(other.cargo)) {
            return false;
        }
        if ((this.login == null) ? (other.login != null) : !this.login.equals(other.login)) {
            return false;
        }
        if ((this.senha == null) ? (other.senha != null) : !this.senha.equals(other.senha)) {
            return false;
        }
        if (this.adm != other.adm) {
            return false;
        }
        if (this.bloqueado != other.bloqueado) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        int intAdmin, intBloq;
        hash = 67 * hash + this.IdPessoa;
        hash = 67 * hash + (this.nomePessoa != null ? this.nomePessoa.hashCode() : 0);
        hash = 67 * hash + (this.email != null ? this.email.hashCode() : 0);
        hash = 67 * hash + (this.telefone != null ? this.telefone.hashCode() : 0);
        hash = 67 * hash + (this.cargo != null ? this.cargo.hashCode() : 0);
        hash = 67 * hash + (this.login != null ? this.login.hashCode() : 0);
        hash = 67 * hash + (this.senha != null ? this.senha.hashCode() : 0);
        intAdmin = (this.adm) ? 1 : 0;
        hash = 67 * hash + intAdmin;
        intBloq = (this.bloqueado) ? 1 : 0;
        hash = 67 * hash + intBloq;
        return hash;
    }

}
