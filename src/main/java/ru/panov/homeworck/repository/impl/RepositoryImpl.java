package ru.panov.homeworck.repository.impl;

import ru.panov.homeworck.model.Ticket;
import ru.panov.homeworck.parser.JsonParser;
import ru.panov.homeworck.parser.impl.JsonParserImpl;
import ru.panov.homeworck.repository.Repository;
import ru.panov.homeworck.root.Root;

import java.util.List;

/**
 * Хранит все объекты используется в качестве репозитория
 */
public class RepositoryImpl implements Repository {

    private  final JsonParser parser = new JsonParserImpl();
    private final Root root = parser.parse();
    private final List<Ticket> tickets = root.getTickets();

    @Override
    public List<Ticket> getTickets() {
        return tickets;
    }
}