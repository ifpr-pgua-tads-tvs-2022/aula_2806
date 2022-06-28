package ifpr.pgua.eic.tvs.mocks;

public class Acao{

    private String id;
    private String nomeEmpresa;
    private int quatidade;
    
    
    public Acao(String id, String nomeEmpresa, int quatidade) {
        this.id = id;
        this.nomeEmpresa = nomeEmpresa;
        this.quatidade = quatidade;
    }


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public String getNomeEmpresa() {
        return nomeEmpresa;
    }


    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }


    public int getQuatidade() {
        return quatidade;
    }


    public void setQuatidade(int quatidade) {
        this.quatidade = quatidade;
    }



}