package cadastrosistem.cadastro.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome obrigatório")
    @Column(nullable = false)
    private String nome;

    @NotBlank(message = "Endereco obrigatório")
    @Column(nullable = false)
    private String endereco;

    @NotBlank(message = "Telefone obrigatório")
    @Pattern(regexp = "\\d{10,11}", message = "Telefone deve conter apenas numeros e ter 10 ou 11 digitos")
    @Column(nullable = false)
    private String telefone;

    @NotBlank(message = "Email obrigatório")
    @Email(message = "Email inválido")
    @Column(unique = true, nullable = false)
    private String email;

    @NotBlank(message = "Senha obrigatória")
    @Column(nullable = false)
    private String senha;
}
