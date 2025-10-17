package smarthome.devices;

public class Thermostat implements Device {
    private final String name;
    private int temperature = 22;

    public Thermostat(String name) { this.name = name; }

    public void setTemperature(int temp) {
        this.temperature = temp;
        System.out.println(name + " set to " + temp + "°C");
    }

    @Override
    public void operate() {
        System.out.println(name + " temperature: " + temperature + "°C");
    }

    @Override
    public String getName() { return name; }
}
