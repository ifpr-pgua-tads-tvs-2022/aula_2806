package ifpr.pgua.eic.tvs.mocks;

import java.util.ArrayList;
import java.util.List;

public class Carteira {
    
    private List<Acao> carteira;
    AcaoService acaoService;

    public Carteira(AcaoService acaoService){
        this.acaoService = acaoService;
        carteira = new ArrayList<>();
    }

    public List<Acao> getCarteira() {
        return carteira;
    }

    public void setCarteira(List<Acao> carteira) {
        this.carteira = carteira;
    }

    public AcaoService getAcaoService() {
        return acaoService;
    }

    public void setAcaoService(AcaoService acaoService) {
        this.acaoService = acaoService;
    }

    public double calculaValorMercado(){
        
        double valor = 0.0;
        
        
        for(Acao acao:carteira){
            double valorAcao = acaoService.getPrecoAcaoMercado(acao);
            valor += acao.getQuatidade()*valorAcao;
        }

        return valor;
    }


}
