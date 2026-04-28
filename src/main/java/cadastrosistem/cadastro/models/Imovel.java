package cadastrosistem.cadastro.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Imovel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Titulo obrigatório")
    @Column(nullable = false)
    private String titulo;

    @NotBlank(message = "Endereco obrigatório")
    @Column(nullable = false)
    private String endereco;

    @NotBlank(message = "Bairro obrigatório")
    @Column(nullable = false)
    private String bairro;

    @NotBlank(message = "Zona obrigatória")
    @Column(nullable = false)
    private String zona;

    @NotNull(message = "Valor obrigatório")
    @Positive(message = "Valor deve ser maior que zero")
    @Digits(integer = 10, fraction = 2, message = "Valor deve ter no maximo 10 digitos inteiros e 2 casas decimais")
    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal valor;
}
