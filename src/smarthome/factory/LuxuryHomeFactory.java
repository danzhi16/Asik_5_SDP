package smarthome.factory;

import smarthome.devices.*;

public class LuxuryHomeFactory implements SmartHomeFactory {
    @Override
    public Light createLight() {
        System.out.println("Creating Luxury Light with voice assistant");
        return new Light("Luxury Light");
    }

    @Override
    public MusicSystem createMusicSystem() {
        System.out.println("Creating Premium Music System");
        return new MusicSystem("Bose Music System");
    }

    @Override
    public Thermostat createThermostat() {
        System.out.println("Creating Luxury Thermostat");
        Thermostat t = new Thermostat("Luxury Thermostat");
        t.setTemperature(24);
        return t;
    }

    @Override
    public SecurityCamera createSecurityCamera() {
        System.out.println("Creating Advanced Security Camera");
        return new SecurityCamera("Luxury Camera");
    }
}
