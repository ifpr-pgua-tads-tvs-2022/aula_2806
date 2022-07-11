package ifpr.pgua.eic.tvs.mocks;

public class Usuario {
    
    private String email;
    private String nome;
    
    public Usuario(String email, String nome) {
        this.email = email;
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
