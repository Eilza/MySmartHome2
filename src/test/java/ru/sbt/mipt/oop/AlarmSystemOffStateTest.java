package ru.sbt.mipt.oop;

import org.junit.Test;
import ru.sbt.mipt.oop.alarmSystem.AlarmSystem;
import ru.sbt.mipt.oop.alarmSystem.AlarmSystemStateEnum;
import ru.sbt.mipt.oop.standartClass.SensorEvent;
import ru.sbt.mipt.oop.standartClass.SensorEventType;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 17.11.2017.
 */
public class AlarmSystemOffStateTest {
    @Test
    public void turnOn() {
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.turnOn();
        assertEquals(AlarmSystemStateEnum.ON, alarmSystem.getState());
    }

    @Test
    public void onSensor() {
        AlarmSystem alarmSystem = new AlarmSystem();
        SensorEvent sensorEvent = createSensorEvent();
        alarmSystem.onSensorEvent(sensorEvent);
        assertEquals(AlarmSystemStateEnum.WAIT_FOR_PASSWORD, alarmSystem.getState());
    }


    @Test
    public void otherMethods() {
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.turnOff();
        assertEquals(AlarmSystemStateEnum.OFF, alarmSystem.getState());
        alarmSystem.enterPassword();
        assertEquals(AlarmSystemStateEnum.OFF, alarmSystem.getState());
    }

    private SensorEvent createSensorEvent() {
        return new SensorEvent(SensorEventType.DOOR_OPEN, "1");
    }
}