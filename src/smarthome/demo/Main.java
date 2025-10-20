package smarthome.demo;

import smarthome.devices.*;
import smarthome.decorators.*;
import smarthome.facade.HomeAutomationFacade;
import smarthome.factory.*;
import smarthome.cli.SmartHomeCLI;

public class Main {
    public static void main(String[] args) {
        SmartHomeFactory factory = new EcoHomeFactory();

        Light light = factory.createLight();
        MusicSystem music = factory.createMusicSystem();
        Thermostat thermostat = factory.createThermostat();
        SecurityCamera camera = factory.createSecurityCamera();

        Device smartLight = new VoiceControlDecorator(light);
        Device smartMusic = new RemoteAccessDecorator(music);
        HomeAutomationFacade home = new HomeAutomationFacade(light, music, thermostat, camera);

        home.startPartyMode();
        home.activateNightMode();
        home.leaveHome();
        ((VoiceControlDecorator) smartLight).voiceCommand("Turn on the light");
        ((RemoteAccessDecorator) smartMusic).remoteControl("Play favorite playlist");

        SmartHomeCLI cli = new SmartHomeCLI();
        cli.start();
    }
}
