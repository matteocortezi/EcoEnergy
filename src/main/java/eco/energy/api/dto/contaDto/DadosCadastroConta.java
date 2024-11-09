package eco.energy.api.dto.contaDto;

import eco.energy.api.mes.Mes;

public record DadosCadastroConta(double valorTotal, double consumoKwh, Mes mes) {
}
