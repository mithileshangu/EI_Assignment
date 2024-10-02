public class MobileAppDisplay implements Observer {
    private String appName;

    public MobileAppDisplay(String appName) {
        this.appName = appName;
    }

    @Override
    public void update(float temperature) {
        System.out.println(appName + " displays: Current temperature is " + temperature + "°C");
    }
}