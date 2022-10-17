package co.usa.Reto3.Reto3.web;


import co.usa.Reto3.Reto3.model.Client;
import co.usa.Reto3.Reto3.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(  "/api/Client")
@CrossOrigin(origins = "*",methods = {
        RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT,RequestMethod.DELETE})

public class ClientController {
    @Autowired
    private ClientService clientService;
    @GetMapping("/all")
    public List<Client> getClient(){
        return clientService.getAll();
    }
    @GetMapping("/{idClient}")
    public Optional<Client> getClient(@PathVariable("idClient") int idClient){
        return clientService.getClient(idClient);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody Client p){

        return clientService.save(p);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Client update(@RequestBody Client client){
        return clientService.update(client);
    }

    @DeleteMapping("/{idClient}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("idClient") int idClient){
        return clientService.deleteClient(idClient);
    }

}
