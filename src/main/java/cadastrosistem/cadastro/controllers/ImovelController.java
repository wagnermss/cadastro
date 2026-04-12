package cadastrosistem.cadastro.controllers;

import cadastrosistem.cadastro.models.Imovel;
import cadastrosistem.cadastro.services.ImovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/imoveis")
@CrossOrigin(origins = "http://localhost:4200")
public class ImovelController {

    @Autowired
    private ImovelService service;

    @PostMapping
    public Imovel criar(@RequestBody Imovel imovel) {
        return service.salvar(imovel);
    }

    @GetMapping
    public List<Imovel> listar() {
        return service.listarTodos();
    }
}