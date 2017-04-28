package com.logger;

/**
 * Created by Volodymyr_Kravtsov on 4/27/2017.
 */
public class ConsoleEventLogger implements EventLogger {
    public void logEvent(String msg) {
        System.out.println(msg);
    }
}
