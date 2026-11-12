package tn.esprit.spring.autoloc.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.autoloc.entity.Reservation;
import tn.esprit.spring.autoloc.service.IReservationService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Reservation")
@Tag(name = "Gestion Reservation")
public class ReservationController {
    IReservationService reservationService;
    @PostMapping("/create")
    public Reservation creer(@RequestBody Reservation reservation) {
        return reservationService.creer(reservation);
    }
    @GetMapping("/Get-By-Id")
    public Reservation obtenirParId(Long id) {
        return reservationService.obtenirParId(id);
    }
    @GetMapping("/getAll")
    public List<Reservation> listerTous() {
        return reservationService.listerTous();
    }
    @PutMapping("/Update")
    public Reservation mettreAJour(Reservation reservation) {
        return reservationService.mettreAJour(reservation);
    }
    @DeleteMapping("/Delete")
    public void supprimer(Long id) {
        reservationService.supprimer(id);
    }
}
