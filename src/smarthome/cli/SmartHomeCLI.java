package smarthome.cli;

import smarthome.devices.*;
import smarthome.decorators.*;
import smarthome.facade.HomeAutomationFacade;
import smarthome.factory.*;

import java.util.Scanner;

public class SmartHomeCLI {

    private Light light;
    private MusicSystem music;
    private Thermostat thermostat;
    private SecurityCamera camera;

    private VoiceControlDecorator smartLight;
    private RemoteAccessDecorator smartMusic;

    private HomeAutomationFacade home;
    private SmartHomeFactory factory;
    private Scanner sc = new Scanner(System.in);

    public void start() {
        System.out.println("Welcome to SmartHome CLI!");
        selectHomeType();
        mainMenu();
    }

    private void selectHomeType() {
        System.out.println("\nChoose home type:");
        System.out.println("1 - Eco Home");
        System.out.println("2 - Luxury Home");
        System.out.print("Your choice: ");

        int type = sc.nextInt();
        sc.nextLine();

        if (type == 1) {
            factory = new EcoHomeFactory();
            System.out.println("Eco mode selected.");
        } else {
            factory = new LuxuryHomeFactory();
            System.out.println("Luxury mode selected.");
        }

        light = factory.createLight();
        music = factory.createMusicSystem();
        thermostat = factory.createThermostat();
        camera = factory.createSecurityCamera();

        smartLight = new VoiceControlDecorator(light);
        smartMusic = new RemoteAccessDecorator(music);

        home = new HomeAutomationFacade(light, music, thermostat, camera);
        System.out.println("Devices created.\n");
    }

    private void mainMenu() {
        int choice = -1;

        while (choice != 0) {
            System.out.println("""
                    
                    ======== SMART HOME MENU ========
                    1. Turn ON light
                    2. Turn OFF light
                    3. Play music
                    4. Stop music
                    5. Set temperature
                    6. Arm camera
                    7. Disarm camera
                    8. Show system status
                    9. Party mode
                    10. Night mode
                    11. Leave home
                    12. Change home type
                    13. Voice / Remote Command
                    0. Exit
                    =================================
                    """);

            System.out.print("Enter: ");
            while (!sc.hasNextInt()) {
                System.out.print("Enter a number: ");
                sc.next();
            }
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> light.on();
                case 2 -> light.off();
                case 3 -> music.play();
                case 4 -> music.stop();
                case 5 -> {
                    System.out.print("Temperature °C: ");
                    int t = sc.nextInt();
                    thermostat.setTemperature(t);
                }
                case 6 -> camera.on();
                case 7 -> camera.off();
                case 8 -> home.systemStatus();
                case 9 -> home.startPartyMode();
                case 10 -> home.activateNightMode();
                case 11 -> home.leaveHome();
                case 12 -> {
                    System.out.println("Switching home type...");
                    selectHomeType();
                }
                case 13 -> handleSmartCommand();
                case 0 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid input.");
            }
        }
    }

    private void handleSmartCommand() {
        System.out.println("\nType a command (example: 'voice: turn on light' or 'remote: play music')");
        System.out.print("Command: ");
        String input = sc.nextLine().trim().toLowerCase();

        if (input.startsWith("voice:")) {
            String cmd = input.replace("voice:", "").trim();
            smartLight.voiceCommand(cmd);
            if (cmd.contains("on")) light.on();
            else if (cmd.contains("off")) light.off();
        }
        else if (input.startsWith("remote:")) {
            String cmd = input.replace("remote:", "").trim();
            smartMusic.remoteControl(cmd);
            if (cmd.contains("play")) music.play();
            else if (cmd.contains("stop")) music.stop();
        }
        else {
            System.out.println("Unknown command format. Use 'voice:' or 'remote:'");
        }
    }
}
