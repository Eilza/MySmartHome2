package ru.sbt.mipt.oop.alarmSystem;

import ru.sbt.mipt.oop.standartClass.SensorEvent;

/**
 * Created by DimaN228 on 12.12.2017.
 */
public interface AlarmSystemState {


    void turnOn();

    void onSensorEvent(SensorEvent sensorEvent);

    void turnOff();

    void enterPassword();

}

