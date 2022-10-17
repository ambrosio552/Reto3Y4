package co.usa.Reto3.Reto3.web;


import co.usa.Reto3.Reto3.model.Reservation;
import co.usa.Reto3.Reto3.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(  "/api/Reservation")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT,RequestMethod.DELETE})
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation> getReservation(){
        return reservationService.getAll();
    }
    @GetMapping("/{id}")

    public Optional<Reservation> getReservation(@PathVariable("idReservation") int idReservation){
        return reservationService.getReservation(idReservation);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reservation){
        return reservationService.save(reservation);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("idReservation") int idReservation){
        return reservationService.deleteReservation(idReservation);
    }

}
