package cadastrosistem.cadastro.services;

import cadastrosistem.cadastro.dtos.LoginDTO;
import cadastrosistem.cadastro.dtos.UsuarioDTO;
import cadastrosistem.cadastro.models.Usuario;
import cadastrosistem.cadastro.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public Usuario cadastrar(UsuarioDTO dto) {
        Usuario novo = new Usuario(null, dto.nome(), dto.endereco(), dto.telefone(), dto.email(), dto.senha());
        return repository.save(novo);
    }

    public Optional<Usuario> autenticar(LoginDTO login) {
        return repository.findByEmail(login.email())
                .filter(u -> u.getSenha().equals(login.senha()));
    }
}