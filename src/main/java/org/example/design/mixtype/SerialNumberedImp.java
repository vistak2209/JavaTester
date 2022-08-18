package org.example.design.mixtype;

public class SerialNumberedImp implements SerialNumbered{
    private static long counter = 1;
    private final long serialNumber = counter++;
    public long getSerialNumber() {return serialNumber;}
}
