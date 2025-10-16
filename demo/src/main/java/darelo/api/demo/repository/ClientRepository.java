package darelo.api.demo.repository;

import darelo.api.demo.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    List<Client> findAllByEmail(String email);
}
