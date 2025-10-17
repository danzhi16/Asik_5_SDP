package smarthome.devices;

public class Light implements Device {
    private final String name;
    private boolean on = false;

    public Light(String name) { this.name = name; }

    public void on() {
        on = true;
        System.out.println(name + " light is ON");
    }

    public void off() {
        on = false;
        System.out.println(name + " light is OFF");
    }

    @Override
    public void operate() {
        System.out.println(name + " light is " + (on ? "ON" : "OFF"));
    }

    @Override
    public String getName() { return name; }
}
