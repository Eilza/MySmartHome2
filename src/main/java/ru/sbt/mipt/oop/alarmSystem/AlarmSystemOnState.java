package ru.sbt.mipt.oop.alarmSystem;

import ru.sbt.mipt.oop.standartClass.SensorEvent;

/**
 * Created by DimaN228 on 12.12.2017.
 */
public class AlarmSystemOnState implements AlarmSystemState {

    private AlarmSystem alarmSystem;

    public AlarmSystemOnState(AlarmSystem alarmSystem) {
        this.alarmSystem = alarmSystem;
    }

    @Override
    public void turnOn() {
    }

    @Override
    public void turnOff() {
        alarmSystem.setStateStrategy(new AlarmSystemOffState(alarmSystem));
        alarmSystem.setState(AlarmSystemStateEnum.OFF);
    }

    @Override
    public void onSensorEvent(SensorEvent sensorEvent) {
        alarmSystem.setStateStrategy(new AlarmSystemWaitForPasswordState(alarmSystem));
        alarmSystem.setState(AlarmSystemStateEnum.WAIT_FOR_PASSWORD);
    }

    @Override
    public void enterPassword() {
    }
}

