package co.usa.Reto3.Reto3.service;

import co.usa.Reto3.Reto3.model.Client;
import co.usa.Reto3.Reto3.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    public List<Client> getAll(){
        return clientRepository.getAll();
    }
    public Optional<Client> getClient(int idClient){
        return clientRepository.getClient(idClient);
    }

    public Client save(Client p) {
        if (p.getIdClient() == null) {
            return clientRepository.save(p);
        } else {
            Optional<Client> cataux = clientRepository.getClient(p.getIdClient());
            if (cataux.isEmpty()) {
                return clientRepository.save(p);
            } else {
                return p;
            }
        }
    }

    public Client update(Client client) {
        if (client.getIdClient() !=null) {
            Optional<Client> j = clientRepository.getClient(client.getIdClient());
            if (!j.isEmpty()) {
                if (client.getName() != null) {
                    j.get().setName((client.getName()));
                }
                if (client.getAge() != null) {
                    j.get().setAge(client.getAge());
                }
                if (client.getPassword() != null) {
                    j.get().setPassword(client.getPassword());
                }
                clientRepository.save(j.get());
                return j.get();
            } else {
                return client;
            }
        }else{
              return client;
        }

    }
    public boolean deleteClient(int id){
        boolean d = getClient(id).map(client -> {
            clientRepository.delete(client);
            return true;
        }).orElse(false);
        return d;
    }

}
