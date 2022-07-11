package ifpr.pgua.eic.tvs.mocks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class CarteiraTest {
    

    @Test
    @DisplayName("Calcula o valor da carteira de acoes")
    public void testaCalculaValorCarteira(){

        //Cenário
        /* 
        Acao acaoGoogle = new Acao("GLG01", "Google", 5);
        Acao acaoMicrosoft = new Acao("MIC01", "Microsoft", 1);
        Acao acaoTesla = new Acao("TSL01", "Tesla", 10);
        */

        Acao acaoGoogle = AcaoBuilder.umaAcao()
                                     .comQuantidade(5)
                                     .comNomeEmpresa("Google")
                                     .agora();
        Acao acaoMicrosoft = AcaoBuilder.umaAcao()
                                        .comNomeEmpresa("Microsoft")
                                        .comQuantidade(1)
                                        .agora();
        Acao acaoTesla = AcaoBuilder.umaAcao()
                                    .comNomeEmpresa("Tesla")
                                    .comQuantidade(10)
                                    .agora();



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

    @Test
    public void novoTeste(){
        Acao acao = AcaoBuilder.umaAcao()
                               .comNomeEmpresa("Blah")
                               .comQuantidade(3)
                               .agora();
        Acao acao2 = AcaoBuilder.umaAcao().agora();
    }

    @Test
    public void testaCalculaValorCarteiraComMock(){
        Acao acaoGoogle = AcaoBuilder.umaAcao()
                                     .comQuantidade(5)
                                     .comNomeEmpresa("Google")
                                     .agora();
        Acao acaoMicrosoft = AcaoBuilder.umaAcao()
                                        .comNomeEmpresa("Microsoft")
                                        .comQuantidade(1)
                                        .agora();
        Acao acaoTesla = AcaoBuilder.umaAcao()
                                    .comNomeEmpresa("Tesla")
                                    .comQuantidade(10)
                                    .agora();



        List<Acao> carteiraAcoes = new ArrayList<>();
        carteiraAcoes.add(acaoGoogle);
        carteiraAcoes.add(acaoMicrosoft);
        carteiraAcoes.add(acaoTesla);

        Map<String,Double> bancoAcoes = new HashMap();

        bancoAcoes.put("Google", 50.0);
        bancoAcoes.put("Microsoft",30.0);
        bancoAcoes.put("Tesla",60.0);
        bancoAcoes.put("Apple",20.0);

        AcaoService acaoService = Mockito.mock(AcaoService.class);

        when(acaoService.getPrecoAcaoMercado(acaoGoogle))
                              .thenReturn(bancoAcoes.get("Google"));
        when(acaoService.getPrecoAcaoMercado(acaoMicrosoft))
                              .thenReturn(bancoAcoes.get("Microsoft"));
        when(acaoService.getPrecoAcaoMercado(acaoTesla))
                              .thenReturn(bancoAcoes.get("Tesla"));

        Carteira carteira = new Carteira(acaoService);
        carteira.setCarteira(carteiraAcoes);

        double valorEsperado = acaoGoogle.getQuatidade()*bancoAcoes.get(acaoGoogle.getNomeEmpresa())+
                                acaoMicrosoft.getQuatidade()*bancoAcoes.get(acaoMicrosoft.getNomeEmpresa())+
                                acaoTesla.getQuatidade()*bancoAcoes.get(acaoTesla.getNomeEmpresa());

        
        //ação
        double valorObtido = carteira.calculaValorMercado();

        verify(acaoService).getPrecoAcaoMercado(acaoGoogle);

        //verificacao
        assertEquals(valorEsperado, valorObtido);


    }
    


}
