package ru.panov.homeworck.parser.impl;

import com.google.gson.Gson;
import ru.panov.homeworck.root.Root;
import ru.panov.homeworck.root.Impl.RootImpl;
import ru.panov.homeworck.parser.JsonParser;

import java.io.FileReader;
import java.io.IOException;

/**
 * Парсер JSON, используется библиотека Gson
 */
public class JsonParserImpl implements JsonParser {

    private Gson gson;

    @Override
    public Root parse() {

        gson = new Gson();

        try (FileReader reader = new FileReader("tickets.json")) {

            return gson.fromJson(reader, RootImpl.class);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
