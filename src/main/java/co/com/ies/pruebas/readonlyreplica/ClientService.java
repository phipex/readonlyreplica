package co.com.ies.pruebas.readonlyreplica;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientEntityRepository repository;

    public ClientService(ClientEntityRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void performWriteOperation() {
        // Perform write operation here
    }


    public List<ClientEntity> performReadOperation() {
        // Perform read operation here
        return repository.findAll();
    }
}
