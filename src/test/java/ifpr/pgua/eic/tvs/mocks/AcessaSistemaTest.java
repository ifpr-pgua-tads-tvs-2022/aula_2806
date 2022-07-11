package ifpr.pgua.eic.tvs.mocks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class AcessaSistemaTest {
    
    @Test
    void testAcessar() {
        //cenário
        String email = "user1@teste.com";
        String senha = "12345";

        AutenticacaoService autenticacaoService = Mockito
                                     .mock(AutenticacaoService.class);

        when(autenticacaoService.login(email, senha))
                             .thenReturn(new Usuario(email, "Zé"));


        AcessaSistema acessaSistema = new AcessaSistema(autenticacaoService);
        
        //ação
        Usuario ret = acessaSistema.acessar(email, senha);
        
        verify(autenticacaoService).login(email, senha);
    
        assertEquals(email,ret.getEmail());
        assertEquals("Zé", ret.getNome());
        
        
    }
}
