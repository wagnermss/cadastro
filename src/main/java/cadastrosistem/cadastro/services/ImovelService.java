package cadastrosistem.cadastro.services;

import cadastrosistem.cadastro.models.Imovel;
import cadastrosistem.cadastro.repositories.ImovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Imovel> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Imovel atualizar(Long id, Imovel imovelAtualizado) {
        return repository.findById(id).map(imovel -> {
            imovel.setTitulo(imovelAtualizado.getTitulo());
            imovel.setEndereco(imovelAtualizado.getEndereco());
            imovel.setBairro(imovelAtualizado.getBairro());
            imovel.setZona(imovelAtualizado.getZona());
            imovel.setValor(imovelAtualizado.getValor());
            return repository.save(imovel);
        }).orElseThrow(() -> new RuntimeException("Imóvel não encontrado"));
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}