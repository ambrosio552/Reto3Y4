package co.usa.Reto3.Reto3.service;

import co.usa.Reto3.Reto3.model.Reservation;
import co.usa.Reto3.Reto3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll() {

        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int id)
    {
        return reservationRepository.getReservation(id);
    }

    public Reservation save(Reservation p){
        if(p.getIdReservation()==null){
            return reservationRepository.save(p);
        }else{
            Optional<Reservation> ortaux= reservationRepository.getReservation(p.getIdReservation());
            if(ortaux.isEmpty()){
                return reservationRepository.save(p);
            }else {
                return p;
            }
        }

    }

    public Reservation update(Reservation reservation) {
        if (reservation.getIdReservation() !=null) {
            Optional<Reservation> v = reservationRepository.getReservation(reservation.getIdReservation());
            if (!v.isEmpty()) {
                if (reservation.getStarDate() != null) {
                    v.get().setStarDate(reservation.getStarDate());
                }
                if (reservation.getDevolutionDate() != null) {
                    v.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStatus() != null) {
                    v.get().setStatus(reservation.getStatus());
                }
                reservationRepository.save(v.get());
                return v.get();
            } else {
                return reservation;
            }
            }else{
                return reservation;
            }
    }
    public boolean deleteReservation(int id){
        boolean d = getReservation(id).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
        return d;
    }
}
