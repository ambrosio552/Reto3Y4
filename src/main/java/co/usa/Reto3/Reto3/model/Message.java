package co.usa.Reto3.Reto3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name="message")
public class Message implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private  Integer idMessage;
    private  String messageText;

     /*private Integer ortopedic{"id": 1}; */
     /*private Integer client[idClient]; */
    /*private Integer category{   }; */
    /*private Integer client {idClient}; */

    @ManyToOne
    @JoinColumn(name = "id")
    @JsonIgnoreProperties({"message","reservations"})
    private Ortopedic ortopedic;

    @ManyToOne
    @JoinColumn(name = "idClient")
    @JsonIgnoreProperties({"message","reservations"})
    private Client client;

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Ortopedic getOrtopedic() {
        return ortopedic;
    }

    public void setOrtopedic(Ortopedic ortopedic) {
        this.ortopedic = ortopedic;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
