package com.logger.impl;

import com.event.Event;
import com.logger.EventLogger;

import java.util.Collection;
import java.util.List;

/**
 * Created by Volodymyr_Kravtsov on 5/3/2017.
 */

public class CombinedEventLogger implements EventLogger {

    private Collection<EventLogger> loggers;

    public CombinedEventLogger(List<EventLogger> loggers) {
        this.loggers = loggers;
    }

    @Override
    public void logEvent(Event event) {
        for (EventLogger logger : loggers) {
            logger.logEvent(event);
        }

    }
}
