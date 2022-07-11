package ifpr.pgua.eic.tvs.mocks;

public class AcessaSistema {
    
    AutenticacaoService autenticacaoService;

    public AcessaSistema(AutenticacaoService autenticacaoService){
        this.autenticacaoService = autenticacaoService;
    }


    public Usuario acessar(String email, String senha){
        Usuario user = autenticacaoService.login(email, senha);
        return user;
    }


}
