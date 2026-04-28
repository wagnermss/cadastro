package cadastrosistem.cadastro.controllers;

import cadastrosistem.cadastro.models.Imovel;
import cadastrosistem.cadastro.services.ImovelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/imoveis")
@CrossOrigin(origins = "http://localhost:4200")
public class ImovelController {

    @Autowired
    private ImovelService service;

    @PostMapping
    public Imovel criar(@Valid @RequestBody Imovel imovel) {
        return service.salvar(imovel);
    }

    @GetMapping
    public List<Imovel> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Imovel> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Imovel> atualizar(@PathVariable Long id, @Valid @RequestBody Imovel imovel) {
        try {
            Imovel atualizado = service.atualizar(id, imovel);
            return ResponseEntity.ok(atualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
