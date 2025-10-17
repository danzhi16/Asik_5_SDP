package smarthome.decorators;

import smarthome.devices.Device;

public class VoiceControlDecorator extends DeviceDecorator {
    public VoiceControlDecorator(Device device) {
        super(device);
    }

    public void voiceCommand(String command) {
        System.out.println("(Voice) Command for " + getName() + ": " + command);
    }

    @Override
    public void operate() {
        System.out.println(getName() + " supports voice control");
        super.operate();
    }
}
