public class Thermostat implements Device {
    private int id;
    private int temperature;

    public Thermostat(int id, int temperature) {
        this.id = id;
        this.temperature = temperature;
    }

    @Override
    public void turnOn() {
        System.out.println("Thermostat " + id + " is set to " + temperature + " degrees.");
    }

    @Override
    public void turnOff() {
        System.out.println("Thermostat " + id + " is Off.");
    }

    @Override
    public String getStatus() {
        return "Thermostat " + id + " is set to " + temperature + " degrees.";
    }

    @Override
    public String getType() {
        return "Thermostat";
    }

    @Override
    public int getId() { // Implement the method
        return id;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        System.out.println("Thermostat " + id + " temperature set to " + temperature + " degrees.");
    }

    public int getTemperature() {
        return temperature;
    }
}