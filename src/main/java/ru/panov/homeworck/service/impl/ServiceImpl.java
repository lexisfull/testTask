package ru.panov.homeworck.service.impl;

import ru.panov.homeworck.model.Ticket;
import ru.panov.homeworck.parser.JsonParser;
import ru.panov.homeworck.parser.impl.JsonParserImpl;
import ru.panov.homeworck.root.Root;
import ru.panov.homeworck.service.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ServiceImpl implements Service {

    private  final JsonParser parser = new JsonParserImpl();
    private final Root root = parser.parse();

    /**
     * Получаем список всех рейсов
     * @param origin город вылета
     * @param destination город прибытия
     * @return возвращвем список
     */
    @Override
    public List<Ticket> getOriginDestination(String origin, String destination) {
        return root.getTickets()
                .stream()
                .filter(e -> e.getOriginName().equals(origin))
                .filter(e -> e.getDestinationName().equals(destination))
                .collect(Collectors.toList());
    }

    /**
     * Получаем среднее арифметическое стоимости
     * @param origin город вылета
     * @param destination город прибытия
     * @return возвращаем Double
     */
    @Override
    public Double getArithmeticAverage(String origin, String destination) {
        return this.getOriginDestination(origin, destination)
                .stream()
                .mapToInt(Ticket::getPrice)
                .average().orElse(Double.NaN);
    }

    /**
     * Высчитываем медиану стоимости
     * @param origin город вылетв
     * @param destination город прибытия
     * @return возвращаем Double
     */
    @Override
    public Double getMedian(String origin, String destination) {
        List<Integer> list = new ArrayList<>();
        double median;
        for (Ticket ticket : this.getOriginDestination(origin, destination)) {
            int price = ticket.getPrice();
            list.add(price);
        }
        list.sort(Integer::compareTo);
        if(list.size() % 2 == 0) {
            median = ((double)list.get(list.size() / 2) + (double)list.get((list.size()-1) / 2)) / 2;
        } else {
            median = (double)list.get(list.size() / 2);
        }
        return median;
    }

    /**
     * Высчитывам разницу между медианой и средней ценой
     * @param origin город вылета
     * @param destination город прибытия
     * @return возвращаем Double
     */
    @Override
    public Double getDifference(String origin, String destination) {
        double difference = getArithmeticAverage(origin, destination) - getMedian(origin, destination);
        if (difference < 0) {
            return difference * -1;
        } else {
            return difference;
        }
    }
}
