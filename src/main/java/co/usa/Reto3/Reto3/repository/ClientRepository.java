package co.usa.Reto3.Reto3.repository;


import co.usa.Reto3.Reto3.model.Client;
import co.usa.Reto3.Reto3.model.Reservation;
import co.usa.Reto3.Reto3.repository.crud.ClientCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {
    @Autowired

    private ClientCrudRepository clientCrudRepository;


    public List<Client> getAll(){
        return (List<Client>) clientCrudRepository.findAll();

    }

    public Optional<Client> getClient(int IdClient) {
        return clientCrudRepository.findById(IdClient);
    }
    public Client save(Client c){
        return clientCrudRepository.save(c);
    }

    public void delete(Client j){
        clientCrudRepository.delete(j);
    }

}
