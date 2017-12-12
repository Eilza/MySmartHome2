package ru.sbt.mipt.oop.alarmSystem;

import ru.sbt.mipt.oop.standartClass.SensorEvent;

/**
 * Created by DimaN228 on 12.12.2017.
 */
public class AlarmSystem {

    private AlarmSystemState stateStrategy;
    private AlarmSystemStateEnum state;

    public void setState(AlarmSystemStateEnum state) {
        this.state = state;
    }

    public AlarmSystem() {
        AlarmSystemState alarmSystemState = new AlarmSystemOffState(this);
        this.stateStrategy = alarmSystemState;
        this.state = AlarmSystemStateEnum.OFF;
    }

    public void setStateStrategy(AlarmSystemState stateStrategy) {
        this.stateStrategy = stateStrategy;
    }

    public AlarmSystemStateEnum getState() {
        return state;
    }

    public void turnOn() {
        stateStrategy.turnOn();
    }

    public void turnOff() {
        stateStrategy.turnOff();
    }

    public void onSensorEvent(SensorEvent sensorEvent) {
        stateStrategy.onSensorEvent(sensorEvent);
    }

    public void enterPassword() {
        stateStrategy.enterPassword();
    }

}
