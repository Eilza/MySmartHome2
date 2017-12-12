package ru.sbt.mipt.oop.handlers;

import ru.sbt.mipt.oop.standartClass.Application;
import ru.sbt.mipt.oop.standartClass.SensorEvent;
import ru.sbt.mipt.oop.smartHome.SmartHome;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by DimaN228 on 27.11.2017.
 */
public class EventObserver {
    private Collection<EventHandler> handlers = new ArrayList<>();

    public EventObserver(Collection<EventHandler> handlers) {
        this.handlers = handlers;
    }

    public void addHandler(EventHandler eventHandler){

        handlers.add(eventHandler);
    }
    public void onSensorEvent(SmartHome smartHome, SensorEvent sensorEvent){
        for (EventHandler handle : handlers) {
            handle.processHandler(smartHome, sensorEvent);
        }
    }

    public void runEvent(SensorEvent event, SmartHome smartHome) {
        while (event != null) {
            System.out.println("Got event: " + event);
            this.onSensorEvent(smartHome, event);
            event = Application.getNextSensorEvent();
        }
    }

}
