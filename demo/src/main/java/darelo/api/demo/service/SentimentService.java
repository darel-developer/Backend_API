package darelo.api.demo.service;

import darelo.api.demo.entities.Client;
import darelo.api.demo.entities.Sentiment;
import darelo.api.demo.repository.SentimentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SentimentService {

    private ClientService clientService;
    private SentimentRepository sentimentRepository;

    public SentimentService(ClientService clientService, SentimentRepository sentimentRepository) {
        this.clientService = clientService;
        this.sentimentRepository = sentimentRepository;
    }

    public void creer(Sentiment sentiment){
        Client client = this.clientService.LireOuCreer(sentiment.getClient());
        sentiment.setClient(client);
        this.sentimentRepository.save(sentiment);
    }

    public List<Sentiment> rechercher() {
        return this.sentimentRepository.findAll();
    }
}
