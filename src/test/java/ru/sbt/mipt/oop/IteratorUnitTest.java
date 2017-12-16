package ru.sbt.mipt.oop;

import org.junit.Test;
import ru.sbt.mipt.oop.smartHome.SmartHome;
import ru.sbt.mipt.oop.standartClass.Door;
import ru.sbt.mipt.oop.standartClass.Light;
import ru.sbt.mipt.oop.standartClass.Room;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by DimaN228 on 17.12.2017.
 */
public class IteratorUnitTest {

    @Test
    public void testActionableComposite() {

        SmartHome smartHome = new SmartHome();
        ArrayList<Light> lights = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            lights.add(new Light("Light #" + String.valueOf(i + 1), true));
        }

        ArrayList<Door> doors = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            doors.add(new Door(true, "Door #" + String.valueOf(i + 1)));
        }

        ArrayList<Room> rooms = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            rooms.add(new Room(lights, doors, "Room #" + String.valueOf(i + 1)));
        }

        for (Room room : rooms) {
            smartHome.addRoom(room);
        }
        Set<Object> homeObject = new HashSet<>();
        homeObject.add(smartHome);
        homeObject.addAll(rooms);
        homeObject.addAll(doors);
        homeObject.addAll(lights);


        smartHome.executeAction(object -> {
            homeObject.remove(object);
        });
        assertEquals(0, homeObject.size());
    }
}
