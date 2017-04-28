package com.main;

import com.client.Client;
import com.event.Event;
import com.logger.EventLogger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Volodymyr_Kravtsov on 4/27/2017.
 */
public class App {

    private Client client;
    private EventLogger eventLogger;

    public App(Client client, EventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }

    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

        App app = (App) ctx.getBean("app");
        Event event = (Event) ctx.getBean("event");

        for (int i = 0; i < 7; i++) {
            event.setMsg("Some event for 1");
            app.logEvent(event);
        }

        ctx.close();
    }

    public void logEvent(Event event) {
        String message = event.getMsg().replaceAll(String.valueOf(client.getId()), client.getFullName());
        event.setMsg(message);
        eventLogger.logEvent(event);
    }
}
