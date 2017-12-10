package ru.sbt.mipt.oop;

/**
 * Created by DimaN228  on 09.11.2017.
 */
public class ScenarioHandler implements EventHandler {
    @Override
    public void processHandler(SmartHome smartHome, SensorEvent sensorEvent) {
        if (!isDoorClosedEvent(sensorEvent)) {
            return;
        }
        for (Room room : smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals(sensorEvent.getObjectId())) {
                    if (room.getName().equals("hall")) {
                        for (Room homeRoom : smartHome.getRooms()) {
                            for (Light light : homeRoom.getLights()) {
                                SmartHomeManager.turnOffLight(light);
                            }
                        }
                    }
                    System.out.println("All lights were turned off.");
                }
            }
        }
    }
    private boolean isDoorClosedEvent(SensorEvent event) {
        return event.getType() == SensorEventType.DOOR_CLOSED;
    }
}
