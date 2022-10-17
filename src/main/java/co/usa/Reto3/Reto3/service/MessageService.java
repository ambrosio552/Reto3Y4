package co.usa.Reto3.Reto3.service;

import co.usa.Reto3.Reto3.model.Message;
import co.usa.Reto3.Reto3.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll() {
        return messageRepository.getAll();
    }

    public Optional<Message> getMessage(int idMessage){
        return messageRepository.getMessage(idMessage);
    }


    public Message save(Message p){
        if(p.getIdMessage()==null){
            return messageRepository.save(p);
        }else{
            Optional<Message> ortaux= messageRepository.getMessage(p.getIdMessage());
            if(ortaux.isEmpty()){
                return messageRepository.save(p);
            }else {
                return p;
            }
        }

    }

    public Message update(Message message) {
        if (message.getIdMessage()!=null) {
            Optional<Message> h = messageRepository.getMessage(message.getIdMessage());
            if (!h.isEmpty()) {
                if (message.getIdMessage() != null) {
                    h.get().setMessageText(message.getMessageText());
                }
                messageRepository.save(h.get());
                return h.get();
            } else {
                return message;
            }
        }else{
            return message;
        }
    }
    public boolean deleteMessage(int idMessage){
        boolean d = getMessage(idMessage).map(message -> {
            messageRepository.delete(message);
            return true;
        }).orElse(false);
        return d;
    }
}
