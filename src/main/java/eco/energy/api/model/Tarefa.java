package eco.energy.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Table(name = "tarefa")
@Entity(name = "Tarefa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome da tarefa não pode ser vazio")
    @Size(min = 3, max = 100, message = "O nome da tarefa deve ter entre 3 e 100 caracteres")
    private String nome;

    @NotBlank(message = "A descrição não pode ser vazia")
    @Size(min = 5, max = 255, message = "A descrição deve ter entre 5 e 255 caracteres")
    private String descricao;

    @NotNull(message = "O status não pode ser nulo")
    private Boolean status; // true para completada, false para não completada
}

