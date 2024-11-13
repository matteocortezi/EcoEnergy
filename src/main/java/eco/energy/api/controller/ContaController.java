package eco.energy.api.controller;
import eco.energy.api.dto.contaDto.DadosAtualizacaoConta;
import eco.energy.api.dto.contaDto.DadosCadastroConta;
import eco.energy.api.dto.contaDto.DadosListagemConta;
import eco.energy.api.model.Conta;
import eco.energy.api.repository.ContaRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
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
    public Page<DadosListagemConta> listar(@PageableDefault(size = 10, page = 0) Pageable paginacao){
        return contaRepository.findAll(paginacao).map(DadosListagemConta::new);
    }
    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoConta dados){
        var conta = contaRepository.getReferenceById(dados.idConta());
        conta.atualizarInformacoes(dados);
    }
    
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        contaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
