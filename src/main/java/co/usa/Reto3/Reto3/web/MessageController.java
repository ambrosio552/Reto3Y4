package co.usa.Reto3.Reto3.web;


import co.usa.Reto3.Reto3.model.Message;
import co.usa.Reto3.Reto3.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(  "/api/Message")
@CrossOrigin(origins = "*",methods = {
        RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT,RequestMethod.DELETE})
public class MessageController {
    @Autowired
    private MessageService messageService;

    @GetMapping("/all")
    public List<Message> getmessage(){
        return messageService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Message> getmessage(@PathVariable("idMessage") int idMessage){
        return messageService.getMessage(idMessage);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message save(@RequestBody Message p){
         return messageService.save(p);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Message update(@RequestBody Message message){
        return messageService.update(message);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return messageService.deleteMessage(id);
    }
}

