package smarthome.devices;

public class SecurityCamera implements Device {
    private final String name;
    private boolean on = false;

    public SecurityCamera(String name) { this.name = name; }

    public void on() {
        on = true;
        System.out.println(name + " camera ARMED");
    }

    public void off() {
        on = false;
        System.out.println(name + " camera DISARMED");
    }

    @Override
    public void operate() {
        System.out.println(name + " camera is " + (on ? "ARMED" : "DISARMED"));
    }

    @Override
    public String getName() { return name; }
}
