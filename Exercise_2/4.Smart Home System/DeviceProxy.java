public class DeviceProxy implements Device {
    private Device realDevice;

    public DeviceProxy(Device realDevice) {
        this.realDevice = realDevice;
    }

    @Override
    public void turnOn() {
        System.out.println("Proxy: Checking access before turning on.");
        realDevice.turnOn();
    }

    @Override
    public void turnOff() {
        System.out.println("Proxy: Checking access before turning off.");
        realDevice.turnOff();
    }

    @Override
    public String getStatus() {
        return realDevice.getStatus();
    }

    @Override
    public String getType() {
        return realDevice.getType();
    }

    @Override
    public int getId() { // Implement the method
        return realDevice.getId();
    }
}