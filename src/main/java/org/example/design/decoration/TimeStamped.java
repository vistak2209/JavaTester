package org.example.design.decoration;

import java.util.Date;

public class TimeStamped extends Decorator{
    private final long timeStamp;
    public TimeStamped(Basic basic) {
        super(basic);
        timeStamp = new Date().getTime();
    }
    public long getTimeStamp() {
        return timeStamp;
    }
}
