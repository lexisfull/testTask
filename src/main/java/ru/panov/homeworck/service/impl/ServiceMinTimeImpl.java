package ru.panov.homeworck.service.impl;

import ru.panov.homeworck.model.Ticket;
import ru.panov.homeworck.service.Service;

import java.util.List;
import java.util.stream.Collectors;


public class ServiceMinTimeImpl {

    private final Service service = new ServiceImpl();
    private List<Ticket> tickets;

    public List<Ticket> getMinTimeOriginDestination(String origin, String destination){

        tickets = service.getOriginDestination(origin, destination);
        List<Ticket> newTickets;
        while (!tickets.isEmpty()){
            String carrierTicket = tickets.get(0).getCarrier();
            newTickets = tickets.stream()
                            .filter(e -> e.getCarrier().equals(carrierTicket))
                                    .collect(Collectors.toList());

            tickets.removeAll(newTickets);
            return newTickets;
        }
        return null;
    }
}
