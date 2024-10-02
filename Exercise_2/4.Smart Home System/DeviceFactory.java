public class DeviceFactory {
    public static Device createDevice(String type, int id, Integer temperature) {
        switch (type.toLowerCase()) {
            case "light":
                return new Light(id);
            case "thermostat":
                return new Thermostat(id, temperature != null ? temperature : 70); // Default temperature
            case "door":
                return new DoorLock(id);
            default:
                throw new IllegalArgumentException("Invalid device type");
        }
    }
}