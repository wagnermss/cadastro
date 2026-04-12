package cadastrosistem.cadastro.services;

import cadastrosistem.cadastro.models.Imovel;
import cadastrosistem.cadastro.repositories.ImovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImovelService {

    @Autowired
    private ImovelRepository repository;

    public Imovel salvar(Imovel imovel) {
        return repository.save(imovel);
    }

    public List<Imovel> listarTodos() {
        return repository.findAll();
    }
}