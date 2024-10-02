import java.util.ArrayList;
import java.util.List;

public class SmartHomeHub {
    private List<Device> devices;
    private List<Observer> observers;
    private List<String> scheduledTasks; // List to store scheduled tasks
    private List<String> automatedTriggers; // List to store automated triggers

    public SmartHomeHub() {
        devices = new ArrayList<>();
        observers = new ArrayList<>();
        scheduledTasks = new ArrayList<>();
        automatedTriggers = new ArrayList<>();
    }

    public void addDevice(Device device) {
        devices.add(device);
        notifyObservers(device.getStatus());
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void turnOnDevice(int id) {
        for (Device device : devices) {
            if (device.getId() == id) {
                device.turnOn();
                notifyObservers(device.getStatus());
                return;
            }
        }
        System.out.println("Device ID not found.");
    }

    public void turnOffDevice(int id) {
        for (Device device : devices) {
            if (device.getId() == id) {
                device.turnOff();
                notifyObservers(device.getStatus());
                return;
            }
        }
        System.out.println("Device ID not found.");
    }

    public void setSchedule(int deviceId, String time, String command) {
        scheduledTasks.add("Device ID: " + deviceId + ", Time: " + time + ", Command: " + command);
        System.out.println("Scheduled Task: " + scheduledTasks.get(scheduledTasks.size() - 1));
    }

    public void addTrigger(String condition, String action) {
        automatedTriggers.add("Condition: " + condition + ", Action: " + action);
        System.out.println("Automated Trigger: " + automatedTriggers.get(automatedTriggers.size() - 1));
    }

    private void notifyObservers(String deviceStatus) {
        for (Observer observer : observers) {
            observer.update(deviceStatus);
        }
    }

    // New methods for GUI
    public List<Device> getDevices() {
        return devices;
    }

    public String getScheduledTasks() {
        return scheduledTasks.toString();
    }

    public String getAutomatedTriggers() {
        return automatedTriggers.toString();
    }
}
