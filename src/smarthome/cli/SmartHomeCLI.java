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
    private HomeAutomationFacade home;
    private SmartHomeFactory factory;
    private Scanner sc = new Scanner(System.in);

    public void start() {
        System.out.println("Welcome to Smart Home System!");
        System.out.println("------------------------------");
        selectHomeType();
        showMenu();
    }

    // выбор типа дома
    private void selectHomeType() {
        System.out.println("Select home type:");
        System.out.println("1 - Eco Home");
        System.out.println("2 - Luxury Home");
        System.out.print("Your choice: ");
        int type = sc.nextInt();

        if (type == 1) {
            factory = new EcoHomeFactory();
            System.out.println("Eco Home mode selected.");
        } else {
            factory = new LuxuryHomeFactory();
            System.out.println("Luxury Home mode selected.");
        }

        // создаем девайсы
        light = factory.createLight();
        music = factory.createMusicSystem();
        thermostat = factory.createThermostat();
        camera = factory.createSecurityCamera();

        // добавляем немного "умных" фич
        Device smartLight = new VoiceControlDecorator(light);
        Device smartMusic = new RemoteAccessDecorator(music);

        home = new HomeAutomationFacade(light, music, thermostat, camera);

        // просто тестируем декораторы
        ((VoiceControlDecorator) smartLight).voiceCommand("Turn on light");
        ((RemoteAccessDecorator) smartMusic).remoteControl("Play music");
    }

    // главное меню
    private void showMenu() {
        int choice = -1;

        while (choice != 0) {
            System.out.println("\n========== SMART HOME MENU ==========");
            System.out.println("1. Turn ON light");
            System.out.println("2. Turn OFF light");
            System.out.println("3. Play music");
            System.out.println("4. Stop music");
            System.out.println("5. Set temperature");
            System.out.println("6. Arm camera");
            System.out.println("7. Disarm camera");
            System.out.println("8. Show system status");
            System.out.println("9. Party mode");
            System.out.println("10. Night mode");
            System.out.println("11. Leave home");
            System.out.println("12. Change home type");
            System.out.println("0. Exit");
            System.out.print("Enter: ");

            while (!sc.hasNextInt()) {
                System.out.print("Enter a number: ");
                sc.next();
            }
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> light.on();
                case 2 -> light.off();
                case 3 -> music.play();
                case 4 -> music.stop();
                case 5 -> {
                    System.out.print("Set temperature °C: ");
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
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Wrong input, try again.");
            }
        }
    }
}
