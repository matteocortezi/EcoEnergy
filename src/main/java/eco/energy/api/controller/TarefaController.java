package eco.energy.api.controller;
import eco.energy.api.dto.tarefaDto.DadosAtualizacaoTarefa;
import eco.energy.api.dto.tarefaDto.DadosCadastroTarefa;
import eco.energy.api.dto.tarefaDto.DadosListagemTarefa;
import eco.energy.api.model.Tarefa;
import eco.energy.api.repository.TarefaRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("tarefa")
public class TarefaController {
    @Autowired
    private TarefaRepository tarefaRepository;

    @PostMapping
    public void cadastrar(@RequestBody @Valid DadosCadastroTarefa dados){
        tarefaRepository.save(new Tarefa(dados));
    }
    @GetMapping
    public Page<DadosListagemTarefa> listar(@PageableDefault(size = 10, page = 0) Pageable paginacao){
        return tarefaRepository.findAll(paginacao).map(DadosListagemTarefa::new);
    }
    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoTarefa dados){
        var tarefa = tarefaRepository.getReferenceById(dados.idTarefa());
        tarefa.atualizarInformacoes(dados);
    }
}
