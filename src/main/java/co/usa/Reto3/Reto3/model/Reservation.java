package co.usa.Reto3.Reto3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="reservation")
public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idReservation;
    private Date starDate;
    private Date devolutionDate ;
    private String status = "created";

    /*private  ortopedic{id}; */
    /*private  category{id}; */
    /*private  messages{idMessage}; */
    /*private  client[idClient]; */
    /*private  score[null]; */

    @ManyToOne
    @JoinColumn(name = "id")
    @JsonIgnoreProperties("reservation")
    private Ortopedic ortopedic;

    @ManyToOne
    @JoinColumn(name = "idClient")
    @JsonIgnoreProperties({"message","reservations"})
    private Client client;

    /* @OneToOne(cascade = {CascadeType.REMOVE}, mappedBy = "reservation")
    @JsonIgnoreProperties("reservation")
    private  Score score; */

    public Integer getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public Date getStarDate() {
        return starDate;
    }

    public void setStarDate(Date starDate) {
        this.starDate = starDate;
    }

    public Date getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
