package com.logger.impl;

import com.event.Event;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Volodymyr_Kravtsov on 4/28/2017.
 */
public class CacheFileEventLogger extends FileEventLogger {
    private int cacheSize;
    private List<Event> cache;

    public CacheFileEventLogger(String filename, int cacheSize) {
        super(filename);
        this.cacheSize = cacheSize;
        this.cache = new ArrayList<>();
    }

    @Override
    public void logEvent(Event event) {
        cache.add(event);

        if (cache.size() == cacheSize) {
            writesEventsFromCache();
            cache.clear();
        }
    }

    private void writesEventsFromCache() {
        for (Event event : cache) {
            super.logEvent(event);
        }
    }

    public void destroy() {
        if (!cache.isEmpty()) {
            writesEventsFromCache();
        }
    }
}
