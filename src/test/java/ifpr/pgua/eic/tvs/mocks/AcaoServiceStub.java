package ifpr.pgua.eic.tvs.mocks;

import java.util.Map;

public class AcaoServiceStub implements AcaoService{

    Map<String, Double> bancoAcoes;

    public Map<String, Double> getBancoAcoes() {
        return bancoAcoes;
    }

    public void setBancoAcoes(Map<String, Double> bancoAcoes) {
        this.bancoAcoes = bancoAcoes;
    }

    @Override
    public double getPrecoAcaoMercado(Acao acao) {
        return bancoAcoes.get(acao.getNomeEmpresa());
    }

}
