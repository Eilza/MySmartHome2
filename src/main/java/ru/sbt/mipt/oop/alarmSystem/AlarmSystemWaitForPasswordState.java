package ru.sbt.mipt.oop.alarmSystem;

import ru.sbt.mipt.oop.standartClass.SensorEvent;

/**
 * Created by DimaN228 on 12.12.2017.
 */
public class AlarmSystemWaitForPasswordState implements AlarmSystemState {
    private AlarmSystem alarmSystem;

    public AlarmSystemWaitForPasswordState(AlarmSystem alarmSystem) {
        this.alarmSystem = alarmSystem;
    }

    @Override
    public void turnOn() {
    }

    @Override
    public void onSensorEvent(SensorEvent sensorEvent) {
    }

    @Override
    public void turnOff() {
        alarmSystem.setStateStrategy(new AlarmSystemOffState(alarmSystem));
        alarmSystem.setState(AlarmSystemStateEnum.OFF);
    }

    @Override
    public void enterPassword() {
        alarmSystem.setStateStrategy(new AlarmSystemOnState(alarmSystem));
        alarmSystem.setState(AlarmSystemStateEnum.ON);
    }
}
