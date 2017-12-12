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
public class AlarmSystemWaitForPasswordStateTest {
    private SensorEvent createSensorEvent() {
        return new SensorEvent(SensorEventType.DOOR_OPEN, "1");
    }

    private AlarmSystem generateStateWait() {
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.turnOn();
        alarmSystem.onSensorEvent(createSensorEvent());
        return alarmSystem;
    }

    @Test
    public void turnOff() {
        AlarmSystem alarmSystem = generateStateWait();
        alarmSystem.turnOff();
        assertEquals(AlarmSystemStateEnum.OFF, alarmSystem.getState());
    }

    @Test
    public void typeCorrectPassword() {
        AlarmSystem alarmSystem = generateStateWait();
        alarmSystem.enterPassword();
        assertEquals(AlarmSystemStateEnum.ON, alarmSystem.getState());
    }


    @Test
    public void otherMethods() {
        AlarmSystem alarmSystem = generateStateWait();
        alarmSystem.turnOn();
        assertEquals(AlarmSystemStateEnum.WAIT_FOR_PASSWORD, alarmSystem.getState());
        alarmSystem.onSensorEvent(createSensorEvent());
        assertEquals(AlarmSystemStateEnum.WAIT_FOR_PASSWORD, alarmSystem.getState());
    }

}