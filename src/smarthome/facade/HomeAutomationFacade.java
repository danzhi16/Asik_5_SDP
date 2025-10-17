package smarthome.facade;

import smarthome.devices.*;

public class HomeAutomationFacade {
    private final Light light;
    private final MusicSystem music;
    private final Thermostat thermostat;
    private final SecurityCamera camera;

    public HomeAutomationFacade(Light light, MusicSystem music, Thermostat thermostat, SecurityCamera camera) {
        this.light = light;
        this.music = music;
        this.thermostat = thermostat;
        this.camera = camera;
    }

    public void startPartyMode() {
        System.out.println("\n=== PARTY MODE ===");
        light.on();
        music.play();
        thermostat.setTemperature(24);
        camera.off();
    }

    public void activateNightMode() {
        System.out.println("\n=== NIGHT MODE ===");
        light.off();
        music.stop();
        thermostat.setTemperature(20);
        camera.on();
    }

    public void leaveHome() {
        System.out.println("\n=== LEAVE HOME ===");
        light.off();
        music.stop();
        thermostat.setTemperature(18);
        camera.on();
    }
}
