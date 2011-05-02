/*
 * A classe Pessoa guarda todas as pessoas ||cadastradas no sistema de reservas||.
 * Inclusive login e senha. Verifica se a Pessoa existe no sistema, verifica
 * login e senha. Enrao entra no sistema.
 */

package sistemareservas;

/**
 *
 * @author 0213101
 */
public class Pessoa
{
    private String nomePessoa;
    private String email;
    private String telefone;
    private String cargo;
    private String login;
    private String senha;
    private boolean admin;          //admin marca 'false' se a pessoa eh um usuario comum
                                    //ou 'true' se eh admistrador.
    private boolean bloqueado;      //marca se o usuario esta bloqueado pelo admin
                                    //apenas admins podem mudar esta variavel
                                    //admin nao pode se bloquear


    public Pessoa() {
    }

    public Pessoa(String nomePessoa, String email, String telefone, String cargo, String login, String senha, boolean admin, boolean bloqueado) {
        this.nomePessoa = nomePessoa;
        this.email = email;
        this.telefone = telefone;
        this.cargo = cargo;
        this.login = login;
        this.senha = senha;
        this.admin = admin;
        this.bloqueado = bloqueado;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    public boolean isBloqueado() {
        return bloqueado;
    }


    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isAdmin() {
        return admin;
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
        return "Pessoa{" + "nomePessoa=" + nomePessoa + "email=" + email +
               "telefone=" + telefone + "cargo=" + cargo + "login=" + login +
               "senha=" + senha + '}';
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
