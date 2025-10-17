package smarthome.factory;

import smarthome.devices.*;

public class EcoHomeFactory implements SmartHomeFactory {
    @Override
    public Light createLight() {
        System.out.println("Creating Eco-friendly Light");
        return new Light("Eco Light");
    }

    @Override
    public MusicSystem createMusicSystem() {
        System.out.println("Creating Low-power Music System");
        return new MusicSystem("Eco Speaker");
    }

    @Override
    public Thermostat createThermostat() {
        System.out.println("Creating Eco Thermostat");
        Thermostat t = new Thermostat("Eco Thermostat");
        t.setTemperature(20);
        return t;
    }

    @Override
    public SecurityCamera createSecurityCamera() {
        System.out.println("Creating Basic Security Camera");
        return new SecurityCamera("Eco Camera");
    }
}
