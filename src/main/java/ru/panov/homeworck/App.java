package ru.panov.homeworck;

import ru.panov.homeworck.service.Service;
import ru.panov.homeworck.service.ServiceMinTime;
import ru.panov.homeworck.service.impl.ServiceImpl;
import ru.panov.homeworck.service.impl.ServiceMinTimeImpl;


public class App {
    public static void main( String[] args ) {

        String start = "Владивосток";
        String stop = "Тель-Авив";

        Service service = new ServiceImpl();
        ServiceMinTime serviceMinTime = new ServiceMinTimeImpl();
        Double median = service.getMedian(start, stop);

        System.out.println("Медиана цены - " + median);
        System.out.println("-------------");

        System.out.println("Среднее арифметическое цены - " + service.getArithmeticAverage(start, stop));
        System.out.println("-------------");
        System.out.println("Разница между медианой и средней ценой - " + service.getDifference(start, stop));
        System.out.println("-------------");
        System.out.println("Минимальнаое время пути для каждой компании.\n" +
                "Первое - компания, второе время в минутах.");
        for (String str : serviceMinTime.getMinTimeByCarrierTickets(start, stop)){
            System.out.println(str);
        }

    }
}