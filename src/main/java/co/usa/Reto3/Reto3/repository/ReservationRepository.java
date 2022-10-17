package co.usa.Reto3.Reto3.repository;


import co.usa.Reto3.Reto3.model.Reservation;
import co.usa.Reto3.Reto3.repository.crud.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {
    @Autowired
   private ReservationCrudRepository reservationCrudRepository;

    public List<Reservation> getAll(){
        return (List<Reservation>) reservationCrudRepository.findAll();

    }
    public Optional<Reservation>getReservation(int Id){

        return reservationCrudRepository.findById(Id);
    }
    public Reservation save(Reservation c){

        return reservationCrudRepository.save(c);
    }

    public void delete(Reservation reservation){
        reservationCrudRepository.delete(reservation);
    }

}
