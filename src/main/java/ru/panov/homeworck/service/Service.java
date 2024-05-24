package ru.panov.homeworck.service;

import ru.panov.homeworck.model.Ticket;

import java.util.List;

public interface Service {

    List<Ticket> getOriginDestination(String origin, String destination);

    Double getArithmeticAverage(String origin, String destination);

    Double getMedian(String origin, String destination);

    Double getDifference(String origin, String destination);

}
