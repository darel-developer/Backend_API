package darelo.api.demo.service;

import darelo.api.demo.entities.Client;
import darelo.api.demo.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public String creer(Client client) {
        List<Client> clientDansLaBDD = this.clientRepository.findAllByEmail(client.getEmail());
        if (clientDansLaBDD != null) {
            return "L'adresse email existe déjà.";
        }

        this.clientRepository.save(client);
        return "Création du compte réussie.";
    }

    public List<Client> rechercher() {
        return this.clientRepository.findAll();
    }

    public Client lire(int id) {
        Optional<Client> optionalClient = this.clientRepository.findById(id);
        if (optionalClient.isPresent()){
            return optionalClient.get();
        }
        return null;
    }

    public Client LireOuCreer(Client clientInput) {
        List<Client> clients = clientRepository.findAllByEmail(clientInput.getEmail());
        if (!clients.isEmpty()) {
            return clients.get(0); // On retourne le premier trouvé
        }
        return clientRepository.save(clientInput);
    }

}
