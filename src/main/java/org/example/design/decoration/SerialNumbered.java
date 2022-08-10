package org.example.design.decoration;

public class SerialNumbered extends Decorator{
    private static long counter = 1;
    private final long serialNumber = counter++;
    public SerialNumbered(Basic basic) {
        super(basic);
    }
    public long getSerialNumber() {return serialNumber;}
}
