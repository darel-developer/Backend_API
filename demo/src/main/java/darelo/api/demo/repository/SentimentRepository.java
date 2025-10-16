package darelo.api.demo.repository;


import darelo.api.demo.entities.Sentiment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SentimentRepository extends JpaRepository<Sentiment,Integer> {
}
