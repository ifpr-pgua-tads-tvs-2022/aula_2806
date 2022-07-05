package ifpr.pgua.eic.tvs.mocks;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarteiraTest {
    

    @Test
    @DisplayName("Calcula o valor da carteira de acoes")
    public void testaCalculaValorCarteira(){

        //Cenário
        Acao acaoGoogle = new Acao("GLG01", "Google", 5);
        Acao acaoMicrosoft = new Acao("MIC01", "Microsoft", 1);
        Acao acaoTesla = new Acao("TSL01", "Tesla", 10);

        List<Acao> carteiraAcoes = new ArrayList<>();
        carteiraAcoes.add(acaoGoogle);
        carteiraAcoes.add(acaoMicrosoft);
        carteiraAcoes.add(acaoTesla);
        
        Map<String,Double> bancoAcoes = new HashMap();

        bancoAcoes.put("Google", 50.0);
        bancoAcoes.put("Microsoft",30.0);
        bancoAcoes.put("Tesla",60.0);
        bancoAcoes.put("Apple",20.0);

        AcaoServiceStub acaoService = new AcaoServiceStub();
        acaoService.setBancoAcoes(bancoAcoes);


        Carteira carteira = new Carteira(acaoService);
        carteira.setCarteira(carteiraAcoes);

        double valorEsperado = acaoGoogle.getQuatidade()*bancoAcoes.get(acaoGoogle.getNomeEmpresa())+
                                acaoMicrosoft.getQuatidade()*bancoAcoes.get(acaoMicrosoft.getNomeEmpresa())+
                                acaoTesla.getQuatidade()*bancoAcoes.get(acaoTesla.getNomeEmpresa());

        //ação
        double valorObtido = carteira.calculaValorMercado();

        //verificacao
        assertEquals(valorEsperado, valorObtido);


    }
    


}
