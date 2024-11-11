package eco.energy.api.dto.contaDto;

import eco.energy.api.mes.Mes;
import eco.energy.api.model.Conta;

public record DadosListagemConta(double valorTotal, double consumoKwh, Mes mes) {
    public DadosListagemConta (Conta conta){
        this(conta.getValorTotal(), conta.getConsumoKwh(), conta.getMes());
    }
}
