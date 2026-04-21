package cadastrosistem.cadastro.controllers;

import cadastrosistem.cadastro.dtos.LoginDTO;
import cadastrosistem.cadastro.dtos.UsuarioDTO;
import cadastrosistem.cadastro.models.Usuario;
import cadastrosistem.cadastro.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    @Autowired
    private UsuarioService service;

    @PostMapping("/registrar")
    public ResponseEntity<Usuario> registrar(@RequestBody UsuarioDTO dto) {
        return ResponseEntity.ok(service.cadastrar(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<Usuario> login(@RequestBody LoginDTO login) {
        return service.autenticar(login)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(401).build());
    }
}