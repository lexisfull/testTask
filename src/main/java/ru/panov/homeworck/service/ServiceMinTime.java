package ru.panov.homeworck.service;

import java.util.List;

public interface ServiceMinTime {
    List<String> getMinTimeByCarrierTickets(String origin, String destination);
}
