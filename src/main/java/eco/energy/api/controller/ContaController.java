package eco.energy.api.controller;
import eco.energy.api.dto.contaDto.DadosCadastroConta;
import eco.energy.api.dto.contaDto.DadosListagemConta;
import eco.energy.api.model.Conta;
import eco.energy.api.repository.ContaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("conta")
public class ContaController {
    @Autowired
    private ContaRepository contaRepository;

    @PostMapping
    public void cadastrar(@RequestBody @Valid DadosCadastroConta dados){
        contaRepository.save(new Conta(dados));
    }
    @GetMapping
    public Page<DadosListagemConta> listar(Pageable paginacao){
        return contaRepository.findAll(paginacao).map(DadosListagemConta::new);

    }
}
