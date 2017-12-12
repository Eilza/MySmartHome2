package ru.sbt.mipt.oop;

import org.junit.Test;
import ru.sbt.mipt.oop.handlers.DoorHandler;
import ru.sbt.mipt.oop.smartHome.SmartHome;
import ru.sbt.mipt.oop.standartClass.Door;
import ru.sbt.mipt.oop.standartClass.Room;
import ru.sbt.mipt.oop.standartClass.SensorEvent;
import ru.sbt.mipt.oop.standartClass.SensorEventType;

import java.util.Collection;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static ru.sbt.mipt.oop.TestUtils.generateSmartHome;

/**
 * Created by DimaN228 on 10.11.2017.
 */
public class DoorHandlerTest {
    DoorHandler doorHandler = new DoorHandler();
    SmartHome smartHome = generateSmartHome();

    @Test
    public void testOpenSomeDoors() {
        Collection<Room> rooms = smartHome.getRooms();

        SensorEvent event = new SensorEvent(SensorEventType.DOOR_CLOSED, "2");
        doorHandler.processHandler(smartHome, event);

        for (Room room : rooms) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals("2")) {
                    assertFalse(door.isOpen());
                } else {
                    assertTrue(door.isOpen());
                }
            }
        }
    }

    @Test
    public void testOpenAllDoors() {
        Collection<Room> rooms = smartHome.getRooms();

        SensorEvent event = new SensorEvent(SensorEventType.DOOR_CLOSED, "4");
        doorHandler.processHandler(smartHome, event);

        for (Room room : rooms) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals("4")) {
                    assertFalse(door.isOpen());
                } else {
                    assertTrue(door.isOpen());
                }
            }
        }
    }
}




