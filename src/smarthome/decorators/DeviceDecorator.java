package smarthome.decorators;

import smarthome.devices.Device;

public abstract class DeviceDecorator implements Device {
    protected final Device device;

    public DeviceDecorator(Device device) {
        this.device = device;
    }

    @Override
    public void operate() {
        device.operate();
    }

    @Override
    public String getName() {
        return device.getName();
    }
}
