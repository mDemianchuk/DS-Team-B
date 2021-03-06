package com.kaniademianchuk.api;

public interface ITogglable extends IIdentifiable {

    void turnOn();

    void turnOff();

    void toggle();

    /**
     * @return Returns true if a device or all devices in a group are on
     * false otherwise
     */
    boolean isOn();

}
