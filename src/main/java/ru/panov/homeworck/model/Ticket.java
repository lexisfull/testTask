package ru.panov.homeworck.model;

import com.google.gson.annotations.SerializedName;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * Модель класса Ticket
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
public class Ticket {

    @SerializedName("origin_name")
    String originName;
    String destination;
    String origin;
    @SerializedName("destination_name")
    String destinationName;
    @SerializedName("departure_date")
    String departureDate;
    @SerializedName("departure_time")
    String departureTime;
    @SerializedName("arrival_date")
    String arrivalDate;
    @SerializedName("arrival_time")
    String arrivalTime;
    String carrier;
    int stops;
    int price;

}
