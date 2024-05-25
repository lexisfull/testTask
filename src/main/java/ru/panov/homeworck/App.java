package ru.panov.homeworck;

import ru.panov.homeworck.service.Service;
import ru.panov.homeworck.service.impl.ServiceImpl;
import ru.panov.homeworck.service.impl.ServiceMinTimeImpl;


public class App {
    public static void main( String[] args ) {

        String start = "Владивосток";
        String stop = "Тель-Авив";

        Service service = new ServiceImpl();
        ServiceMinTimeImpl serviceMinTime = new ServiceMinTimeImpl();
        Double median = service.getMedian(start, stop);

        System.out.println(median);
        System.out.println("-------------");

        System.out.println(service.getArithmeticAverage(start, stop));
        System.out.println("-------------");
        System.out.println(service.getDifference(start, stop));
        System.out.println("-------------");
        for (String str : serviceMinTime.getMinTimeByCarrierTickets(start, stop)){
            System.out.println(str);
        }

    }
}