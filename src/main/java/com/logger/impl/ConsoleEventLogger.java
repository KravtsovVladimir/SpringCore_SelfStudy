package com.logger.impl;

import com.event.Event;
import com.logger.EventLogger;

/**
 * Created by Volodymyr_Kravtsov on 4/27/2017.
 */

public class ConsoleEventLogger implements EventLogger {
    public void logEvent(Event event) {
        System.out.println(event.toString());
    }
}
