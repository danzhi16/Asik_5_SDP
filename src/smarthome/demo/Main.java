package smarthome.demo;

import smarthome.devices.*;
import smarthome.decorators.*;
import smarthome.facade.HomeAutomationFacade;
import smarthome.factory.*;
import smarthome.cli.SmartHomeCLI;

public class Main {
    public static void main(String[] args) {

        // создаём фабрику (можно поменять на LuxuryHomeFactory)
        SmartHomeFactory factory = new EcoHomeFactory();


        Light light = factory.createLight();
        MusicSystem music = factory.createMusicSystem();
        Thermostat thermostat = factory.createThermostat();
        SecurityCamera camera = factory.createSecurityCamera();


        VoiceControlDecorator smartLight = new VoiceControlDecorator(light);
        RemoteAccessDecorator smartMusic = new RemoteAccessDecorator(music);


        HomeAutomationFacade home = new HomeAutomationFacade(light, music, thermostat, camera);


        System.out.println("\n=== DEMO START ===");
        home.startPartyMode();
        home.activateNightMode();
        home.leaveHome();


        System.out.println("\n--- Testing Decorators ---");
        smartLight.voiceCommand("Turn on light");
        smartLight.operate();

        smartMusic.remoteControl("Play music");
        smartMusic.operate();


        System.out.println("\n--- Checking system status ---");
        home.systemStatus();


        System.out.println("\n=== Switching to Interactive Mode ===\n");
        SmartHomeCLI cli = new SmartHomeCLI();
        cli.start();
    }
}
