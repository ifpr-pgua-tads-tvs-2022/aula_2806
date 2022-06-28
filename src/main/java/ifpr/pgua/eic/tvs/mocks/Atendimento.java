package ifpr.pgua.eic.tvs.mocks;

import java.time.LocalDateTime;

import net.bytebuddy.asm.Advice.Local;

public class Atendimento {
    private LocalDateTime horaInicio;
    private String assunto;
    private double valorPorMinuto;
    private double valorTotal;
    
    public double getValorPorMinuto() {
        return valorPorMinuto;
    }

    public void setValorPorMinuto(double valorPorMinuto) {
        this.valorPorMinuto = valorPorMinuto;
    }

    
    public LocalDateTime getHoraInicio() {
        return horaInicio;
    }
    
    public void setHoraInicio(LocalDateTime horaInicio) {
        this.horaInicio = horaInicio;
    }
    
    public String getAssunto() {
        return assunto;
    }
    
    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public double calculaValorTotal(){
        double valor = 0.0;

        LocalDateTime dataTermino = LocalDateTime.now();

        int qtdeMinutos = DataUtils.calculaMinutos(this.horaInicio, dataTermino);

        valor = qtdeMinutos*valorPorMinuto;

        return valor;
    }



    

}
