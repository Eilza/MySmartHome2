package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.LIGHT_OFF;
import static ru.sbt.mipt.oop.SensorEventType.LIGHT_ON;

/**
 * Created by DimaN228  on 09.11.2017.
 */
public class LightHandler implements EventHandler {
    @Override
    public void processHandler(SmartHome smartHome, SensorEvent sensorEvent) {
        if (isLightEvent(sensorEvent)) {
            // событие от источника света
            for (Room room : smartHome.getRooms()) {
                for (Light light : room.getLights()) {
                    if (light.getId().equals(sensorEvent.getObjectId())) {
                        if (sensorEvent.getType() == LIGHT_ON) {
                            light.setOn(true);
                            System.out.println("Light " + light.getId() + " in room " + room.getName() + " was turned on.");
                        } else {
                            light.setOn(false);
                            System.out.println("Light " + light.getId() + " in room " + room.getName() + " was turned off.");
                        }
                    }
                }
            }
        }
    }

    private boolean isLightEvent(SensorEvent sensorEvent) {
        return sensorEvent.getType() == LIGHT_ON || sensorEvent.getType() == LIGHT_OFF;
    }

}
