package eco.energy.api.dto.contaDto;

import eco.energy.api.mes.Mes;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoConta(@NotNull Long idConta, Double valorTotal, Double consumoKwh, Mes mes) {
}
