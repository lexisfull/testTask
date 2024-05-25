package ru.panov.homeworck.parser.impl;

import ru.panov.homeworck.parser.TimeParser;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * Класс считает разницу между вылетом и прибытием в минутах
 */

public class TimeParserImpl implements TimeParser {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy.MM.dd HH:mm");
    private final ZoneId zoneId = ZoneId.systemDefault();

    /**
     * @param start дата и время вылета
     * @param end дата и время прибытия
     * @throw при введении аргументов null
     * возвращаемое значение long в минутах
     */
    @Override
    public long countDaysBetween(String start, String end){

            LocalDateTime startDateTime = LocalDateTime.parse(start, formatter).atZone(zoneId).toLocalDateTime();
            LocalDateTime endDateTime = LocalDateTime.parse(end, formatter).atZone(zoneId).toLocalDateTime();

        if(startDateTime == null || endDateTime == null)
        {
            throw new IllegalArgumentException("No such a date");
        }

        long daysBetween = ChronoUnit.MINUTES.between(startDateTime, endDateTime);

        return daysBetween;
    }
}
