package ru.sbt.mipt.oop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ru.sbt.mipt.oop.handlers.DoorHandler;
import ru.sbt.mipt.oop.handlers.EventObserver;
import ru.sbt.mipt.oop.handlers.LightHandler;
import ru.sbt.mipt.oop.handlers.ScenarioHandler;
import ru.sbt.mipt.oop.smartHome.SmartHome;
import ru.sbt.mipt.oop.standartClass.SensorEvent;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.verify;

/**
 * Created by DimaN228 on 27.11.2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class EventObserverTest {
    @Mock
    DoorHandler doorHandler;
    @Mock
    LightHandler lightHandler;
    @Mock
    ScenarioHandler scenarioHandler;
    @Mock
    SmartHome smartHome;
    @Mock
    SensorEvent sensorEvent;

    @Test
    public void testOnSensorEvent() {
        EventObserver eventObserver = new EventObserver(
                asList(doorHandler, lightHandler, scenarioHandler));
        eventObserver.onSensorEvent(smartHome, sensorEvent);

        verify(doorHandler).processHandler(smartHome, sensorEvent);
        verify(lightHandler).processHandler(smartHome, sensorEvent);
        verify(scenarioHandler).processHandler(smartHome, sensorEvent);
    }

}