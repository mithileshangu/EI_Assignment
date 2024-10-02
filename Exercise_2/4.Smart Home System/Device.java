public interface Device {
    void turnOn();
    void turnOff();
    String getStatus();
    String getType();
    int getId(); // Added method for getting the ID
}