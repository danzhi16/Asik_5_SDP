package smarthome.decorators;

import smarthome.devices.Device;

public class RemoteAccessDecorator extends DeviceDecorator {
    public RemoteAccessDecorator(Device device) {
        super(device);
    }

    public void remoteControl(String action) {
        System.out.println("(Remote) " + getName() + " performed: " + action + " via Internet");
    }

    @Override
    public void operate() {
        System.out.println(getName() + " connected to cloud control");
        super.operate();
    }
}
