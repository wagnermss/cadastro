package cadastrosistem.cadastro.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record UsuarioDTO(
        Long id,
        @NotBlank(message = "Nome obrigatório")
        String nome,
        @NotBlank(message = "Endereco obrigatório")
        String endereco,
        @NotBlank(message = "Telefone obrigatório")
        @Pattern(regexp = "\\d{10,11}", message = "Telefone deve conter apenas números e ter 10 ou 11 digitos")
        String telefone,
        @NotBlank(message = "Email obrigatório")
        @Email(message = "Email inválido")
        String email,
        @NotBlank(message = "Senha obrigatória")
        String senha
) {}
