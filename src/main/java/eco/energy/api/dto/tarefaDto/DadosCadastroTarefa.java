package eco.energy.api.dto.tarefaDto;

//Este record mapeia os dados do json, recebendo o nome, a descrição e o status: completo ou não
public record DadosCadastroTarefa(String nome, String descricao, Boolean status) {
}
