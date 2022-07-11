package ifpr.pgua.eic.tvs.mocks;

public class AcaoBuilder {
    private static AcaoBuilder instance;
    private Acao acao = new Acao("00", "Empresa Fake", 1);

    private AcaoBuilder(){}

    public static AcaoBuilder umaAcao(){
        instance = new AcaoBuilder();
        return instance;
    }

    public AcaoBuilder comId(String id){
        instance.acao.setId(id);
        return instance;
    }

    public AcaoBuilder comNomeEmpresa(String nome){
        instance.acao.setNomeEmpresa(nome);
        return instance;
    }

    public AcaoBuilder comQuantidade(int quatidade){
        instance.acao.setQuatidade(quatidade);
        return instance;
    }
    
    public Acao agora(){
        return instance.acao;
    }



}
