package smarthome.devices;

public class MusicSystem implements Device {
    private final String name;
    private boolean playing = false;

    public MusicSystem(String name) { this.name = name; }

    public void play() {
        playing = true;
        System.out.println(name + " is PLAYING music");
    }

    public void stop() {
        playing = false;
        System.out.println(name + " music STOPPED");
    }

    @Override
    public void operate() {
        System.out.println(name + " music is " + (playing ? "PLAYING" : "STOPPED"));
    }

    @Override
    public String getName() { return name; }
}
