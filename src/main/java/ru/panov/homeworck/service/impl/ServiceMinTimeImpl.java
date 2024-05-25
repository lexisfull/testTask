package ru.panov.homeworck.service.impl;

import ru.panov.homeworck.model.Ticket;
import ru.panov.homeworck.parser.TimeParser;
import ru.panov.homeworck.parser.impl.TimeParserImpl;
import ru.panov.homeworck.service.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class ServiceMinTimeImpl {

    private final Service service = new ServiceImpl();
    private final TimeParser timeParser = new TimeParserImpl();
    private List<Ticket> tickets;
    private List<Ticket> newTickets;
    private List<Ticket> ticketsCarrier;
    private List<String> printList;
    private Map<String, List<Ticket>> ticketsMap;

    private Map<String, List<Ticket>> getMapTicketByCarrier(String origin, String destination){
        ticketsMap = new HashMap<>();
        tickets = service.getOriginDestination(origin, destination);
        while (!tickets.isEmpty()){
            String carrier = tickets.get(0).getCarrier();
            newTickets = tickets.stream()
                    .filter(e -> e.getCarrier().equals(carrier))
                    .collect(Collectors.toList());

            ticketsMap.put(carrier, newTickets);
            tickets.removeAll(newTickets);
        }
        return ticketsMap;
    }

    public List<String> getMinTimeByCarrierTickets(String origin, String destination) {
        Map<String, List<Ticket>> ticketsMap = getMapTicketByCarrier(origin, destination);
        printList = new ArrayList<>();
        long start;
        long end;
        for (String key : ticketsMap.keySet()){
            ticketsCarrier = ticketsMap.get(key);

            if (ticketsCarrier.size() == 1){
                printList.add(ticketsCarrier.get(0).getCarrier() + " "
                                + (timeParser.countDaysBetween(ticketsCarrier.get(0).getDepartureDate()
                                + " " + ticketsCarrier.get(0).getDepartureTime()
                        ,ticketsCarrier.get(0).getArrivalDate()
                                + " " + checkLengthOfString(ticketsCarrier.get(0).getArrivalTime()))));
            }

            for (int i = 0; i < ticketsCarrier.size() - 1; i++) {

                start = timeParser.countDaysBetween(ticketsCarrier.get(i).getDepartureDate()
                                + " " + ticketsCarrier.get(i).getDepartureTime()
                                            ,ticketsCarrier.get(i).getArrivalDate()
                                + " " + checkLengthOfString(ticketsCarrier.get(i).getArrivalTime()));

                end = timeParser.countDaysBetween(ticketsCarrier.get(i + 1).getDepartureDate()
                                + " " + checkLengthOfString(ticketsCarrier.get(i + 1).getDepartureTime())
                        ,ticketsCarrier.get(i + 1).getArrivalDate()
                                + " " + checkLengthOfString(ticketsCarrier.get(i + 1).getArrivalTime()));

                while (!ticketsCarrier.isEmpty()) {
                   if (start > end) {
                        String str = ticketsCarrier.get(i).getCarrier() + " " + start;
                        printList.add(str);
                        ticketsCarrier.remove(1);
                    } else {
                        String str2 = ticketsCarrier.get(i + 1).getCarrier() + " " + start;
                        printList.add(str2);
                        ticketsCarrier.remove(i + 1);
                    }
                    ticketsCarrier.removeAll(ticketsCarrier);
                }
            }
        }
        return printList;
    }

    /**
     * Проверка строки на длину
     * @param str получаем строку, ставим первым символм "0" ессли длина меньше 5
     * @return возвращаем ту же строку, если строка равна 5
     */
    public String checkLengthOfString(String str) {
        if (str.length() < 5) {
            return "0" + str;
        }
        return str;
    }


}
