package smarthome.factory;

import smarthome.devices.*;

public interface SmartHomeFactory {
    Light createLight();
    MusicSystem createMusicSystem();
    Thermostat createThermostat();
    SecurityCamera createSecurityCamera();
}