package com.event;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * Created by Volodymyr_Kravtsov on 4/28/2017.
 */

public class Event {
    private int id;
    private String msg;
    private Date date;
    private DateFormat df;

    public Event(Date date, DateFormat df) {
        this.date = date;
        this.df = df;
        this.id = new Random().nextInt(100);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static boolean isDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int hours = calendar.get(Calendar.HOUR_OF_DAY);

        if (hours >= 8 && hours < 18) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id = " + id +
                ", msg = '" + msg + '\'' +
                ", date = " + df.format(date) +
                '}';
    }
}
