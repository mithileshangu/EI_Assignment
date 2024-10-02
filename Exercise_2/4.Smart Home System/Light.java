public class Light implements Device {
    private int id;
    private boolean status; // true for ON, false for OFF

    public Light(int id) {
        this.id = id;
        this.status = false;
    }

    @Override
    public void turnOn() {
        status = true;
        System.out.println("Light " + id + " is On.");
    }

    @Override
    public void turnOff() {
        status = false;
        System.out.println("Light " + id + " is Off.");
    }

    @Override
    public String getStatus() {
        return "Light " + id + " is " + (status ? "On" : "Off") + ".";
    }

    @Override
    public String getType() {
        return "Light";
    }

    @Override
    public int getId() { // Implement the method
        return id;
    }
}