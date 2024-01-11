package sn.douanes.gestionstockpostgres.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.douanes.gestionstockpostgres.entities.Tickets;
import sn.douanes.gestionstockpostgres.repositories.TicketsRepository;
import sn.douanes.gestionstockpostgres.services.TicketsService;


@Service
public class TicketsServiceImpl implements TicketsService {

    @Autowired
    TicketsRepository ticketsRepository;

    @Override
    public Tickets saveTickets(Tickets t) {
        return ticketsRepository.save(t);
    }

    @Override
    public Tickets updateTickets(Tickets t) {
        return ticketsRepository.save(t);
    }

    @Override
    public void deleteTickets(Tickets t) {
        ticketsRepository.delete(t);
    }

    @Override
    public void deleteTicketsById(Long id) {
        ticketsRepository.deleteById(id);
    }

    @Override
    public Tickets getTickets(Long id) {
        return ticketsRepository.findById(id).get();
    }

    @Override
    public List<Tickets> getAllTickets() {
        return ticketsRepository.findAll();
    }



}
