package eco.energy.api.dto.contaDto;

import eco.energy.api.mes.Mes;

//Este record mapeia os dados do json, recebendo o valor total da conta de luz, o consumo e o mês da conta.
public record DadosCadastroConta(Double valorTotal, Double consumoKwh, Mes mes) {
}
