package org.example.design.mixtype;

public class Mixin extends BasicImp implements TimeStamped,SerialNumbered{
    private TimeStamped timeStamp       = new TimeStampedImp();
    private SerialNumbered serialNumber = new SerialNumberedImp();
    public long getStamp(){return timeStamp.getStamp();}
    @Override
    public long getSerialNumber() {
        return serialNumber.getSerialNumber();
    }
}
