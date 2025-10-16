package darelo.api.demo.entities;

import darelo.api.demo.enums.TypseSentiment;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@Table(name = "SENTIMENT")
public class Sentiment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private  String texte;
    private TypseSentiment type;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "CLIENT_ID")
    private Client client;

    public Sentiment() {
    }

    public Sentiment(int id, String texte, TypseSentiment type, Client client) {
        this.id = id;
        this.texte = texte;
        this.type = type;
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public TypseSentiment getType() {
        return type;
    }

    public void setType(TypseSentiment type) {
        this.type = type;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
