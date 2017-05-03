package com.main;

import com.client.Client;
import com.event.Event;
import com.event.EventType;
import com.logger.EventLogger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * Created by Volodymyr_Kravtsov on 4/27/2017.
 */
public class App {

    private Client client;
    private EventLogger defaultLogger;
    private Map<EventType, EventLogger> loggers;

    public App(Client client, EventLogger defaultLogger, Map<EventType, EventLogger> loggers) {
        this.client = client;
        this.defaultLogger = defaultLogger;
        this.loggers = loggers;
    }

    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

        App app = (App) ctx.getBean("app");
        Event event = (Event) ctx.getBean("event");

        event.setMsg("Some event for 1");
        app.logEvent(EventType.ERROR, event);

        ctx.close();
    }

    public void logEvent(EventType eventType, Event event) {
        String message = event.getMsg().replaceAll(String.valueOf(client.getId()), client.getFullName());
        event.setMsg(message);

        EventLogger logger = loggers.get(eventType);
        if (logger == null) {
            logger = defaultLogger;
        }
        logger.logEvent(event);
    }
}
