package ru.sbt.mipt.oop;

import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static ru.sbt.mipt.oop.TestUtils.generateSmartHome;

/**
 * Created by DimaN228 on 10.11.2017.
 */
public class LightHandlerTest {
    private SmartHome smartHome = generateSmartHome();
    LightHandler lightHandler = new LightHandler();

    @Test
    public void test() {
        SensorEvent sensorEvent = new SensorEvent(SensorEventType.LIGHT_ON, "2");
        lightHandler.processHandler(smartHome, sensorEvent);
        Collection<Room> rooms = smartHome.getRooms();

        for (Room room : rooms) {
            for (Light light : room.getLights()) {
                if (light.getId().equals("2")) {
                    assertTrue(light.isOn());
                } else {
                    assertFalse(light.isOn());
                }
            }
        }
    }

    @Test
    public void test1() {
        String[] turnedOnLightId = new String[]{"2", "4"};
        LightHandler lightHandler = new LightHandler();

        for (String lightId : turnedOnLightId) {
            SensorEvent sensorEvent = new SensorEvent(SensorEventType.LIGHT_ON, lightId);
            lightHandler.processHandler(smartHome, sensorEvent);
        }
        Collection<Room> rooms = smartHome.getRooms();
        for (Room room : rooms) {
            for (Light light : room.getLights()) {
                if (light.getId().equals(turnedOnLightId)) {
                    assertTrue(light.isOn());
                }
            }
        }
        for (Room room : rooms) {
            for (Light light : room.getLights()) {
                if (light.getId().equals("1") || light.getId().equals("3")) {
                    assertFalse(light.isOn());
                }
            }
        }

    }

}