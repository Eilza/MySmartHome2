package ru.sbt.mipt.oop.standartClass;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.sbt.mipt.oop.handlers.EventObserver;
import ru.sbt.mipt.oop.smartHome.SmartHome;

import java.io.IOException;

public class Application {

    public static void main(String... args) throws IOException {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml");

        EventObserver observer = ctx.getBean(EventObserver.class);
        SensorEvent sensorEvent = ctx.getBean(SensorEvent.class);
        SmartHome smartHome = ctx.getBean(SmartHome.class);

        observer.runEvent(sensorEvent, smartHome);
    }

    private static void sendCommand(SensorCommand command) {
        System.out.println("Pretent we're sending command " + command);
    }

    public static SensorEvent getNextSensorEvent() {
        // pretend like we're getting the events from physical world, but here we're going to just generate some random events
        if (Math.random() < 0.05) return null; // null means end of event stream
        SensorEventType sensorEventType = SensorEventType.values()[(int) (4 * Math.random())];
        String objectId = "" + ((int) (10 * Math.random()));
        return new SensorEvent(sensorEventType, objectId);
    }
}
