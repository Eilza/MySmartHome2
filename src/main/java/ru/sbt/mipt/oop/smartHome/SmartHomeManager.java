package ru.sbt.mipt.oop.smartHome;

import ru.sbt.mipt.oop.standartClass.Door;
import ru.sbt.mipt.oop.standartClass.Light;

/**
 * Created by DimaN228  on 09.11.2017.
 */
public class SmartHomeManager {
    public static void turnOnLight(Light light) {
        light.setOn(true);
    }

    public static void turnOffLight(Light light) {
        light.setOn(false);
    }

    public static void openDoor(Door door) {
        door.setOpen(true);
    }

    public static void closeDoor(Door door) {
        door.setOpen(false);
    }
}
