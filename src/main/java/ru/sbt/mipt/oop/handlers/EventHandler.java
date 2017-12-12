package ru.sbt.mipt.oop.handlers;

import ru.sbt.mipt.oop.standartClass.SensorEvent;
import ru.sbt.mipt.oop.smartHome.SmartHome;

/**
 * Created by DimaN228  on 09.11.2017.
 */
public interface EventHandler {
    void processHandler(SmartHome smartHome, SensorEvent sensorEvent);
}
