package eco.energy.api.controller;

import eco.energy.api.dto.contaDto.DadosCadastroConta;
import eco.energy.api.model.Conta;
import eco.energy.api.repository.ContaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("conta")
public class ContaController {
    @Autowired
    private ContaRepository contaRepository;

    @PostMapping
    public void cadastrar(@RequestBody @Valid DadosCadastroConta dados){
        contaRepository.save(new Conta(dados));
    }
}
