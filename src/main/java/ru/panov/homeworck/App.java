package ru.panov.homeworck;

import ru.panov.homeworck.service.Service;
import ru.panov.homeworck.service.impl.ServiceImpl;
import ru.panov.homeworck.service.impl.ServiceMinTimeImpl;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {

        String start = "Владивосток";
        String stop = "Тель-Авив";
//
//        Service service = new ServiceImpl();
//        Double median = service.getMedian(start, stop);
//
//        System.out.println(median);
//        System.out.println("-------------");
//
//        System.out.println(service.getArithmeticAverage(start, stop));
//        System.out.println("-------------");
//        System.out.println(service.getDifference(start, stop));

        ServiceMinTimeImpl smi = new ServiceMinTimeImpl();
        System.out.println(smi.getMinTimeOriginDestination(start, stop));

    }
}
