package ru.sbt.mipt.oop.alarmSystem;

import ru.sbt.mipt.oop.standartClass.SensorEvent;

/**
 * Created by DimaN228 on 12.12.2017.
 */
public class AlarmSystemOffState implements AlarmSystemState {

    private AlarmSystem alarmSystem;

    public AlarmSystemOffState(AlarmSystem alarmSystem) {
        this.alarmSystem = alarmSystem;
    }

    @Override
    public void turnOn() {
        alarmSystem.setStateStrategy(new AlarmSystemOnState(alarmSystem));
        alarmSystem.setState(AlarmSystemStateEnum.ON);
    }

    @Override
    public void onSensorEvent(SensorEvent sensorEvent) {
        alarmSystem.setStateStrategy(new AlarmSystemWaitForPasswordState(alarmSystem));
        alarmSystem.setState(AlarmSystemStateEnum.WAIT_FOR_PASSWORD);
    }

    @Override
    public void turnOff() {}

    @Override
    public void enterPassword() {}
}
