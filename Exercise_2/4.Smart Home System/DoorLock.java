public class DoorLock implements Device {
    private int id;
    private boolean status; // true for LOCKED, false for UNLOCKED

    public DoorLock(int id) {
        this.id = id;
        this.status = true; // default locked
    }

    @Override
    public void turnOn() {
        status = true;
        System.out.println("Door " + id + " is Locked.");
    }

    @Override
    public void turnOff() {
        status = false;
        System.out.println("Door " + id + " is Unlocked.");
    }

    @Override
    public String getStatus() {
        return "Door " + id + " is " + (status ? "Locked" : "Unlocked") + ".";
    }

    @Override
    public String getType() {
        return "Door Lock";
    }

    @Override
    public int getId() { // Implement the method
        return id;
    }
}