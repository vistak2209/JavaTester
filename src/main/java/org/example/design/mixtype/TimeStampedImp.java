package org.example.design.mixtype;

import java.util.Date;

public class TimeStampedImp implements TimeStamped{
    private final long timeStamp;
    public TimeStampedImp() {

        timeStamp = new Date().getTime();
    }
    public long getStamp() {
        return timeStamp;
    }
}
