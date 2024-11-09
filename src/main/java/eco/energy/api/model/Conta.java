package eco.energy.api.model;
import eco.energy.api.dto.contaDto.DadosCadastroConta;
import eco.energy.api.mes.Mes;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Table(name = "Conta")
@Entity(name = "Conta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Conta {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 @NotNull(message = "O valor total não pode ser nulo")
 @DecimalMin(value = "0.01", message = "O valor total deve ser maior que 0")
 private Double valorTotal;

 @NotNull(message = "O consumo de kWh não pode ser nulo")
 @DecimalMin(value = "0.01", message = "O consumo de kWh deve ser maior que 0")
 private Double consumoKwh;

 @NotNull(message = "O mês não pode ser nulo")
 @Enumerated(EnumType.STRING)
 private Mes mes;

 public Conta(DadosCadastroConta dados) {
  this.valorTotal = dados.valorTotal();
  this.consumoKwh = dados.consumoKwh();
  this.mes = dados.mes();
 }
}