package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.smartHome.SmartHome;
import ru.sbt.mipt.oop.standartClass.Door;
import ru.sbt.mipt.oop.standartClass.Light;
import ru.sbt.mipt.oop.standartClass.Room;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by DimaN228  on 10.11.2017.
 */
public class TestUtils {
    public static SmartHome generateSmartHome(){
        Door door1 = new Door(true, "1");
        Door door2 = new Door(true, "2");
        Door door3 = new Door(true, "3");
        Door door4 = new Door(true, "4");
        List<Door> doors1 = new ArrayList<>();
        doors1.add(door1);
        doors1.add(door2);
        doors1.add(door3);
        doors1.add(door4);

        Door door5 = new Door(true, "5");
        Door door6 = new Door(true, "6");
        List<Door> doors2 = new ArrayList<>();
        doors2.add(door5);
        doors2.add(door6);

        Light light1 = new Light("1", false);
        Light light2 = new Light("2", false);
        List<Light> lights1 = new ArrayList<>();
        lights1.add(light1);
        lights1.add(light2);

        Light light3 = new Light("3", false);
        Light light4 = new Light("4", false);
        List<Light> lights2 = new ArrayList<>();
        lights2.add(light3);
        lights2.add(light4);


        Room room = new Room(lights1, doors1, "hall");
        Room room1 = new Room(lights2, doors2, "bathroom");

        SmartHome smartHome = new SmartHome(Arrays.asList(room, room1));
        return smartHome;
    }
}

