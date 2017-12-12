package ru.sbt.mipt.oop.handlers;

import ru.sbt.mipt.oop.standartClass.Door;
import ru.sbt.mipt.oop.standartClass.Room;
import ru.sbt.mipt.oop.standartClass.SensorEvent;
import ru.sbt.mipt.oop.smartHome.SmartHome;

import static ru.sbt.mipt.oop.standartClass.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.standartClass.SensorEventType.DOOR_OPEN;

/**
 * Created by DimaN228  on 09.11.2017.
 */
public class DoorHandler implements EventHandler {
    @Override
    public void processHandler(SmartHome smartHome, SensorEvent sensorEvent) {
        if (isDoorEvent(sensorEvent)) {
            // событие от двери
            for (Room room : smartHome.getRooms()) {
                for (Door door : room.getDoors()) {
                    if (door.getId().equals(sensorEvent.getObjectId())) {
                        if (sensorEvent.getType() == DOOR_OPEN) {
                            door.setOpen(true);
                            System.out.println("Door " + door.getId() + " in room " + room.getName() + " was opened.");
                        } else {
                            door.setOpen(false);
                            System.out.println("Door " + door.getId() + " in room " + room.getName() + " was closed.");
                        }
                    }
                }
            }
        }
    }

    private static boolean isDoorEvent(SensorEvent sensorEvent) {
        return (sensorEvent.getType() == DOOR_OPEN || sensorEvent.getType() == DOOR_CLOSED);
    }
}
