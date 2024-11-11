package eco.energy.api.controller;
import eco.energy.api.dto.tarefaDto.DadosCadastroTarefa;
import eco.energy.api.dto.tarefaDto.DadosListagemTarefa;
import eco.energy.api.model.Tarefa;
import eco.energy.api.repository.TarefaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<DadosListagemTarefa> listar(Pageable paginacao){
        return tarefaRepository.findAll(paginacao).map(DadosListagemTarefa::new);
    }
}
