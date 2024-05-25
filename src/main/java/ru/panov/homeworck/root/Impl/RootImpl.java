package ru.panov.homeworck.root.Impl;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import ru.panov.homeworck.model.Ticket;
import ru.panov.homeworck.root.Root;

import java.util.ArrayList;

/**
 * Корневой класс для хранения моделей после сериализации
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@ToString
public class RootImpl implements Root {

    ArrayList<Ticket> tickets;

}
