public class TVDisplay implements Observer {
    private String channelName;

    public TVDisplay(String channelName) {
        this.channelName = channelName;
    }

    @Override
    public void update(float temperature) {
        System.out.println(channelName + " TV Channel: Current temperature is " + temperature + "°C");
    }
}
