package ru.sbt.mipt.oop;

import org.junit.Test;
import ru.sbt.mipt.oop.handlers.ScenarioHandler;
import ru.sbt.mipt.oop.smartHome.SmartHome;
import ru.sbt.mipt.oop.standartClass.*;

import java.util.Collection;

import static java.util.Collections.singletonList;
import static org.junit.Assert.*;

/**
 * Created by DimaN228 on 10.11.2017.
 */
public class ScenarioHandlerTest {
    @Test
    public void testSRT() {
        SmartHome smartHome = TestUtils.generateSmartHome();
        Light light = new Light("1", true);
        String hallId = "Door #1";
        Room hall = new Room(
                singletonList(new Light("Light #1", true)),
                singletonList(new Door(false, hallId)),
                "hall");
        smartHome.addRoom(hall);

        Collection<Room> rooms = smartHome.getRooms();

        SensorEvent event = new SensorEvent(SensorEventType.DOOR_CLOSED, hallId);
        ScenarioHandler scenarioHandler = new ScenarioHandler();
        scenarioHandler.processHandler(smartHome, event);


        for (Room room : rooms) {
            for (Light l :room.getLights()) {
                assertFalse(l.isOn());
            }
        }
    }
}