package com.kaniademianchuk.model;

import com.kaniademianchuk.api.IIdentifiable;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class DeviceGroup<T extends IIdentifiable> extends AbstractIdentifiable implements IIdentifiable {
    private final Map<Integer, T> devices = new HashMap<>();

    protected DeviceGroup(Integer id, String name, Map<Integer, T> map) {
        super(id, name);
        this.devices.putAll(map);
    }

    public DeviceGroup(String name, Map<Integer, T> map) {
        super(AbstractIdentifiable.latestId++, name);
        this.devices.putAll(map);
    }

    public DeviceGroup(String name, T... devices) {
        super(AbstractIdentifiable.latestId++, name);
        for (T device : devices)
            this.devices.put(device.getId(), device);
    }

    protected DeviceGroup(Integer id, String name, T... devices) {
        super(id, name);
        for (T device : devices)
            this.devices.put(device.getId(), device);
    }

    public Collection<T> getDevices() {
        return this.devices.values();
    }


    public T addDevice(T device) {
        return this.devices.put(device.getId(), device);
    }

    public T removeDevice(T device) {
        return this.devices.remove(device.getId());
    }

    public T getDeviceById(int id) {
        return this.devices.get(id);
    }

    public int getSize() {
        return devices.size();
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("DeviceGroup{id='" + id + "', name='" + name + "', size=" + this.devices.size());
//        for (T device : this.devices.values()) {
//            buffer.append(device.toString());
//            buffer.append(System.lineSeparator());
//        }
        buffer.append("}");
        return buffer.toString();
    }

    @Override
    public DeviceGroup<T> setId(Integer id) {
        return new DeviceGroup<>(id, this.name, this.devices);
    }

    @Override
    public IIdentifiable setName(String name) {
        return new DeviceGroup<>(this.id, name, this.devices);
    }
}
