package ru.panov.homeworck.repository;

import ru.panov.homeworck.model.Ticket;

import java.util.List;

public interface Repository {

    List<Ticket> getTickets();
}
