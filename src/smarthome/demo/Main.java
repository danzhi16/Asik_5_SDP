package smarthome.demo;

import smarthome.devices.*;
import smarthome.decorators.*;
import smarthome.facade.HomeAutomationFacade;
import smarthome.factory.*;

public class Main {
    public static void main(String[] args) {

        // 1️⃣ Выбираем тип дома
        SmartHomeFactory factory = new EcoHomeFactory()   ;
        // SmartHomeFactory factory = new EcoHomeFactory();

        // 2️⃣ Фабрика создаёт устройства
        Light light = factory.createLight();
        MusicSystem music = factory.createMusicSystem();
        Thermostat thermostat = factory.createThermostat();
        SecurityCamera camera = factory.createSecurityCamera();

        // 3️⃣ Добавляем декораторы
        Device smartLight = new VoiceControlDecorator(light);
        Device smartMusic = new RemoteAccessDecorator(music);

        // 4️⃣ Создаём фасад
        HomeAutomationFacade home = new HomeAutomationFacade(light, music, thermostat, camera);

        // 5️⃣ Демонстрация
        home.startPartyMode();
        home.activateNightMode();
        home.leaveHome();

        // 6️⃣ Используем декораторы
        ((VoiceControlDecorator) smartLight).voiceCommand("Turn on the light");
        ((RemoteAccessDecorator) smartMusic).remoteControl("Play favorite playlist");
    }
}
