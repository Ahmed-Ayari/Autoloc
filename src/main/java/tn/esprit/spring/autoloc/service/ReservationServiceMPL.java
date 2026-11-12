package tn.esprit.spring.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.autoloc.entity.Reservation;
import tn.esprit.spring.autoloc.repository.ReservationRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ReservationServiceMPL implements IReservationService {
    ReservationRepository reservationRepository;

    @Override
    public Reservation creer(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation obtenirParId(Long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    @Override
    public List<Reservation> listerTous() {
        return (List<Reservation>) reservationRepository.findAll();
    }

    @Override
    public Reservation mettreAJour(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public void supprimer(Long id) {
        reservationRepository.deleteById(id);
    }
}
