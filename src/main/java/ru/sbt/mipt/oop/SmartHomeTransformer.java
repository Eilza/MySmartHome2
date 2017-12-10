package ru.sbt.mipt.oop;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by DimaN228  on 10.11.2017.
 */
public class SmartHomeTransformer {
    public static String transform(SmartHome smartHome) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(smartHome);
        System.out.println(jsonString);
        return jsonString;
    }
}
