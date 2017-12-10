package ru.sbt.mipt.oop;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by DimaN228 on 10.11.2017.
 */
public class SmartHomeFileReader {
    static SmartHome read() throws IOException {
        Gson gson = new Gson();
        // считываем состояние дома из файла
        String json = new String(Files.readAllBytes(Paths.get("smart-home-1.js")));
        return gson.fromJson(json, SmartHome.class);
    }
}
