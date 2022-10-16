package com.ciclo3.reto.reto4.servicio;

import com.ciclo3.reto.reto4.entidad.Reservation;
import com.ciclo3.reto.reto4.repositorio.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository repository;

    //GET
    public List<Reservation> getReservations() {
        return repository.findAll();
    }

    public Reservation getReservation(long idReservation) {return repository.findById(idReservation).orElse(null);}

    //POST
    public Reservation saveReservation(Reservation reservation){
        return repository.save(reservation);
    }

    //PUT=UPDATE
    public Reservation updateReservation(Reservation reservationUpd) {
        Reservation reservationOld = getReservation(reservationUpd.getIdReservation());
        reservationOld.setStartDate(reservationUpd.getStartDate());
        reservationOld.setDevolutionDate(reservationUpd.getDevolutionDate());
        reservationOld.setStatus(reservationUpd.getStatus());
        return repository.save(reservationOld);
    }

    //DELETE
    public void deleteReservation(long idReservation){
        repository.deleteById(idReservation);
    }

}
