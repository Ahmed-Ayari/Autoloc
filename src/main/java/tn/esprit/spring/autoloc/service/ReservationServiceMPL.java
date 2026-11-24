package tn.esprit.spring.autoloc.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.juli.logging.Log;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.spring.autoloc.entity.Contrat;
import tn.esprit.spring.autoloc.entity.Reservation;
import tn.esprit.spring.autoloc.entity.StatutReservation;
import tn.esprit.spring.autoloc.repository.ReservationRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
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

    @Override
    @Scheduled(cron = "0 0 0 * * *")
    public void verifReservationExpire() {
        LocalDate aujourdHui = LocalDate.now();

        // Adaptez le nom du champ de date de fin selon votre entité (ex: dateFin, dateRetour...)
        List<Reservation> reservationsExpirees = reservationRepository
                .findByStatutAndDateFinBefore(StatutReservation.CONFIRMEE, aujourdHui);

        for (Reservation reservation : reservationsExpirees) {
            reservation.setStatut(StatutReservation.TERMINEE);
        }

        if (!reservationsExpirees.isEmpty()) {
            reservationRepository.saveAll(reservationsExpirees);
            log.info("{} réservation(s) marquée(s) comme TERMINEE.", reservationsExpirees.size());
        }
    }

    @Override
    @Transactional
    public Reservation ajouterReservationContrat(Reservation reservation) {
        Contrat contrat = reservation.getContrat();
        if (contrat == null) {
            throw new IllegalArgumentException("The reservation must contain a contract");
        }
        contrat.setReservation(reservation);
        return reservationRepository.save(reservation);
    }
}
