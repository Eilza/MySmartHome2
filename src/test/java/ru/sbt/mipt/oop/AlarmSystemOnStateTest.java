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
public class AlarmSystemOnStateTest {

    private AlarmSystem generateStateOn() {
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.turnOn();
        return alarmSystem;
    }

    @Test
    public void turnOn() {
        AlarmSystem alarmSystem = generateStateOn();
        alarmSystem.turnOn();
        assertEquals(AlarmSystemStateEnum.ON, alarmSystem.getState());
    }

    @Test
    public void onSensor() {
        AlarmSystem alarmSystem = generateStateOn();
        alarmSystem.onSensorEvent(createSensorEvent());
        assertEquals(AlarmSystemStateEnum.WAIT_FOR_PASSWORD, alarmSystem.getState());
    }

    @Test
    public void turnOff() {
        AlarmSystem alarmSystem = generateStateOn();
        assertEquals(AlarmSystemStateEnum.ON, alarmSystem.getState());
        alarmSystem.turnOff();
        assertEquals(AlarmSystemStateEnum.OFF, alarmSystem.getState());
    }

    @Test
    public void otherMethods() {
        AlarmSystem alarmSystem = generateStateOn();
        alarmSystem.enterPassword();
        assertEquals(AlarmSystemStateEnum.ON, alarmSystem.getState());

    }

    private SensorEvent createSensorEvent() {
        return new SensorEvent(SensorEventType.DOOR_OPEN, "1");
    }
}